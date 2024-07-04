package org.real7.luckywiki.domain.controller

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.extension.ExtendWith
import org.real7.luckywiki.domain.comment.controller.CommentController
import org.real7.luckywiki.domain.comment.dto.CommentRequest
import org.real7.luckywiki.domain.comment.dto.SimpleCommentResponse
import org.real7.luckywiki.domain.comment.service.CommentService
import org.real7.luckywiki.domain.wiki.dto.CreateWikiPageRequest
import org.real7.luckywiki.domain.wiki.dto.CreateWikiPageResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.mock.web.MockMultipartFile
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart
import java.nio.charset.StandardCharsets
import java.time.LocalDateTime


@WebMvcTest(CommentController::class)
@ExtendWith(MockKExtension::class)
@AutoConfigureMockMvc
class CommentControllerTest @Autowired constructor(
    private val mockMvc: MockMvc,

    @MockkBean
    private val commentService: CommentService
) : DescribeSpec({
    extension(SpringExtension)

    afterContainer {
        clearAllMocks()
    }


    describe("POST /api/v1/comments/{debateId}") {
        context("댓글 작성 요청을 하면") {
            val memberId = 1L
            val debateId = 1L
            val request = MockMultipartFile(
                "request",
                null,
                "application/json",
                jacksonObjectMapper().writeValueAsString(
                    CommentRequest(
                        content = "content",
                        vote = true
                    )
                ).toByteArray(StandardCharsets.UTF_8)

            )

            it("Status Code 200과 작성된 내용을 응답으로 전달한다.") {

                every { commentService.createComment(any(), any(), any()) } returns SimpleCommentResponse(
                    id = 1L,
                    content = "content"
                )

                val result = mockMvc.perform(
                    multipart("/api/v1/comments/{debateId}")
                        .file(request)
                        .contentType(MediaType.APPLICATION_JSON)
                ).andReturn()

                result.response.status shouldBe 200
                result.response.contentAsString shouldContain "content"
            }
        }
    }

})