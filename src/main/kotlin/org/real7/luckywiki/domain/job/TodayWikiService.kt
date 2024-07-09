package org.real7.luckywiki.domain.job

import org.real7.luckywiki.common.MatchingKey
import org.real7.luckywiki.config.LettuceRedis
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
    val cacheManager: CacheManager,
    val lettuceRedis: LettuceRedis
) {

//    @CachePut(cacheNames = ["today_wiki"], key = "'key'")
    fun getTodayWiki(): WikiPageResponse {
        val max = wikiPageRepository.findMaxId() ?: throw IllegalArgumentException("Max ID not found")
        var id = Random.nextLong(max)
        while (!wikiPageRepository.existsById(id)) {
            id = Random.nextLong(max)
        }
        return wikiPageRepository.findByIdOrNull(id)!!.toResponse()
    }

    fun getTodayWikiRedis() : Map<String, String> {
        return lettuceRedis.findHashSet(MatchingKey.TODAYWIKI)
    }

}