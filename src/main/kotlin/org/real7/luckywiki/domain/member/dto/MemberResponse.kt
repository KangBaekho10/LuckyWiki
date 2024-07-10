package org.real7.luckywiki.domain.member.dto

import org.real7.luckywiki.domain.member.model.Role

data class MemberResponse (
    val id: Long,
    val email: String,
    val name: String,
    val role: Role,
)