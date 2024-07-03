package org.real7.luckywiki.domain.wiki.model;

@jakarta.persistence.Entity()
@jakarta.persistence.Table(name = "wiki_history")
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\b\u0017\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB/\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\tR\u0014\u0010\u0007\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR&\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108\u0016@TX\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0016X\u0097\u0004\u00a2\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001e"}, d2 = {"Lorg/real7/luckywiki/domain/wiki/model/WikiHistory;", "", "wikiPage", "Lorg/real7/luckywiki/domain/wiki/model/WikiPage;", "columnType", "", "beforeContent", "afterContent", "author", "(Lorg/real7/luckywiki/domain/wiki/model/WikiPage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAfterContent", "()Ljava/lang/String;", "getAuthor", "getBeforeContent", "getColumnType", "<set-?>", "Ljava/time/LocalDateTime;", "createdAt", "getCreatedAt", "()Ljava/time/LocalDateTime;", "setCreatedAt", "(Ljava/time/LocalDateTime;)V", "id", "", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getWikiPage", "()Lorg/real7/luckywiki/domain/wiki/model/WikiPage;", "Companion", "luckyWiki"})
public class WikiHistory {
    @jakarta.persistence.ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @jakarta.persistence.JoinColumn(name = "wiki_id")
    @org.jetbrains.annotations.NotNull()
    private final org.real7.luckywiki.domain.wiki.model.WikiPage wikiPage = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String columnType = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String beforeContent = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String afterContent = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String author = null;
    @jakarta.persistence.Id()
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long id = null;
    @org.springframework.data.annotation.CreatedDate()
    @jakarta.persistence.Column(name = "created_at", updatable = false)
    @org.jetbrains.annotations.NotNull()
    private java.time.LocalDateTime createdAt;
    @org.jetbrains.annotations.NotNull()
    public static final org.real7.luckywiki.domain.wiki.model.WikiHistory.Companion Companion = null;
    
    private WikiHistory(org.real7.luckywiki.domain.wiki.model.WikiPage wikiPage, java.lang.String columnType, java.lang.String beforeContent, java.lang.String afterContent, java.lang.String author) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public org.real7.luckywiki.domain.wiki.model.WikiPage getWikiPage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getColumnType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getBeforeContent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getAfterContent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getAuthor() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.Long getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.time.LocalDateTime getCreatedAt() {
        return null;
    }
    
    protected void setCreatedAt(@org.jetbrains.annotations.NotNull()
    java.time.LocalDateTime p0) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lorg/real7/luckywiki/domain/wiki/model/WikiHistory$Companion;", "", "()V", "from", "Lorg/real7/luckywiki/domain/wiki/model/WikiHistory;", "request", "Lorg/real7/luckywiki/domain/wiki/dto/CreateWikiHistoryRequest;", "luckyWiki"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.real7.luckywiki.domain.wiki.model.WikiHistory from(@org.jetbrains.annotations.NotNull()
        org.real7.luckywiki.domain.wiki.dto.CreateWikiHistoryRequest request) {
            return null;
        }
    }
}