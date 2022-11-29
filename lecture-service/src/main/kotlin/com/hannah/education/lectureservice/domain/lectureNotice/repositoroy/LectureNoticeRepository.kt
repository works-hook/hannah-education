package com.hannah.education.lectureservice.domain.lectureNotice.repositoroy

import com.hannah.education.lectureservice.domain.lectureNotice.LectureNotice
import org.springframework.data.jpa.repository.JpaRepository

interface LectureNoticeRepository: JpaRepository<LectureNotice, Long>, LectureNoticeCustomRepository