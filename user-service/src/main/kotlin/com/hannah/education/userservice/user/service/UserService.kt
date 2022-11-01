package com.hannah.education.userservice.user.service

import com.hannah.education.userservice.user.domain.User
import com.hannah.education.userservice.user.dto.request.UserCreateRequest
import com.hannah.education.userservice.user.dto.response.UserCreateResponse
import com.hannah.education.userservice.user.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository
) {

    @Transactional
    fun createUser(request: UserCreateRequest): UserCreateResponse {
        val saveUser = userRepository.save(request.toEntity())
        return saveUser.toDto()
    }

    fun findAll(): List<UserCreateResponse> {
        return userRepository.findAll().map { user -> user.toDto() }
    }
}