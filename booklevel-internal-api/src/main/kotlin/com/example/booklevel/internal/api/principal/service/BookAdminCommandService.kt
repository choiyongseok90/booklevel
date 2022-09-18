package com.example.booklevel.internal.api.principal.service


import com.example.booklevel.domain.principal.service.BookCommandService
import com.example.booklevel.domain.principal.service.ReviewCommandService
import com.example.booklevel.internal.api.principal.model.BookForm
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class BookAdminCommandService(
    val bookCommandService: BookCommandService
) {
    fun save(bookForm: BookForm): Long {
        return kotlin.runCatching { bookCommandService.save(bookForm.toEntity()) }
            .map { it.id }
            .onFailure { throw RuntimeException("도서정보를 저장할 수 없습니다.") }
            .getOrThrow()
    }
}