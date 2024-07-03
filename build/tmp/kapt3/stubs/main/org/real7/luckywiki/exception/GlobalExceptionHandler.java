package org.real7.luckywiki.exception;

@org.springframework.web.bind.annotation.RestControllerAdvice()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0017J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u000bH\u0017\u00a8\u0006\f"}, d2 = {"Lorg/real7/luckywiki/exception/GlobalExceptionHandler;", "", "()V", "handleMethodArgumentNotValidException", "Lorg/springframework/http/ResponseEntity;", "Lorg/real7/luckywiki/exception/dto/ErrorResponse;", "e", "Lorg/springframework/web/bind/MethodArgumentNotValidException;", "bindingResult", "Lorg/springframework/validation/BindingResult;", "handleModelNotFoundException", "Lorg/real7/luckywiki/exception/ModelNotFoundException;", "luckyWiki"})
public class GlobalExceptionHandler {
    
    public GlobalExceptionHandler() {
        super();
    }
    
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {org.real7.luckywiki.exception.ModelNotFoundException.class})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<org.real7.luckywiki.exception.dto.ErrorResponse> handleModelNotFoundException(@org.jetbrains.annotations.NotNull()
    org.real7.luckywiki.exception.ModelNotFoundException e) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {org.springframework.web.bind.MethodArgumentNotValidException.class})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<org.real7.luckywiki.exception.dto.ErrorResponse> handleMethodArgumentNotValidException(@org.jetbrains.annotations.NotNull()
    org.springframework.web.bind.MethodArgumentNotValidException e, @org.jetbrains.annotations.NotNull()
    org.springframework.validation.BindingResult bindingResult) {
        return null;
    }
}