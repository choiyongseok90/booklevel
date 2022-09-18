package com.example.booklevel.internal.api.principal.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel("관리자용 책정보 Response")
data class Book(
    @ApiModelProperty("id")
    val id: Long,
    @ApiModelProperty("책제목")
    val title: String,
    @ApiModelProperty("저자")
    val author: String,
    @ApiModelProperty("책난이도")
    val averageBookLevel: Double
)
