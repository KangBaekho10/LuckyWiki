package org.real7.luckywiki.domain.wiki.dto.wikihistory

import org.real7.luckywiki.domain.wiki.model.type.WikiHistoryColumnType
import org.real7.luckywiki.domain.wiki.model.WikiPage

data class CreateWikiHistoryRequest(
    val wikiPage: WikiPage,
    val columnType: WikiHistoryColumnType,
    val beforeContent: String,
    val afterContent: String,
    val author: String
)
