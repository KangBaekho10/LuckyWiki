package org.real7.luckywiki.domain.wiki.repository.wikipage

import org.real7.luckywiki.domain.wiki.dto.KeywordRequest
import org.real7.luckywiki.domain.wiki.model.WikiPage
import org.real7.luckywiki.domain.wiki.model.type.SearchType
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface WikiPageCustomRepository {

    fun search(pageable: Pageable): Page<WikiPage>
    fun keywordSearch(searchType: SearchType, keyword: KeywordRequest, pageable: Pageable): Page<WikiPage>
    fun updateViews(wikiId: Long)
    fun findByCountTop10(): List<WikiPage>
    fun searchExceptTop10(pageable: Pageable, top10List: List<String>): Page<WikiPage>
    fun keywordSearchExceptTop10(searchType: SearchType, keyword: KeywordRequest, pageable: Pageable, top10List: List<String>): Page<WikiPage>
}