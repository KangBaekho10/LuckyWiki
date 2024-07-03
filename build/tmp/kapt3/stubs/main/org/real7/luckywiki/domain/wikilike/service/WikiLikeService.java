package org.real7.luckywiki.domain.wikilike.service;

@org.springframework.stereotype.Service()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0017J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lorg/real7/luckywiki/domain/wikilike/service/WikiLikeService;", "", "memberService", "Lorg/real7/luckywiki/domain/member/service/MemberService;", "wikiService", "Lorg/real7/luckywiki/domain/wiki/service/WikiPageService;", "wikiLikeRepository", "Lorg/real7/luckywiki/domain/wikilike/repository/WikiLikeRepository;", "(Lorg/real7/luckywiki/domain/member/service/MemberService;Lorg/real7/luckywiki/domain/wiki/service/WikiPageService;Lorg/real7/luckywiki/domain/wikilike/repository/WikiLikeRepository;)V", "like", "Lorg/real7/luckywiki/domain/wikilike/dto/WikiLikeResponse;", "memberId", "", "wikiId", "unlike", "", "luckyWiki"})
public class WikiLikeService {
    @org.jetbrains.annotations.NotNull()
    private final org.real7.luckywiki.domain.member.service.MemberService memberService = null;
    @org.jetbrains.annotations.NotNull()
    private final org.real7.luckywiki.domain.wiki.service.WikiPageService wikiService = null;
    @org.jetbrains.annotations.NotNull()
    private final org.real7.luckywiki.domain.wikilike.repository.WikiLikeRepository wikiLikeRepository = null;
    
    public WikiLikeService(@org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.member.service.MemberService memberService, @org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.wiki.service.WikiPageService wikiService, @org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.wikilike.repository.WikiLikeRepository wikiLikeRepository) {
        super();
    }
    
    @org.springframework.transaction.annotation.Transactional()
    @org.jetbrains.annotations.NotNull()
    public org.real7.luckywiki.domain.wikilike.dto.WikiLikeResponse like(long memberId, long wikiId) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional()
    public void unlike(long memberId, long wikiId) {
    }
}