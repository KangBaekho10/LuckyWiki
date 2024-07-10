package org.real7.luckywiki.config

import io.lettuce.core.RedisClient
import io.lettuce.core.ScanArgs
import io.lettuce.core.api.StatefulRedisConnection
import org.real7.luckywiki.common.MatchingKey
import org.real7.luckywiki.domain.wiki.dto.KeywordRequest
import org.real7.luckywiki.domain.wiki.model.type.SearchType
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration


@Configuration
class LettuceRedis(
){
    private val redisClient = RedisClient.create("redis://localhost:6379")
    private val connection: StatefulRedisConnection<String, String> = redisClient.connect()
    private val command = connection.sync()
    private val logger = LoggerFactory.getLogger("LettuceRedis::class.java")

    init {
        command.configSet("maxmemory-policy", RedisEviction.VOLATILE_TTL.policy)
    }

    fun <T, S>save(matchingKey: MatchingKey, key: T, value: S, expiredTime: Long){

        val keyString = "${matchingKey}_$key"
        command.expire("*", expiredTime)

        command.set(keyString,value as String)
    }

    fun <T, S> saveHashSet(matchingKey: MatchingKey, key: T, value: S, expiredTime: Long){
        command.expire("*", expiredTime)
        command.hset(matchingKey.name, key as String, value as String)
    }

    fun <T, S> saveHashSet(matchingKey: String, key: T, value: S, expiredTime: Long){
        command.expire("*", expiredTime)
        command.hset(matchingKey, key as String, value as String)
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
       val keys = command.keys("*$matchingKey*")
       val mapList: MutableList<Map<String, String>> = mutableListOf()
       keys.forEachIndexed{ index, it ->
          val key = it.substringAfter("${matchingKey}_")
          mapList.add(index, mapOf("key" to key, "value" to command.get(it)))
       }

       return mapList
    }

    fun findHashSet(matchingKey: MatchingKey): Map<String, String>{
        return command.hgetall(matchingKey.name)
    }

    fun findHashSet(matchingKey: String): Map<String, String>{
        return command.hgetall(matchingKey)
    }


    fun findAllHashSet(matchingKey: String, searchType: SearchType, keyword: String): MutableList<Map<String, String>>{
        val scanArgs = ScanArgs.Builder.matches("*$matchingKey*")
        var scanCursor = command.scan(scanArgs)

        val resultList:MutableList<Map<String, String>> = mutableListOf()

        while (!scanCursor.isFinished) {
            scanCursor.keys.forEach { key ->
                resultList.add(command.hgetall(key))
            }
            scanCursor = command.scan(scanCursor, scanArgs)
        }

        return resultList.filter { if(searchType != SearchType.TAG) it["title"]!!.contains(keyword) else it["tag"]!!.contains(keyword) }.toMutableList()
    }

}