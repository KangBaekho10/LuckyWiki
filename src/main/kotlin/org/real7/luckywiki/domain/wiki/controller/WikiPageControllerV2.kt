package org.real7.luckywiki.domain.wiki.controller

import jakarta.validation.Valid
import org.real7.luckywiki.domain.wiki.dto.KeywordRequest
import org.real7.luckywiki.domain.wiki.dto.wikipage.PopularWordTop10Response
import org.real7.luckywiki.domain.wiki.dto.wikipage.WikiPageResponse
import org.real7.luckywiki.domain.wiki.model.type.SearchType
import org.real7.luckywiki.domain.wiki.service.WikiPageServiceImplV2
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v2/wikis")
class WikiPageControllerV2(
    private val wikiPageService: WikiPageServiceImplV2
){

    @GetMapping("/popular-word-top10")
    fun getPopularWordTop10(): ResponseEntity<List<PopularWordTop10Response>> {
        return ResponseEntity.ok(wikiPageService.getPopularWordTop10())
    }

    @GetMapping("/{wikiId}")
    fun getWikiPage(
        @PathVariable("wikiId") wikiId: Long,
    ): ResponseEntity<WikiPageResponse> {
        return ResponseEntity.ok(wikiPageService.getWikiPageRedis(wikiId))
    }

    @GetMapping()
    fun getWikiPageList(
        @RequestParam searchType: SearchType, // searchType: title, tag
        @RequestParam @Valid keyword: KeywordRequest?,
        pageable: Pageable
    ): ResponseEntity<Page<WikiPageResponse>> {
        return ResponseEntity.ok(wikiPageService.getWikiPageList(searchType, keyword ?: KeywordRequest(""), pageable))
    }
}