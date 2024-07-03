package org.real7.luckywiki.domain.wiki.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import org.real7.luckywiki.domain.wiki.model.QWikiHistory
import org.real7.luckywiki.domain.wiki.model.WikiHistory
import org.springframework.stereotype.Repository

@Repository
class WikiHistoryCustomRepository(
    private val queryFactory: JPAQueryFactory
) {
    private val wikiHistory = QWikiHistory.wikiHistory

    fun findImageById(wikiId: Long): List<String> {
        return queryFactory.select(wikiHistory.afterContent.substring(74))
            .from(wikiHistory)
            .where(
                wikiHistory.wikiPage.id.eq(wikiId)
                    .and(wikiHistory.columnType.eq("IMAGE"))
            )
            .fetch()
    }

    fun findHistoryById(wikiId: Long): MutableList<WikiHistory> {
        return queryFactory.selectFrom(wikiHistory)
            .where(wikiHistory.wikiPage.id.eq(wikiId))
            .orderBy(wikiHistory.createdAt.desc())
            .fetch()
    }
}