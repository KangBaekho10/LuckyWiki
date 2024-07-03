package org.real7.luckywiki.domain.comment.service;

@org.springframework.stereotype.Service()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0017J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0017J \u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0017R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0012"}, d2 = {"Lorg/real7/luckywiki/domain/comment/service/CommentService;", "", "commentRepository", "Lorg/real7/luckywiki/domain/comment/repository/CommentRepository;", "(Lorg/real7/luckywiki/domain/comment/repository/CommentRepository;)V", "getCommentRepository", "()Lorg/real7/luckywiki/domain/comment/repository/CommentRepository;", "createComment", "Lorg/real7/luckywiki/domain/comment/dto/SimpleCommentResponse;", "memberId", "", "debateId", "request", "Lorg/real7/luckywiki/domain/comment/dto/CommentRequest;", "deleteComment", "", "commentId", "updateComment", "luckyWiki"})
public class CommentService {
    @org.jetbrains.annotations.NotNull()
    private final org.real7.luckywiki.domain.comment.repository.CommentRepository commentRepository = null;
    
    public CommentService(@org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.comment.repository.CommentRepository commentRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public org.real7.luckywiki.domain.comment.repository.CommentRepository getCommentRepository() {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional()
    @org.jetbrains.annotations.NotNull()
    public org.real7.luckywiki.domain.comment.dto.SimpleCommentResponse createComment(long memberId, long debateId, @org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.comment.dto.CommentRequest request) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional()
    @org.jetbrains.annotations.NotNull()
    public org.real7.luckywiki.domain.comment.dto.SimpleCommentResponse updateComment(long memberId, long commentId, @org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.comment.dto.CommentRequest request) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional()
    public void deleteComment(long memberId, long commentId) {
    }
}