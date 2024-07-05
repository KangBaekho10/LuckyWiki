package org.real7.luckywiki.domain.job

import org.real7.luckywiki.config.LettuceRedis
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class JobScheduler(
    private val lettuceRedis: LettuceRedis,
    private val todayWikiService: TodayWikiService
){

    @Scheduled(cron = "0 * * * * *")
    fun savedTodayWiki(){

        val result = todayWikiService.getTodayWiki()

        val resultMap = mapOf("title" to result.title, "content" to result.content, "image" to result.image)

        lettuceRedis.saveAllHashSet("TodayWiki", resultMap, 86400)
    }
}