package org.real7.luckywiki.domain.wikilike.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWikiLike is a Querydsl query type for WikiLike
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWikiLike extends EntityPathBase<WikiLike> {

    private static final long serialVersionUID = -1312077474L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWikiLike wikiLike = new QWikiLike("wikiLike");

    public final QWikiLikeId wikiLikeId;

    public QWikiLike(String variable) {
        this(WikiLike.class, forVariable(variable), INITS);
    }

    public QWikiLike(Path<? extends WikiLike> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWikiLike(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWikiLike(PathMetadata metadata, PathInits inits) {
        this(WikiLike.class, metadata, inits);
    }

    public QWikiLike(Class<? extends WikiLike> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.wikiLikeId = inits.isInitialized("wikiLikeId") ? new QWikiLikeId(forProperty("wikiLikeId"), inits.get("wikiLikeId")) : null;
    }

}

