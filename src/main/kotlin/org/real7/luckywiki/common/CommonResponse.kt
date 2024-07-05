package org.real7.luckywiki.common

import org.real7.luckywiki.domain.debate.entity.Debate

data class CommonResponse(
    val msg : String,
    val id : Long,
    val title : String,
){
    companion object{
        fun from(msg: String, debate: Debate): CommonResponse {
            return CommonResponse(
                id = debate.id!!.toLong(),
                title = debate.title,
                msg = msg
            )
        }
    }
}