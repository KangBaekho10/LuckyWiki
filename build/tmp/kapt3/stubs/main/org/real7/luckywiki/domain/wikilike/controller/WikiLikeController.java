package org.real7.luckywiki.domain.wikilike.controller;

@org.springframework.web.bind.annotation.RestController()
@org.springframework.web.bind.annotation.RequestMapping(value = {"/api/v1/wikis"})
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0017J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lorg/real7/luckywiki/domain/wikilike/controller/WikiLikeController;", "", "memberService", "Lorg/real7/luckywiki/domain/member/service/MemberService;", "wikiLikeService", "Lorg/real7/luckywiki/domain/wikilike/service/WikiLikeService;", "(Lorg/real7/luckywiki/domain/member/service/MemberService;Lorg/real7/luckywiki/domain/wikilike/service/WikiLikeService;)V", "unWikiLike", "Lorg/springframework/http/ResponseEntity;", "", "wikiId", "", "wikiLike", "Lorg/real7/luckywiki/domain/wikilike/dto/WikiLikeResponse;", "luckyWiki"})
public class WikiLikeController {
    @org.jetbrains.annotations.NotNull()
    private final org.real7.luckywiki.domain.member.service.MemberService memberService = null;
    @org.jetbrains.annotations.NotNull()
    private final org.real7.luckywiki.domain.wikilike.service.WikiLikeService wikiLikeService = null;
    
    public WikiLikeController(@org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.member.service.MemberService memberService, @org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.wikilike.service.WikiLikeService wikiLikeService) {
        super();
    }
    
    @org.springframework.web.bind.annotation.PostMapping(value = {"/{wikiId}/reaction"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<org.real7.luckywiki.domain.wikilike.dto.WikiLikeResponse> wikiLike(@org.springframework.web.bind.annotation.PathVariable()
    long wikiId) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.DeleteMapping(value = {"/{wikiId}/reaction"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<kotlin.Unit> unWikiLike(@org.springframework.web.bind.annotation.PathVariable()
    long wikiId) {
        return null;
    }
}