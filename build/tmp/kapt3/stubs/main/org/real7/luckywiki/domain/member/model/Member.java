package org.real7.luckywiki.domain.member.model;

@jakarta.persistence.Entity()
@jakarta.persistence.Table(name = "member")
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\b\u0017\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0016X\u0097\u0004\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0006\u001a\u00020\u00078\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u0019"}, d2 = {"Lorg/real7/luckywiki/domain/member/model/Member;", "", "email", "", "name", "password", "role", "Lorg/real7/luckywiki/domain/member/model/Role;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/real7/luckywiki/domain/member/model/Role;)V", "getEmail", "()Ljava/lang/String;", "id", "", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getName", "setName", "(Ljava/lang/String;)V", "getPassword", "setPassword", "getRole", "()Lorg/real7/luckywiki/domain/member/model/Role;", "setRole", "(Lorg/real7/luckywiki/domain/member/model/Role;)V", "luckyWiki"})
public class Member {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String email = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String name;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String password;
    @jakarta.persistence.Enumerated(value = jakarta.persistence.EnumType.STRING)
    @org.jetbrains.annotations.NotNull()
    private org.real7.luckywiki.domain.member.model.Role role;
    @jakarta.persistence.Id()
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long id = null;
    
    public Member(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.member.model.Role role) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getName() {
        return null;
    }
    
    public void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getPassword() {
        return null;
    }
    
    public void setPassword(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public org.real7.luckywiki.domain.member.model.Role getRole() {
        return null;
    }
    
    public void setRole(@org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.member.model.Role p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.Long getId() {
        return null;
    }
}