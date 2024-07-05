package org.real7.luckywiki.domain.wiki.service

import org.real7.luckywiki.common.MatchingKey
import org.real7.luckywiki.config.LettuceRedis
import org.real7.luckywiki.domain.wiki.repository.popularword.PopularWordCustomRepository
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class WikiPageServiceScheduler(
    private val popularWordRepository: PopularWordCustomRepository,
    private val lettuceRedis: LettuceRedis
){

    @Scheduled(cron = "0 * * * * *")
    fun savePopularWordTop10(){
        val result = popularWordRepository.getPopularWordTop10()

        lettuceRedis.saveAllHashSet(MatchingKey.TOP10, result, 3600)
//        lettuceRedis.saveAll("top10", result, 3600)

    }

}