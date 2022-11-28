package com.hannah.education.lectureservice.tag.controller

import com.hannah.education.lectureservice.domain.tag.dto.LectureTagResponse
import com.hannah.education.lectureservice.tag.service.TagService
import com.hannah.education.lectureservice.util.ApiResponse.Success
import com.hannah.education.lectureservice.util.code.SuccessCode
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/lecture")
class TagController(
    private val tagService: TagService,
) {

    @GetMapping("/tags")
    fun findAllTags(): Success<List<LectureTagResponse>> {
        val result = tagService.findAllTags()
        return Success(result, SuccessCode.ALL_TAGS)
    }

    @GetMapping("/tags/random")
    fun findRandomTags(): Success<List<LectureTagResponse>> {
        val result = tagService.findRandomTags()
        return Success(result, SuccessCode.RANDOM_TAGS)
    }

}