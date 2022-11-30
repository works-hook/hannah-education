package com.hannah.education.lectureservice.domain.lectureNotice

import com.hannah.education.lectureservice.domain.lecture.Lecture
import com.hannah.education.lectureservice.teacher.dto.request.NoticeRequest
import com.hannah.education.lectureservice.util.domain.BaseEntity
import javax.persistence.*

@Entity
class LectureNotice(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    val lecture: Lecture,

    var title: String,
    var content: String,
): BaseEntity() {

    fun update(request: NoticeRequest) {
        request.title.let { this.title = it }
        request.content.let { this.content = it }
    }

}