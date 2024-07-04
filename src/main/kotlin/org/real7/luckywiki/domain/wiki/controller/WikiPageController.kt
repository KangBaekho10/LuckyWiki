package org.real7.luckywiki.domain.wiki.controller

import jakarta.validation.Valid
import org.real7.luckywiki.domain.wiki.dto.*
import org.real7.luckywiki.domain.wiki.service.WikiPageService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/v1/wikis")
class WikiPageController(
    private val wikiPageService: WikiPageService
) {
    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    fun createWiki(
        // TODO: userId는 Token의 값을 가져와야 함
        @RequestPart @Valid request: CreateWikiPageRequest,
        @RequestPart image: MultipartFile?
    ): ResponseEntity<CreateWikiPageResponse> {
        val memberId = 1L
        return ResponseEntity.status(HttpStatus.CREATED).body(wikiPageService.createWikiPage(memberId, request, image))
    }

    @GetMapping("/{wikiId}")
    fun getWikiPage(@PathVariable wikiId: Long): ResponseEntity<WikiPageResponse> {
        return ResponseEntity.ok(wikiPageService.getWikiPage(wikiId))
    }

    @PutMapping("/{wikiId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    fun updateWikiPage(
        @PathVariable wikiId: Long,
        @RequestPart @Valid request: UpdateWikiPageRequest,
        @RequestPart image: MultipartFile?
    ): ResponseEntity<WikiPageResponse> {
        return ResponseEntity.ok(wikiPageService.updateWikiPage(wikiId, request, image))
    }

    @DeleteMapping("/{wikiId}")
    @PreAuthorize("hasRole('ADMIN')")
    fun deleteWikiPage(@PathVariable wikiId: Long): ResponseEntity<Unit> {
        wikiPageService.deleteWikiPage(wikiId)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/{wikiId}/history")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    fun getWikiHistory(@PathVariable wikiId: Long): ResponseEntity<List<WikiHistoryResponse>> {
        return ResponseEntity.ok(wikiPageService.getWikiHistory(wikiId))
    }

    // TODO: 태그 수정 /api/v1/wikis/{wikiId}
    // ---------------------------------------------------------------
    // TODO: /api/v2/popular-word-top10
    // TODO: 일간 게시물 조회 /api/v2/daily-wiki
    // TODO: 게시물 전체 조회 /api/v2/wikis?searchType=${searchType}&keyword={keyword}
}