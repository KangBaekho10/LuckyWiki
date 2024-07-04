package org.real7.luckywiki.domain.job

import org.real7.luckywiki.domain.wiki.dto.WikiPageResponse
import org.real7.luckywiki.domain.wiki.model.WikiPage
import org.real7.luckywiki.domain.wiki.model.toResponse
import org.real7.luckywiki.domain.wiki.repository.WikiPageRepository
import org.real7.luckywiki.exception.ModelNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.Cache
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.data.repository.findByIdOrNull
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class why(
    val wikiPageRepository: WikiPageRepository,
    val cacheManager: CacheManager
) {


    @CachePut(cacheNames = ["today_wiki"], key = "'key'")
    fun real(): Long {
        val max = wikiPageRepository.findMaxId() ?: throw IllegalArgumentException("Max ID not found")
        var id = Random.nextLong(max)
        while (!wikiPageRepository.existsById(id)) {
            id = Random.nextLong(max)
        }
        println("실행됨$id")
        return id
    }

    private fun getId(): Long? {
        val cache = cacheManager.getCache("today_wiki")
        val cachedValue = cache?.get("key")?.get()
        return cachedValue as? Long
    }


    fun getTodayWiki() : WikiPageResponse {
        println("//////////${getId()}//////////")
        return wikiPageRepository.findByIdOrNull(getId())!!.toResponse()
    }

}