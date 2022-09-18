package com.example.booklevel.app.api.principal.controller

import com.example.booklevel.api.model.BookLevelApiResponse
import com.example.booklevel.app.api.principal.model.MemberForm
import com.example.booklevel.domain.principal.entity.MemberEntity
import com.example.booklevel.domain.principal.service.MemberCommandService
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
@Api("회원 관리")
@RestController
@RequestMapping("/members")
class MemberController(
    val memberCommandService: MemberCommandService
) {

    @PostMapping("")
    fun registerMember(@RequestBody memberForm: MemberForm) : BookLevelApiResponse<MemberEntity> =
        BookLevelApiResponse.ok(memberCommandService.save(memberForm.toEntity()))

}