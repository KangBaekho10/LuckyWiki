package org.real7.luckywiki.domain.redis

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/redis")
class RedisController(
    private val redisService: RedisService
){

    @PostMapping
    fun createRedis(id: Long, name: String): ResponseEntity<Unit> {
        redisService.createRedis(id, name)
        return ResponseEntity.ok().build()
    }

    @GetMapping
    fun getRedisList(): ResponseEntity<List<Map<String,String>>> {
        return ResponseEntity.ok().body(redisService.getRedis())
    }
}