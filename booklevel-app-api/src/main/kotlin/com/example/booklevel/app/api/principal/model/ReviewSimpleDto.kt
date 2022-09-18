package com.example.booklevel.app.api.principal.model

import com.example.booklevel.domain.principal.entity.ReviewEntity
import java.io.Serializable

data class ReviewSimpleDto(
    val id: Long,
    val title: String,
    val content: String,
    val score: Int,
    val writer: String
) : Serializable

object ReviewSimpleMapper{
    fun map(review: ReviewEntity): ReviewSimpleDto = review.let {
        return ReviewSimpleDto(
            id = it.id,
            title = it.title,
            content = it.content,
            score = it.score,
            writer = it.member.name

        )
    }
}