package com.example.booklevel.app.api.principal.service

import com.example.booklevel.app.api.principal.model.ReviewSimpleDto
import com.example.booklevel.app.api.principal.model.ReviewSimpleMapper
import com.example.booklevel.domain.principal.service.ReviewQueryService
import mu.KotlinLogging
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class BookReviewSearchService(
    val reviewQueryService: ReviewQueryService
){
    val log = KotlinLogging.logger { }
    @Cacheable(value = ["cached_review_by_bookId_reviewId"], key = "{#bookId, #reviewId}")
    fun findByBookIdAndReviewId(bookId: Long, reviewId: Long): ReviewSimpleDto {
        val review = reviewQueryService.findByBookIdAndReviewId(bookId, reviewId);
        return ReviewSimpleMapper.map(review);
    }

    fun findByBookId(bookId: Long): List<ReviewSimpleDto> {
        return reviewQueryService.findByBookId(bookId)
            .stream()
            .map { it-> ReviewSimpleMapper.map(it) }
            .collect(Collectors.toList())
    }

}