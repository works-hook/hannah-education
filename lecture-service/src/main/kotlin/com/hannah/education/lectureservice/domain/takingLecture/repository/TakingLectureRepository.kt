package com.hannah.education.lectureservice.domain.takingLecture.repository

import com.hannah.education.lectureservice.domain.takingLecture.TakingLecture
import org.springframework.data.jpa.repository.JpaRepository

interface TakingLectureRepository: JpaRepository<TakingLecture, Long>, TakingLectureCustomRepository