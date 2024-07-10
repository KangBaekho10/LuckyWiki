package org.real7.luckywiki.common

import org.apache.tika.Tika
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class FileUtils (
    val tika : Tika
) {
    fun fileTrust(file: MultipartFile) {
        val detectedMimeType = file.inputStream.use{tika.detect(it)}

        if (detectedMimeType != file.contentType){
            throw IllegalArgumentException("파일과 확장자명이 일치하지 않습니다.")
        }

    }
}