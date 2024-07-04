package org.real7.luckywiki.domain.wiki.repository

import org.real7.luckywiki.domain.wiki.model.PopularWord
import org.springframework.data.jpa.repository.JpaRepository

interface PopularWordRepository : JpaRepository<PopularWord, Long> {

}