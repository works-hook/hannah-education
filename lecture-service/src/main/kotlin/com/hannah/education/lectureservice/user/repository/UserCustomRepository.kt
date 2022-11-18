package com.hannah.education.lectureservice.user.repository

import com.hannah.education.lectureservice.user.domain.User

interface UserCustomRepository {
    fun findUserById(userId: Long): User?
}
