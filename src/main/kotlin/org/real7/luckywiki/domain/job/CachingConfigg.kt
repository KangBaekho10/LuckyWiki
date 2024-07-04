package org.real7.luckywiki.domain.job

import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.concurrent.ConcurrentMapCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@EnableCaching
@Configuration
class CachingConfig {
    @Bean
    fun cacheManager(): ConcurrentMapCacheManager {
        val cacheManager = ConcurrentMapCacheManager()
        cacheManager.isAllowNullValues = false
        cacheManager.setCacheNames(listOf("today_wiki"))
        return cacheManager
    }
}