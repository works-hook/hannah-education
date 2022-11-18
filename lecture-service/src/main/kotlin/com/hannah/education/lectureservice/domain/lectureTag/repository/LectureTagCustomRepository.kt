package com.hannah.education.lectureservice.domain.lectureTag.repository

import com.hannah.education.lectureservice.domain.lecture.Lecture
import com.hannah.education.lectureservice.domain.lectureTag.LectureTag

interface LectureTagCustomRepository {

    fun findTagByLecture(lecture: Lecture): List<LectureTag>

}
