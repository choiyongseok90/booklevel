package com.example.booklevel.domain.principal.service

import com.example.booklevel.domain.principal.entity.ReviewEntity
import com.example.booklevel.domain.principal.repository.ReviewRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = false)
class ReviewCommandService(
    val reviewRepository: ReviewRepository
) {

    fun save( review: ReviewEntity) :ReviewEntity {
        return reviewRepository.save(review)
    }

}