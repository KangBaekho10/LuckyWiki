package org.real7.luckywiki.domain.wiki.model

import jakarta.persistence.*
import org.real7.luckywiki.domain.wiki.BaseTimeEntity
import org.real7.luckywiki.domain.wiki.dto.CreateWikiHistoryRequest
import org.real7.luckywiki.domain.wiki.dto.CreateWikiPageRequest
import org.real7.luckywiki.domain.wiki.dto.CreateWikiPageResponse
import org.real7.luckywiki.domain.wiki.dto.WikiPageResponse


@Entity
@Table(name = "wiki_page")
class WikiPage private constructor(
    title: String,
    content: String,
    tag: String,
    memberId: Long
) : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    var title: String = title
        protected set
    var content: String = content
        protected set
    var image: String? = null
        protected set
    var reaction: Long = 0
        protected set
    var tag: String = tag
        protected set
    var views: Long = 0
        protected set
    // createdAt, updatedAt은 BaseEntity 사용

    @OneToMany(mappedBy = "wikiPage", fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
    val wikiHistoryList: MutableList<WikiHistory> = mutableListOf()

    companion object {
        fun from(
            request: CreateWikiPageRequest,
            memberId: Long
        ): WikiPage {
            return WikiPage(
                title = request.title,
                content = request.content,
                tag = request.tag,
                memberId = memberId
            )
        }
    }

    fun uploadImage(imageLink: String) {
        this.image = imageLink
    }

    fun update(title: String?, content: String?) {
        title?.let { this.title = it }
        content?.let { this.content = it }
    }

    fun createWikiHistory(request: CreateWikiHistoryRequest) {
        val wikiHistory = WikiHistory.from(request)
        wikiHistoryList.add(wikiHistory)
    }

    fun deleteAllWikiHistory() {
        wikiHistoryList.clear()
    }
}

fun WikiPage.createWikiPageResponse(): CreateWikiPageResponse {
    return CreateWikiPageResponse(title, content, image, tag, createdAt)
}

fun WikiPage.toResponse(): WikiPageResponse {
    return WikiPageResponse(title, content, image, tag, reaction, views, createdAt, updatedAt)
}