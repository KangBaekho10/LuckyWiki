package org.real7.luckywiki.security.jwt;

@org.springframework.stereotype.Component()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0012J)\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0012"}, d2 = {"Lorg/real7/luckywiki/security/jwt/JwtPlugin;", "", "()V", "generateAccessToken", "", "subject", "email", "generateToken", "expirationPeriod", "Ljava/time/Duration;", "validateToken", "Lkotlin/Result;", "Lio/jsonwebtoken/Jws;", "Lio/jsonwebtoken/Claims;", "jwt", "validateToken-IoAF18A", "(Ljava/lang/String;)Ljava/lang/Object;", "Companion", "luckyWiki"})
public class JwtPlugin {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ISSUER = "LuckyWiki";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SECRET = "PO4c8z41Hia5gJG3oeuFJMRYBB4Ws4aZ";
    public static final long ACCESS_TOKEN_EXPIRATION_HOUR = 168L;
    @org.jetbrains.annotations.NotNull()
    public static final org.real7.luckywiki.security.jwt.JwtPlugin.Companion Companion = null;
    
    public JwtPlugin() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String generateAccessToken(@org.jetbrains.annotations.NotNull()
    java.lang.String subject, @org.jetbrains.annotations.NotNull()
    java.lang.String email) {
        return null;
    }
    
    private java.lang.String generateToken(java.lang.String subject, java.lang.String email, java.time.Duration expirationPeriod) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lorg/real7/luckywiki/security/jwt/JwtPlugin$Companion;", "", "()V", "ACCESS_TOKEN_EXPIRATION_HOUR", "", "ISSUER", "", "SECRET", "luckyWiki"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}