package com.hannah.education.classservice.domain.lecture.repository

import com.hannah.education.classservice.domain.lecture.Lecture
import org.springframework.data.jpa.repository.JpaRepository

interface LectureRepository: JpaRepository<Lecture, Long> {

    fun findByIdAndDeletedDateIsNull(id: Long): Lecture?

}
