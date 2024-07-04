package org.real7.luckywiki.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories

@Configuration
@EnableRedisRepositories
class RedisConfig(

){

    fun redisConnectionFactory(): RedisConnectionFactory {
        return LettuceConnectionFactory()
    }
}