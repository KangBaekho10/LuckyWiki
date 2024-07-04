package org.real7.luckywiki.domain.wikilike.repository

import org.real7.luckywiki.domain.wikilike.model.WikiLike
import org.real7.luckywiki.domain.wikilike.model.WikiLikeId
import org.springframework.data.jpa.repository.JpaRepository

interface WikiLikeRepository : JpaRepository<WikiLike, WikiLikeId> {
    fun findByWikiLikeId(wikiLikeId: WikiLikeId): WikiLike?

    fun deleteByWikiLikeIdWikiId(id: Long)
}