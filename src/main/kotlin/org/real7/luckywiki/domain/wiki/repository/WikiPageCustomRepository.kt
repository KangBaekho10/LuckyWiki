package org.real7.luckywiki.domain.wiki.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import org.real7.luckywiki.domain.wiki.model.QWikiPage
import org.real7.luckywiki.domain.wiki.model.WikiPage
import org.real7.luckywiki.domain.wiki.model.type.SearchType
import org.real7.luckywiki.infra.aws.querydsl.QueryDslSortUtil
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class WikiPageCustomRepository(
    private val queryFactory: JPAQueryFactory
) {
    private val wikiPage = QWikiPage.wikiPage

    fun search(searchType: SearchType, keyword: String, pageable: Pageable): Page<WikiPage> {
        val where = when (searchType) {
            SearchType.NONE -> null
            SearchType.TITLE -> wikiPage.title.like("%$keyword%")
            SearchType.TAG -> wikiPage.tag.like("%$keyword%")
        }

        val totalCount = queryFactory.select(wikiPage.count())
            .from(wikiPage)
            .where(where)
            .fetchOne() ?: 0L

        val contents = queryFactory.selectFrom(wikiPage)
            .where(where)
            .orderBy(*QueryDslSortUtil.getOrderSpecifier(wikiPage, pageable.sort))
            .offset(pageable.offset)
            .limit(pageable.pageSize.toLong())
            .fetch()

        return PageImpl(contents, pageable, totalCount)
    }

}