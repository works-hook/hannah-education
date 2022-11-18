package com.hannah.education.lectureservice.teacher.dto.response

import com.hannah.education.lectureservice.domain.lectureTag.LectureTag

data class LectureTagResponse(
    val tagId: Long,
    val name: String,
    val color: String,
)

fun LectureTag.toResponse(): LectureTagResponse = LectureTagResponse(
    tagId = this.tag.id,
    name = this.tag.name,
    color = this.tag.color,
)