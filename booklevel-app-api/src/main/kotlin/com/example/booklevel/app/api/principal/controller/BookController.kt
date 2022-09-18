package com.example.booklevel.app.api.principal.controller

import com.example.booklevel.api.model.BookLevelApiResponse
import com.example.booklevel.app.api.principal.model.ReviewSimpleDto
import com.example.booklevel.app.api.principal.service.BookReviewSearchService

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class BookController(
    val bookReviewSearchService: BookReviewSearchService
) {
    @GetMapping("/{bookId}/reviews/{reviewId}")
    fun review(@PathVariable("bookId") bookId: Long, @PathVariable("reviewId") reviewId: Long): BookLevelApiResponse<ReviewSimpleDto> {
        return BookLevelApiResponse.ok(
            bookReviewSearchService.findByBookIdAndReviewId(bookId, reviewId)
        )
    }

    @GetMapping("/{bookId}/reviews")
    fun reviews(@PathVariable("bookId") bookId: Long) : BookLevelApiResponse<List<ReviewSimpleDto>> {
        return BookLevelApiResponse.ok(
            bookReviewSearchService.findByBookId(bookId)
        )
    }
}