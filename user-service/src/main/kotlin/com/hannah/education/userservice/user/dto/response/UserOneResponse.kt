package com.hannah.education.userservice.user.dto.response

import com.hannah.education.userservice.user.domain.User
import java.time.LocalDate

data class UserOneResponse(
    val id: Long?,
    val account: String,
    val name: String,
    val brith: LocalDate?,
    val email: String,
    val phoneNumber: String,
    val imageUrl: String?,
)

fun User.toUserOneResponse() : UserOneResponse = UserOneResponse(
    id = this.id,
    account = this.account,
    name = this.name,
    brith = this.brith,
    email = this.email,
    phoneNumber = this.phoneNumber,
    imageUrl = this.imageUrl
)
