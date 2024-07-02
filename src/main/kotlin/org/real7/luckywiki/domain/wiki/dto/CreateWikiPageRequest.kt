package org.real7.luckywiki.domain.wiki.dto

data class CreateWikiPageRequest( // TODO: Validation 필요
    val title: String,
    val content: String,
    val tag: String
)