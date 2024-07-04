package org.real7.luckywiki.domain.member.dto

data class LoginMemberRequest(
    val email: String,
    val password: String,
)