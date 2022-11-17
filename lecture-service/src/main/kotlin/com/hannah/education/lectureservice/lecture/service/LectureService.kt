package com.hannah.education.lectureservice.lecture.service

import com.hannah.education.lectureservice.lecture.repository.LectureRepository
import org.springframework.stereotype.Service

@Service
class LectureService(
    private val lectureRepository: LectureRepository,
) {

}
