package org.real7.luckywiki.domain.wiki.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWikiHistory is a Querydsl query type for WikiHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWikiHistory extends EntityPathBase<WikiHistory> {

    private static final long serialVersionUID = 2122621974L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWikiHistory wikiHistory = new QWikiHistory("wikiHistory");

    public final StringPath afterContent = createString("afterContent");

    public final StringPath author = createString("author");

    public final StringPath beforeContent = createString("beforeContent");

    public final StringPath columnType = createString("columnType");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QWikiPage wikiPage;

    public QWikiHistory(String variable) {
        this(WikiHistory.class, forVariable(variable), INITS);
    }

    public QWikiHistory(Path<? extends WikiHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWikiHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWikiHistory(PathMetadata metadata, PathInits inits) {
        this(WikiHistory.class, metadata, inits);
    }

    public QWikiHistory(Class<? extends WikiHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.wikiPage = inits.isInitialized("wikiPage") ? new QWikiPage(forProperty("wikiPage")) : null;
    }

}

