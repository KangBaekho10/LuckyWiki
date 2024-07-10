package org.real7.luckywiki.domain.wiki.dto

import jakarta.validation.constraints.Size

data class KeywordRequest (
    @field:Size(min = 1, max = 30, message = "최소 1자에서 최대 30자까지 입력 가능합니다.")
    val keyword: String
)