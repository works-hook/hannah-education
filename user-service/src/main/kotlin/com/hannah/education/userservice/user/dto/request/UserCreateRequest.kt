package com.hannah.education.userservice.user.dto.request

import com.hannah.education.userservice.user.domain.User

data class UserCreateRequest(
    val account: String,
    val password: String,
    val name: String,
    val email: String,
    val phoneNumber: String,
) {
    fun toEntity(): User {
        return User(
            id = null,
            account = this.account,
            password = this.password,
            name = this.name,
            email = this.email,
            phoneNumber = this.phoneNumber,
        )
    }

}