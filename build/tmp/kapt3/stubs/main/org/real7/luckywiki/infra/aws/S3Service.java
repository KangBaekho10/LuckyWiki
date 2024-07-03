package org.real7.luckywiki.infra.aws;

@org.springframework.stereotype.Service()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0017J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0005H\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lorg/real7/luckywiki/infra/aws/S3Service;", "", "s3Operations", "Lio/awspring/cloud/s3/S3Operations;", "bucket", "", "(Lio/awspring/cloud/s3/S3Operations;Ljava/lang/String;)V", "delete", "", "key", "upload", "file", "Lorg/springframework/web/multipart/MultipartFile;", "luckyWiki"})
public class S3Service {
    @org.jetbrains.annotations.NotNull()
    private final io.awspring.cloud.s3.S3Operations s3Operations = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String bucket = null;
    
    public S3Service(@org.jetbrains.annotations.NotNull()
    io.awspring.cloud.s3.S3Operations s3Operations, @org.springframework.beans.factory.annotation.Value(value = "${spring.cloud.aws.s3.bucket}")
    @org.jetbrains.annotations.NotNull()
    java.lang.String bucket) {
        super();
    }
    
    @org.springframework.transaction.annotation.Transactional()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String upload(@org.jetbrains.annotations.NotNull()
    org.springframework.web.multipart.MultipartFile file, @org.jetbrains.annotations.NotNull()
    java.lang.String key) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional()
    public void delete(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
    }
}