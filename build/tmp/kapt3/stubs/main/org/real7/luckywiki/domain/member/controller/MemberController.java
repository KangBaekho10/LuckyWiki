package org.real7.luckywiki.domain.member.controller;

@org.springframework.web.bind.annotation.RestController()
@org.springframework.web.bind.annotation.RequestMapping(value = {"/api/v1"})
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u0017J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\b\b\u0001\u0010\b\u001a\u00020\fH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lorg/real7/luckywiki/domain/member/controller/MemberController;", "", "memberService", "Lorg/real7/luckywiki/domain/member/service/MemberService;", "(Lorg/real7/luckywiki/domain/member/service/MemberService;)V", "createMember", "Lorg/springframework/http/ResponseEntity;", "Lorg/real7/luckywiki/domain/member/dto/MemberResponse;", "request", "Lorg/real7/luckywiki/domain/member/dto/CreateMemberRequest;", "loginMember", "Lorg/real7/luckywiki/domain/member/dto/LoginMemberResponse;", "Lorg/real7/luckywiki/domain/member/dto/LoginMemberRequest;", "luckyWiki"})
public class MemberController {
    @org.jetbrains.annotations.NotNull()
    private final org.real7.luckywiki.domain.member.service.MemberService memberService = null;
    
    public MemberController(@org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.member.service.MemberService memberService) {
        super();
    }
    
    @org.springframework.web.bind.annotation.PostMapping(value = {"/signup"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<org.real7.luckywiki.domain.member.dto.MemberResponse> createMember(@org.springframework.web.bind.annotation.RequestBody()
    @org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.member.dto.CreateMemberRequest request) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.PostMapping(value = {"/login"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<org.real7.luckywiki.domain.member.dto.LoginMemberResponse> loginMember(@org.springframework.web.bind.annotation.RequestBody()
    @org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.member.dto.LoginMemberRequest request) {
        return null;
    }
}