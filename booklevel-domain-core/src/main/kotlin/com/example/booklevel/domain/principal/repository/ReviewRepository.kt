package com.example.booklevel.domain.principal.repository

import com.example.booklevel.domain.principal.entity.ReviewEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ReviewRepository : JpaRepository<ReviewEntity, Long> {
    fun findByStoreId(bookId: Long): MutableList<ReviewEntity>
    fun findByStoreIdAndId(bookId: Long, reviewId: Long): Optional<ReviewEntity>
}