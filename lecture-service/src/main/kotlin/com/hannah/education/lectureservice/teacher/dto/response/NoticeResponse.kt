package com.hannah.education.lectureservice.teacher.dto.response

import com.hannah.education.lectureservice.domain.lectureNotice.LectureNotice
import java.time.LocalDateTime

data class NoticeResponse(
    val noticeId: Long?,
    val title: String,
    val content: String,
    val createdDate: LocalDateTime,
    val modifiedDate: LocalDateTime,
)

fun LectureNotice.toResponse(): NoticeResponse = NoticeResponse(
    noticeId = this.id,
    title = this.title,
    content = this.content,
    createdDate = this.createdDate,
    modifiedDate = this.modifiedDate
)
