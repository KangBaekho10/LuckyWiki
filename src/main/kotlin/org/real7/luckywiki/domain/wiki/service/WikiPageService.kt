package org.real7.luckywiki.domain.wiki.service

import org.real7.luckywiki.domain.wiki.dto.CreateWikiPageRequest
import org.real7.luckywiki.domain.wiki.dto.CreateWikiPageResponse
import org.real7.luckywiki.domain.wiki.dto.WikiPageResponse
import org.real7.luckywiki.domain.wiki.model.WikiPage
import org.real7.luckywiki.domain.wiki.model.createWikiPageResponse
import org.real7.luckywiki.domain.wiki.model.toResponse
import org.real7.luckywiki.domain.wiki.repository.WikiPageRepository
import org.real7.luckywiki.exception.ModelNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile

@Service
class WikiPageService(
    private val wikiPageRepository: WikiPageRepository
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

        image?.let {
            println("image 확인")
            // TODO: S3 연결 후 아래 코드 활성화
//            wikiPage.imageUpload(s3Service.upload(it, result.id.toString()))
        }

        return wikiPage.createWikiPageResponse()
    }

    fun getWikiPage(wikiId: Long): WikiPageResponse {
        val wikiPage = wikiPageRepository.findByIdOrNull(wikiId) ?: throw ModelNotFoundException("WikiPage", wikiId)
        return wikiPage.toResponse()
    }
}