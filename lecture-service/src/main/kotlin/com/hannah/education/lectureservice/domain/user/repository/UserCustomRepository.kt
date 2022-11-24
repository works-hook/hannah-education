package com.hannah.education.lectureservice.domain.user.repository

import com.hannah.education.lectureservice.domain.user.User

interface UserCustomRepository {
    fun findUserById(userId: Long): User?
}
