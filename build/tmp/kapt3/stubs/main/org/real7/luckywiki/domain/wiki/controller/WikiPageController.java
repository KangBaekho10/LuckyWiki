package org.real7.luckywiki.domain.wiki.controller;

@org.springframework.web.bind.annotation.RestController()
@org.springframework.web.bind.annotation.RequestMapping(value = {"/api/v1/wikis"})
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0017J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0017J\u001e\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0017J\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0017J.\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\b\u001a\u00020\u00162\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lorg/real7/luckywiki/domain/wiki/controller/WikiPageController;", "", "wikiPageService", "Lorg/real7/luckywiki/domain/wiki/service/WikiPageService;", "(Lorg/real7/luckywiki/domain/wiki/service/WikiPageService;)V", "createWiki", "Lorg/springframework/http/ResponseEntity;", "Lorg/real7/luckywiki/domain/wiki/dto/CreateWikiPageResponse;", "request", "Lorg/real7/luckywiki/domain/wiki/dto/CreateWikiPageRequest;", "image", "Lorg/springframework/web/multipart/MultipartFile;", "deleteWikiPage", "", "wikiId", "", "getWikiHistory", "", "Lorg/real7/luckywiki/domain/wiki/dto/WikiHistoryResponse;", "getWikiPage", "Lorg/real7/luckywiki/domain/wiki/dto/WikiPageResponse;", "updateWikiPage", "Lorg/real7/luckywiki/domain/wiki/dto/UpdateWikiPageRequest;", "luckyWiki"})
public class WikiPageController {
    @org.jetbrains.annotations.NotNull()
    private final org.real7.luckywiki.domain.wiki.service.WikiPageService wikiPageService = null;
    
    public WikiPageController(@org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.wiki.service.WikiPageService wikiPageService) {
        super();
    }
    
    @org.springframework.web.bind.annotation.PostMapping()
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<org.real7.luckywiki.domain.wiki.dto.CreateWikiPageResponse> createWiki(@org.springframework.web.bind.annotation.RequestPart()
    @jakarta.validation.Valid()
    @org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.wiki.dto.CreateWikiPageRequest request, @org.springframework.web.bind.annotation.RequestPart()
    @org.jetbrains.annotations.Nullable()
    org.springframework.web.multipart.MultipartFile image) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.GetMapping(value = {"/{wikiId}"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<org.real7.luckywiki.domain.wiki.dto.WikiPageResponse> getWikiPage(@org.springframework.web.bind.annotation.PathVariable()
    long wikiId) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.PutMapping(value = {"/{wikiId}"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<org.real7.luckywiki.domain.wiki.dto.WikiPageResponse> updateWikiPage(@org.springframework.web.bind.annotation.PathVariable()
    long wikiId, @org.springframework.web.bind.annotation.RequestPart()
    @jakarta.validation.Valid()
    @org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.wiki.dto.UpdateWikiPageRequest request, @org.springframework.web.bind.annotation.RequestPart()
    @org.jetbrains.annotations.Nullable()
    org.springframework.web.multipart.MultipartFile image) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.DeleteMapping(value = {"/{wikiId}"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<kotlin.Unit> deleteWikiPage(@org.springframework.web.bind.annotation.PathVariable()
    long wikiId) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.GetMapping(value = {"/{wikiId}/history"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<java.util.List<org.real7.luckywiki.domain.wiki.dto.WikiHistoryResponse>> getWikiHistory(@org.springframework.web.bind.annotation.PathVariable()
    long wikiId) {
        return null;
    }
}