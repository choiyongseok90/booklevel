package com.example.booklevel.api.model

/** 페이지 요청 */
data class BookLevelApiPageableRequest(
    val previousPageNumber:Long,
    val pageNumber:Long,
    val rows:Long
)