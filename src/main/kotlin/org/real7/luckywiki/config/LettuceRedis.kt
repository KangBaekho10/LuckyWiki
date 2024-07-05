package org.real7.luckywiki.config

import io.lettuce.core.RedisClient
import io.lettuce.core.api.StatefulRedisConnection
import org.springframework.context.annotation.Configuration

@Configuration
class LettuceRedis(
){
    private val redisClient = RedisClient.create("redis://localhost:6379")
    private val connection: StatefulRedisConnection<String, String> = redisClient.connect()
    private val commend = connection.sync()


    fun <T, S>save(matchingKey: String, key: T, value: S, expiredTime: Long){

        val keyString = "${matchingKey}_$key"
        commend.expire("*", expiredTime)

        commend.set(keyString,value as String)
    }

    fun <T, S> saveHashSet(matchingKey: String, key: T, value: S, expiredTime: Long){
        commend.expire("*", expiredTime)
        commend.hset(matchingKey, key as String, value as String)
    }

    fun <T> saveAll(matchingKey: String, wordList:List<T>, expiredTime: Long){

        wordList.forEachIndexed { index, word ->
            save(matchingKey, index.toString(), word as String, expiredTime)
        }
    }

    fun <T> saveAllHashSet(matchingKey: String, wordList:List<T>, expiredTime: Long){

        wordList.forEachIndexed { index, word ->
            saveHashSet(matchingKey, index.toString(), word as String, expiredTime)
        }
    }

    fun findAll(matchingKey: String): List<Map<String, String>>{
       val keys = commend.keys("*$matchingKey*")
       val mapList: MutableList<Map<String, String>> = mutableListOf()
       keys.forEachIndexed{ index, it ->
          val key = it.substringAfter("${matchingKey}_")
          mapList.add(index, mapOf("key" to key, "value" to commend.get(it)))
       }

       return mapList
    }

    fun findHashSet(matchingKey: String): Map<String, String>{
        return commend.hgetall(matchingKey)
    }

}