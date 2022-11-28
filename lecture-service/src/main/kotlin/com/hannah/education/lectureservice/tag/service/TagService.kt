package com.hannah.education.lectureservice.tag.service

import com.hannah.education.lectureservice.domain.tag.dto.LectureTagResponse
import com.hannah.education.lectureservice.domain.tag.dto.toResponse
import com.hannah.education.lectureservice.domain.tag.repository.TagRepository
import org.springframework.stereotype.Service

@Service
class TagService(
    private val tagRepository: TagRepository
) {

    fun findAllTags(): List<LectureTagResponse> {
        return tagRepository.findAll()
            .map { it.toResponse() }
    }

    fun findRandomTags(): List<LectureTagResponse> {
        return tagRepository.findAll()
            .shuffled()
            .subList(0, 7)
            .map { it.toResponse() }
    }

}
