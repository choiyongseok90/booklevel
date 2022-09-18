package com.example.booklevel.domain.principal.entity

import BaseEntity
import org.hibernate.annotations.Comment
import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
@Table(
    name = "review",
    indexes = [
    ]
)
@org.hibernate.annotations.Table(appliesTo = "review", comment = "책평가")
class ReviewEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long = 0,

    @Column(nullable = false, name = "title")
    @Comment(value = "사용자 평가-제목")
    @NotNull
    var title: String,

    @Column(nullable = false, name = "content")
    @Comment(value = "사용자 평가-본문")
    @NotNull
    var content: String,

    @Column(nullable = false, name = "score")
    @Comment(value = "사용자 평가-난이도 점수")
    @NotNull
    var score: Int,

    @ManyToOne
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    val book: BookEntity,

    @ManyToOne
    @JoinColumn(name = "member_id", insertable = false, updatable = false)
    val member: MemberEntity



    ): BaseEntity()