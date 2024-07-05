package org.real7.luckywiki.domain.wiki.repository

import org.real7.luckywiki.domain.wiki.model.WikiPage
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface WikiPageRepository : JpaRepository<WikiPage, Long> {

}