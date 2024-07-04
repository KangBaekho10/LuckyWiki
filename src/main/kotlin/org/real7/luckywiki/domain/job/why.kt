package org.real7.luckywiki.domain.job

import org.real7.luckywiki.domain.wiki.repository.WikiPageRepository
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class why(
    val wikiPageRepository: WikiPageRepository
) {

    @Scheduled(cron = "0 0 * * * *")
    fun real(max:Long) : Long {
        var id = Random.nextLong(max)
        while(!wikiPageRepository.existsById(id)) {
            id = Random.nextLong(max)
        }
        return id
    }
}