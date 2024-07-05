package org.real7.luckywiki.domain.wikilike.model

import jakarta.persistence.*
import org.real7.luckywiki.domain.member.model.Member
import org.real7.luckywiki.domain.wiki.model.WikiPage
import org.real7.luckywiki.domain.wikilike.dto.WikiLikeResponse

@Entity(name = "reaction")
class WikiLike {
    @EmbeddedId
    val wikiLikeId: WikiLikeId = WikiLikeId()

    companion object {
        fun createWikiLike(member: Member, wiki: WikiPage): WikiLike {
            val wikiLike = WikiLike()
            wikiLike.wikiLikeId.member = member
            wikiLike.wikiLikeId.wiki = wiki
            return wikiLike
        }
    }

    fun toResponse(): WikiLikeResponse {
        return WikiLikeResponse(
            this.wikiLikeId.wiki!!.id.toString(),
            this.wikiLikeId.member!!.id.toString(),
        )
    }
}