package org.real7.luckywiki.domain.wiki.service

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.real7.luckywiki.domain.wiki.dto.KeywordRequest
import org.real7.luckywiki.domain.wiki.dto.wikihistory.WikiHistoryResponse
import org.real7.luckywiki.domain.wiki.dto.wikipage.CreateWikiPageRequest
import org.real7.luckywiki.domain.wiki.dto.wikipage.CreateWikiPageResponse
import org.real7.luckywiki.domain.wiki.dto.wikipage.UpdateWikiPageRequest
import org.real7.luckywiki.domain.wiki.dto.wikipage.WikiPageResponse
import org.real7.luckywiki.domain.wiki.model.WikiPage
import org.real7.luckywiki.domain.wiki.model.type.SearchType
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.multipart.MultipartFile

interface WikiPageService {

    fun createWikiPage(request: CreateWikiPageRequest, image: MultipartFile?): CreateWikiPageResponse

    fun getWikiPage(wikiId: Long, request: HttpServletRequest, response: HttpServletResponse): WikiPageResponse

    fun viewCountUp(wikiId: Long, request: HttpServletRequest, response: HttpServletResponse)

    fun updateWikiPage(wikiId: Long, request: UpdateWikiPageRequest, image: MultipartFile?): WikiPageResponse

    fun deleteWikiPage(wikiId: Long)

    fun getWikiHistory(wikiId: Long): List<WikiHistoryResponse>

    fun getWikiPageList(searchType: SearchType, keyword: KeywordRequest?, pageable: Pageable): Page<WikiPageResponse>

}