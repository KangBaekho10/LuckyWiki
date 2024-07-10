package org.real7.luckywiki.domain.member.dto

data class CreateMemberRequest (
    val email: String,
    val name: String,
    val password: String,
    val role: String,
)