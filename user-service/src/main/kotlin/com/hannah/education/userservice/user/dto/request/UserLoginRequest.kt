package com.hannah.education.userservice.user.dto.request

data class UserLoginRequest(
    val account: String,
    val password: String,
)
