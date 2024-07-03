package org.real7.luckywiki.domain.wiki.dto

import java.time.LocalDateTime

data class CreateWikiPageResponse(
    val title: String,
    val content: String,
    val image: String?,
    val tag: String,
    val createdAt: LocalDateTime
)