package com.hannah.education.lectureservice.student.service

import com.hannah.education.lectureservice.domain.lecture.Lecture
import com.hannah.education.lectureservice.domain.lecture.dto.LectureResponse
import com.hannah.education.lectureservice.domain.lecture.dto.toLectureResponse
import com.hannah.education.lectureservice.domain.lecture.repository.LectureRepository
import com.hannah.education.lectureservice.domain.lectureLike.repository.LectureLikeRepository
import com.hannah.education.lectureservice.domain.lectureTag.repository.LectureTagRepository
import com.hannah.education.lectureservice.student.dto.response.LectureDetailResponse
import com.hannah.education.lectureservice.student.dto.response.toLectureDetailResponse
import com.hannah.education.lectureservice.util.code.ErrorCode
import com.hannah.education.lectureservice.util.exception.BusinessException
import org.springframework.stereotype.Service

@Service
class LectureStudentService(
    private val lectureRepository: LectureRepository,
    private val lectureTagRepository: LectureTagRepository,
    private val lectureLikeRepository: LectureLikeRepository,
) {

    fun mostTakenLectures(): List<Lecture> {
        return lectureRepository.findMostTakenLectures()
    }

    fun mostLikeLectures(): List<LectureResponse> {
        return lectureRepository.findMostLikeLectures()
            .map {
                val lectureTags = lectureTagRepository.findTagByLecture(it)
                it.toLectureResponse(lectureTags)
            }.toList()
    }

    fun findAllLectures(): List<LectureResponse> {
        return lectureRepository.findAllByStudent()
            .map {
                val lectureTags = lectureTagRepository.findTagByLecture(it)
                it.toLectureResponse(lectureTags)
            }.toList()
    }

    fun findOneLecture(lectureId: Long): LectureDetailResponse {
        val findLecture = (lectureRepository.findLectureId(lectureId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_LECTURE))
        val findLectureTags = lectureTagRepository.findTagByLecture(findLecture)
        val findLikeCount = lectureLikeRepository.findCountByLecture(findLecture)
        return findLecture.toLectureDetailResponse(findLectureTags, findLikeCount)
    }
}