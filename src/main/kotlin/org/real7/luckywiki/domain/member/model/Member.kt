package org.real7.luckywiki.domain.member.model

import jakarta.persistence.*
import org.real7.luckywiki.domain.member.dto.MemberResponse

@Entity
@Table(name = "member")
class Member(
    val email: String,
    var name: String,
    var password: String,

    @Enumerated(EnumType.STRING)
    var role: Role = Role.USER,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}

fun Member.toResponse(): MemberResponse {
    return MemberResponse(
        id = id?: throw IllegalStateException("UserId should not be null"),
        email = email,
        name = name,
        role = role
    )
}