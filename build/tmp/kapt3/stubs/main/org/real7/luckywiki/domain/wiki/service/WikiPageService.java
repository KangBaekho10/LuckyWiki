package org.real7.luckywiki.domain.wiki.service;

@org.springframework.stereotype.Service()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0017J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\fH\u0016J\"\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u001d2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lorg/real7/luckywiki/domain/wiki/service/WikiPageService;", "", "wikiPageRepository", "Lorg/real7/luckywiki/domain/wiki/repository/WikiPageRepository;", "s3Service", "Lorg/real7/luckywiki/infra/aws/S3Service;", "wikiHistoryCustomRepository", "Lorg/real7/luckywiki/domain/wiki/repository/WikiHistoryCustomRepository;", "(Lorg/real7/luckywiki/domain/wiki/repository/WikiPageRepository;Lorg/real7/luckywiki/infra/aws/S3Service;Lorg/real7/luckywiki/domain/wiki/repository/WikiHistoryCustomRepository;)V", "createWikiPage", "Lorg/real7/luckywiki/domain/wiki/dto/CreateWikiPageResponse;", "memberId", "", "request", "Lorg/real7/luckywiki/domain/wiki/dto/CreateWikiPageRequest;", "image", "Lorg/springframework/web/multipart/MultipartFile;", "deleteWikiPage", "", "wikiId", "getWikiById", "Lorg/real7/luckywiki/domain/wiki/model/WikiPage;", "id", "getWikiHistory", "", "Lorg/real7/luckywiki/domain/wiki/dto/WikiHistoryResponse;", "getWikiPage", "Lorg/real7/luckywiki/domain/wiki/dto/WikiPageResponse;", "updateWikiPage", "Lorg/real7/luckywiki/domain/wiki/dto/UpdateWikiPageRequest;", "luckyWiki"})
public class WikiPageService {
    @org.jetbrains.annotations.NotNull()
    private final org.real7.luckywiki.domain.wiki.repository.WikiPageRepository wikiPageRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final org.real7.luckywiki.infra.aws.S3Service s3Service = null;
    @org.jetbrains.annotations.NotNull()
    private final org.real7.luckywiki.domain.wiki.repository.WikiHistoryCustomRepository wikiHistoryCustomRepository = null;
    
    public WikiPageService(@org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.wiki.repository.WikiPageRepository wikiPageRepository, @org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.infra.aws.S3Service s3Service, @org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.wiki.repository.WikiHistoryCustomRepository wikiHistoryCustomRepository) {
        super();
    }
    
    @org.springframework.transaction.annotation.Transactional()
    @org.jetbrains.annotations.NotNull()
    public org.real7.luckywiki.domain.wiki.dto.CreateWikiPageResponse createWikiPage(long memberId, @org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.wiki.dto.CreateWikiPageRequest request, @org.jetbrains.annotations.Nullable()
    org.springframework.web.multipart.MultipartFile image) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public org.real7.luckywiki.domain.wiki.dto.WikiPageResponse getWikiPage(long wikiId) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional()
    @org.jetbrains.annotations.NotNull()
    public org.real7.luckywiki.domain.wiki.dto.WikiPageResponse updateWikiPage(long wikiId, @org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.wiki.dto.UpdateWikiPageRequest request, @org.jetbrains.annotations.Nullable()
    org.springframework.web.multipart.MultipartFile image) {
        return null;
    }
    
    public void deleteWikiPage(long wikiId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.util.List<org.real7.luckywiki.domain.wiki.dto.WikiHistoryResponse> getWikiHistory(long wikiId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public org.real7.luckywiki.domain.wiki.model.WikiPage getWikiById(long id) {
        return null;
    }
}