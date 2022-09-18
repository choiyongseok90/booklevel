package com.example.booklevel.app.api.principal.controller

import com.example.booklevel.app.api.principal.model.ReviewSimpleDto
import com.example.booklevel.app.api.principal.service.BookReviewSearchService
import com.fnb.review.api.model.BookLevelApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class BookReviewController(
    val bookReviewSearchService: BookReviewSearchService
) {
    @GetMapping("/{bookId}/reviews/{reviewId}")
    fun review(@PathVariable("bookId") storeId: Long, @PathVariable("reviewId") reviewId: Long): BookLevelApiResponse<ReviewSimpleDto> {
        return BookLevelApiResponse.ok(
            bookReviewSearchService.findByStoreIdAndReviewId(storeId, reviewId)
        )
    }

    @GetMapping("/{bookId}/reviews")
    fun reviews(@PathVariable("bookId") storeId: Long) : BookLevelApiResponse<List<ReviewSimpleDto>> {
        return BookLevelApiResponse.ok(
            bookReviewSearchService.findByStoreId(storeId)
        )
    }
}