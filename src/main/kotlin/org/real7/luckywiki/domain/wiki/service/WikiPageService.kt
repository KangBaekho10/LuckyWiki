package org.real7.luckywiki.domain.wiki.service

import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.real7.luckywiki.config.LettuceRedis
import org.real7.luckywiki.domain.debate.repository.DebateJpaRepository
import org.real7.luckywiki.domain.member.repository.MemberRepository
import org.real7.luckywiki.domain.member.service.MemberService
import org.real7.luckywiki.domain.wiki.dto.*
import org.real7.luckywiki.domain.wiki.model.PopularWord
import org.real7.luckywiki.domain.wiki.model.WikiPage
import org.real7.luckywiki.domain.wiki.model.createWikiPageResponse
import org.real7.luckywiki.domain.wiki.model.toResponse
import org.real7.luckywiki.domain.wiki.model.type.SearchType
import org.real7.luckywiki.domain.wiki.model.type.WikiHistoryColumnType
import org.real7.luckywiki.domain.wiki.repository.*
import org.real7.luckywiki.domain.wikilike.repository.WikiLikeRepository
import org.real7.luckywiki.exception.ModelNotFoundException
import org.real7.luckywiki.infra.aws.S3Service
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class WikiPageService(
    private val wikiPageRepository: WikiPageRepository,
    private val s3Service: S3Service,
    private val wikiHistoryCustomRepository: WikiHistoryCustomRepository,
    private val wikiPageCustomRepository: WikiPageCustomRepository,
    private val popularWordRepository: PopularWordRepository,
    private val popularWordCustomRepository: PopularWordCustomRepository,
    private val memberRepository: MemberRepository,
    private val memberService: MemberService,
    private val debateJpaRepository: DebateJpaRepository,
    private val wikiLikeRepository: WikiLikeRepository,
    private val lettuceRedis: LettuceRedis
) {

    @Transactional
    fun createWikiPage(request: CreateWikiPageRequest, image: MultipartFile?): CreateWikiPageResponse {
        val memberId = memberService.getMemberIdFromToken()
        val member = memberRepository.findByIdOrNull(memberId) ?: throw ModelNotFoundException("Member", memberId!!)
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

    fun getWikiPage(wikiId: Long, request: HttpServletRequest, response: HttpServletResponse): WikiPageResponse {
        val wikiPage = wikiPageRepository.findByIdOrNull(wikiId) ?: throw ModelNotFoundException("WikiPage", wikiId)

        viewCountUp(wikiId, request, response)

        return wikiPage.toResponse()
    }

    @Transactional
    fun viewCountUp(wikiId: Long, request: HttpServletRequest, response: HttpServletResponse) {
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

                return wikiPageCustomRepository.updateViews(wikiId) // 조회수 증가
            } else {
                return // 존재하면
            }
        }

        // Cookie가 없는 경우
        val newCookieValue = "[${wikiId}]"
        val viewCountCookie = Cookie("viewCounts", newCookieValue)
        response.addCookie(viewCountCookie)
        return wikiPageCustomRepository.updateViews(wikiId) // 조회수 증가
    }

    @Transactional
    fun updateWikiPage(wikiId: Long, request: UpdateWikiPageRequest, image: MultipartFile?): WikiPageResponse {
        val memberId = memberService.getMemberIdFromToken()
        val member = memberRepository.findByIdOrNull(memberId) ?: throw ModelNotFoundException("Member", memberId!!)
        val wikiPage = wikiPageRepository.findByIdOrNull(wikiId) ?: throw ModelNotFoundException("WikiPage", wikiId)

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
    fun deleteWikiPage(wikiId: Long) {
        val wikiPage = wikiPageRepository.findByIdOrNull(wikiId) ?: throw ModelNotFoundException("WikiPage", wikiId)
        val imageList = wikiHistoryCustomRepository.findImageById(wikiId) // S3에서 지울 이미지 key 가져오기

        // DELETE
        debateJpaRepository.deleteByWikiId(wikiId) // debate
        wikiLikeRepository.deleteByWikiLikeIdWikiId(wikiId) // reaction
        wikiPage.deleteAllWikiHistory() // wiki_history
        wikiPageRepository.deleteById(wikiId) // wiki_page


        imageList.forEach { s3Service.delete(it) }
    }

    fun getWikiHistory(wikiId: Long): List<WikiHistoryResponse> {
        return wikiHistoryCustomRepository.findHistoryById(wikiId).map { it.toResponse() }
    }

    fun getWikiById(id: Long): WikiPage {
        return wikiPageRepository.findByIdOrNull(id) ?: throw ModelNotFoundException("Wiki", id)
    }

    fun getWikiPageList(searchType: SearchType, keyword: KeywordRequest?, pageable: Pageable): Page<WikiPageResponse> {
        if (searchType == SearchType.NONE) {
            return wikiPageCustomRepository.search(pageable).map { it.toResponse() }
        }

        keyword?.let { popularWordRepository.save(PopularWord.from(it.keyword)) }

        return wikiPageCustomRepository.keywordSearch(searchType, keyword!!, pageable).map { it.toResponse() }
    }

    @Scheduled(cron = "0 0 0 * * * ")
    fun savePopularWordTop10(){
        val result = popularWordCustomRepository.getPopularWordTop10()
        lettuceRedis.saveAll(result)
    }

    fun getPopularWordTop10(): List<Map<String, String>> {

        return lettuceRedis.findAll()
    }
}