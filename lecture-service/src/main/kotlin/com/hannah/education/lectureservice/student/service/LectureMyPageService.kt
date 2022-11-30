package com.hannah.education.lectureservice.student.service

import com.hannah.education.lectureservice.domain.lecture.dto.LectureResponse
import com.hannah.education.lectureservice.domain.lecture.dto.toLectureResponse
import com.hannah.education.lectureservice.domain.lecture.repository.LectureRepository
import com.hannah.education.lectureservice.domain.lectureLike.repository.LectureLikeRepository
import com.hannah.education.lectureservice.domain.lectureTag.repository.LectureTagRepository
import com.hannah.education.lectureservice.domain.takingLecture.repository.TakingLectureRepository
import com.hannah.education.lectureservice.domain.user.repository.UserRepository
import com.hannah.education.lectureservice.student.dto.response.TagsByUserResponse
import com.hannah.education.lectureservice.util.code.ErrorCode
import com.hannah.education.lectureservice.util.exception.BusinessException
import org.springframework.stereotype.Service

@Service
class LectureMyPageService(
    private val lectureRepository: LectureRepository,
    private val takingLectureRepository: TakingLectureRepository,
    private val lectureTagRepository: LectureTagRepository,
    private val lectureLikeRepository: LectureLikeRepository,
    private val userRepository: UserRepository,
) {

    fun findLectureByLiked(userId: Long): List<LectureResponse> {
        val findUser = userRepository.findUserById(userId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_MEMBER)
        return lectureLikeRepository.findLectureByUser(findUser)
            .map {
                val lectureTags = lectureTagRepository.findTagByLecture(it.lecture)
                it.toLectureResponse(lectureTags)
            }.toList()
    }

    fun findTagsByUser(userId: Long): List<TagsByUserResponse> {
        val findUser = userRepository.findUserById(userId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_MEMBER)
        return takingLectureRepository.findTakingLectureByUser(findUser)
    }

}