package com.hannah.education.lectureservice.domain.lecture.repository

import com.hannah.education.lectureservice.domain.lecture.Lecture
import org.springframework.data.jpa.repository.JpaRepository

interface LectureRepository : JpaRepository<Lecture, Long>, LectureCustomRepository
