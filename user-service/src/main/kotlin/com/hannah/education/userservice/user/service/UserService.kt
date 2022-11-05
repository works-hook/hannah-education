package com.hannah.education.userservice.user.service

import com.hannah.education.userservice.user.dto.request.UserCreateRequest
import com.hannah.education.userservice.user.dto.request.UserLoginRequest
import com.hannah.education.userservice.user.dto.response.UserCreateResponse
import com.hannah.education.userservice.user.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.RuntimeException

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
) {

    @Transactional
    fun createUser(request: UserCreateRequest): UserCreateResponse {
        val userEntity = request.toEntity()
        userEntity.encodingPassword(passwordEncoder)
        return userRepository.save(userEntity).toCreateResponseDto()
    }

    fun findAll(): List<UserCreateResponse> {
        return userRepository.findAll().map { user -> user.toCreateResponseDto() }
    }

    fun loginUser(request: UserLoginRequest) {
        val user = (userRepository.findByAccount(request.account)
            ?: throw RuntimeException("존재하지 않은 회원입니다."))

    }
}