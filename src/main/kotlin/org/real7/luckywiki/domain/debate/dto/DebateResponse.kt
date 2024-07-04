package org.real7.luckywiki.domain.debate.dto

import org.real7.luckywiki.domain.comment.dto.CommentResponse
import org.real7.luckywiki.domain.comment.model.toResponse
import org.real7.luckywiki.domain.debate.entity.Debate

data class DebateResponse (
    val wikiId : Long,
    val title  : String,
    val content: String,
    val comments : List<CommentResponse>
){
    companion object{
        fun from(debate: Debate, isComment: Boolean): DebateResponse{
            return DebateResponse(
                wikiId = debate.wiki.id!!,
                title = debate.title,
                content = debate.content,
                comments = if(isComment) debate.comment.map { it.toResponse() } else listOf()
            )
        }
    }
}
