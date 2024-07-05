package org.real7.luckywiki.domain.wiki.dto.wikipage

import jakarta.validation.constraints.Size

data class UpdateWikiPageRequest(
    @field:Size(min = 1, max = 200, message = "최소 1자에서 최대 200자만 등록 가능합니다.")
    val title: String?,
    @field:Size(min = 50, message = "최소 50자부터 등록 가능합니다.")
    val content: String?
)
