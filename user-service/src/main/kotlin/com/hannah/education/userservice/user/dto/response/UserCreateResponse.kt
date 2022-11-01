package com.hannah.education.userservice.user.dto.response

data class UserCreateResponse(
    val id: String?,
    val account: String,
    val name: String,
    val email: String,
    val phoneNumber: String,
)