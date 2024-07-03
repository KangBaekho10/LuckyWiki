package org.real7.luckywiki.domain.member.service

import org.real7.luckywiki.domain.member.model.Member
import org.real7.luckywiki.domain.member.repository.MemberRepository
import org.real7.luckywiki.domain.member.service.CustomMemberDetails
import org.springframework.security.authentication.InternalAuthenticationServiceException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service


@Service
class CustomMemberDetailsService(
    private val memberRepository: MemberRepository
) : UserDetailsService {

    override fun loadUserByUsername(email: String): UserDetails {
        val member: Member

        try {
            member = memberRepository.findByEmail(email)!!

        } catch (e: InternalAuthenticationServiceException) {
            throw UsernameNotFoundException(email)
        }

        return CustomMemberDetails(member)
    }
}