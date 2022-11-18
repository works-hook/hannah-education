package com.hannah.education.lectureservice.domain.lecture

import com.hannah.education.lectureservice.teacher.dto.request.LectureModifyRequest
import com.hannah.education.lectureservice.user.domain.User
import com.hannah.education.lectureservice.util.domain.BaseEntity
import java.time.LocalDate
import javax.persistence.*

@Entity
class Lecture(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var title: String,
    var content: String,
    var startDate: LocalDate,
    var endDate: LocalDate,
    var thumbnailImgUrl: String,
    @ManyToOne
    val user: User,
): BaseEntity() {

    fun update(request: LectureModifyRequest) {
        this.title = request.title
        this.content = request.content
        this.startDate = LocalDate.parse(request.startDate)
        this.endDate = LocalDate.parse(request.endDate)
        this.thumbnailImgUrl = request.thumbnailImgUrl
    }
}