package com.hannah.education.userservice.user.repository

import com.hannah.education.userservice.user.domain.User

interface UserCustomRepository {

    fun findUserAll(): List<User>

    fun findUserById(id: Long): User?

    fun findByAccount(account: String): User?

}
