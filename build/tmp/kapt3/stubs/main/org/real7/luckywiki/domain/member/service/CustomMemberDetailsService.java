package org.real7.luckywiki.domain.member.service;

@org.springframework.stereotype.Service()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lorg/real7/luckywiki/domain/member/service/CustomMemberDetailsService;", "Lorg/springframework/security/core/userdetails/UserDetailsService;", "memberRepository", "Lorg/real7/luckywiki/domain/member/repository/MemberRepository;", "(Lorg/real7/luckywiki/domain/member/repository/MemberRepository;)V", "loadUserByUsername", "Lorg/springframework/security/core/userdetails/UserDetails;", "email", "", "luckyWiki"})
public class CustomMemberDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @org.jetbrains.annotations.NotNull()
    private final org.real7.luckywiki.domain.member.repository.MemberRepository memberRepository = null;
    
    public CustomMemberDetailsService(@org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.member.repository.MemberRepository memberRepository) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
        return null;
    }
}