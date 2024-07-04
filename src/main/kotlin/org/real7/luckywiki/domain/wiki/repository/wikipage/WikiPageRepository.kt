package org.real7.luckywiki.domain.wiki.repository.wikipage

import org.real7.luckywiki.domain.wiki.model.WikiPage
import org.springframework.data.jpa.repository.JpaRepository

interface WikiPageRepository : JpaRepository<WikiPage, Long>, WikiPageCustomRepository {
}