package com.hannah.education.userservice.user.dto.request

import com.hannah.education.userservice.user.domain.Type
import com.hannah.education.userservice.user.domain.User

data class UserCreateRequest(
    val account: String,
    val password: String,
    val name: String,
    val email: String,
    val phoneNumber: String,
    val type: Type,
) {
    fun toEntity(): User {
        return User(
            account = this.account,
            password = this.password,
            name = this.name,
            email = this.email,
            phoneNumber = this.phoneNumber,
            type = this.type,
        )
    }

}