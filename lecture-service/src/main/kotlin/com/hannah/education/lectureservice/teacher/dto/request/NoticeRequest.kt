package com.hannah.education.lectureservice.teacher.dto.request

import com.hannah.education.lectureservice.domain.lecture.Lecture
import com.hannah.education.lectureservice.domain.lectureNotice.LectureNotice

data class NoticeRequest(
    val title: String,
    val content: String,
) {
    fun toEntity(lecture: Lecture): LectureNotice {
        return LectureNotice(
            lecture = lecture,
            title = this.title,
            content = this.content
        )
    }
}