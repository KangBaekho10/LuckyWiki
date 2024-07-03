package org.real7.luckywiki.domain.wiki.model;

@jakarta.persistence.Entity()
@jakarta.persistence.Table(name = "wiki_page")
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 /2\u00020\u0001:\u0001/B\'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020(H\u0016J\u001c\u0010,\u001a\u00020(2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020\u0003H\u0016R$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003@TX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0016X\u0097\u0004\u00a2\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R(\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003@TX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@TX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0016\"\u0004\b\u0019\u0010\u001aR$\u0010\u0005\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003@TX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003@TX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000b\"\u0004\b\u001e\u0010\rR$\u0010\u001f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@TX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u001aR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#8\u0016X\u0097\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&\u00a8\u00060"}, d2 = {"Lorg/real7/luckywiki/domain/wiki/model/WikiPage;", "Lorg/real7/luckywiki/domain/wiki/BaseTimeEntity;", "title", "", "content", "tag", "memberId", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "<set-?>", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "id", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "image", "getImage", "setImage", "getMemberId", "()J", "reaction", "getReaction", "setReaction", "(J)V", "getTag", "setTag", "getTitle", "setTitle", "views", "getViews", "setViews", "wikiHistoryList", "", "Lorg/real7/luckywiki/domain/wiki/model/WikiHistory;", "getWikiHistoryList", "()Ljava/util/List;", "createWikiHistory", "", "request", "Lorg/real7/luckywiki/domain/wiki/dto/CreateWikiHistoryRequest;", "deleteAllWikiHistory", "update", "uploadImage", "imageLink", "Companion", "luckyWiki"})
public class WikiPage extends org.real7.luckywiki.domain.wiki.BaseTimeEntity {
    @jakarta.persistence.Id()
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long id = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String title;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String content;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String image;
    private long reaction = 0L;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String tag;
    private long views = 0L;
    private final long memberId = 0L;
    @jakarta.persistence.OneToMany(mappedBy = "wikiPage", fetch = jakarta.persistence.FetchType.LAZY, cascade = {jakarta.persistence.CascadeType.ALL}, orphanRemoval = true)
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<org.real7.luckywiki.domain.wiki.model.WikiHistory> wikiHistoryList = null;
    @org.jetbrains.annotations.NotNull()
    public static final org.real7.luckywiki.domain.wiki.model.WikiPage.Companion Companion = null;
    
    private WikiPage(java.lang.String title, java.lang.String content, java.lang.String tag, long memberId) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.Long getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getTitle() {
        return null;
    }
    
    protected void setTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getContent() {
        return null;
    }
    
    protected void setContent(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getImage() {
        return null;
    }
    
    protected void setImage(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public long getReaction() {
        return 0L;
    }
    
    protected void setReaction(long p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getTag() {
        return null;
    }
    
    protected void setTag(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public long getViews() {
        return 0L;
    }
    
    protected void setViews(long p0) {
    }
    
    public long getMemberId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.util.List<org.real7.luckywiki.domain.wiki.model.WikiHistory> getWikiHistoryList() {
        return null;
    }
    
    public void uploadImage(@org.jetbrains.annotations.NotNull()
    java.lang.String imageLink) {
    }
    
    public void update(@org.jetbrains.annotations.Nullable()
    java.lang.String title, @org.jetbrains.annotations.Nullable()
    java.lang.String content) {
    }
    
    public void createWikiHistory(@org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.wiki.dto.CreateWikiHistoryRequest request) {
    }
    
    public void deleteAllWikiHistory() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lorg/real7/luckywiki/domain/wiki/model/WikiPage$Companion;", "", "()V", "from", "Lorg/real7/luckywiki/domain/wiki/model/WikiPage;", "request", "Lorg/real7/luckywiki/domain/wiki/dto/CreateWikiPageRequest;", "memberId", "", "luckyWiki"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.real7.luckywiki.domain.wiki.model.WikiPage from(@org.jetbrains.annotations.NotNull()
        org.real7.luckywiki.domain.wiki.dto.CreateWikiPageRequest request, long memberId) {
            return null;
        }
    }
}