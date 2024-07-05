package org.real7.luckywiki.domain.member.controller

import org.real7.luckywiki.domain.member.dto.CreateMemberRequest
import org.real7.luckywiki.domain.member.dto.LoginMemberRequest
import org.real7.luckywiki.domain.member.dto.LoginMemberResponse
import org.real7.luckywiki.domain.member.dto.MemberResponse
import org.real7.luckywiki.domain.member.service.MemberService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class MemberController(
    private val memberService: MemberService
) {
    @PostMapping("/signup")
    fun createMember(@RequestBody request: CreateMemberRequest): ResponseEntity<MemberResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(memberService.signup(request))
    }

    @PostMapping("/login")
    fun loginMember(@RequestBody request: LoginMemberRequest): ResponseEntity<LoginMemberResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(memberService.login(request))
    }

    @DeleteMapping
    fun deleteMember(): ResponseEntity<Unit> {
        memberService.deleteMember()
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }
}