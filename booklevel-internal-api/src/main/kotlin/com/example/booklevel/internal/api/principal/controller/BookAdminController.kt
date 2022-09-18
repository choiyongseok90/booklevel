package com.example.booklevel.internal.api.principal.controller

import com.example.booklevel.api.model.BookLevelApiPageableRequest
import com.example.booklevel.api.model.BookLevelApiPageableResponse
import com.example.booklevel.api.model.BookLevelApiResponse
import com.example.booklevel.domain.message.I18NMessageHelper
import com.example.booklevel.internal.api.message.ErrorMessageProperty
import com.example.booklevel.internal.api.principal.model.Book
import com.example.booklevel.internal.api.principal.model.BookForm
import com.example.booklevel.internal.api.principal.service.BookAdminCommandService
import io.swagger.annotations.Api
import mu.KotlinLogging
import org.springframework.web.bind.annotation.*

@Api("도서 관리")
@RestController
@RequestMapping("/books")
class BookAdminController(
    val bookAdminCommandService: BookAdminCommandService,
    val errorMessageProperty: ErrorMessageProperty,
    val message: I18NMessageHelper
) {
    val log = KotlinLogging.logger { }

    @GetMapping("/{bookId}/error", )
    fun books(): BookLevelApiResponse<String> {
        return BookLevelApiResponse.ok(
            errorMessageProperty.notfound +" / "+ message.getMessage("error.notfound")
        )
    }

//    @GetMapping("/")
//    fun getBooks(pageRequest: BookLevelApiPageableRequest): BookLevelApiPageableResponse<Book> {
//        return BookLevelApiPageableResponse.ok(
//            data = listOf<Book>(Book(
//                id=1,
//                title = "",
//                author = "",
//                averageBookLevel = 3.0
//                )),
//            currentPageNumber = 1,
//            nextPageNumber = 2,
//            hasNextPage = true
//        )
//    }
    @PostMapping("/", )
    fun createBook(@RequestBody newBookForm: BookForm): BookLevelApiResponse<Long> {
        return BookLevelApiResponse.ok(
            bookAdminCommandService.save(newBookForm)
        )
    }
}