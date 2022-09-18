package com.example.booklevel.domain.principal.repository

import com.example.booklevel.domain.principal.entity.BookEntity
import com.example.booklevel.domain.principal.entity.ReviewEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface ReviewRepository : JpaRepository<ReviewEntity, Long> {
    fun findByBookId(bookId: Long): MutableList<ReviewEntity>
    fun findByBookIdAndId(bookId: Long, id: Long): Optional<ReviewEntity>
}