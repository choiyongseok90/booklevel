package com.example.booklevel.domain.principal.entity

import BaseEntity
import org.hibernate.annotations.Comment
import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
@Table(
    name = "member"
)
@org.hibernate.annotations.Table(appliesTo = "member", comment = "회원")
class MemberEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long = 0,

    @Column(nullable = false, name = "name", length = 50)
    @Comment("이름")
    @NotNull
    var name: String,

    @Column(nullable = false, name = "username")
    @Comment(value = "사용자Id")
    @NotNull
    var userName: String,

    @Column(nullable = false, name = "password")
    @Comment(value = "비밀번호")
    @NotNull
    var password: String,

    @OneToMany(mappedBy = "review", fetch = FetchType.LAZY)
    var reviews: MutableList<ReviewEntity> = mutableListOf()

    ): BaseEntity()