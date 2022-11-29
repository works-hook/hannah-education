package com.hannah.education.lectureservice.teacher.service

import com.hannah.education.lectureservice.domain.lecture.repository.LectureRepository
import com.hannah.education.lectureservice.domain.lectureNotice.repositoroy.LectureNoticeRepository
import com.hannah.education.lectureservice.teacher.dto.request.NoticeRequest
import com.hannah.education.lectureservice.teacher.dto.response.NoticeResponse
import com.hannah.education.lectureservice.teacher.dto.response.toResponse
import com.hannah.education.lectureservice.util.code.ErrorCode
import com.hannah.education.lectureservice.util.exception.BusinessException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LectureNoticeService(
    private val lectureRepository: LectureRepository,
    private val noticeRepository: LectureNoticeRepository,
) {

    fun findAllNotice(lectureId: Long): List<NoticeResponse> {
        val findLecture = lectureRepository.findLectureId(lectureId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_LECTURE)

        return noticeRepository.findNoticeAll(findLecture)
            .map { it.toResponse() }
            .toList()
    }

    @Transactional
    fun createNotice(lectureId: Long, request: NoticeRequest) {
        val findLecture = lectureRepository.findLectureId(lectureId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_LECTURE)
        val notice = request.toEntity(findLecture)
        noticeRepository.save(notice)
    }

    @Transactional
    fun modifyNotice(noticeId: Long, request: NoticeRequest) {
        val findNotice = noticeRepository.findNoticeById(noticeId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_NOTICE)
        findNotice.update(request)
    }

    @Transactional
    fun deleteNotice(noticeId: Long) {
        val findNotice = noticeRepository.findNoticeById(noticeId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_NOTICE)
        findNotice.delete()
    }

}