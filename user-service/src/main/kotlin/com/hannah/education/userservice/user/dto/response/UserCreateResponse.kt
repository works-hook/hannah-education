package com.hannah.education.userservice.user.dto.response

import com.hannah.education.userservice.domain.user.User

data class UserCreateResponse(
    val id: Long?,
    val account: String,
    val name: String,
    val email: String,
    val phoneNumber: String,
)

fun User.toCreateResponseDto() : UserCreateResponse = UserCreateResponse(
    id = this.id,
    account = this.account,
    name = this.name,
    email = this.email,
    phoneNumber = this.phoneNumber
)