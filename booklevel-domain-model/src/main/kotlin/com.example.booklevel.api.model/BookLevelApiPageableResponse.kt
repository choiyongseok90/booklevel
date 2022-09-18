package com.example.booklevel.api.model

import java.time.LocalDateTime
import java.time.ZoneId

data class BookLevelApiPageableResponse<T>(
    val timestamp: Long,
    val errorCode: String,
    val message: String,
    // 현재페이지
    val currentPageNumber: Long,
    // 다음페이지
    val nextPageNumber: Long,
    // 다음페이지 여부
    val hasNextPage: Boolean,
    // 데이터
    val data: List<T>? = null
){
    companion object {
        fun <T> ok(data: List<T>?, currentPageNumber:Long, nextPageNumber:Long, hasNextPage:Boolean): BookLevelApiPageableResponse<T> = BookLevelApiPageableResponse(
            timestamp = LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond(),
            errorCode = "",
            message = "OK",
            currentPageNumber = currentPageNumber,
            nextPageNumber = nextPageNumber,
            hasNextPage = hasNextPage,
            data = data
        )

        fun <T> fail(errorCode: String, message: String): BookLevelApiPageableResponse<T> = BookLevelApiPageableResponse(
            timestamp = LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond(),
            errorCode = errorCode,
            message = message,
            currentPageNumber = 0,
            nextPageNumber = 0,
            hasNextPage = false,
            data = null
        )
    }
}