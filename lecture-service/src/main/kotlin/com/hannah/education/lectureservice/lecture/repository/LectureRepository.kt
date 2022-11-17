package com.hannah.education.lectureservice.lecture.repository

import com.hannah.education.lectureservice.lecture.domain.Lecture
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LectureRepository : JpaRepository<Lecture, Long>, LectureCustomRepository
