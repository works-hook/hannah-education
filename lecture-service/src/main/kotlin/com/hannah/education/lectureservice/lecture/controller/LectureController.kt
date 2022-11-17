package com.hannah.education.lectureservice.lecture.controller

import com.hannah.education.lectureservice.lecture.service.LectureService
import com.hannah.education.lectureservice.util.ApiResponse.Success
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LectureController(
    private val lectureService: LectureService,
) {

    @PostMapping("/lectures")
    fun createLecture(): Success<String> {
        TODO()
    }

    @PatchMapping("/lectures/{id}")
    fun modifyLecture(@PathVariable id: Long): Success<String> {
        TODO()
    }

    @DeleteMapping("/lectures/{id}")
    fun deleteLecture(@PathVariable id: Long): Success<String> {
        TODO()
    }

    @GetMapping("/lectures/{id}")
    fun findOneLecture(@PathVariable id: Long): Success<String> {
        TODO()
    }

    @GetMapping("/lectures")
    fun findAllLecture(): Success<String> {
        TODO()
    }

}