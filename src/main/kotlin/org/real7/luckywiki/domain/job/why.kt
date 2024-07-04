package org.real7.luckywiki.domain.job

import org.real7.luckywiki.domain.wiki.dto.WikiPageResponse
import org.real7.luckywiki.domain.wiki.model.WikiPage
import org.real7.luckywiki.domain.wiki.model.toResponse
import org.real7.luckywiki.domain.wiki.repository.WikiPageRepository
import org.real7.luckywiki.exception.ModelNotFoundException
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.data.repository.findByIdOrNull
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
@Component
class why(
    val wikiPageRepository: WikiPageRepository
) {

    @CachePut(cacheNames = ["today_wiki"])
    @Scheduled(cron = "0 * * * * *")
    fun real() : Long {
        val max = wikiPageRepository.findMaxId()
        var id = Random.nextLong(max!!)
        while(!wikiPageRepository.existsById(id)) {
            id = Random.nextLong(max)
        }
        println("스케쥬ㅠㄹ러는 실행이 되나?")
        return id
    }

    @Cacheable(cacheNames = ["today_wiki"])
    fun getId(): Long? {
        return null
    }

    fun getTodayWiki() : WikiPageResponse {
//        val id = if(!wikiPageRepository.existsById(getId()!!)) real() else getId()

        println("////${real()}//////${getId()}//////////")
        return wikiPageRepository.findByIdOrNull(getId())!!.toResponse()
    }

}