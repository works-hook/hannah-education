package com.hannah.education.userservice.user.repository

import com.hannah.education.userservice.user.domain.User

interface UserCustomRepository {

    fun findByAccount(account: String): User?

}