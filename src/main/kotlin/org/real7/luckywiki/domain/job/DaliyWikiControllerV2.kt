package org.real7.luckywiki.domain.job

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v2")
@RestController
class DailyWikiControllerV2(
    val todayWikiService: TodayWikiService
) {

    @GetMapping("/today")
    fun getToday() : ResponseEntity<Map<String, String>> {
        return ResponseEntity.status(HttpStatus.OK).body(todayWikiService.getTodayWikiRedis())
    }

}