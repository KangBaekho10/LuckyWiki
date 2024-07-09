package org.real7.luckywiki.exception

data class CustomAccessDeniedException (
    override val message: String
) : RuntimeException(message)