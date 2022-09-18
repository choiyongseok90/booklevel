package com.example.booklevel.app.api.principal.controller

import com.example.booklevel.api.model.BookLevelApiResponse
import com.example.booklevel.app.api.principal.model.*
import com.example.booklevel.app.api.principal.service.BookReviewSearchService
import com.example.booklevel.domain.principal.entity.ReviewEntity
import com.example.booklevel.domain.principal.service.BookQueryService
import com.example.booklevel.domain.principal.service.MemberQueryService
import com.example.booklevel.domain.principal.service.ReviewCommandService
import io.swagger.annotations.Api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.stream.Collectors

@Api("도서 조회 및 리뷰등록")
@RestController
@RequestMapping("/books")
class BookController(
    val bookReviewSearchService: BookReviewSearchService,
    val bookQueryService: BookQueryService,
    val memberQueryService: MemberQueryService,
    val reviewCommandService: ReviewCommandService
) {
    @GetMapping("/{bookId}/reviews/{reviewId}")
    fun readReviewByBookIdAndReviewId(@PathVariable("bookId") bookId: Long, @PathVariable("reviewId") reviewId: Long): BookLevelApiResponse<ReviewSimpleDto> {
        return BookLevelApiResponse.ok(
            bookReviewSearchService.findByBookIdAndReviewId(bookId, reviewId)
        )
    }

    @GetMapping("/{bookId}/reviews")
    fun readReviewByBookId(@PathVariable("bookId") bookId: Long) : BookLevelApiResponse<List<ReviewSimpleDto>> {
        return BookLevelApiResponse.ok(
            bookReviewSearchService.findByBookId(bookId)
        )
    }

    @GetMapping("")
    fun readAllBooks() : BookLevelApiResponse<List<BookSimpleDto>> {
        return BookLevelApiResponse.ok(
            bookQueryService.findAll().stream()
                .map { it-> BookSimpleMapper.map(it) }.collect(Collectors.toList())
        )
    }
    @PostMapping("/{bookId}/reviews")
    fun createReview(@PathVariable("bookId") bookId: Long, @RequestBody reviewRequestDto: ReviewRequestDto ) : BookLevelApiResponse<ReviewEntity> {
        var member = memberQueryService.findById(reviewRequestDto.memberId)
        var book = bookQueryService.findById(bookId)
        var newReviewForm = ReviewForm(reviewRequestDto.title, reviewRequestDto.content, reviewRequestDto.score, member, book)
        return BookLevelApiResponse.ok(
            reviewCommandService.save(newReviewForm.toEntity())
        )
    }
}