package com.example.booklevel.domain.principal.service

import com.example.booklevel.domain.principal.entity.BookEntity
import com.example.booklevel.domain.principal.entity.MemberEntity
import com.example.booklevel.domain.principal.repository.MemberRepository
import org.jetbrains.annotations.NotNull
import org.springframework.stereotype.Service


@Service
class MemberQueryService(val memberRepository: MemberRepository) {

//    fun findAll() : MutableList<MemberEntity> =
//        memberRepository.findAll()

    fun findById(@NotNull memberId : Long) : MemberEntity =
        memberRepository.findById(memberId).orElseThrow()
}