package org.real7.luckywiki.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.cache.CacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import java.time.Duration

//@Configuration
//@EnableRedisRepositories
//class RedisConfig(
//    @Value("\${spring.data.redis.port}")
//    private val host: String,
//
//    @Value("\${spring.data.redis.port}")
//    private val port: Int,
//){
//    @Bean
//    fun redisConnectionFactory(): RedisConnectionFactory {
//
//        val redisStandaloneConfiguration = RedisStandaloneConfiguration(host, port)
//        val lettuceClientConfiguration = LettuceClientConfiguration.builder()
//            .commandTimeout(Duration.ofSeconds(10))
//            .shutdownTimeout(Duration.ofMillis(100))
//            .build()
//
//
//        return LettuceConnectionFactory(redisStandaloneConfiguration, lettuceClientConfiguration)
//    }
//
////    @Bean
////    fun redisTemplate(): RedisTemplate<String, String> {
////        val template = RedisTemplate<String, String>()
////        template.keySerializer = StringRedisSerializer()
////        template.valueSerializer = StringRedisSerializer()
////        template.connectionFactory = redisConnectionFactory()
////        return template
////    }
////
////    @Bean
////    fun cacheManager(): CacheManager {
////        val redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
////            .entryTtl(Duration.ofMinutes(1))
////        return RedisCacheManager.builder(redisConnectionFactory())
////            .cacheDefaults(redisCacheConfiguration)
////            .build()
////    }
//}