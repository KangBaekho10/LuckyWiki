package org.real7.luckywiki.domain.wiki.service

import org.real7.luckywiki.common.MatchingKey
import org.real7.luckywiki.config.LettuceRedis
import org.real7.luckywiki.domain.wiki.model.WikiPage
import org.real7.luckywiki.domain.wiki.repository.popularword.PopularWordCustomRepository
import org.real7.luckywiki.domain.wiki.repository.wikipage.WikiPageRepository
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class WikiPageServiceScheduler(
    private val popularWordRepository: PopularWordCustomRepository,
    private val wikiPageRepository: WikiPageRepository,
    private val lettuceRedis: LettuceRedis
){

    @Scheduled(cron = "0 0 * * * *")
    fun savePopularWordTop10(){
        val result = popularWordRepository.getPopularWordTop10()

        lettuceRedis.saveAllHashSet(MatchingKey.TOP10, result, 3600)
//        lettuceRedis.saveAll("top10", result, 3600)

    }

    @Scheduled(cron = "0 * * * * *")
    fun savePopularWikiTop10(){

        val popularList = wikiPageRepository.findByCountTop10()

        popularList.forEachIndexed { index , it ->
            savedRedis(it, index)
        }
    }

    private fun savedRedis(args: WikiPage, index: Int){
        val resultMap = mapOf(
            "title" to args.title,
            "content" to args.content,
            "image" to args.image,
            "tag" to args.tag,
            "reaction" to args.reaction.toString(),
            "views" to args.views.toString(),
            "created_at" to args.createdAt.toString(),
            "updated_at" to args.updatedAt.toString(),
        )

        lettuceRedis.saveAllHashSet("${MatchingKey.WIKI}_$index", resultMap, 3600)
    }

}