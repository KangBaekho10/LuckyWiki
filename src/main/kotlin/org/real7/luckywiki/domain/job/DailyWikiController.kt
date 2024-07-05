package org.real7.luckywiki.domain.job

import org.real7.luckywiki.domain.wiki.dto.wikipage.WikiPageResponse
import org.real7.luckywiki.domain.wiki.model.toResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RequestMapping("/api/v1")
@RestController
class DailyWikiController(
    val todayWikiService: TodayWikiService
) {

    @GetMapping("/today")
    fun getToday() : ResponseEntity<WikiPageResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(todayWikiService.getTodayWiki().toResponse())
    }

}