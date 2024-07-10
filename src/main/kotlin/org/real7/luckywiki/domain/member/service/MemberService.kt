package org.real7.luckywiki.domain.member.service

import org.real7.luckywiki.domain.member.dto.CreateMemberRequest
import org.real7.luckywiki.domain.member.dto.LoginMemberRequest
import org.real7.luckywiki.domain.member.dto.LoginMemberResponse
import org.real7.luckywiki.domain.member.dto.MemberResponse
import org.real7.luckywiki.domain.member.model.Member
import org.real7.luckywiki.domain.member.model.Role
import org.real7.luckywiki.domain.member.model.toResponse
import org.real7.luckywiki.domain.member.repository.MemberRepository
import org.real7.luckywiki.exception.ModelNotFoundException
import org.real7.luckywiki.security.UserPrincipal
import org.real7.luckywiki.security.jwt.JwtPlugin
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtPlugin: JwtPlugin
) {

    fun signup(request: CreateMemberRequest): MemberResponse {
        if (memberRepository.existsByEmail(request.email)) {
            throw IllegalStateException("Email is already in use")
        } else if (!isValidEmail(request.email)) {
            throw IllegalStateException("email is invalid")
        } else if (request.password.length > 8) {
            throw IllegalStateException("비밀번호는 최소 8자 이하")
        } else if (memberRepository.existsByName(request.name)) {
            throw IllegalStateException("중복된 이름입니다.")
        }
        return memberRepository.save(
            Member(
                email = request.email,
                password = passwordEncoder.encode(request.password),
                name = request.name,
                role = when (request.role) {
                    "USER" -> Role.USER
                    "ADMIN" -> Role.ADMIN
                    else -> throw IllegalArgumentException("Invalid role")
                }

            )
        ).toResponse()
    }

    fun login(request: LoginMemberRequest): LoginMemberResponse {
        val member = memberRepository.findByEmail(request.email)

            if (request.email != member!!.email || !passwordEncoder.matches(request.password, member.password))
            {
                throw IllegalStateException("이메일 또는 비밀번호를 확인해주세요")
            }

            return LoginMemberResponse(
                accessToken = jwtPlugin.generateAccessToken(
                    subject = member.id.toString(),
                    email = member.email,
                    role = member.role.toString()
                )
            )
    }

    @Transactional
    fun deleteMember() {
        val memberId = getMemberIdFromToken()
        val member = memberRepository.findByIdOrNull(memberId) ?: throw ModelNotFoundException("Member", memberId!!.toString())

        memberRepository.delete(member)
    }

    fun getMemberIdFromToken(): Long? {
        val principal = SecurityContextHolder.getContext().authentication.principal as UserPrincipal
        return principal.id
    }

    fun isValidEmail(email: String): Boolean {
        val regex = Regex("^[a-z0-9]{3,12}+@[a-z0-9-]+\\.[a-z.]+\$")
        return regex.matches(email)
    }

    fun getMemberById(id: Long): Member {
        return memberRepository.findByIdOrNull(id) ?: throw ModelNotFoundException("Member", id.toString())
    }
}
