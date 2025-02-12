package org.real7.luckywiki.domain.wikilike.service

import org.real7.luckywiki.domain.member.service.MemberService
import org.real7.luckywiki.domain.wiki.service.WikiPageServiceImpl
import org.real7.luckywiki.domain.wikilike.dto.WikiLikeResponse
import org.real7.luckywiki.domain.wikilike.model.WikiLike
import org.real7.luckywiki.domain.wikilike.model.WikiLikeId
import org.real7.luckywiki.domain.wikilike.repository.WikiLikeRepository
import org.real7.luckywiki.exception.ModelNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class WikiLikeService(
    private val memberService: MemberService,
    private val wikiService: WikiPageServiceImpl,
    private val wikiLikeRepository: WikiLikeRepository
) {
    @Transactional
    fun like(memberId: Long, wikiId: Long): WikiLikeResponse {
        val member = memberService.getMemberById(memberId)
        val wiki = wikiService.getWikiById(wikiId)
        return wikiLikeRepository.save(
            WikiLike.createWikiLike(
                member,
                wiki
            )
        ).toResponse()
    }

    @Transactional
    fun unlike(memberId: Long, wikiId: Long) {
        val wikiLikeId = WikiLikeId()
        wikiLikeId.member = memberService.getMemberById(memberId)
        wikiLikeId.wiki = wikiService.getWikiById(wikiId)
        val wikiLike = wikiLikeRepository.findByWikiLikeId(wikiLikeId) ?: throw ModelNotFoundException("Follow", memberId.toString())
        wikiLikeRepository.delete(wikiLike)
    }
}