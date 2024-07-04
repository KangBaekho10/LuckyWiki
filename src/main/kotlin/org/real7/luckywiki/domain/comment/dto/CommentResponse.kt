package org.real7.luckywiki.domain.comment.dto

import java.time.LocalDateTime

data class CommentResponse (
//    val id: Long,
    val content:String,
    val vote : Boolean,
//    val member:
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
}