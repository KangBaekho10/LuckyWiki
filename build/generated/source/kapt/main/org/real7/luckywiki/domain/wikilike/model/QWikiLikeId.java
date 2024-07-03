package org.real7.luckywiki.domain.wikilike.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWikiLikeId is a Querydsl query type for WikiLikeId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QWikiLikeId extends BeanPath<WikiLikeId> {

    private static final long serialVersionUID = 1813934873L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWikiLikeId wikiLikeId = new QWikiLikeId("wikiLikeId");

    public final org.real7.luckywiki.domain.member.model.QMember member;

    public final org.real7.luckywiki.domain.wiki.model.QWikiPage wiki;

    public QWikiLikeId(String variable) {
        this(WikiLikeId.class, forVariable(variable), INITS);
    }

    public QWikiLikeId(Path<? extends WikiLikeId> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWikiLikeId(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWikiLikeId(PathMetadata metadata, PathInits inits) {
        this(WikiLikeId.class, metadata, inits);
    }

    public QWikiLikeId(Class<? extends WikiLikeId> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new org.real7.luckywiki.domain.member.model.QMember(forProperty("member")) : null;
        this.wiki = inits.isInitialized("wiki") ? new org.real7.luckywiki.domain.wiki.model.QWikiPage(forProperty("wiki")) : null;
    }

}

