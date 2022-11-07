package com.hannah.education.userservice.user.domain

import com.hannah.education.userservice.user.dto.request.UserModifyRequest
import com.querydsl.core.annotations.QueryEntity
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.security.crypto.password.PasswordEncoder
import javax.persistence.Entity

@Entity
@QueryEntity
@Document
class User(
    @Id
    var id: String? = null,
    val account: String,
    var password: String,
    var name: String,
    var brith: String = "",
    var email: String,
    var phoneNumber: String,
    var imageUrl: String = "",
    val type: Type,
) {

    fun encodingPassword(passwordEncoder: PasswordEncoder) {
        this.password = passwordEncoder.encode(this.password)
    }

    fun checkPassword(password: String): Boolean {
        return this.password == password
    }

    fun update(request: UserModifyRequest) {
        request.name?.let { this.name = it }
        request.brith?.let { this.brith = it}
        request.email?.let { this.email = it }
        request.phoneNumber?.let { this.phoneNumber = it }
        request.imageUrl?.let { this.imageUrl = it }
    }

}