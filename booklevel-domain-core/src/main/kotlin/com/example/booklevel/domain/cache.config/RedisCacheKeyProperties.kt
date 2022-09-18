package com.example.booklevel.domain.cache.config

enum class RedisCacheKeyProperties(val description: String, val ttl: Long, val key: Boolean, val placeholder: String, val dpOrderNumber: Int) {
    cached_default(
        "시스템 유지 관리 캐시",
        60 * 60 * 24L,
        true,
        "KEY",
        0
    ), // second s * m * h
    cached_review_by_bookId_reviewId(
        "리뷰 캐시",
        60 * 60 * 24L,
        true,
        "KEY",
        0
    ), // second s * m * h
}