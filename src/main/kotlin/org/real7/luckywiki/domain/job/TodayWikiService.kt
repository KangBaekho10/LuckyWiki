package org.real7.luckywiki.domain.job

import org.real7.luckywiki.domain.wiki.dto.wikipage.WikiPageResponse
import org.real7.luckywiki.domain.wiki.model.WikiPage
import org.real7.luckywiki.domain.wiki.model.toResponse
import org.real7.luckywiki.domain.wiki.repository.wikipage.WikiPageRepository
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.CachePut
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class TodayWikiService(
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
        return id
    }

    private fun getId(): Long? {
        val cache = cacheManager.getCache("today_wiki")
        val cachedValue = cache?.get("key")?.get()
        return cachedValue as? Long
    }


    fun getTodayWiki() : WikiPage {
        return wikiPageRepository.findByIdOrNull(getId())!!
    }

}