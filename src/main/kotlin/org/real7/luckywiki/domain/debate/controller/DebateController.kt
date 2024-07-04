package org.real7.luckywiki.domain.debate.controller

import org.real7.luckywiki.domain.debate.dto.CreateDebateRequest
import org.real7.luckywiki.common.CommonResponse
import org.real7.luckywiki.domain.debate.dto.DebateResponse
import org.real7.luckywiki.domain.debate.dto.UpdateDebateRequest
import org.real7.luckywiki.domain.debate.service.DebateService
import org.real7.luckywiki.security.UserPrincipal
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/debates")
class DebateController(
    private val debateService: DebateService
){

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    fun createDebate(
        @AuthenticationPrincipal userPrincipal: UserPrincipal?,
        createDebateRequest: CreateDebateRequest
    ): ResponseEntity<CommonResponse> {

        if(userPrincipal == null) throw IllegalArgumentException()

        return ResponseEntity.status(HttpStatus.CREATED).body(debateService.createDebate(userPrincipal.email, createDebateRequest))
    }

    @GetMapping("/{debateId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    fun getDebate(
        @PathVariable("debateId") debateId: Long,
    ): ResponseEntity<DebateResponse>{

        return ResponseEntity.status(HttpStatus.OK).body(debateService.getDebate(debateId))
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    fun getDebateList(): ResponseEntity<List<DebateResponse>>{

        return ResponseEntity.status(HttpStatus.OK).body(debateService.getDebateList())
    }

    @PutMapping("/{debateId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    fun updateDebate(
        @PathVariable("debateId") debateId: Long,
        @RequestBody updateDebateRequest: UpdateDebateRequest
    ): ResponseEntity<CommonResponse>{

        return ResponseEntity.status(HttpStatus.OK).body(debateService.updateDebate(debateId, updateDebateRequest))
    }

    @DeleteMapping("/{debateId}")
    @PreAuthorize("hasRole('ADMIN')")
    fun deleteDebate(
        @PathVariable("debateId") debateId: Long,
    ): ResponseEntity<CommonResponse>{

        return ResponseEntity.status(HttpStatus.OK).body(debateService.deleteDebate(debateId))
    }

}