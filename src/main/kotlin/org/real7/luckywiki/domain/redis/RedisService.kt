package org.real7.luckywiki.domain.redis

import org.real7.luckywiki.config.LettuceRedis
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RedisService(
    private val lettuceRedis: LettuceRedis
) {


    @Transactional
    fun createRedis(id: Long, name: String){
        lettuceRedis.save(id, name)
    }


    fun getRedis(): List<Map<String,String>>{
        return lettuceRedis.findAll()
    }
}

