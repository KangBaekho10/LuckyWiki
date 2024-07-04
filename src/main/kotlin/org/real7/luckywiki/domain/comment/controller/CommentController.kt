package org.real7.luckywiki.domain.comment.controller

import org.real7.luckywiki.domain.comment.dto.CommentRequest
import org.real7.luckywiki.domain.comment.dto.SimpleCommentResponse
import org.real7.luckywiki.domain.comment.service.CommentService
import org.real7.luckywiki.security.UserPrincipal
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*


@RequestMapping("/api/v1/comments")
@RestController
class CommentController(
    val commentService: CommentService
) {

    @PostMapping("/{debateId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    fun createComment(
        @PathVariable("debateId") debateId: Long,
        @AuthenticationPrincipal userPrincipal: UserPrincipal?,
        @RequestBody request: CommentRequest
    ) : ResponseEntity<SimpleCommentResponse> {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(commentService.createComment(userPrincipal!!.id,debateId,request))
    }

    @PutMapping("/{commentId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    fun updateComment(
        @PathVariable("commentId") commentId: Long,
        @AuthenticationPrincipal userPrincipal: UserPrincipal?,
        @RequestBody request: CommentRequest
    ) : ResponseEntity<SimpleCommentResponse> {
        return ResponseEntity.status(HttpStatus.OK)
            .body(commentService.updateComment(userPrincipal!!.id ,commentId,request))
    }

    @DeleteMapping("/{commentId}")
    @PreAuthorize("hasRole('ADMIN')")
    fun deleteComment(@PathVariable("commentId") commentId: Long,
                      @AuthenticationPrincipal userPrincipal: UserPrincipal?,): ResponseEntity<Unit> {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
            .body(commentService.deleteComment(userPrincipal!!.id,commentId))
    }
}