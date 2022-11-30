package com.hannah.education.userservice.student.controller

import com.hannah.education.userservice.student.dto.response.BannerResponse
import com.hannah.education.userservice.student.dto.response.TeacherResponse
import com.hannah.education.userservice.student.service.MainService
import com.hannah.education.userservice.util.ApiResponse.Success
import com.hannah.education.userservice.util.code.SuccessCode
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user-student")
class MainController(
    private val mainService: MainService,
) {

    @GetMapping("/banner")
    fun findMainBanner(): Success<List<BannerResponse>> {
        val result = mainService.findAllBanner()
        return Success(result, SuccessCode.BANNER_LIST)
    }

    @GetMapping("/teacher")
    fun findMainTeacher(): Success<List<TeacherResponse>> {
        val result = mainService.findAllTeacher()
        return Success(result, SuccessCode.TEACHER_LIST)
    }

}