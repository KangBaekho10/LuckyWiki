package org.real7.luckywiki.domain.wiki.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import org.real7.luckywiki.domain.wiki.model.QPopularWord
import org.springframework.stereotype.Repository

@Repository
class PopularWordCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory
) : PopularWordCustomRepository {
    private val popularWord = QPopularWord.popularWord

    override fun getPopularWordTop10(): List<String> {
        val subQuery = queryFactory.select(popularWord.searchWord, popularWord.searchWord.count())
            .from(popularWord)
            .groupBy(popularWord.searchWord)
            .orderBy(popularWord.searchWord.count().desc())
            .limit(10)

        return subQuery.select(popularWord.searchWord).fetch()
    }
}