package org.real7.luckywiki.domain.wiki.repository.wikipage

import org.real7.luckywiki.domain.wiki.model.WikiPage
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface WikiPageRepository : JpaRepository<WikiPage, Long>, WikiPageCustomRepository {

    @Query("SELECT MAX(w.id) FROM WikiPage w")
    fun findMaxId(): Long?
    @Query("SELECT MIN(w.id) FROM WikiPage w")
    fun findMinId(): Long?

    fun findByTitle(keyword: String): WikiPage?

    fun findByTag(keyword: String): WikiPage?
}