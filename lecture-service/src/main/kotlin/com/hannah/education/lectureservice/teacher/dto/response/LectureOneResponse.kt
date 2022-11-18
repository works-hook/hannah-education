package com.hannah.education.lectureservice.teacher.dto.response

import com.hannah.education.lectureservice.domain.lecture.Lecture
import com.hannah.education.lectureservice.domain.lectureTag.LectureTag

data class LectureOneResponse(
    val lectureId: Long?,
    val title: String,
    val content: String,
    val startDate: String,
    val endDate: String,
    val thumbnailImgUrl: String,
    val tags: List<LectureTagResponse>,
)

fun Lecture.toOneResponse(lectureTags: List<LectureTag>): LectureOneResponse = LectureOneResponse(
    lectureId = this.id,
    title = this.title,
    content = this.content,
    startDate = this.startDate.toString(),
    endDate = this.endDate.toString(),
    thumbnailImgUrl = this.thumbnailImgUrl,
    tags = lectureTags.map { it.toResponse() }.toList()
)