package org.real7.luckywiki.domain.wiki.service

import org.real7.luckywiki.domain.wiki.dto.*
import org.real7.luckywiki.domain.wiki.model.WikiHistoryColumnType
import org.real7.luckywiki.domain.wiki.model.WikiPage
import org.real7.luckywiki.domain.wiki.model.createWikiPageResponse
import org.real7.luckywiki.domain.wiki.model.toResponse
import org.real7.luckywiki.domain.wiki.repository.WikiPageRepository
import org.real7.luckywiki.exception.ModelNotFoundException
import org.real7.luckywiki.infra.aws.S3Service
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class WikiPageService(
    private val wikiPageRepository: WikiPageRepository,
    private val s3Service: S3Service
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
            val imageFileName = "${wikiPage.id.toString()}-${LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"))}"
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
            val imageFileName = "${wikiPage.id.toString()}-${LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"))}"
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
}