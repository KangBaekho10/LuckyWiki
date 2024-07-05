package org.real7.luckywiki.domain.wiki.controller

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import jakarta.validation.Valid
import org.real7.luckywiki.domain.wiki.dto.*
import org.real7.luckywiki.domain.wiki.dto.wikihistory.WikiHistoryResponse
import org.real7.luckywiki.domain.wiki.dto.wikipage.CreateWikiPageRequest
import org.real7.luckywiki.domain.wiki.dto.wikipage.CreateWikiPageResponse
import org.real7.luckywiki.domain.wiki.dto.wikipage.UpdateWikiPageRequest
import org.real7.luckywiki.domain.wiki.dto.wikipage.WikiPageResponse
import org.real7.luckywiki.domain.wiki.model.type.SearchType
import org.real7.luckywiki.domain.wiki.service.WikiPageService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
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
        @RequestPart @Valid request: CreateWikiPageRequest,
        @RequestPart image: MultipartFile?
    ): ResponseEntity<CreateWikiPageResponse> {
        return ResponseEntity.status(HttpStatus.CREATED).body(wikiPageService.createWikiPage(request, image))
    }

    @GetMapping("/{wikiId}")
    fun getWikiPage(@PathVariable wikiId: Long, request: HttpServletRequest, response: HttpServletResponse): ResponseEntity<WikiPageResponse> {
        return ResponseEntity.ok(wikiPageService.getWikiPage(wikiId, request, response))
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

    @GetMapping
    fun getWikiPageList(
        @RequestParam searchType: SearchType, // searchType: title, tag
        @RequestParam @Valid keyword: KeywordRequest?,
        @PageableDefault(page = 0, size = 10, sort = ["createdAt"], direction = Sort.Direction.DESC) pageable: Pageable
    ): ResponseEntity<Page<WikiPageResponse>> {
        return ResponseEntity.ok(wikiPageService.getWikiPageList(searchType, keyword, pageable))
    }

    @GetMapping("/popular-word-top10")
    fun getPopularWordTop10(): ResponseEntity<List<String>> {
        return ResponseEntity.ok(wikiPageService.getPopularWordTop10())
    }

    // ---------------------------------------------------------------
    // TODO: /api/v2/popular-word-top10
    // TODO: 일간 게시물 조회 /api/v2/daily-wiki
    // TODO: 게시물 전체 조회 /api/v2/wikis?searchType=${searchType}&keyword={keyword}
}