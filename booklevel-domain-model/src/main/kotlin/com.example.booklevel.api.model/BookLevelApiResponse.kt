
package com.example.booklevel.api.model

import java.time.LocalDateTime
import java.time.ZoneId

data class BookLevelApiResponse<T>(
    val timestamp: Long,
    val errorCode: String,
    val message: String,
    val data: T? = null
){
    companion object {
        fun <T> ok(t: T): BookLevelApiResponse<T> = BookLevelApiResponse(
            timestamp = LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond(),
            errorCode = "",
            message = "OK",
            data = t
        )
        fun <T> fail(errorCode: String, message: String): BookLevelApiResponse<T> = BookLevelApiResponse(
            timestamp = LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond(),
            errorCode = errorCode,
            message = message,
            data = null
        )
    }
}


