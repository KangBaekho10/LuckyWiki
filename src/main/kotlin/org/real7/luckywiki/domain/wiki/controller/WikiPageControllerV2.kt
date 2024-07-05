package org.real7.luckywiki.domain.wiki.controller

import org.real7.luckywiki.domain.wiki.service.WikiPageService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v2/wikis")
class WikiPageControllerV2(
    private val wikiPageService: WikiPageService
){

    @GetMapping("/popular-word-top10")
    fun getPopularWordTop10(): ResponseEntity<Map<String, String>> {
        return ResponseEntity.ok(wikiPageService.getPopularWordTop10Redis())
    }
}