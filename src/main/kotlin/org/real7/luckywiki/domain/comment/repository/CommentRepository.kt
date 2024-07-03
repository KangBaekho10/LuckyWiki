package org.real7.luckywiki.domain.comment.repository

import org.real7.luckywiki.domain.comment.model.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Long> {
}