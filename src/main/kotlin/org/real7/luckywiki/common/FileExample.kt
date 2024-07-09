package org.real7.luckywiki.common

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RequestMapping("/api/v1/example/file")
@RestController
class FileExample(
    private val fileUtils: FileUtils
) {
    @PostMapping()
    fun example(
        @RequestBody file: MultipartFile
    ) : ResponseEntity<Unit> {
        println(file.originalFilename)
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(fileUtils.fileTrust(file))
    }



}