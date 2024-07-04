package org.real7.luckywiki.domain.debate.repository

import org.real7.luckywiki.domain.debate.entity.Debate

interface DebateRepository {

    fun save(debate: Debate): Debate

    fun findByIdOrNull(debateId: Long): Debate?

    fun findAll(): List<Debate>

    fun delete(debate: Debate)
}