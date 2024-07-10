package org.real7.luckywiki.domain.comment.dto

data class CommentRequest (
    val content: String,
    val vote:Boolean
)