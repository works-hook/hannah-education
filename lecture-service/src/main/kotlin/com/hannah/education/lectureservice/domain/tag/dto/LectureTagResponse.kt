package com.hannah.education.lectureservice.domain.tag.dto

import com.hannah.education.lectureservice.domain.lectureTag.LectureTag
import com.hannah.education.lectureservice.domain.tag.Tag

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

fun Tag.toResponse(): LectureTagResponse = LectureTagResponse(
    tagId = this.id,
    name = this.name,
    color = this.color,
)