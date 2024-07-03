package org.real7.luckywiki.domain.comment.model

import jakarta.persistence.*
import org.real7.luckywiki.domain.comment.dto.CommentRequest
import org.real7.luckywiki.domain.comment.dto.CommentResponse
import org.real7.luckywiki.domain.wiki.BaseTimeEntity
import org.real7.luckywiki.domain.wiki.dto.CreateWikiPageRequest
import org.real7.luckywiki.domain.wiki.dto.WikiPageResponse
import org.real7.luckywiki.domain.wiki.model.WikiPage

@Entity
@Table(name = "comment")
class Comment private constructor(
    content : String,
    vote : Boolean,

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


    companion object {
        fun from(
            request: CommentRequest,
//            member: Member,
//            debate : Debate
        ): Comment {
            return Comment(
                content = request.content,
                vote = request.vote,
//                member = member,
//                debate = debate
            )
        }
    }
}


fun Comment.toResponse(): CommentResponse {
    return CommentResponse(content, vote, createdAt, updatedAt)
}