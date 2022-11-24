package com.hannah.education.lectureservice.domain.lectureLike.repository

import com.hannah.education.lectureservice.domain.lectureLike.LectureLike
import org.springframework.data.jpa.repository.JpaRepository

interface LectureLikeRepository: JpaRepository<LectureLike, Long>, LectureLikeCustomRepository
