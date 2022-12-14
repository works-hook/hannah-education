package com.hannah.education.classservice.domain.lectureClass

import com.hannah.education.classservice.domain.lecture.Lecture
import com.hannah.education.classservice.teacher.dto.request.ClassModifyRequest
import com.hannah.education.classservice.util.domain.BaseEntity
import com.hannah.education.classservice.util.domain.BooleanToYNConverter
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class LectureClass(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    val lecture: Lecture,

    var title: String,
    var content: String,
    var period: LocalDateTime,

    @Convert(converter = BooleanToYNConverter::class)
    var isAssignment: Boolean,

    var assignmentContent: String? = null,
): BaseEntity() {

    fun update(request: ClassModifyRequest) {
        this.title = request.title
        this.content = request.content
        this.period = request.period
        this.isAssignment = request.isAssignment
        this.assignmentContent = request.assignmentContent
    }

}