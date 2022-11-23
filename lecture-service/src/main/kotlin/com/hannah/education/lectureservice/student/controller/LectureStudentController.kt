package com.hannah.education.lectureservice.student.controller

import com.hannah.education.lectureservice.domain.lecture.Lecture
import com.hannah.education.lectureservice.student.dto.response.MostLectureResponse
import com.hannah.education.lectureservice.student.service.LectureStudentService
import com.hannah.education.lectureservice.util.ApiResponse.Success
import com.hannah.education.lectureservice.util.code.SuccessCode
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("lecture-student")
class LectureStudentController(
    private val studentService: LectureStudentService
) {

    @GetMapping("/most-taken")
    fun mostTakenLectures(): List<Lecture> {
        return studentService.mostTakenLectures()
    }

    @GetMapping("/most-like")
    fun mostLikeLectures(): Success<List<MostLectureResponse>> {
        val result = studentService.mostLikeLectures()
        return Success(result, SuccessCode.ALL_LECTURE)
    }

}