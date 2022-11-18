package com.hannah.education.lectureservice.domain.lecture.repository

import com.hannah.education.lectureservice.domain.lecture.Lecture

interface LectureCustomRepository {

    fun findLectureAll(id: Long): List<Lecture>

    fun findLectureId(lectureId: Long): Lecture?

}
