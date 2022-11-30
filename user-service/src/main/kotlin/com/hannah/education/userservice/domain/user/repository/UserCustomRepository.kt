package com.hannah.education.userservice.domain.user.repository

import com.hannah.education.userservice.domain.user.User

interface UserCustomRepository {

    fun findUserAll(): List<User>

    fun findUserById(id: Long): User?

    fun findByAccount(account: String): User?

    fun findTeachers(): List<User>

}
