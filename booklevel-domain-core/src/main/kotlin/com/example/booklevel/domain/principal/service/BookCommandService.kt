package com.example.booklevel.domain.principal.service

import com.example.booklevel.domain.principal.entity.BookEntity
import com.example.booklevel.domain.principal.entity.MemberEntity
import com.example.booklevel.domain.principal.repository.BookRepository
import com.example.booklevel.domain.principal.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@Transactional
class BookCommandService(val bookRepository: BookRepository) {

    fun save( book : BookEntity): BookEntity =
        bookRepository.save(book)
}