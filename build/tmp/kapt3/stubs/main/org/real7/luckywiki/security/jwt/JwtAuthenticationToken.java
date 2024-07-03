package org.real7.luckywiki.security.jwt;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lorg/real7/luckywiki/security/jwt/JwtAuthenticationToken;", "Lorg/springframework/security/authentication/AbstractAuthenticationToken;", "Ljava/io/Serializable;", "principal", "Lorg/real7/luckywiki/security/UserPrincipal;", "details", "Lorg/springframework/security/web/authentication/WebAuthenticationDetails;", "(Lorg/real7/luckywiki/security/UserPrincipal;Lorg/springframework/security/web/authentication/WebAuthenticationDetails;)V", "getCredentials", "", "getPrincipal", "isAuthenticated", "", "luckyWiki"})
public final class JwtAuthenticationToken extends org.springframework.security.authentication.AbstractAuthenticationToken implements java.io.Serializable {
    @org.jetbrains.annotations.NotNull()
    private final org.real7.luckywiki.security.UserPrincipal principal = null;
    
    public JwtAuthenticationToken(@org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.security.UserPrincipal principal, @org.jetbrains.annotations.NotNull()
    org.springframework.security.web.authentication.WebAuthenticationDetails details) {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.real7.luckywiki.security.UserPrincipal getPrincipal() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Void getCredentials() {
        return null;
    }
    
    @java.lang.Override()
    public boolean isAuthenticated() {
        return false;
    }
}