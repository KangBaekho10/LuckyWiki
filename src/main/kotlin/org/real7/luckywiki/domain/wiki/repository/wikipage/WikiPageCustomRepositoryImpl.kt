package org.real7.luckywiki.domain.wiki.repository.wikipage

import com.querydsl.core.types.Expression
import com.querydsl.core.types.Order
import com.querydsl.core.types.OrderSpecifier
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.core.types.dsl.EntityPathBase
import com.querydsl.core.types.dsl.PathBuilder
import com.querydsl.jpa.impl.JPAQueryFactory
import org.real7.luckywiki.domain.wiki.dto.KeywordRequest
import org.real7.luckywiki.domain.wiki.model.QWikiPage
import org.real7.luckywiki.domain.wiki.model.WikiPage
import org.real7.luckywiki.domain.wiki.model.type.SearchType
import org.real7.luckywiki.infra.aws.querydsl.QueryDslSortUtil
import org.real7.luckywiki.infra.aws.querydsl.QueryDslSortUtil.Companion.getOrderSpecifier
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class WikiPageCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory
) : WikiPageCustomRepository {
    private val wikiPage = QWikiPage.wikiPage

    override fun search(pageable: Pageable): Page<WikiPage> {

        val totalCount = queryFactory.select(wikiPage.count())
            .from(wikiPage)
            .fetchOne() ?: 0L

        val contents = queryFactory.selectFrom(wikiPage)
            .orderBy(*QueryDslSortUtil.getOrderSpecifier(wikiPage, pageable.sort))
            .offset(pageable.offset)
            .limit(pageable.pageSize.toLong())
            .fetch()

        return PageImpl(contents, pageable, totalCount)
    }

    override fun searchExceptTop10(pageable: Pageable, keyword: String, top10List: List<String>): Page<WikiPage> {

        val query = queryFactory.selectFrom(wikiPage)

        query.where(
                filteringTop10(top10List),
                wikiPage.title.contains(keyword)
            )

        if (pageable.sort.isSorted) {
            query.orderBy(wikiPage.views.desc())
        }

        val result = query.offset(pageable.offset)
            .limit(pageable.pageSize.toLong())
            .fetch()

        val totalCount = result.size.toLong()

        return PageImpl(result, pageable, totalCount)
    }

    override fun keywordSearch(searchType: SearchType, keyword: KeywordRequest, pageable: Pageable): Page<WikiPage> {
        val where = when (searchType) {
            SearchType.NONE -> null
            SearchType.TITLE -> wikiPage.title.contains(keyword.keyword)
            SearchType.TAG -> wikiPage.tag.contains(keyword.keyword)
        }

        val totalCount = queryFactory.select(wikiPage.count())
            .from(wikiPage)
            .where(where)
            .fetchOne() ?: 0L

        val contents = queryFactory.selectFrom(wikiPage)
            .where(where)
            .orderBy(*getOrderSpecifier(wikiPage, pageable.sort))
            .offset(pageable.offset)
            .limit(pageable.pageSize.toLong())
            .fetch()

        return PageImpl(contents, pageable, totalCount)
    }

    override fun keywordSearchExceptTop10(searchType: SearchType, keyword: String, pageable: Pageable, top10List: List<String>): Page<WikiPage> {
        val where = when (searchType) {
            SearchType.TITLE -> wikiPage.title.contains(keyword)
            SearchType.TAG -> wikiPage.tag.contains(keyword)
            else -> throw IllegalArgumentException()
        }

        val query = queryFactory.selectFrom(wikiPage)

            query.where(where).where(filteringTop10(top10List))

        if (pageable.sort.isSorted) {
           query.orderBy(*getOrderSpecifier(wikiPage, pageable.sort))

        }

        val result = query.offset(pageable.offset)
            .limit(pageable.pageSize.toLong())
            .fetch()

        return PageImpl(result, pageable, result.size.toLong())
    }

    override fun updateViews(wikiId: Long) {
        queryFactory.update(wikiPage)
            .set(wikiPage.views, wikiPage.views.add(1))
            .where(wikiPage.id.eq(wikiId))
            .execute()
    }

    override fun findByCountTop10(): List<WikiPage> {

        return queryFactory.selectFrom(wikiPage)
            .orderBy(getOrderBy(false, wikiPage, "views"))
            .offset(0)
            .limit(50).fetch()
    }

    private fun getOrderBy(ascend: Boolean, path: EntityPathBase<*>, str: String): OrderSpecifier<*> {
        val pathBuilder = PathBuilder(path.type, path.metadata)


        return OrderSpecifier(
            if (ascend) Order.ASC else Order.DESC,
            pathBuilder.get(str) as Expression<Comparable<*>>,
        )
    }

    private fun filteringTop10(top10List: List<String>): BooleanExpression{
      return excludeTitles(wikiPage, top10List)
    }

    private fun excludeTitles(wikiPage: QWikiPage, titles: List<String>): BooleanExpression {
        return wikiPage.title.notIn(titles)
    }
}