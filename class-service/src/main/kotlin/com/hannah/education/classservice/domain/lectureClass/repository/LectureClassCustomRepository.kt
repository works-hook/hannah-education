package com.hannah.education.classservice.domain.lectureClass.repository

import com.hannah.education.classservice.domain.lecture.Lecture
import com.hannah.education.classservice.domain.lectureClass.LectureClass

interface LectureClassCustomRepository {

    fun findClassById(classId: Long): LectureClass?

    fun findClassAllByLecture(lecture: Lecture): List<LectureClass>

}
