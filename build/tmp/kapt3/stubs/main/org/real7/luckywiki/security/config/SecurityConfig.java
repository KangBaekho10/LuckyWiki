package org.real7.luckywiki.security.config;

@org.springframework.context.annotation.Configuration()
@org.springframework.security.config.annotation.web.configuration.EnableWebSecurity()
@org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lorg/real7/luckywiki/security/config/SecurityConfig;", "", "jwtAuthenticationFilter", "Lorg/real7/luckywiki/security/filter/JwtAuthenticationFilter;", "authenticationEntrypoint", "Lorg/springframework/security/web/AuthenticationEntryPoint;", "accessDeniedHandler", "Lorg/springframework/security/web/access/AccessDeniedHandler;", "(Lorg/real7/luckywiki/security/filter/JwtAuthenticationFilter;Lorg/springframework/security/web/AuthenticationEntryPoint;Lorg/springframework/security/web/access/AccessDeniedHandler;)V", "filterChain", "Lorg/springframework/security/web/SecurityFilterChain;", "http", "Lorg/springframework/security/config/annotation/web/builders/HttpSecurity;", "luckyWiki"})
public class SecurityConfig {
    @org.jetbrains.annotations.NotNull()
    private final org.real7.luckywiki.security.filter.JwtAuthenticationFilter jwtAuthenticationFilter = null;
    @org.jetbrains.annotations.NotNull()
    private final org.springframework.security.web.AuthenticationEntryPoint authenticationEntrypoint = null;
    @org.jetbrains.annotations.NotNull()
    private final org.springframework.security.web.access.AccessDeniedHandler accessDeniedHandler = null;
    
    public SecurityConfig(@org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.security.filter.JwtAuthenticationFilter jwtAuthenticationFilter, @org.jetbrains.annotations.NotNull()
    org.springframework.security.web.AuthenticationEntryPoint authenticationEntrypoint, @org.jetbrains.annotations.NotNull()
    org.springframework.security.web.access.AccessDeniedHandler accessDeniedHandler) {
        super();
    }
    
    @org.springframework.context.annotation.Bean()
    @org.jetbrains.annotations.NotNull()
    public org.springframework.security.web.SecurityFilterChain filterChain(@org.jetbrains.annotations.NotNull()
    org.springframework.security.config.annotation.web.builders.HttpSecurity http) {
        return null;
    }
}