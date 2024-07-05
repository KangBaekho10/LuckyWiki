package org.real7.luckywiki.infra.task

import org.real7.luckywiki.domain.wiki.repository.popularword.PopularWordRepository
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class ScheduledDeletionTasks(
    private val popularWordRepository: PopularWordRepository
) {

    @Scheduled(cron = "0 * * * * *") // 1분마다 실행 -> 24시간 마다 삭제로 변경해야 함, 인기 검색어는 24시간 기준
    fun reportCurrentTime() {
        popularWordRepository.deleteDataPast24Hours()
    }
}