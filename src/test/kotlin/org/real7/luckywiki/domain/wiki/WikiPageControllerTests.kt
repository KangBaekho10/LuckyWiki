package org.real7.luckywiki.domain.wiki

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.extension.ExtendWith
import org.real7.luckywiki.domain.wiki.controller.WikiPageController
import org.real7.luckywiki.domain.wiki.dto.wikipage.CreateWikiPageRequest
import org.real7.luckywiki.domain.wiki.dto.wikipage.CreateWikiPageResponse
import org.real7.luckywiki.domain.wiki.dto.wikipage.WikiPageResponse
import org.real7.luckywiki.domain.wiki.service.WikiPageServiceImpl
import org.real7.luckywiki.exception.ModelNotFoundException
import org.real7.luckywiki.exception.dto.ErrorResponse
import org.real7.luckywiki.security.jwt.JwtPlugin
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.mock.web.MockMultipartFile
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart
import java.nio.charset.StandardCharsets
import java.time.LocalDateTime


@WebMvcTest(WikiPageController::class)
@ExtendWith(MockKExtension::class)
@Import(value = [JwtPlugin::class])
@WithMockUser(username = "user", roles = ["USER"])
@AutoConfigureMockMvc
class WikiPageControllerTests @Autowired constructor(
    private val mockMvc: MockMvc,

    @MockkBean
    private val wikiPageService: WikiPageServiceImpl,

    ) : DescribeSpec({
    extension(SpringExtension)

    afterContainer {
        clearAllMocks()
    }

    describe("POST /api/v1/wikis") {
        context("게시글 작성 요청을 하면") {

            val request = MockMultipartFile(
                "request",
                null,
                "application/json",
                jacksonObjectMapper().writeValueAsString(
                    // title: 최소 1자에서 최대 30자
                    // content: 최소 30자부터
                    // tag: 최소 1자에서 최대 10자
                    CreateWikiPageRequest(
                        title = "title",
                        content = "contentcontentcontentcontentcontentcontentcontentcontentcontentcontentcontentcontentcontentcontentcontent",
                        tag = "tag"
                    )
                ).toByteArray(StandardCharsets.UTF_8)

            )

            it("Status Code 200과 작성된 내용을 응답으로 전달한다.") {

                every { wikiPageService.createWikiPage(any(), any()) } returns CreateWikiPageResponse(
                    title = "title",
                    content = "contentcontentcontentcontentcontentcontentcontentcontentcontentcontentcontentcontentcontentcontentcontent",
                    image = "image",
                    tag = "tag",
                    createdAt = LocalDateTime.of(2024, 7, 3, 6, 0)
                )

                val result = mockMvc.perform(
                    multipart("/api/v1/wikis")
                        .file(request)
                        .contentType(MediaType.APPLICATION_JSON)
                        .with(csrf())
                ).andReturn()

                // 403: with(csrf()) 추가로 해결
                // 400: 입력값 유효성 체크를 통과하지 못해서 생긴 문제였음
                result.response.status shouldBe 201 // CREATED
                result.response.contentAsString shouldContain "title"
            }
        }
    }

    describe("GET /api/v1/wikis/{wikiId}") {
        context("존재하는 특정 게시물에 대해 정보를 요청 하면") {
            it("Status Code 200과 요청한 게시물에 대한 정보를 응답으로 전달한다.") {
                val wikiPageId = 1L

                every { wikiPageService.getWikiPage(any(), any(), any()) } returns WikiPageResponse(
                    title = "title",
                    content = "content",
                    image = "image",
                    tag = "tag",
                    reaction = 0,
                    views = 0,
                    createdAt = LocalDateTime.of(2024, 7, 3, 6, 0),
                    updatedAt = LocalDateTime.of(2024, 7, 3, 6, 0)
                )

                val result = mockMvc.perform(
                    get("/api/v1/wikis/$wikiPageId")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andReturn()

                result.response.status shouldBe 200

                val wikiPageResponse = jacksonObjectMapper()
                    .registerModule(JavaTimeModule())
                    .readValue<WikiPageResponse>(result.response.contentAsString)

                wikiPageResponse.title shouldBe "title"
            }
        }

        context("존재하지 않는 특정 게시물에 대해 정보를 요청 하면") {
            it("Status Code 400과 요청한 게시물을 찾을 수 없다는 메시지를 응답으로 전달한다.") {
                val wikiPageId = 10L

                every { wikiPageService.getWikiPage(any(), any(), any()) } throws ModelNotFoundException(
                    "WikiPage",
                    wikiPageId
                )

                val result = mockMvc.perform(
                    get("/api/v1/wikis/$wikiPageId")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andReturn()

                result.response.status shouldBe 404

                val errorResponse =
                    jacksonObjectMapper()
                        .readValue<ErrorResponse>(result.response.contentAsString)

                errorResponse.message shouldBe "Model WikiPage not found with given id: 10"
            }
        }
    }
})