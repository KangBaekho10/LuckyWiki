package org.real7.luckywiki.domain.debate.repository

import org.real7.luckywiki.domain.debate.entity.Debate
import org.springframework.data.jpa.repository.JpaRepository

interface DebateJpaRepository: JpaRepository<Debate, Long> {

    fun deleteByWikiId(id: Long)
}