package org.real7.luckywiki.domain.wikilike.model;

@jakarta.persistence.Embeddable()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lorg/real7/luckywiki/domain/wikilike/model/WikiLikeId;", "", "()V", "member", "Lorg/real7/luckywiki/domain/member/model/Member;", "getMember", "()Lorg/real7/luckywiki/domain/member/model/Member;", "setMember", "(Lorg/real7/luckywiki/domain/member/model/Member;)V", "wiki", "Lorg/real7/luckywiki/domain/wiki/model/WikiPage;", "getWiki", "()Lorg/real7/luckywiki/domain/wiki/model/WikiPage;", "setWiki", "(Lorg/real7/luckywiki/domain/wiki/model/WikiPage;)V", "luckyWiki"})
public class WikiLikeId {
    @jakarta.persistence.ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @jakarta.persistence.JoinColumn(name = "wiki_id", nullable = false)
    @org.jetbrains.annotations.Nullable()
    private org.real7.luckywiki.domain.wiki.model.WikiPage wiki;
    @jakarta.persistence.ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @jakarta.persistence.JoinColumn(name = "member_id", nullable = false)
    @org.jetbrains.annotations.Nullable()
    private org.real7.luckywiki.domain.member.model.Member member;
    
    public WikiLikeId() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public org.real7.luckywiki.domain.wiki.model.WikiPage getWiki() {
        return null;
    }
    
    public void setWiki(@org.jetbrains.annotations.Nullable()
    org.real7.luckywiki.domain.wiki.model.WikiPage p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public org.real7.luckywiki.domain.member.model.Member getMember() {
        return null;
    }
    
    public void setMember(@org.jetbrains.annotations.Nullable()
    org.real7.luckywiki.domain.member.model.Member p0) {
    }
}