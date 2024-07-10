package org.real7.luckywiki.domain.wiki.service

import org.real7.luckywiki.domain.wiki.model.WikiPage
import org.real7.luckywiki.domain.wiki.repository.wikipage.WikiPageRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ExternalWikiPageService(
    private val wikiPageRepository: WikiPageRepository
){

    fun searchByWikiId(id: Long): WikiPage{
        return wikiPageRepository.findByIdOrNull(id) ?: throw IllegalArgumentException()
    }
}