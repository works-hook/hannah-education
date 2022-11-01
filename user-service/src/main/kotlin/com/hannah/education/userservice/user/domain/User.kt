package com.hannah.education.userservice.user.domain

import com.hannah.education.userservice.user.dto.response.UserCreateResponse
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class User(
    @Id
    private var id: String?,
    private val account: String,
    private val password: String,
    private val name: String,
    private val brith: String = "",
    private val email: String,
    private val phoneNumber: String,
    private val imageUrl: String = "",
) {

    fun toCreateResponseDto(): UserCreateResponse {
        return UserCreateResponse(
            id = this.id,
            account = this.account,
            name = this.name,
            email = this.email,
            phoneNumber = this.phoneNumber
        )
    }
}