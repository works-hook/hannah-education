package com.hannah.education.userservice.user.repository

import com.hannah.education.userservice.user.domain.QUser
import com.hannah.education.userservice.user.domain.User
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class UserCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory
): UserCustomRepository {

    override fun findUserById(id: Long): User? {
        return null
    }

    override fun findByAccount(account: String): User? {
        return null
    }
}