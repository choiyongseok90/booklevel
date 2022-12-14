package com.example.booklevel.domain.principal.entity

import com.example.booklevel.domain.principal.entity.ReviewEntity
import com.example.booklevel.domain.entity.base.BaseEntity
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

    @Column(nullable = false, name = "email")
    @Comment(value = "이메일")
    @NotNull
    var email: String,

    @Column(nullable = false, name = "password")
    @Comment(value = "비밀번호")
    @NotNull
    var password: String,

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    var reviews: MutableList<ReviewEntity> = mutableListOf()

    ): BaseEntity()