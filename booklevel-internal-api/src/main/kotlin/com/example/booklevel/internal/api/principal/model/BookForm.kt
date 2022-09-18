import com.example.booklevel.domain.principal.entity.BookEntity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel("도서 등록")
data class BookForm(

    @ApiModelProperty("책제목")
    val title: String,
    @ApiModelProperty("저자")
    val author: String
) {
    fun toEntity() : BookEntity{
        return BookEntity(title = title, author = author, averageBookLevel = 3.0)
    }
}