package com.hannah.education.userservice.user.dto.request

data class UserUpdatePasswordRequest(
    val originPassword: String,
    val updatePassword: String,
)
