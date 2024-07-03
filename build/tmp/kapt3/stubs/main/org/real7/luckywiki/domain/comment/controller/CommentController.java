package org.real7.luckywiki.domain.comment.controller;

@org.springframework.web.bind.annotation.RequestMapping(value = {"/api/v1/comments"})
@org.springframework.web.bind.annotation.RestController()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0017J\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\b\b\u0001\u0010\u0010\u001a\u00020\u000bH\u0017J\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0001\u0010\u0010\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0017R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0012"}, d2 = {"Lorg/real7/luckywiki/domain/comment/controller/CommentController;", "", "commentService", "Lorg/real7/luckywiki/domain/comment/service/CommentService;", "(Lorg/real7/luckywiki/domain/comment/service/CommentService;)V", "getCommentService", "()Lorg/real7/luckywiki/domain/comment/service/CommentService;", "createComment", "Lorg/springframework/http/ResponseEntity;", "Lorg/real7/luckywiki/domain/comment/dto/SimpleCommentResponse;", "debateId", "", "request", "Lorg/real7/luckywiki/domain/comment/dto/CommentRequest;", "deleteComment", "", "commentId", "updateComment", "luckyWiki"})
public class CommentController {
    @org.jetbrains.annotations.NotNull()
    private final org.real7.luckywiki.domain.comment.service.CommentService commentService = null;
    
    public CommentController(@org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.comment.service.CommentService commentService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public org.real7.luckywiki.domain.comment.service.CommentService getCommentService() {
        return null;
    }
    
    @org.springframework.web.bind.annotation.PostMapping(value = {"/{debateId}"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<org.real7.luckywiki.domain.comment.dto.SimpleCommentResponse> createComment(@org.springframework.web.bind.annotation.PathVariable(value = "debateId")
    long debateId, @org.springframework.web.bind.annotation.RequestBody()
    @org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.comment.dto.CommentRequest request) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.PutMapping(value = {"/{commentId}"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<org.real7.luckywiki.domain.comment.dto.SimpleCommentResponse> updateComment(@org.springframework.web.bind.annotation.PathVariable(value = "commentId")
    long commentId, @org.springframework.web.bind.annotation.RequestBody()
    @org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.comment.dto.CommentRequest request) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.DeleteMapping(value = {"/{commentId}"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<kotlin.Unit> deleteComment(@org.springframework.web.bind.annotation.PathVariable(value = "commentId")
    long commentId) {
        return null;
    }
}