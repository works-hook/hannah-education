package com.hannah.education.userservice.student.dto.response

import com.hannah.education.userservice.domain.banner.Banner

data class BannerResponse(
    val title: String,
    val content: String,
    val backgroundColor: String,
    val imageUrl: String,
)

fun Banner.toResponse(): BannerResponse = BannerResponse(
    title = this.title,
    content = this.content,
    backgroundColor = this.backgroundColor,
    imageUrl = this.imageUrl
)
