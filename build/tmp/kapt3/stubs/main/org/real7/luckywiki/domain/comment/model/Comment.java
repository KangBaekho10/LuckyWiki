package org.real7.luckywiki.domain.comment.model;

@jakarta.persistence.Entity()
@jakarta.persistence.Table(name = "comment")
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000 !2\u00020\u0001:\u0001!B\'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016R$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003@TX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@TX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0016X\u0097\u0004\u00a2\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@TX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005@TX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lorg/real7/luckywiki/domain/comment/model/Comment;", "Lorg/real7/luckywiki/domain/wiki/BaseTimeEntity;", "content", "", "vote", "", "memberId", "", "debateId", "(Ljava/lang/String;ZJJ)V", "<set-?>", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getDebateId", "()J", "setDebateId", "(J)V", "id", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMemberId", "setMemberId", "getVote", "()Z", "setVote", "(Z)V", "updateComment", "", "request", "Lorg/real7/luckywiki/domain/comment/dto/CommentRequest;", "Companion", "luckyWiki"})
public class Comment extends org.real7.luckywiki.domain.wiki.BaseTimeEntity {
    @jakarta.persistence.Id()
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long id = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String content;
    private boolean vote;
    private long memberId;
    private long debateId;
    @org.jetbrains.annotations.NotNull()
    public static final org.real7.luckywiki.domain.comment.model.Comment.Companion Companion = null;
    
    private Comment(java.lang.String content, boolean vote, long memberId, long debateId) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.Long getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getContent() {
        return null;
    }
    
    protected void setContent(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public boolean getVote() {
        return false;
    }
    
    protected void setVote(boolean p0) {
    }
    
    public long getMemberId() {
        return 0L;
    }
    
    protected void setMemberId(long p0) {
    }
    
    public long getDebateId() {
        return 0L;
    }
    
    protected void setDebateId(long p0) {
    }
    
    public void updateComment(@org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.comment.dto.CommentRequest request) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lorg/real7/luckywiki/domain/comment/model/Comment$Companion;", "", "()V", "from", "Lorg/real7/luckywiki/domain/comment/model/Comment;", "request", "Lorg/real7/luckywiki/domain/comment/dto/CommentRequest;", "luckyWiki"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.real7.luckywiki.domain.comment.model.Comment from(@org.jetbrains.annotations.NotNull()
        org.real7.luckywiki.domain.comment.dto.CommentRequest request) {
            return null;
        }
    }
}