package com.hannah.education.userservice.student.service

import com.hannah.education.userservice.student.dto.request.StudentModifyRequest
import com.hannah.education.userservice.student.dto.response.StudentModifyResponse
import com.hannah.education.userservice.student.dto.response.StudentOneResponse
import com.hannah.education.userservice.student.dto.response.toStudentModifyResponse
import com.hannah.education.userservice.student.dto.response.toStudentOneResponse
import com.hannah.education.userservice.domain.user.repository.UserRepository
import com.hannah.education.userservice.util.code.ErrorCode
import com.hannah.education.userservice.util.exception.BusinessException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserStudentService(
    private val userRepository: UserRepository,
) {

    @Transactional
    fun modifyStudent(id: Long, request: StudentModifyRequest): StudentModifyResponse {
        val findUser = userRepository.findUserById(id)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_MEMBER)
        findUser.studentUpdate(request)
        return findUser.toStudentModifyResponse()
    }

    fun findOneStudent(id: Long): StudentOneResponse {
        val user = userRepository.findUserById(id)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_MEMBER)
        return user.toStudentOneResponse()
    }

}