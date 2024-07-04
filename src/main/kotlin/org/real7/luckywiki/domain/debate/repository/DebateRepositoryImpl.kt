package org.real7.luckywiki.domain.debate.repository

import org.real7.luckywiki.domain.debate.entity.Debate
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class DebateRepositoryImpl(
    private val debateJpaRepository: DebateJpaRepository
):DebateRepository {

    override fun save(debate: Debate): Debate {
        return debateJpaRepository.save(debate)
    }

    override fun findByIdOrNull(debateId: Long): Debate? {
        return debateJpaRepository.findByIdOrNull(debateId)
    }

    override fun findAll(): List<Debate> {
        return debateJpaRepository.findAll()
    }

    override fun delete(debate: Debate) {
        debateJpaRepository.delete(debate)
    }
}