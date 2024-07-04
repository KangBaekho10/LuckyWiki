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


    fun save(key: String, value: String){

        commend.set(key,value)
    }

    fun saveAll( wordList:List<String> ){

        wordList.forEachIndexed { index, word ->
            save(index.toString(), word)
        }
    }

    fun findAll(): List<Map<String, String>>{
       val keys = connection.sync().keys("*")
       val mapList: MutableList<Map<String, String>> = mutableListOf()
       keys.forEachIndexed{ index, it ->
          mapList.add(index, mapOf("key" to it, "value" to commend.get(it)))
       }

       return mapList
    }

}