package com.example.booklevel.domain.principal.repository

import com.example.booklevel.domain.principal.entity.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : JpaRepository<MemberEntity, Long> {
}