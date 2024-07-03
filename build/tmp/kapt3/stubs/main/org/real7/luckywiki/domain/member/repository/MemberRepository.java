package org.real7.luckywiki.domain.member.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\t"}, d2 = {"Lorg/real7/luckywiki/domain/member/repository/MemberRepository;", "Lorg/springframework/data/jpa/repository/JpaRepository;", "Lorg/real7/luckywiki/domain/member/model/Member;", "", "existsByEmail", "", "email", "", "findByEmail", "luckyWiki"})
public abstract interface MemberRepository extends org.springframework.data.jpa.repository.JpaRepository<org.real7.luckywiki.domain.member.model.Member, java.lang.Long> {
    
    public abstract boolean existsByEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String email);
    
    @org.jetbrains.annotations.Nullable()
    public abstract org.real7.luckywiki.domain.member.model.Member findByEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String email);
}