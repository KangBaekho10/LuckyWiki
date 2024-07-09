package org.real7.luckywiki.domain.comment.service

import org.real7.luckywiki.domain.comment.dto.CommentRequest
import org.real7.luckywiki.domain.comment.dto.SimpleCommentResponse
import org.real7.luckywiki.domain.comment.model.Comment
import org.real7.luckywiki.domain.comment.model.toSimpleResponse
import org.real7.luckywiki.domain.comment.repository.CommentRepository
import org.real7.luckywiki.domain.debate.repository.DebateRepository
import org.real7.luckywiki.domain.member.repository.MemberRepository
import org.real7.luckywiki.exception.ModelNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.access.AccessDeniedException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentService (
    val commentRepository: CommentRepository,
    val memberRepository: MemberRepository,
    val debateRepository: DebateRepository
) {

    @Transactional
    fun createComment(memberId:Long, debateId:Long, request: CommentRequest): SimpleCommentResponse {
        if(!memberRepository.existsById(memberId)) throw ModelNotFoundException("Member", memberId.toString())
        val debate = debateRepository.findByIdOrNull(debateId) ?: throw ModelNotFoundException("Debate", debateId.toString())
        val comment = commentRepository.save(
            Comment.from(request, memberId, debate )
        )

        return comment.toSimpleResponse()
    }
    @Transactional
    fun updateComment(memberId:Long, commentId:Long, request: CommentRequest): SimpleCommentResponse {
        val comment = commentRepository.findByIdOrNull(commentId) ?: throw ModelNotFoundException("comment",commentId.toString())
        if(memberId != comment.memberId) throw AccessDeniedException("This feed/comment is not yours!!")
        comment.updateComment(request)
        return comment.toSimpleResponse()
    }

    @Transactional
    fun deleteComment(memberId:Long, commentId:Long) {
        val comment = commentRepository.findByIdOrNull(commentId) ?: throw ModelNotFoundException("comment", commentId.toString())
        if(memberId != comment.memberId) throw AccessDeniedException("This feed/comment is not yours!!")
        commentRepository.delete(comment)

    }


}