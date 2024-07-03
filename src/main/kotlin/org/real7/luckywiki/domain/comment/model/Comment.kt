package org.real7.luckywiki.domain.comment.model

import jakarta.persistence.*
import org.real7.luckywiki.domain.comment.dto.CommentRequest
import org.real7.luckywiki.domain.comment.dto.CommentResponse
import org.real7.luckywiki.domain.comment.dto.SimpleCommentResponse
import org.real7.luckywiki.domain.wiki.BaseTimeEntity
import java.time.LocalDateTime

@Entity
@Table(name = "comment")
class Comment private constructor(
    content : String,
    vote : Boolean,

    memberId:Long,
    debateId:Long


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_id")
//    val member: Member,

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "debate_id")
//    val debate: Debate

) : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    var content: String = content
    protected set

    var vote: Boolean = vote
    protected set

    var memberId:Long = memberId
        protected set

    var debateId:Long = debateId
        protected set

    companion object {
        fun from(
            request: CommentRequest,
//            member: Member,
//            debate : Debate
        ): Comment {
            return Comment(
                content = request.content,
                vote = request.vote,
                memberId = 1,
                debateId = 1
//                member = member,
//                debate = debate
            )
        }
    }

    fun updateComment(request: CommentRequest){
        this.content = request.content
        this.vote = request.vote
        this.updatedAt = LocalDateTime.now()
    }
}

fun Comment.toSimpleResponse() : SimpleCommentResponse{
    return SimpleCommentResponse(id!!, content)
}

fun Comment.toResponse(): CommentResponse {
    return CommentResponse(content, vote, createdAt, updatedAt)
}