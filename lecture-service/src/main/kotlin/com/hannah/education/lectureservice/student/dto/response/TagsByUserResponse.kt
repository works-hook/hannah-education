package com.hannah.education.lectureservice.student.dto.response

data class TagsByUserResponse(
    val tagId: Long?,
    val name: String,
    val color: String,
    val count: Long,
)