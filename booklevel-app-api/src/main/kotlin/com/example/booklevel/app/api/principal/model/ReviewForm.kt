package com.example.booklevel.app.api.principal.model

import com.example.booklevel.domain.principal.entity.BookEntity
import com.example.booklevel.domain.principal.entity.MemberEntity
import com.example.booklevel.domain.principal.entity.ReviewEntity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel("리뷰 등록")
data class ReviewForm(

    @ApiModelProperty("리뷰 타이틀")
    val title: String,
    @ApiModelProperty("리뷰 내용")
    val content: String,
    @ApiModelProperty("책 난이도")
    val score: Int,
    @ApiModelProperty("작성 회원")
    val member: MemberEntity,
    @ApiModelProperty("대상 도서")
    val book: BookEntity,

) {
    fun toEntity() : ReviewEntity {
        return ReviewEntity(title = title, content = content, score = score, member = member, book = book)
    }
}