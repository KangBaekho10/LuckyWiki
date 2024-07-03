package org.real7.luckywiki.domain.member.service;

@org.springframework.stereotype.Service()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0019H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lorg/real7/luckywiki/domain/member/service/MemberService;", "", "memberRepository", "Lorg/real7/luckywiki/domain/member/repository/MemberRepository;", "passwordEncoder", "Lorg/springframework/security/crypto/password/PasswordEncoder;", "jwtPlugin", "Lorg/real7/luckywiki/security/jwt/JwtPlugin;", "(Lorg/real7/luckywiki/domain/member/repository/MemberRepository;Lorg/springframework/security/crypto/password/PasswordEncoder;Lorg/real7/luckywiki/security/jwt/JwtPlugin;)V", "getMemberById", "Lorg/real7/luckywiki/domain/member/model/Member;", "id", "", "getMemberDetails", "Lorg/real7/luckywiki/domain/member/service/CustomMemberDetails;", "isValidEmail", "", "email", "", "login", "Lorg/real7/luckywiki/domain/member/dto/LoginMemberResponse;", "request", "Lorg/real7/luckywiki/domain/member/dto/LoginMemberRequest;", "signup", "Lorg/real7/luckywiki/domain/member/dto/MemberResponse;", "Lorg/real7/luckywiki/domain/member/dto/CreateMemberRequest;", "luckyWiki"})
public class MemberService {
    @org.jetbrains.annotations.NotNull()
    private final org.real7.luckywiki.domain.member.repository.MemberRepository memberRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final org.springframework.security.crypto.password.PasswordEncoder passwordEncoder = null;
    @org.jetbrains.annotations.NotNull()
    private final org.real7.luckywiki.security.jwt.JwtPlugin jwtPlugin = null;
    
    public MemberService(@org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.member.repository.MemberRepository memberRepository, @org.jetbrains.annotations.NotNull()
    org.springframework.security.crypto.password.PasswordEncoder passwordEncoder, @org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.security.jwt.JwtPlugin jwtPlugin) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public org.real7.luckywiki.domain.member.dto.MemberResponse signup(@org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.member.dto.CreateMemberRequest request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public org.real7.luckywiki.domain.member.dto.LoginMemberResponse login(@org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.member.dto.LoginMemberRequest request) {
        return null;
    }
    
    public boolean isValidEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public org.real7.luckywiki.domain.member.model.Member getMemberById(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public org.real7.luckywiki.domain.member.service.CustomMemberDetails getMemberDetails() {
        return null;
    }
}