package com.hannah.education.userservice.user.service

import com.hannah.education.userservice.user.domain.User
import com.hannah.education.userservice.user.dto.request.UserCreateRequest
import com.hannah.education.userservice.user.dto.request.UserDuplicateRequest
import com.hannah.education.userservice.user.dto.request.UserLoginRequest
import com.hannah.education.userservice.user.dto.request.UserModifyRequest
import com.hannah.education.userservice.user.dto.response.UserCreateResponse
import com.hannah.education.userservice.user.dto.response.UserModifyResponse
import com.hannah.education.userservice.user.dto.response.toCreateResponseDto
import com.hannah.education.userservice.user.dto.response.toUserModifyResponse
import com.hannah.education.userservice.user.repository.UserRepository
import com.hannah.education.userservice.util.error.BusinessException
import com.hannah.education.userservice.util.error.ErrorCode
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

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

    @Transactional
    fun accountDuplicateCheck(request: UserDuplicateRequest): User {
        return userRepository.findByAccount(request.account)
            ?: "Ok"
            .let { throw BusinessException(ErrorCode.EXIST_ACCOUNT) }
    }

    @Transactional
    fun modifyUser(id: Long, request: UserModifyRequest): UserModifyResponse {
        val findUser = userRepository.findUserById(id)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_MEMBER)
        findUser.update(request)
        return findUser.toUserModifyResponse()
    }

    fun findAll(): List<UserCreateResponse> {
        return userRepository.findAll().map { user -> user.toCreateResponseDto() }
    }

    fun loginUser(request: UserLoginRequest) {
        val user = (userRepository.findByAccount(request.account)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_MEMBER))
        val checkPassword = user.checkPassword(passwordEncoder.encode(request.password))
        if (!checkPassword) throw BusinessException(ErrorCode.INVALID_TOKEN_ERROR)
    }
}