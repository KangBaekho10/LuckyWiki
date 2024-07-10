package org.real7.luckywiki.domain.wikilike.model

import jakarta.persistence.Embeddable
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.real7.luckywiki.domain.member.model.Member
import org.real7.luckywiki.domain.wiki.model.WikiPage

@Embeddable
class WikiLikeId {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wiki_id", nullable = false)
    var wiki: WikiPage? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    var member: Member? = null
}