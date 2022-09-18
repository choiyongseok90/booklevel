package com.example.booklevel.app.api.principal.model

import com.example.booklevel.domain.principal.entity.BookEntity
import com.example.booklevel.domain.principal.entity.ReviewEntity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.io.Serializable

@ApiModel("책정보")
data class BookSimpleDto(
    @ApiModelProperty("id")
    val id: Long,
    @ApiModelProperty("책제목")
    val title: String,
    @ApiModelProperty("저자")
    val author: String,
    @ApiModelProperty("책난이도")
    val averageBookLevel: Double
) : Serializable

object BookSimpleMapper{
    fun map(book: BookEntity): BookSimpleDto = book.let {
        return BookSimpleDto(
            id = it.id,
            title = it.title,
            author = it.author,
            averageBookLevel = it.averageBookLevel
        )
    }
}