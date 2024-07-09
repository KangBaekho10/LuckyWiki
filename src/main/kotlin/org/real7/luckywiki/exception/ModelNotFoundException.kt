package org.real7.luckywiki.exception

data class ModelNotFoundException(val modelName: String, val content: String) : RuntimeException(
    "Model $modelName not found with given id: $content"
)