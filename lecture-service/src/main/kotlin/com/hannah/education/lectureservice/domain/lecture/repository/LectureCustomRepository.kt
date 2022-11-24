package com.hannah.education.lectureservice.domain.lecture.repository

import com.hannah.education.lectureservice.domain.lecture.Lecture

interface LectureCustomRepository {

    fun findAllByTeacher(teacherId: Long): List<Lecture>

    fun findLectureId(lectureId: Long): Lecture?

    fun findMostTakenLectures(): List<Lecture>

    fun findMostLikeLectures(): List<Lecture>

    fun findAllByStudent(): List<Lecture>

}
