package org.real7.luckywiki.domain.wiki.dto

import org.real7.luckywiki.domain.wiki.model.WikiHistoryColumnType
import org.real7.luckywiki.domain.wiki.model.WikiPage

data class CreateWikiHistoryRequest(
    val wikiPage: WikiPage,
    val columnType: WikiHistoryColumnType,
    val beforeContent: String,
    val afterContent: String,
    val author: String
)
