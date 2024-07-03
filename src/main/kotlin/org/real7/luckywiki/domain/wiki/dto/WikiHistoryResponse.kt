package org.real7.luckywiki.domain.wiki.dto

import java.time.LocalDateTime

data class WikiHistoryResponse(
    val columnType: String,
    val beforeContent: String,
    val afterContent: String,
    val author: String,
    val createdAt: LocalDateTime
)
