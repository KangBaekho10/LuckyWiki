package org.real7.luckywiki.domain.member.repository

import org.real7.luckywiki.domain.member.model.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member, Long> {
    fun existsByEmail(email: String): Boolean

    fun findByEmail(email: String): Member?
}