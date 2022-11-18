package com.hannah.education.lectureservice.domain.lectureTag.repository

import com.hannah.education.lectureservice.domain.lectureTag.LectureTag
import org.springframework.data.jpa.repository.JpaRepository

interface LectureTagRepository : JpaRepository<LectureTag, Long>, LectureTagCustomRepository