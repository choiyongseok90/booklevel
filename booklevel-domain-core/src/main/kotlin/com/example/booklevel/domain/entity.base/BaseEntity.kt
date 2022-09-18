import org.hibernate.annotations.Comment
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
class BaseEntity (
    @CreatedDate @Column(name = "created_dt",
        nullable = false,
        updatable = false,
        columnDefinition = "DATE")
    @Comment(value = "생성일")
    val createdDt: LocalDateTime = LocalDateTime.now(),

    @LastModifiedDate @Column(name = "updated_dt",
        columnDefinition = "DATE")
    @Comment(value = "수정일")
    val updatedDt: LocalDateTime = LocalDateTime.now(),

    @CreatedBy @Column(name = "created_by",
        updatable = false,
        length = 120)
    @Comment(value = "생성자")
    val createBy: String? = null,

    @LastModifiedBy @Column(name = "updated_by",
        length = 120)
    @Comment(value = "수정자")
    val updatedBy: String? = null,

    @Column(name = "deleted")
    @Comment(value = "삭제여부")
    var deleted: Boolean = false
        )