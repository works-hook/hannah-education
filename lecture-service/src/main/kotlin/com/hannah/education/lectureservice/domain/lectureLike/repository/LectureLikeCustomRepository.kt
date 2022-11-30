package com.hannah.education.lectureservice.domain.lectureLike.repository

import com.hannah.education.lectureservice.domain.lecture.Lecture
import com.hannah.education.lectureservice.domain.lectureLike.LectureLike
import com.hannah.education.lectureservice.domain.user.User

interface LectureLikeCustomRepository {

    fun findCountByLecture(findLecture: Lecture): Long?

    fun findLectureByUser(findUser: User): List<LectureLike>

}
