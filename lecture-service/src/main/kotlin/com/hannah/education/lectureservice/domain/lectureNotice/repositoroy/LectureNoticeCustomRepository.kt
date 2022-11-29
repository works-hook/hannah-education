package com.hannah.education.lectureservice.domain.lectureNotice.repositoroy

import com.hannah.education.lectureservice.domain.lecture.Lecture
import com.hannah.education.lectureservice.domain.lectureNotice.LectureNotice

interface LectureNoticeCustomRepository {

    fun findNoticeAll(lecture: Lecture): List<LectureNotice>

    fun findNoticeById(noticeId: Long): LectureNotice?

}
