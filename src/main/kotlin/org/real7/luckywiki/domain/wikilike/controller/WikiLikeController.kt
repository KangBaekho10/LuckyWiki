package org.real7.luckywiki.domain.wikilike.controller

import org.real7.luckywiki.domain.member.service.MemberService
import org.real7.luckywiki.domain.wikilike.dto.WikiLikeResponse
import org.real7.luckywiki.domain.wikilike.service.WikiLikeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/wikis")
class WikiLikeController (
    private val memberService: MemberService,
    private val wikiLikeService: WikiLikeService
) {
    @PostMapping("/{wikiId}/reaction")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    fun wikiLike(
        @PathVariable wikiId: Long
    ): ResponseEntity<WikiLikeResponse> {
        val memberId = memberService.getMemberDetails()?.getMemberId()
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(wikiLikeService.like(memberId!!, wikiId))
    }

    @DeleteMapping("/{wikiId}/reaction")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    fun unWikiLike(
        @PathVariable wikiId: Long
    ): ResponseEntity<Unit> {
        val memberId = memberService.getMemberDetails()?.getMemberId()
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .body(wikiLikeService.unlike(memberId!!, wikiId))
    }
}