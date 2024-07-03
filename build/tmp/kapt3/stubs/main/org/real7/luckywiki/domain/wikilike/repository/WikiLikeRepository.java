package org.real7.luckywiki.domain.wikilike.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0003H&\u00a8\u0006\u0006"}, d2 = {"Lorg/real7/luckywiki/domain/wikilike/repository/WikiLikeRepository;", "Lorg/springframework/data/jpa/repository/JpaRepository;", "Lorg/real7/luckywiki/domain/wikilike/model/WikiLike;", "Lorg/real7/luckywiki/domain/wikilike/model/WikiLikeId;", "findByWikiLikeId", "wikiLikeId", "luckyWiki"})
public abstract interface WikiLikeRepository extends org.springframework.data.jpa.repository.JpaRepository<org.real7.luckywiki.domain.wikilike.model.WikiLike, org.real7.luckywiki.domain.wikilike.model.WikiLikeId> {
    
    @org.jetbrains.annotations.Nullable()
    public abstract org.real7.luckywiki.domain.wikilike.model.WikiLike findByWikiLikeId(@org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.wikilike.model.WikiLikeId wikiLikeId);
}