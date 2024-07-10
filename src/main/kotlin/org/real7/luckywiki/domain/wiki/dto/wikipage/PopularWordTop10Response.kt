package org.real7.luckywiki.domain.wiki.dto.wikipage

import org.real7.luckywiki.domain.wiki.model.WikiPage

data class PopularWordTop10Response(
    val rank : Int,
    val content: String
){
    companion object {
        fun from(popularWordTop10List: Map<String, String>): List<PopularWordTop10Response> {

            return popularWordTop10List.map{
                PopularWordTop10Response(
                    rank = it.key.toInt() + 1,
                    content = it.value
                )
            }
        }
    }
}