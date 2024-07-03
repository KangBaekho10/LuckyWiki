package org.real7.luckywiki.security;

@org.springframework.stereotype.Component()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lorg/real7/luckywiki/security/CustomAuthenticationEntrypoint;", "Lorg/springframework/security/web/AuthenticationEntryPoint;", "()V", "commence", "", "request", "Ljakarta/servlet/http/HttpServletRequest;", "response", "Ljakarta/servlet/http/HttpServletResponse;", "authException", "Lorg/springframework/security/core/AuthenticationException;", "luckyWiki"})
public class CustomAuthenticationEntrypoint implements org.springframework.security.web.AuthenticationEntryPoint {
    
    public CustomAuthenticationEntrypoint() {
        super();
    }
    
    @java.lang.Override()
    public void commence(@org.jetbrains.annotations.NotNull()
    jakarta.servlet.http.HttpServletRequest request, @org.jetbrains.annotations.NotNull()
    jakarta.servlet.http.HttpServletResponse response, @org.jetbrains.annotations.NotNull()
    org.springframework.security.core.AuthenticationException authException) {
    }
}