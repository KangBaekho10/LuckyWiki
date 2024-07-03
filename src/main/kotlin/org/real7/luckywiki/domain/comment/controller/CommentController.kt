package org.real7.luckywiki.domain.comment.controller

import org.real7.luckywiki.domain.comment.dto.CommentRequest
import org.real7.luckywiki.domain.comment.dto.SimpleCommentResponse
import org.real7.luckywiki.domain.comment.service.CommentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RequestMapping("/api/v1/comments")
@RestController
class CommentController(
    val commentService: CommentService
) {

    @PostMapping("/{debateId}")
    fun createComment(
        @PathVariable("debateId") debateId: Long,
        @RequestBody request: CommentRequest
    ) : ResponseEntity<SimpleCommentResponse> {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(commentService.createComment(1,debateId,request))
    }

    @PutMapping("/{commentId}")
    fun updateComment(
        @PathVariable("commentId") commentId: Long,
        @RequestBody request: CommentRequest
    ) : ResponseEntity<SimpleCommentResponse> {
        return ResponseEntity.status(HttpStatus.OK)
            .body(commentService.updateComment(1,commentId,request))
    }

    @DeleteMapping("/{commentId}")
    fun deleteComment(@PathVariable("commentId") commentId: Long): ResponseEntity<Unit> {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
            .body(commentService.deleteComment(1,commentId))
    }
}