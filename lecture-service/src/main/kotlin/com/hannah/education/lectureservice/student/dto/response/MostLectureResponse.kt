package com.hannah.education.lectureservice.student.dto.response

import com.hannah.education.lectureservice.domain.lecture.Lecture
import com.hannah.education.lectureservice.domain.lectureTag.LectureTag
import com.hannah.education.lectureservice.domain.tag.dto.LectureTagResponse
import com.hannah.education.lectureservice.domain.tag.dto.toResponse

data class MostLectureResponse(
    val lectureId: Long? = null,
    val title: String,
    val thumbnailImgUrl: String,
    val tags: List<LectureTagResponse>,
)

fun Lecture.toMostLectureResponse(lectureTags: List<LectureTag>): MostLectureResponse = MostLectureResponse(
    lectureId = this.id,
    title = this.title,
    thumbnailImgUrl = this.thumbnailImgUrl,
    tags = lectureTags.map { it.toResponse() }
)
