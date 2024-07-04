package org.real7.luckywiki.domain.debate.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.real7.luckywiki.domain.comment.model.Comment
import org.real7.luckywiki.domain.debate.dto.UpdateDebateRequest
import org.real7.luckywiki.domain.member.model.Member
import org.real7.luckywiki.domain.wiki.model.WikiPage
import java.time.LocalDateTime

@Entity
@Table(name = "debate")
class Debate(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null,

    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "content", nullable = false)
    var content : String,

    @Column(name = "image", nullable = true)
    val image : String?,

    @ManyToOne(fetch = FetchType.LAZY,)
    @JoinColumn(name = "member_id", nullable = false)
    val member: Member,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wiki_id", nullable = false)
    val wiki : WikiPage,

    @OneToMany(mappedBy= "debate", fetch = FetchType.LAZY, orphanRemoval = true)
    val comment: List<Comment>
){

    fun update(updateDebateRequest: UpdateDebateRequest) {
        title = updateDebateRequest.title
        content = updateDebateRequest.content
    }

    @Column(name = "created_at",nullable = false)
    @CreationTimestamp
    val createdAt: LocalDateTime = LocalDateTime.now()

    @Column(name = "updated_at",nullable = false)
    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now()
}