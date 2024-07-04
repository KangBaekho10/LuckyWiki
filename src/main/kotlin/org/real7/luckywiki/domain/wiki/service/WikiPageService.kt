package org.real7.luckywiki.domain.wiki.service

import org.real7.luckywiki.domain.wiki.dto.*
import org.real7.luckywiki.domain.wiki.model.PopularWord
import org.real7.luckywiki.domain.wiki.model.WikiPage
import org.real7.luckywiki.domain.wiki.model.createWikiPageResponse
import org.real7.luckywiki.domain.wiki.model.toResponse
import org.real7.luckywiki.domain.wiki.model.type.SearchType
import org.real7.luckywiki.domain.wiki.model.type.WikiHistoryColumnType
import org.real7.luckywiki.domain.wiki.repository.*
import org.real7.luckywiki.exception.ModelNotFoundException
import org.real7.luckywiki.infra.aws.S3Service
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
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
    private val popularWordCustomRepository: PopularWordCustomRepository
) {

    @Transactional
    fun createWikiPage(memberId: Long, request: CreateWikiPageRequest, image: MultipartFile?): CreateWikiPageResponse {
        // TODO: Member 구현이 완료되면 memberRepository의 getByIdOrNull(memberId)로 회원 정보 가져오기
//        val member = memberRepository.findByIdOrNull(memberId) ?: throw ModelNotFoundException("Member", memberId)
        val wikiPage = wikiPageRepository.save(
            WikiPage.from(
                request = request,
                memberId = memberId
            )
        )
        request.title.let {
            wikiPage.createWikiHistory(
                CreateWikiHistoryRequest(
                    wikiPage = wikiPage,
                    columnType = WikiHistoryColumnType.TITLE,
                    beforeContent = wikiPage.title,
                    afterContent = it,
                    author = "TEST"
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
                    author = "TEST"
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
                    author = "TEST"
                )
            )
        }

        return wikiPage.createWikiPageResponse()
    }

    fun getWikiPage(wikiId: Long): WikiPageResponse {
        val wikiPage = wikiPageRepository.findByIdOrNull(wikiId) ?: throw ModelNotFoundException("WikiPage", wikiId)
        return wikiPage.toResponse()
    }

    @Transactional
    fun updateWikiPage(wikiId: Long, request: UpdateWikiPageRequest, image: MultipartFile?): WikiPageResponse {
        val wikiPage = wikiPageRepository.findByIdOrNull(wikiId) ?: throw ModelNotFoundException("WikiPage", wikiId)

        request.title?.let {
            wikiPage.createWikiHistory(
                CreateWikiHistoryRequest(
                    wikiPage = wikiPage,
                    columnType = WikiHistoryColumnType.TITLE,
                    beforeContent = wikiPage.title,
                    afterContent = it,
                    author = "TEST"
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
                    author = "TEST"
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
                    author = "TEST"
                )
            )
        }

        return wikiPage.toResponse()
    }

    fun deleteWikiPage(wikiId: Long) {
        // 이미지 이력을 찾아서 이미지 먼저 지우고 데이터 삭제, 데이터 먼저 삭제하면 이미지 이력을 찾아올 수 없음
        // TODO: 연관된 테이블들의 데이터 삭제 문제!!
        val wikiPage = wikiPageRepository.findByIdOrNull(wikiId) ?: throw ModelNotFoundException("WikiPage", wikiId)
        val imageList = wikiHistoryCustomRepository.findImageById(wikiId)

        wikiPage.deleteAllWikiHistory()
        wikiPageRepository.deleteById(wikiId)

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

    fun getPopularWordTop10(): List<String> {
        return popularWordCustomRepository.getPopularWordTop10()
    }
}