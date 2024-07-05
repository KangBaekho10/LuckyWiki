package org.real7.luckywiki.domain.wiki.repository.popularword

import com.querydsl.jpa.impl.JPAQueryFactory
import org.real7.luckywiki.domain.wiki.model.QPopularWord
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

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

    @Transactional
    override fun deleteDataPast24Hours() {
        queryFactory.delete(popularWord)
            .where(popularWord.searchedAt.lt(LocalDateTime.now().minusHours(24)))
            .execute()
    }
}