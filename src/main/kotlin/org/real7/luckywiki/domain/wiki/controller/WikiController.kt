package org.real7.luckywiki.domain.wiki.controller

import org.real7.luckywiki.domain.wiki.dto.CreateWikiPageRequest
import org.real7.luckywiki.domain.wiki.dto.CreateWikiPageResponse
import org.real7.luckywiki.domain.wiki.service.WikiPageService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/v1/wikis")
class WikisController(
    private val wikiPageService: WikiPageService
) {
    // TODO: 게시물 생성 /api/v1/wikis - 사용자, 관리자만 가능
    @PostMapping
    fun createWiki(
        // TODO: userId는 Token의 값을 가져와야 함
        @RequestPart request: CreateWikiPageRequest,
        @RequestPart image: MultipartFile?
    ): ResponseEntity<CreateWikiPageResponse> {
        val memberId = 1L
        return ResponseEntity.ok(wikiPageService.createWikiPage(memberId, request, image))
    }

    // TODO: 게시물 단 건 조회 /api/v1/wikis/{wikiId}
    // TODO: 게시물 수정 /api/v1/wikis/{wikiId} - 사용자, 관리자만 가능
    // TODO: 게시물 삭제 /api/v1/wikis/{wikiId}
    // TODO: 태그 수정 /api/v1/wikis/{wikiId}
    // TODO: 게시물 생성 및 수정 히스토리 /api/v1/wikis/{wikiId}/history
    // ---------------------------------------------------------------
    // TODO: /api/v2/popular-word-top10
    // TODO: 일간 게시물 조회 /api/v2/daily-wiki
    // TODO: 게시물 전체 조회 /api/v2/wikis?searchType=${searchType}&keyword={keyword}
}