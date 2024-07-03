package org.real7.luckywiki.domain.wiki.dto

data class UpdateWikiPageRequest(
    val title: String?,
    val content: String?
)
