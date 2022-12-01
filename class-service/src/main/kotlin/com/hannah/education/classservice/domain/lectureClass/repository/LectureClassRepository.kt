package com.hannah.education.classservice.domain.lectureClass.repository

import com.hannah.education.classservice.domain.lectureClass.LectureClass
import org.springframework.data.jpa.repository.JpaRepository

interface LectureClassRepository: JpaRepository<LectureClass, Long>, LectureClassCustomRepository