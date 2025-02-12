package org.real7.luckywiki.infra.task

import org.real7.luckywiki.domain.wiki.repository.popularword.PopularWordRepository
import org.springframework.cache.CacheManager
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class ScheduledDeletionTasks(
    private val popularWordRepository: PopularWordRepository,
    private val cacheManager: CacheManager
) {

    @Scheduled(cron = "0 0 0 * * *") // 24시간 마다 삭제
    fun deletePopularWordDataPast24Hours() {
        popularWordRepository.deleteDataPast24Hours()
    }

    @Scheduled(cron = "0 0 * * * *") // 1시간 마다 삭제
    fun deletePopularWordCacheDataPast1Hours() {
        cacheManager.getCache("popularWordTop10")?.clear()
    }
}