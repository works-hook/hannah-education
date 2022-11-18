package com.hannah.education.userservice.student.controller

import com.hannah.education.userservice.student.dto.request.StudentModifyRequest
import com.hannah.education.userservice.student.dto.response.StudentModifyResponse
import com.hannah.education.userservice.student.dto.response.StudentOneResponse
import com.hannah.education.userservice.student.service.UserStudentService
import com.hannah.education.userservice.util.ApiResponse.Success
import com.hannah.education.userservice.util.code.SuccessCode
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users-student")
class UserStudentController(
    private val userStudentService: UserStudentService,
) {

    @PatchMapping("/{id}")
    fun modifyStudent(
        @PathVariable id: Long,
        @RequestBody request: StudentModifyRequest,
    ): Success<StudentModifyResponse> {
        val result = userStudentService.modifyStudent(id, request)
        return Success(result, SuccessCode.USER_MODIFY)
    }

    @GetMapping("/{id}")
    fun findOneStudent(@PathVariable id: Long): Success<StudentOneResponse> {
        val result = userStudentService.findOneStudent(id)
        return Success(result, SuccessCode.USER_ONE)
    }

}