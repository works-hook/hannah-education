package com.hannah.education.lectureservice.student.service

import com.hannah.education.lectureservice.domain.lecture.Lecture
import com.hannah.education.lectureservice.domain.lecture.repository.LectureRepository
import com.hannah.education.lectureservice.domain.lectureTag.repository.LectureTagRepository
import com.hannah.education.lectureservice.student.dto.response.MostLectureResponse
import com.hannah.education.lectureservice.student.dto.response.toMostLectureResponse
import org.springframework.stereotype.Service

@Service
class LectureStudentService(
    private val lectureRepository: LectureRepository,
    private val lectureTagRepository: LectureTagRepository,
) {

    fun mostTakenLectures(): List<Lecture> {
        return lectureRepository.findMostTakenLectures()
    }

    fun mostLikeLectures(): List<MostLectureResponse> {
        return lectureRepository.findMostLikeLectures()
            .map {
                val lectureTags = lectureTagRepository.findTagByLecture(it)
                it.toMostLectureResponse(lectureTags)
            }.toList()
    }
}