package com.example.booklevel.domain.principal.entity

import com.example.booklevel.domain.entity.base.BaseEntity
import org.hibernate.annotations.Comment
import org.jetbrains.annotations.NotNull
import javax.persistence.*
import com.example.booklevel.domain.principal.entity.ReviewEntity

@Entity
@Table(
    name = "book",
    indexes = [
        Index(name = "idx_book_level", columnList = "average_book_level", unique = false)
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

    @Column(nullable = false, name = "author", length = 50)
    @Comment("저자")
    @NotNull
    var author: String,

    @Column(name = "average_book_level", columnDefinition="Decimal(2,1) default '3.0'")
    @Comment(value = "사용자 난이도 평가 평균(default:3.0)")
    var averageBookLevel: Double,

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    var reviews: MutableList<ReviewEntity> = mutableListOf()




): BaseEntity()