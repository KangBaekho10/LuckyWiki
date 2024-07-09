package org.real7.luckywiki.domain.wiki.dto.wikipage

import java.time.LocalDateTime

data class WikiPageResponse(
    val title: String,
    val content: String,
    val image: String?,
    val tag: String,
    val reaction: Long,
    val views: Long,
    val createdAt: String,
    val updatedAt: String
){
    companion object{
        fun from(redisMap: Map<String, String>): WikiPageResponse{

            return WikiPageResponse(
                title = redisMap["title"] as String,
                content = redisMap["content"] as String,
                image = redisMap["image"] as String,
                tag = redisMap["tag"] as String,
                reaction = redisMap["reaction"].toString().toLong(),
                views = redisMap["views"].toString().toLong(),
                createdAt = redisMap["created_at"]!!,
                updatedAt = redisMap["updated_at"]!!
            )
        }
    }
}