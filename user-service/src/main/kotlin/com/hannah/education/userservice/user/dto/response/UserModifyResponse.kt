package com.hannah.education.userservice.user.dto.response

import com.hannah.education.userservice.user.domain.User

data class UserModifyResponse(
    val account: String,
    val name: String,
    val brith: String,
    val email: String,
    val phoneNumber: String,
    val imageUrl: String,
)

fun User.toUserModifyResponse() : UserModifyResponse = UserModifyResponse(
    account = this.account,
    name = this.name,
    brith = this.brith,
    email = this.email,
    phoneNumber = this.phoneNumber,
    imageUrl = this.imageUrl
)