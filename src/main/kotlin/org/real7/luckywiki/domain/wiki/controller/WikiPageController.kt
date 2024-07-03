package org.real7.luckywiki.domain.wiki.controller

import jakarta.validation.Valid
import org.real7.luckywiki.domain.wiki.dto.*
import org.real7.luckywiki.domain.wiki.service.WikiPageService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/v1/wikis")
class WikiPageController(
    private val wikiPageService: WikiPageService
) {
    // TODO: 사용자, 관리자만 가능으로 Token 구현 후 권한 체크 필요
    @PostMapping
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

    // TODO: 사용자, 관리자만 가능으로 Token 구현 후 권한 체크 필요
    @PutMapping("/{wikiId}")
    fun updateWikiPage(
        @PathVariable wikiId: Long,
        @RequestPart  @Valid request: UpdateWikiPageRequest,
        @RequestPart image: MultipartFile?
    ): ResponseEntity<WikiPageResponse> {
        return ResponseEntity.ok(wikiPageService.updateWikiPage(wikiId, request, image))
    }
    // TODO: 게시물 삭제 /api/v1/wikis/{wikiId}
    // TODO: 태그 수정 /api/v1/wikis/{wikiId}
    // TODO: 게시물 생성 및 수정 히스토리 /api/v1/wikis/{wikiId}/history
    // ---------------------------------------------------------------
    // TODO: /api/v2/popular-word-top10
    // TODO: 일간 게시물 조회 /api/v2/daily-wiki
    // TODO: 게시물 전체 조회 /api/v2/wikis?searchType=${searchType}&keyword={keyword}
}