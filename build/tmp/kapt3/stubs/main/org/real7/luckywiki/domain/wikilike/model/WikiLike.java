package org.real7.luckywiki.domain.wikilike.model;

@jakarta.persistence.Entity(name = "like")
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0016\u0010\u0003\u001a\u00020\u00048\u0016X\u0097\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lorg/real7/luckywiki/domain/wikilike/model/WikiLike;", "", "()V", "wikiLikeId", "Lorg/real7/luckywiki/domain/wikilike/model/WikiLikeId;", "getWikiLikeId", "()Lorg/real7/luckywiki/domain/wikilike/model/WikiLikeId;", "toResponse", "Lorg/real7/luckywiki/domain/wikilike/dto/WikiLikeResponse;", "Companion", "luckyWiki"})
public class WikiLike {
    @jakarta.persistence.EmbeddedId()
    @org.jetbrains.annotations.NotNull()
    private final org.real7.luckywiki.domain.wikilike.model.WikiLikeId wikiLikeId = null;
    @org.jetbrains.annotations.NotNull()
    public static final org.real7.luckywiki.domain.wikilike.model.WikiLike.Companion Companion = null;
    
    public WikiLike() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public org.real7.luckywiki.domain.wikilike.model.WikiLikeId getWikiLikeId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public org.real7.luckywiki.domain.wikilike.dto.WikiLikeResponse toResponse() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lorg/real7/luckywiki/domain/wikilike/model/WikiLike$Companion;", "", "()V", "createWikiLike", "Lorg/real7/luckywiki/domain/wikilike/model/WikiLike;", "member", "Lorg/real7/luckywiki/domain/member/model/Member;", "wiki", "Lorg/real7/luckywiki/domain/wiki/model/WikiPage;", "luckyWiki"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.real7.luckywiki.domain.wikilike.model.WikiLike createWikiLike(@org.jetbrains.annotations.NotNull()
        org.real7.luckywiki.domain.member.model.Member member, @org.jetbrains.annotations.NotNull()
        org.real7.luckywiki.domain.wiki.model.WikiPage wiki) {
            return null;
        }
    }
}