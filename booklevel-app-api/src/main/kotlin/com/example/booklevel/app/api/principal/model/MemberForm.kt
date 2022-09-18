package com.example.booklevel.app.api.principal.model

import com.example.booklevel.domain.principal.entity.BookEntity
import com.example.booklevel.domain.principal.entity.MemberEntity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel("회원 등록")
data class MemberForm(

    @ApiModelProperty("회원 이름")
    val name: String,
    @ApiModelProperty("이메일")
    val email: String,
    @ApiModelProperty("비밀번호")
    val password: String
) {
    fun toEntity() : MemberEntity {
        return MemberEntity(name = name, email = email, password = password)
    }
}