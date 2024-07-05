package org.real7.luckywiki.domain.wiki.service

import org.real7.luckywiki.config.LettuceRedis
import org.real7.luckywiki.domain.wiki.repository.PopularWordCustomRepository
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class WikiPageServiceScheduler(
    private val popularWordRepository: PopularWordCustomRepository,
    private val lettuceRedis: LettuceRedis
){
    val log = LoggerFactory.getLogger("LuckyWikiPageServiceScheduler")

    @Scheduled(cron = "0 0 * * * *")
    fun savePopularWordTop10(){
        log.info("schedule is run")
        val result = popularWordRepository.getPopularWordTop10()
        lettuceRedis.saveAll(result)
    }

}