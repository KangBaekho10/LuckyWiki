package org.real7.luckywiki.domain.debate.service

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.real7.luckywiki.domain.comment.dto.CommentRequest
import org.real7.luckywiki.domain.comment.model.Comment
import org.real7.luckywiki.domain.debate.dto.CreateDebateRequest
import org.real7.luckywiki.domain.debate.dto.UpdateDebateRequest
import org.real7.luckywiki.domain.debate.entity.Debate
import org.real7.luckywiki.domain.debate.repository.DebateRepository
import org.real7.luckywiki.domain.member.model.Member
import org.real7.luckywiki.domain.member.model.Role
import org.real7.luckywiki.domain.member.repository.MemberRepository
import org.real7.luckywiki.domain.member.service.ExternalMemberService
import org.real7.luckywiki.domain.wiki.dto.wikipage.CreateWikiPageRequest
import org.real7.luckywiki.domain.wiki.model.WikiPage
import org.real7.luckywiki.domain.wiki.repository.wikipage.WikiPageRepository
import org.real7.luckywiki.domain.wiki.service.ExternalWikiPageService

class DebateServiceTest {


    private val debateRepository = mockk<DebateRepository>()
    private val memberRepository = mockk<MemberRepository>()
    private val wikiPageRepository = mockk<WikiPageRepository>()
    private val memberService = ExternalMemberService(memberRepository)
    private val wikiService = ExternalWikiPageService(wikiPageRepository)
    private val debateService = DebateService(debateRepository, memberService, wikiService)

    @Test
    fun `createDebate 가 정상적으로 동작 할 시 정상적으로 save 진행`(){

        val createDebateRequest = CreateDebateRequest(
            wikiId = 1L,
            title = "title",
            content = "content",
        )

        every { memberRepository.findByEmail(any()) } returns MEMBER

        every { wikiService.searchByWikiId(any()) } returns WIKI

        every { debateRepository.save(any()) } returns DEBATE


        val result = debateService.createDebate("test@test.com",createDebateRequest)

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

        every { debateRepository.save(any()) } returns DEBATE

        val result = debateService.updateDebate(1L, updateDebateRequest)

        result.title shouldBe "title2"
        result.msg shouldBe "토론 데이터 업데이트가 완료 되었습니다"

    }


    companion object{
        private val createWikiPageRequest = CreateWikiPageRequest(
            title = "title",
            content = "content",
            tag = "tag"
        )

        private val commentRequest = CommentRequest(
            content = "content",
            vote = true
        )
        private val MEMBER = Member(
            email = "test@test.com",
            name = "test",
            password = "test",
            role = Role.USER
        )


        private var WIKI: WikiPage = WikiPage.from(createWikiPageRequest, 1L)

        private var DEBATE = Debate(
            id = 1L,
            title = "title",
            content = "content",
            image = "image",
            member = MEMBER,
            wiki = WIKI,
            comment = listOf()
        )
        private val COMMENT: Comment = Comment.from(commentRequest, 1L, DEBATE)





    }
}
