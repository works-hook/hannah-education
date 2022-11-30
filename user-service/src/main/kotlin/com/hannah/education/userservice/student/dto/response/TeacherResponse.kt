package com.hannah.education.userservice.student.dto.response

import com.hannah.education.userservice.domain.user.User

data class TeacherResponse(
    val name: String,
    val oneLineIntroduction: String?,
    val imageUrl: String?,
)

fun User.toTeacherResponse(): TeacherResponse = TeacherResponse(
    name = this.name,
    oneLineIntroduction = this.oneLineIntroduction,
    imageUrl = this.imageUrl
)
