package org.real7.luckywiki.domain.wiki.controller

import jakarta.validation.Valid
import org.real7.luckywiki.domain.wiki.dto.KeywordRequest
import org.real7.luckywiki.domain.wiki.dto.wikipage.WikiPageResponse
import org.real7.luckywiki.domain.wiki.model.type.SearchType
import org.real7.luckywiki.domain.wiki.service.WikiPageServiceImplV2
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v2/wikis")
class WikiPageControllerV2(
    private val wikiPageService: WikiPageServiceImplV2
){

    @GetMapping("/popular-word-top10")
    fun getPopularWordTop10(): ResponseEntity<Map<String, String>> {
        return ResponseEntity.ok(wikiPageService.getPopularWordTop10())
    }

    @GetMapping
    fun getWiki(
        @RequestParam searchType: SearchType, // searchType: title, tag
        @RequestParam @Valid keyword: KeywordRequest?,
    ): ResponseEntity<WikiPageResponse> {
        return ResponseEntity.ok(wikiPageService.getWikiPageRedis(searchType, keyword ?: KeywordRequest("")))
    }
}