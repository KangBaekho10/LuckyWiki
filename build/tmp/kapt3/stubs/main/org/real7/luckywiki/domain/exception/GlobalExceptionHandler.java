package org.real7.luckywiki.domain.exception;

@org.springframework.web.bind.annotation.RestControllerAdvice()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0017J\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\u0010\u0006\u001a\u00060\nj\u0002`\u000bH\u0017J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\rH\u0017\u00a8\u0006\u000e"}, d2 = {"Lorg/real7/luckywiki/domain/exception/GlobalExceptionHandler;", "", "()V", "handleAlreadyAppliedException", "Lorg/springframework/http/ResponseEntity;", "Lorg/real7/luckywiki/domain/exception/dto/ErrorResponse;", "e", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "handleIllegalArgumentException", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "handleModelNotFoundException", "Lorg/real7/luckywiki/domain/exception/ModelNotFoundException;", "luckyWiki"})
public class GlobalExceptionHandler {
    
    public GlobalExceptionHandler() {
        super();
    }
    
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {org.real7.luckywiki.domain.exception.ModelNotFoundException.class})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<org.real7.luckywiki.domain.exception.dto.ErrorResponse> handleModelNotFoundException(@org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.domain.exception.ModelNotFoundException e) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {java.lang.IllegalStateException.class})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<org.real7.luckywiki.domain.exception.dto.ErrorResponse> handleAlreadyAppliedException(@org.jetbrains.annotations.NotNull()
    java.lang.IllegalStateException e) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {java.lang.IllegalArgumentException.class})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<org.real7.luckywiki.domain.exception.dto.ErrorResponse> handleIllegalArgumentException(@org.jetbrains.annotations.NotNull()
    java.lang.IllegalArgumentException e) {
        return null;
    }
}