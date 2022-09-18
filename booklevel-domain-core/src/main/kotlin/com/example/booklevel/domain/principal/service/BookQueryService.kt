package com.example.booklevel.domain.principal.service

import com.example.booklevel.domain.principal.entity.BookEntity
import com.example.booklevel.domain.principal.entity.MemberEntity
import com.example.booklevel.domain.principal.repository.BookRepository
import org.jetbrains.annotations.NotNull
import org.springframework.stereotype.Service

@Service
class BookQueryService(val bookRepository: BookRepository) {

    fun findAll() : MutableList<BookEntity> =
        bookRepository.findAll()

    fun findById(@NotNull bookId : Long) : BookEntity =
        bookRepository.findById(bookId).orElseThrow()
}