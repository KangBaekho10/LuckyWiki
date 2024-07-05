package org.real7.luckywiki.config

import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.concurrent.ConcurrentMapCache
import org.springframework.cache.support.SimpleCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
@EnableCaching
class CacheConfig {

    @Bean
    fun cacheManager(): CacheManager {
        val simpleCacheManager = SimpleCacheManager()
        simpleCacheManager.setCaches(
            listOf(
                ConcurrentMapCache("popularWordTop10"),
                ConcurrentMapCache("wikiPage"),
                ConcurrentMapCache("today_wiki")
            )
        )
        return simpleCacheManager
    }
}