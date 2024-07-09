package org.real7.luckywiki.config

import io.lettuce.core.RedisClient
import io.lettuce.core.ScanArgs
import io.lettuce.core.api.StatefulRedisConnection
import org.real7.luckywiki.common.MatchingKey
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration


@Configuration
class LettuceRedis(
){
    private val redisClient = RedisClient.create("redis://localhost:6379")
    private val connection: StatefulRedisConnection<String, String> = redisClient.connect()
    private val commend = connection.sync()
    private val logger = LoggerFactory.getLogger("LettuceRedis::class.java")

    init {
        // 만료 시간이 짧은 순서 대로 제거
        commend.configSet("maxmemory-policy", RedisEviction.VOLATILE_TTL.policy)

    }

    fun <T, S>save(matchingKey: MatchingKey, key: T, value: S, expiredTime: Long){

        val keyString = "${matchingKey}_$key"
        commend.expire("*", expiredTime)

        commend.set(keyString,value as String)
    }

    fun <T, S> saveHashSet(matchingKey: MatchingKey, key: T, value: S, expiredTime: Long){
        commend.expire("*", expiredTime)
        commend.hset(matchingKey.name, key as String, value as String)
    }

    fun <T, S> saveHashSet(matchingKey: String, key: T, value: S, expiredTime: Long){
        commend.expire("*", expiredTime)
        commend.hset(matchingKey, key as String, value as String)
    }

    fun <T> saveAll(matchingKey: MatchingKey, wordList:List<T>, expiredTime: Long){

        wordList.forEachIndexed { index, word ->
            save(matchingKey, index.toString(), word as String, expiredTime)
        }
    }

    // 매칭키 가 고정 이고 key 를 숫자로 주고 싶은 경우
    fun <T> saveAllHashSet(matchingKey: MatchingKey, wordList:List<T>, expiredTime: Long){

        wordList.forEachIndexed { index, word ->
            saveHashSet(matchingKey, index.toString(), word as String, expiredTime)
        }
    }

    // 매칭키 가 고정 이고 key 를 내가 원하는 키로 주고 싶은 경우
    fun <T, S> saveAllHashSet(matchingKey: MatchingKey, keyValueMap: Map<T, S>, expiredTime: Long){

        keyValueMap.forEach {
            saveHashSet(matchingKey, it.key , it.value, expiredTime)
        }
    }

    // 매칭키를 수동으로 설정 하고 고정 이고 key 를 내가 원하는 키로 주고 싶은 경우
    fun <T, S> saveAllHashSet(matchingKey: String, keyValueMap: Map<T, S>, expiredTime: Long){

        keyValueMap.forEach {
            saveHashSet(matchingKey, it.key as String, it.value as String, expiredTime)
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

    fun findHashSet(matchingKey: MatchingKey): Map<String, String>{
        return commend.hgetall(matchingKey.name)
    }

    fun findHashSet(matchingKey: String): Map<String, String>{
        return commend.hgetall(matchingKey)
    }


    fun findAllHashSet(matchingKey: String): MutableList<Map<String, String>>{
        val scanArgs = ScanArgs.Builder.matches("*$matchingKey*")
        var scanCursor = commend.scan(scanArgs)

        val resultList:MutableList<Map<String, String>> = mutableListOf()

        while (!scanCursor.isFinished) {
            scanCursor.keys.forEach { key ->
                resultList.add(commend.hgetall(key))
            }
            scanCursor = commend.scan(scanCursor, scanArgs)
        }

        return resultList
    }

}