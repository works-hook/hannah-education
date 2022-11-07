package com.hannah.education.userservice.user.dto.request

data class UserModifyRequest(
    val name: String?,
    val brith: String?,
    val email: String?,
    val phoneNumber: String?,
    val imageUrl: String?
)