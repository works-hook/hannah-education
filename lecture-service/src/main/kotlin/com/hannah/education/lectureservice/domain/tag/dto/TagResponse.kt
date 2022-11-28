package com.hannah.education.lectureservice.domain.tag.dto

import com.hannah.education.lectureservice.domain.tag.Tag

data class TagResponse(
    val name: String,
    val imageUrl: String?,
)

fun Tag.toResponse(): TagResponse = TagResponse(
    name = this.name,
    imageUrl = this.imageUrl,
)
