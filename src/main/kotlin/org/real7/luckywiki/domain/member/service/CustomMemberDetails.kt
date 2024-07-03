package org.real7.luckywiki.domain.member.service

import org.real7.luckywiki.domain.member.model.Member
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails


class CustomMemberDetails(
    private val member: Member
) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority> {
        val collector: MutableCollection<GrantedAuthority> = ArrayList()
        return collector
    }

    fun getMemberId(): Long? {
        return member.id
    }

    override fun getPassword(): String {
        return member.password
    }

    override fun getUsername(): String {
        return member.name
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}