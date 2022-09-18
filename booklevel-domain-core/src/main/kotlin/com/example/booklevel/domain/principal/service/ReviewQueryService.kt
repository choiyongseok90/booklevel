package com.example.booklevel.domain.principal.service

import com.example.booklevel.domain.principal.entity.ReviewEntity
import com.example.booklevel.domain.principal.repository.ReviewRepository
import org.jetbrains.annotations.NotNull
import org.springframework.stereotype.Service


@Service
class ReviewQueryService(
    val reviewRepository: ReviewRepository
) {
    fun findByBookIdAndReviewId(@NotNull bookId: Long, @NotNull reviewId: Long): ReviewEntity =
        reviewRepository.findByStoreIdAndId(bookId, reviewId).orElseThrow()

    fun findByBookId(@NotNull bookId: Long): MutableList<ReviewEntity> =
        reviewRepository.findByStoreId(bookId)
}