package org.real7.luckywiki.domain.wiki.model

import WikiHistoryResponse
import jakarta.persistence.*
import org.real7.luckywiki.domain.wiki.dto.wikihistory.CreateWikiHistoryRequest
import org.real7.luckywiki.domain.wiki.dto.wikihistory.WikiHistoryResponse
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime

@Entity
@Table(name = "wiki_history")
class WikiHistory private constructor(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wiki_id")
    val wikiPage: WikiPage,
    val columnType: String,
    val beforeContent: String,
    val afterContent: String,
    val author: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()
        protected set

    companion object {
        fun from(
            request: CreateWikiHistoryRequest
        ): WikiHistory {
            return WikiHistory(
                request.wikiPage,
                request.columnType.name,
                request.beforeContent,
                request.afterContent,
                request.author
            )
        }
    }
}

fun WikiHistory.toResponse(): WikiHistoryResponse {
    return WikiHistoryResponse(columnType, beforeContent, afterContent, author, createdAt)
}