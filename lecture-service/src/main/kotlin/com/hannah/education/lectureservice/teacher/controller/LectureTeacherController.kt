package com.hannah.education.lectureservice.teacher.controller

import com.hannah.education.lectureservice.teacher.dto.request.LectureCreateRequest
import com.hannah.education.lectureservice.teacher.dto.request.LectureModifyRequest
import com.hannah.education.lectureservice.teacher.dto.response.LectureListResponse
import com.hannah.education.lectureservice.teacher.dto.response.LectureOneResponse
import com.hannah.education.lectureservice.teacher.service.LectureTeacherService
import com.hannah.education.lectureservice.util.ApiResponse.Success
import com.hannah.education.lectureservice.util.code.SuccessCode
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/lecture-teacher")
class LectureTeacherController(
    private val teacherService: LectureTeacherService,
) {

    @PostMapping("")
    fun createLecture(@RequestBody request: LectureCreateRequest): Success<String> {
        teacherService.createLecture(request)
        return Success(SuccessCode.LECTURE_CREATE)
    }

    @PatchMapping("/{lectureId}")
    fun modifyLecture(
        @PathVariable lectureId: Long,
        @RequestBody request: LectureModifyRequest,
    ): Success<LectureOneResponse> {
        val result = teacherService.modifyLecture(lectureId, request)
        return Success(result, SuccessCode.LECTURE_MODIFY)
    }

    @DeleteMapping("/{lectureId}")
    fun deleteLecture(@PathVariable lectureId: Long): Success<String> {
        teacherService.deleteLecture(lectureId)
        return Success(SuccessCode.LECTURE_DELETE)
    }

    @GetMapping("/lecture/{userId}")
    fun findAllLecture(@PathVariable userId: Long): Success<List<LectureListResponse>> {
        val result = teacherService.findAllLecture(userId)
        return Success(result, SuccessCode.ALL_LECTURE)
    }

    @GetMapping("/student/{lectureId}")
    fun findOneLecture(@PathVariable lectureId: Long): Success<LectureOneResponse> {
        val result = teacherService.findOneLecture(lectureId)
        return Success(result, SuccessCode.ONE_LECTURE)
    }

}