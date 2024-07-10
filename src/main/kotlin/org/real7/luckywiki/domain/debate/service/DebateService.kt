package org.real7.luckywiki.domain.debate.service

import org.real7.luckywiki.common.CommonResponse
import org.real7.luckywiki.domain.debate.dto.CreateDebateRequest
import org.real7.luckywiki.domain.debate.dto.DebateResponse
import org.real7.luckywiki.domain.debate.dto.UpdateDebateRequest
import org.real7.luckywiki.domain.debate.entity.Debate
import org.real7.luckywiki.domain.debate.repository.DebateRepository
import org.real7.luckywiki.domain.member.service.ExternalMemberService
import org.real7.luckywiki.domain.wiki.service.ExternalWikiPageService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class DebateService(
    private val debateRepository: DebateRepository,
    private val memberService: ExternalMemberService,
    private val wikiService : ExternalWikiPageService
){


    fun createDebate(email: String, createDebateRequest: CreateDebateRequest): CommonResponse {

        val member = memberService.searchByEmail(email)
        val wiki = wikiService.searchByWikiId(createDebateRequest.wikiId)

        val savedData = debateRepository.save(
            Debate(
                title = createDebateRequest.title,
                content = createDebateRequest.content,
                image = null,
                member = member,
                wiki = wiki,
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
