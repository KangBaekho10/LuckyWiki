package org.real7.luckywiki.domain.wiki;

@jakarta.persistence.MappedSuperclass()
@jakarta.persistence.EntityListeners(value = {org.springframework.data.jpa.domain.support.AuditingEntityListener.class})
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048\u0016@TX\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048\u0016@TX\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t\u00a8\u0006\r"}, d2 = {"Lorg/real7/luckywiki/domain/wiki/BaseTimeEntity;", "", "()V", "<set-?>", "Ljava/time/LocalDateTime;", "createdAt", "getCreatedAt", "()Ljava/time/LocalDateTime;", "setCreatedAt", "(Ljava/time/LocalDateTime;)V", "updatedAt", "getUpdatedAt", "setUpdatedAt", "luckyWiki"})
public abstract class BaseTimeEntity {
    @org.springframework.data.annotation.CreatedDate()
    @jakarta.persistence.Column(name = "created_at", updatable = false)
    @org.jetbrains.annotations.NotNull()
    private java.time.LocalDateTime createdAt;
    @org.springframework.data.annotation.LastModifiedDate()
    @jakarta.persistence.Column(name = "updated_at")
    @org.jetbrains.annotations.NotNull()
    private java.time.LocalDateTime updatedAt;
    
    public BaseTimeEntity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.time.LocalDateTime getCreatedAt() {
        return null;
    }
    
    protected void setCreatedAt(@org.jetbrains.annotations.NotNull()
    java.time.LocalDateTime p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.time.LocalDateTime getUpdatedAt() {
        return null;
    }
    
    protected void setUpdatedAt(@org.jetbrains.annotations.NotNull()
    java.time.LocalDateTime p0) {
    }
}