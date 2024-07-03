package org.real7.luckywiki.domain.wiki.repository;

@org.springframework.stereotype.Repository()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0092\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007\u00a8\u0006\u0010"}, d2 = {"Lorg/real7/luckywiki/domain/wiki/repository/WikiHistoryCustomRepository;", "", "queryFactory", "Lcom/querydsl/jpa/impl/JPAQueryFactory;", "(Lcom/querydsl/jpa/impl/JPAQueryFactory;)V", "wikiHistory", "error/NonExistentClass", "Lerror/NonExistentClass;", "findHistoryById", "", "Lorg/real7/luckywiki/domain/wiki/model/WikiHistory;", "wikiId", "", "findImageById", "", "", "luckyWiki"})
public class WikiHistoryCustomRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.querydsl.jpa.impl.JPAQueryFactory queryFactory = null;
    @org.jetbrains.annotations.NotNull()
    private final error.NonExistentClass wikiHistory = null;
    
    public WikiHistoryCustomRepository(@org.jetbrains.annotations.NotNull()
    com.querydsl.jpa.impl.JPAQueryFactory queryFactory) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.util.List<java.lang.String> findImageById(long wikiId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.util.List<org.real7.luckywiki.domain.wiki.model.WikiHistory> findHistoryById(long wikiId) {
        return null;
    }
}