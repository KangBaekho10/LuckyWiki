package org.real7.luckywiki.domain.wiki.dto

import java.time.LocalDateTime

data class WikiPageResponse(
    val title: String,
    val content: String,
    val image: String?,
    val tag: String,
    val reaction: Long,
    val views: Long,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)