package org.real7.luckywiki.domain.job

import org.real7.luckywiki.domain.wiki.dto.WikiPageResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RequestMapping("/api/v1")
@RestController
class RandomController(
    val why: why
) {

    @GetMapping("/today")
    fun getToday() : ResponseEntity<WikiPageResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(why.getTodayWiki())
    }

}