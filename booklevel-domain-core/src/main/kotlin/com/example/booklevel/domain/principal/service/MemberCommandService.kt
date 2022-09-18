package com.example.booklevel.domain.principal.service

import com.example.booklevel.domain.principal.entity.MemberEntity
import com.example.booklevel.domain.principal.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@Transactional
class MemberCommandService(val memberRepository: MemberRepository) {

    fun save( member : MemberEntity): MemberEntity =
        memberRepository.save(member)
}