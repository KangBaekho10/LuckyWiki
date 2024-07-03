package org.real7.luckywiki.config;

@org.springframework.context.annotation.Configuration()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017\u00a8\u0006\u0007"}, d2 = {"Lorg/real7/luckywiki/config/QueryDslConfig;", "", "()V", "jpaQueryFactory", "Lcom/querydsl/jpa/impl/JPAQueryFactory;", "entityManager", "Ljakarta/persistence/EntityManager;", "luckyWiki"})
public class QueryDslConfig {
    
    public QueryDslConfig() {
        super();
    }
    
    @org.springframework.context.annotation.Bean()
    @org.jetbrains.annotations.NotNull()
    public com.querydsl.jpa.impl.JPAQueryFactory jpaQueryFactory(@org.jetbrains.annotations.NotNull()
    jakarta.persistence.EntityManager entityManager) {
        return null;
    }
}