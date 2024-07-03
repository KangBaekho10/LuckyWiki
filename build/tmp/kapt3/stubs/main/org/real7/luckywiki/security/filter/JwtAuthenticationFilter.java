package org.real7.luckywiki.security.filter;

@org.springframework.stereotype.Component()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u000e\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\bH\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lorg/real7/luckywiki/security/filter/JwtAuthenticationFilter;", "Lorg/springframework/web/filter/OncePerRequestFilter;", "jwtPlugin", "Lorg/real7/luckywiki/security/jwt/JwtPlugin;", "(Lorg/real7/luckywiki/security/jwt/JwtPlugin;)V", "doFilterInternal", "", "request", "Ljakarta/servlet/http/HttpServletRequest;", "response", "Ljakarta/servlet/http/HttpServletResponse;", "filterChain", "Ljakarta/servlet/FilterChain;", "getBearerToken", "", "Companion", "luckyWiki"})
public class JwtAuthenticationFilter extends org.springframework.web.filter.OncePerRequestFilter {
    @org.jetbrains.annotations.NotNull()
    private final org.real7.luckywiki.security.jwt.JwtPlugin jwtPlugin = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.text.Regex BEARER_PATTERN = null;
    @org.jetbrains.annotations.NotNull()
    public static final org.real7.luckywiki.security.filter.JwtAuthenticationFilter.Companion Companion = null;
    
    public JwtAuthenticationFilter(@org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.security.jwt.JwtPlugin jwtPlugin) {
        super();
    }
    
    @java.lang.Override()
    protected void doFilterInternal(@org.jetbrains.annotations.NotNull()
    jakarta.servlet.http.HttpServletRequest request, @org.jetbrains.annotations.NotNull()
    jakarta.servlet.http.HttpServletResponse response, @org.jetbrains.annotations.NotNull()
    jakarta.servlet.FilterChain filterChain) {
    }
    
    private java.lang.String getBearerToken(jakarta.servlet.http.HttpServletRequest $this$getBearerToken) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lorg/real7/luckywiki/security/filter/JwtAuthenticationFilter$Companion;", "", "()V", "BEARER_PATTERN", "Lkotlin/text/Regex;", "luckyWiki"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}