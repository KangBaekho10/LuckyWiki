package org.real7.luckywiki.domain.debate.service

import org.real7.luckywiki.domain.common.CommonResponse
import org.real7.luckywiki.domain.debate.dto.CreateDebateRequest
import org.real7.luckywiki.domain.debate.dto.DebateResponse
import org.real7.luckywiki.domain.debate.dto.UpdateDebateRequest
import org.real7.luckywiki.domain.debate.entity.Debate
import org.real7.luckywiki.domain.debate.repository.DebateRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class DebateService(
    private val debateRepository: DebateRepository,
){


    fun createDebate(createDebateRequest: CreateDebateRequest): CommonResponse {

        val savedData = debateRepository.save(
            Debate(
                title = createDebateRequest.title,
                content = createDebateRequest.content,
                image = null,
                member = TODO(),
                wiki = TODO(),
                comment = listOf()
            )
        )

        return CommonResponse.from("토론 생성이 완료되었습니다", savedData)
    }

    @Transactional(readOnly = true)
    fun getDebate(debateId: Long): DebateResponse {

        val debate = debateRepository.findByIdOrNull(debateId) ?: throw IllegalArgumentException()

        return DebateResponse.from(debate, true)
    }

    @Transactional(readOnly = true)
    fun getDebateList(): List<DebateResponse> {

        val debateList = debateRepository.findAll()

        return debateList.map { DebateResponse.from(it, false) }
    }

    fun updateDebate(debateId: Long, updateDebateRequest: UpdateDebateRequest): CommonResponse {

        val debate = debateRepository.findByIdOrNull(debateId) ?: throw IllegalArgumentException()

        debate.update(updateDebateRequest)

        val savedData = debateRepository.save(debate)

        return CommonResponse.from("토론 데이터 업데이트가 완료 되었습니다",savedData)
    }

    fun deleteDebate(debateId: Long): CommonResponse {

        val debate = debateRepository.findByIdOrNull(debateId) ?: throw IllegalArgumentException()
        val commonResponseData = CommonResponse.from("토론 삭제가 완료되었습니다", debate)
        debateRepository.delete(debate)

        return commonResponseData
    }

}
