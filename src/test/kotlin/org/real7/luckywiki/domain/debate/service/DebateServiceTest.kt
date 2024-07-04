package org.real7.luckywiki.domain.debate.service

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.real7.luckywiki.domain.debate.dto.CreateDebateRequest
import org.real7.luckywiki.domain.debate.dto.UpdateDebateRequest
import org.real7.luckywiki.domain.debate.entity.Debate
import org.real7.luckywiki.domain.debate.repository.DebateRepository

class DebateServiceTest {


    private val debateRepository = mockk<DebateRepository>()
    private val debateService = DebateService(debateRepository)

    @Test
    fun `createDebate 가 정상적으로 동작 할 시 정상적으로 save 진행`(){

        val createDebateRequest = CreateDebateRequest(
            wikiId = 1L,
            title = "title",
            content = "content",
        )

        every { debateRepository.save(any()) } returns DEBATE

        val result = debateService.createDebate(createDebateRequest)

        result.id shouldBe 1L
        result.title shouldBe "title"
        result.msg shouldContain "토론 생성이 완료되었습니다"

    }

    @Test
    fun `getDebate를 실행 시에 해당 아이디가 없으면 throw 진행`(){

        every { debateRepository.findByIdOrNull(any()) } returns null

        shouldThrow<IllegalArgumentException> {
            debateService.getDebate(2L)
        }.let {
            it.message shouldBe "test"
        }
    }

    @Test
    fun `getDebate를 실행 시에 정상적으로 조회 진행`(){

        every { debateRepository.findByIdOrNull(any()) } returns DEBATE

        val result = debateService.getDebate(1L)


        result.title shouldBe "title"
        result.content shouldBe "content"
        result.comments shouldBe listOf(COMMENT)
    }

    @Test
   fun `getDebateList를 실행 시에 Comment에 emptyList 출력`(){

        every { debateRepository.findAll() } returns listOf(DEBATE, DEBATE)

        val result = debateService.getDebateList()


        result.size shouldBe 2
        result.forEach {
            it.comments shouldBe emptyList()
        }
    }

    @Test
    fun `updateDebate를 실행 시에 정상적으로 업데이트가 되는지 출력`(){

        val updateDebateRequest = UpdateDebateRequest(
            title = "title2",
            content = "content",
        )

        every { debateRepository.findByIdOrNull(any()) } returns DEBATE

        DEBATE.update(updateDebateRequest)

        every { debateRepository.save(any()) } returns DEBATE

        val result = debateService.updateDebate(1L, updateDebateRequest)

        result.title shouldBe "title2"
        result.msg shouldBe "토론 데이터 업데이트가 완료 되었습니다"

    }


    companion object{
        private val DEBATE = Debate(
            id = 1L,
            title = "title",
            content = "content",
            image = "image",
            member = MEMBER,
            wiki = WIKI,
            comment = listOf(COMMENT)
        )

        private val MEMBER = Member()
        private val WIKI = Wiki()
        private val COMMENT = Comment()
    }
}