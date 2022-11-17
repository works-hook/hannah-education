package com.hannah.education.userservice.user.service

import com.hannah.education.userservice.user.dto.request.UserCreateRequest
import com.hannah.education.userservice.user.dto.request.UserDuplicateRequest
import com.hannah.education.userservice.user.dto.request.UserLoginRequest
import com.hannah.education.userservice.user.dto.request.UserUpdatePasswordRequest
import com.hannah.education.userservice.user.dto.response.*
import com.hannah.education.userservice.user.repository.UserRepository
import com.hannah.education.userservice.util.code.ErrorCode
import com.hannah.education.userservice.util.exception.BusinessException
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
    fun accountDuplicateCheck(request: UserDuplicateRequest) {
        userRepository.findByAccount(request.account)
            ?.let { throw BusinessException(ErrorCode.EXIST_ACCOUNT) }
    }

    @Transactional
    fun deleteUser(id: Long) {
        val findUser = userRepository.findUserById(id)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_MEMBER)
        findUser.delete()
    }

    fun loginUser(request: UserLoginRequest) {
        val user = userRepository.findByAccount(request.account)
            ?: throw BusinessException(ErrorCode.NOT_MATCH_MEMBER)
        checkPassword(request.password, user.password)
    }

    @Transactional
    fun updatePassword(id: Long, request: UserUpdatePasswordRequest) {
        val user = userRepository.findUserById(id)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_MEMBER)
        checkPassword(request.originPassword, user.password)
        user.updatePassword(passwordEncoder.encode(request.updatePassword))
    }

    private fun checkPassword(requestPassword: String, originPassword: String) {
        val checkPassword = passwordEncoder.matches(requestPassword, originPassword)
        if (!checkPassword) throw BusinessException(ErrorCode.NOT_MATCH_PASSWORD)
    }

}