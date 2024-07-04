package org.real7.luckywiki.domain.member.service

import org.real7.luckywiki.domain.member.model.Member
import org.real7.luckywiki.domain.member.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class ExternalMemberService(
    private val memberRepository: MemberRepository
){

    fun searchByEmail(email: String): Member {
        return memberRepository.findByEmail(email) ?: throw IllegalArgumentException()
    }
}