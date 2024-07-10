package org.real7.luckywiki.domain.wiki.service

import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.real7.luckywiki.common.MatchingKey
import org.real7.luckywiki.config.LettuceRedis
import org.real7.luckywiki.domain.debate.repository.DebateJpaRepository
import org.real7.luckywiki.domain.member.model.Role
import org.real7.luckywiki.domain.member.repository.MemberRepository
import org.real7.luckywiki.domain.member.service.MemberService
import org.real7.luckywiki.domain.wiki.dto.KeywordRequest
import org.real7.luckywiki.domain.wiki.dto.wikihistory.CreateWikiHistoryRequest
import org.real7.luckywiki.domain.wiki.dto.wikihistory.WikiHistoryResponse
import org.real7.luckywiki.domain.wiki.dto.wikipage.*
import org.real7.luckywiki.domain.wiki.model.WikiPage
import org.real7.luckywiki.domain.wiki.model.createWikiPageResponse
import org.real7.luckywiki.domain.wiki.model.toResponse
import org.real7.luckywiki.domain.wiki.model.type.SearchType
import org.real7.luckywiki.domain.wiki.model.type.WikiHistoryColumnType
import org.real7.luckywiki.domain.wiki.repository.WikiHistoryCustomRepository
import org.real7.luckywiki.domain.wiki.repository.popularword.PopularWordRepository
import org.real7.luckywiki.domain.wiki.repository.wikipage.WikiPageRepository
import org.real7.luckywiki.domain.wikilike.repository.WikiLikeRepository
import org.real7.luckywiki.exception.CustomAccessDeniedException
import org.real7.luckywiki.exception.ModelNotFoundException
import org.real7.luckywiki.infra.aws.S3Service
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class WikiPageServiceImplV2(
    private val wikiPageRepository: WikiPageRepository,
    private val s3Service: S3Service,
    private val wikiHistoryCustomRepository: WikiHistoryCustomRepository,
    private val popularWordRepository: PopularWordRepository, // 검색어 저장을 위해 추가
    private val memberRepository: MemberRepository, // 회원 정보를 가져오기 위해 추가
    private val memberService: MemberService, // 토큰에서 회원 정보를 가져오기 위해 추가
    private val debateJpaRepository: DebateJpaRepository, // 연관 삭제를 위해 추가
    private val wikiLikeRepository: WikiLikeRepository, // 연관 삭제를 위해 추가
    private val lettuceRedis: LettuceRedis
): WikiPageService {

    @Transactional
    override fun createWikiPage(request: CreateWikiPageRequest, image: MultipartFile?): CreateWikiPageResponse {
        val memberId = memberService.getMemberIdFromToken()
        val member = memberRepository.findByIdOrNull(memberId) ?: throw ModelNotFoundException("Member", memberId!!.toString())
        val wikiPage = wikiPageRepository.save(
            WikiPage.from(
                request = request,
                memberId = memberId!!
            )
        )

        // history
        request.title.let {
            wikiPage.createWikiHistory(
                CreateWikiHistoryRequest(
                    wikiPage = wikiPage,
                    columnType = WikiHistoryColumnType.TITLE,
                    beforeContent = wikiPage.title,
                    afterContent = it,
                    author = member.name
                )
            )
        }

        request.content.let {
            wikiPage.createWikiHistory(
                CreateWikiHistoryRequest(
                    wikiPage = wikiPage,
                    columnType = WikiHistoryColumnType.CONTENT,
                    beforeContent = wikiPage.content,
                    afterContent = it,
                    author = member.name
                )
            )
        }

        image?.let {
            // 신규 이미지 등록
            val imageFileName = "${wikiPage.id.toString()}-${
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"))
            }"
            val imageLink = s3Service.upload(it, imageFileName)

            wikiPage.uploadImage(imageLink)

            wikiPage.createWikiHistory(
                CreateWikiHistoryRequest(
                    wikiPage = wikiPage,
                    columnType = WikiHistoryColumnType.IMAGE,
                    beforeContent = wikiPage.image ?: "이미지 없음",
                    afterContent = imageLink,
                    author = member.name
                )
            )
        }

        return wikiPage.createWikiPageResponse()
    }

    @Cacheable("wikiPage", key = "#wikiId")
    @Transactional
    override fun getWikiPage(wikiId: Long, request: HttpServletRequest, response: HttpServletResponse): WikiPageResponse {
        val wikiPage = wikiPageRepository.findByIdOrNull(wikiId) ?: throw ModelNotFoundException("WikiPage", wikiId.toString())

        viewCountUp(wikiId, request, response)

        return wikiPage.toResponse()
    }

    @Transactional
    fun getWikiPageRedis(wikiId: Long): WikiPageResponse{
        val redisResult = lettuceRedis.findHashSet(wikiId.toString())

        return if(redisResult.isEmpty()) {
            savedRedisAndToResponse(wikiId)
        }else{
            WikiPageResponse.from(redisResult)
        }
    }


    override fun viewCountUp(wikiId: Long, request: HttpServletRequest, response: HttpServletResponse) {
        var oldCookie: Cookie? = null

        request.cookies?.map {
            if (it.name == "viewCounts") {
                oldCookie = it
            }
        }

        oldCookie?.let {
            if (!it.value.contains("[${wikiId}]")) { // 쿠키에 해당 wikiId가 존재하지 않으면
                it.value += "[${wikiId}]"
                response.addCookie(oldCookie)

                return wikiPageRepository.updateViews(wikiId) // 조회수 증가
            } else {
                return // 존재하면
            }
        }

        // Cookie가 없는 경우
        val newCookieValue = "[${wikiId}]"
        val viewCountCookie = Cookie("viewCounts", newCookieValue)
        response.addCookie(viewCountCookie)
        return wikiPageRepository.updateViews(wikiId) // 조회수 증가
    }

    @Transactional
    override fun updateWikiPage(wikiId: Long, request: UpdateWikiPageRequest, image: MultipartFile?): WikiPageResponse {
        val memberId = memberService.getMemberIdFromToken()
        val member = memberRepository.findByIdOrNull(memberId) ?: throw ModelNotFoundException("Member", memberId!!.toString())
        val wikiPage = wikiPageRepository.findByIdOrNull(wikiId) ?: throw ModelNotFoundException("WikiPage", wikiId.toString())

        if (member.role == Role.USER && memberId != wikiPage.memberId) {
            throw CustomAccessDeniedException("수정 권한이 없습니다.")
        }

        request.title?.let {
            wikiPage.createWikiHistory(
                CreateWikiHistoryRequest(
                    wikiPage = wikiPage,
                    columnType = WikiHistoryColumnType.TITLE,
                    beforeContent = wikiPage.title,
                    afterContent = it,
                    author = member.name
                )
            )
        }

        request.content?.let {
            wikiPage.createWikiHistory(
                CreateWikiHistoryRequest(
                    wikiPage = wikiPage,
                    columnType = WikiHistoryColumnType.CONTENT,
                    beforeContent = wikiPage.content,
                    afterContent = it,
                    author = member.name
                )
            )
        }


        wikiPage.update(
            title = request.title,
            content = request.content
        )

        image?.let {
            // 신규 이미지 등록
            val imageFileName = "${wikiPage.id.toString()}-${
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"))
            }"
            val imageLink = s3Service.upload(it, imageFileName)

            wikiPage.uploadImage(imageLink)

            // 게시물 생성 및 수정 히스토리에 수정 이력 등록
            wikiPage.createWikiHistory(
                CreateWikiHistoryRequest(
                    wikiPage = wikiPage,
                    columnType = WikiHistoryColumnType.IMAGE,
                    beforeContent = wikiPage.image ?: "이미지 없음",
                    afterContent = imageLink,
                    author = member.name
                )
            )
        }

        return wikiPage.toResponse()
    }

    @Transactional
    override fun deleteWikiPage(wikiId: Long) {
        val wikiPage = wikiPageRepository.findByIdOrNull(wikiId) ?: throw ModelNotFoundException("WikiPage", wikiId.toString())
        val imageList = wikiHistoryCustomRepository.findImageById(wikiId) // S3에서 지울 이미지 key 가져오기

        // DELETE
        debateJpaRepository.deleteByWikiId(wikiId) // debate
        wikiLikeRepository.deleteByWikiLikeIdWikiId(wikiId) // reaction
        wikiPage.deleteAllWikiHistory() // wiki_history
        wikiPageRepository.deleteById(wikiId) // wiki_page


        imageList.forEach { s3Service.delete(it) }
    }

    override fun getWikiHistory(wikiId: Long): List<WikiHistoryResponse> {
        return wikiHistoryCustomRepository.findHistoryById(wikiId).map { it.toResponse() }
    }

    @Transactional
    override fun getWikiPageList(searchType: SearchType, keyword: KeywordRequest?, pageable: Pageable): Page<WikiPageResponse> {

        val result = lettuceRedis.findAllHashSet(MatchingKey.WIKI.name, searchType, keyword?.keyword ?: "")

        val titleList = result.map { it["title"]!! }
        val tagList = result.map { it["tag"]!! }

        fun filteringResult(search: String) = result.filter { it[search]?.contains(keyword?.keyword ?: "") == true }

        when(searchType){
            SearchType.NONE -> {
                val searchResult = wikiPageRepository.searchExceptTop10(pageable, keyword?.keyword ?: "", titleList).map { it.toResponse() }

                if(result.isNotEmpty()) return convertToPage(filteringResult("title").toMutableList(), pageable, searchResult)

                return searchResult
            }
            SearchType.TITLE -> {
                val databaseResult = wikiPageRepository.keywordSearchExceptTop10(searchType, keyword?.keyword ?: "", pageable, tagList).map { it.toResponse() }

                if(result.isNotEmpty()) return convertToPage(filteringResult("title").toMutableList(), pageable, databaseResult)

                return databaseResult
            }
            SearchType.TAG -> {
                val databaseResult = wikiPageRepository.keywordSearchExceptTop10(searchType, keyword?.keyword ?: "", pageable, tagList).map { it.toResponse() }

                if(result.isNotEmpty()) return convertToPage(filteringResult("tag").toMutableList(), pageable, databaseResult)

                return databaseResult
            }
            else -> throw IllegalArgumentException()
        }

    }


    fun getPopularWordTop10(): List<PopularWordTop10Response> {
        return PopularWordTop10Response.from(lettuceRedis.findHashSet(MatchingKey.TOP10))
//        return lettuceRedis.findAll("top10")
    }

    private fun savedRedisAndToResponse(wikiId: Long): WikiPageResponse {

        val result = wikiPageRepository.findByIdOrNull(wikiId) ?: throw ModelNotFoundException("WikiPage", wikiId.toString())

        savedRedis(result)

        return result.toResponse()
    }

    private fun savedRedis(args: WikiPage){
        val resultMap = mapOf(
            "title" to args.title,
            "content" to args.content,
            "image" to args.image,
            "tag" to args.tag,
            "reaction" to args.reaction.toString(),
            "views" to args.views.toString(),
            "created_at" to args.createdAt.toString(),
            "updated_at" to args.updatedAt.toString(),
        )

        lettuceRedis.saveAllHashSet(args.title, resultMap, 3600)
    }

    fun convertToPage(list: MutableList<Map<String, String>>, pageable: Pageable, searchDataBase: Page<WikiPageResponse>): Page<WikiPageResponse> {
        val responses = list.map { map ->
            WikiPageResponse(
                title = map["title"] ?: "",
                content = map["key2"] ?: "",
                image = map["image"] ?: "",
                tag = map["tag"] ?: "",
                reaction = map["reaction"]?.toLong() ?: 0L,
                views = map["views"]?.toLong() ?: 0L,
                createdAt = map["created_at"] ?: "",
                updatedAt = map["updated_at"] ?: "",
            )
        }

        val result = responses + searchDataBase.content
        val size = result.size
        val pageSetting = PageRequest.of(pageable.pageNumber, pageable.pageSize)

        val start = (pageable.pageNumber * pageable.pageSize).coerceAtMost(size)
        val end = (start + pageable.pageSize).coerceAtMost(size)

        val currentPageContent = result.subList(start, end)

        return PageImpl(currentPageContent, pageSetting, size.toLong())
    }


}