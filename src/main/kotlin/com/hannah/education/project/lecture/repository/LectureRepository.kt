package com.hannah.education.project.lecture.repository

import com.hannah.education.project.lecture.Lecture
import org.springframework.data.jpa.repository.JpaRepository

interface LectureRepository : JpaRepository<Lecture, Long>, LectureCustomRepository