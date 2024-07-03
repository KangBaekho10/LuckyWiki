package org.real7.luckywiki.domain.wiki.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWikiPage is a Querydsl query type for WikiPage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWikiPage extends EntityPathBase<WikiPage> {

    private static final long serialVersionUID = -238443955L;

    public static final QWikiPage wikiPage = new QWikiPage("wikiPage");

    public final org.real7.luckywiki.domain.wiki.QBaseTimeEntity _super = new org.real7.luckywiki.domain.wiki.QBaseTimeEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath image = createString("image");

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final NumberPath<Long> reaction = createNumber("reaction", Long.class);

    public final StringPath tag = createString("tag");

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final NumberPath<Long> views = createNumber("views", Long.class);

    public final ListPath<WikiHistory, QWikiHistory> wikiHistoryList = this.<WikiHistory, QWikiHistory>createList("wikiHistoryList", WikiHistory.class, QWikiHistory.class, PathInits.DIRECT2);

    public QWikiPage(String variable) {
        super(WikiPage.class, forVariable(variable));
    }

    public QWikiPage(Path<? extends WikiPage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWikiPage(PathMetadata metadata) {
        super(WikiPage.class, metadata);
    }

}

