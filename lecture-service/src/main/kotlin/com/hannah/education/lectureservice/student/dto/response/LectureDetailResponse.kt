package com.hannah.education.lectureservice.student.dto.response

import com.hannah.education.lectureservice.domain.lecture.Lecture
import com.hannah.education.lectureservice.domain.lectureTag.LectureTag
import com.hannah.education.lectureservice.domain.tag.dto.LectureTagResponse
import com.hannah.education.lectureservice.domain.tag.dto.toResponse
import java.time.LocalDate

data class LectureDetailResponse(
    val lectureId: Long? = null,
    val title: String,
    val content: String,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val thumbnailImgUrl: String,
    val tags: List<LectureTagResponse>,
    val likeCount: Long,
)

fun Lecture.toLectureDetailResponse(lectureTags: List<LectureTag>, likeCount: Long?) = LectureDetailResponse(
    lectureId = this.id,
    title = this.title,
    content = this.content,
    startDate = this.startDate,
    endDate = this.endDate,
    thumbnailImgUrl = this.thumbnailImgUrl,
    tags = lectureTags.map { it.toResponse() },
    likeCount = likeCount ?: 0
)
