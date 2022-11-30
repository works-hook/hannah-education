package com.hannah.education.lectureservice.domain.takingLecture.repository

import com.hannah.education.lectureservice.domain.user.User
import com.hannah.education.lectureservice.student.dto.response.TagsByUserResponse

interface TakingLectureCustomRepository {

    fun findTakingLectureByUser(user: User): List<TagsByUserResponse>

}
