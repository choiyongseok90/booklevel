package com.example.booklevel.domain.principal.entity

import BaseEntity
import org.hibernate.annotations.Comment
import org.jetbrains.annotations.NotNull
import javax.persistence.*


@Entity
@Table(
    name = "book",
    indexes = [
        Index(name = "idx_book_level", columnList = "average_level", unique = false)
    ]
)
@org.hibernate.annotations.Table(appliesTo = "book", comment = "도서")
class BookEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long = 0,

    @Column(nullable = false, name = "title", length = 50)
    @Comment("도서 제목")
    @NotNull
    var title: String,

    @Column(nullable = false, name = "average_book_level", columnDefinition="Decimal(2,1) default '3.0'")
    @Comment(value = "사용자 난이도 평가 평균(default:3.0)")
    @NotNull
    var averageBookLevel: Double,

    @OneToMany(mappedBy = "review", fetch = FetchType.LAZY)
    var reviews: MutableList<ReviewEntity> = mutableListOf()




): BaseEntity()