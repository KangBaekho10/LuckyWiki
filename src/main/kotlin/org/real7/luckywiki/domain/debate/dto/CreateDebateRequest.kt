package org.real7.luckywiki.domain.debate.dto

data class CreateDebateRequest(
    val wikiId : Long,
    val title  : String,
    val content: String,
)
