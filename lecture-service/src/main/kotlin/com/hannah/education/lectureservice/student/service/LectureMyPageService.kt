package com.hannah.education.lectureservice.student.service

import com.hannah.education.lectureservice.domain.lecture.dto.LectureResponse
import com.hannah.education.lectureservice.domain.lecture.dto.toLectureResponse
import com.hannah.education.lectureservice.domain.lectureLike.repository.LectureLikeRepository
import com.hannah.education.lectureservice.domain.lectureNotice.repositoroy.LectureNoticeRepository
import com.hannah.education.lectureservice.domain.lectureTag.repository.LectureTagRepository
import com.hannah.education.lectureservice.domain.takingLecture.repository.TakingLectureRepository
import com.hannah.education.lectureservice.domain.user.repository.UserRepository
import com.hannah.education.lectureservice.student.dto.response.TagsByUserResponse
import com.hannah.education.lectureservice.teacher.dto.response.TakingLectureResponse
import com.hannah.education.lectureservice.teacher.dto.response.toResponse
import com.hannah.education.lectureservice.util.code.ErrorCode
import com.hannah.education.lectureservice.util.exception.BusinessException
import org.springframework.stereotype.Service

@Service
class LectureMyPageService(
    private val noticeRepository: LectureNoticeRepository,
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
        return takingLectureRepository.findTakingLectureTagsByUser(findUser)
    }

    fun findTakingLecture(userId: Long): List<TakingLectureResponse> {
        val findUser = userRepository.findUserById(userId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_MEMBER)
        return takingLectureRepository.findTakingLectureByUser(findUser)
            .map {
                val tags = lectureTagRepository.findTagByLecture(it.lecture)
                val notices = noticeRepository.findNoticeAll(it.lecture)
                it.toResponse(tags, notices)
            }.toList()
    }

}