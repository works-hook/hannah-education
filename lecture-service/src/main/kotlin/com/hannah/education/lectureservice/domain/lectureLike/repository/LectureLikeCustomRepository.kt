package com.hannah.education.lectureservice.domain.lectureLike.repository

import com.hannah.education.lectureservice.domain.lecture.Lecture

interface LectureLikeCustomRepository {

    fun findCountByLecture(findLecture: Lecture): Long?

}
