package org.real7.luckywiki.domain.job

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class Job(
    val why: why
) {

    @Scheduled(cron = "0 * * * * *")
    fun sc() {
        why.real()
    }

}