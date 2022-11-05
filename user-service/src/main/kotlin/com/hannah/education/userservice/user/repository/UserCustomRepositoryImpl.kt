package com.hannah.education.userservice.user.repository

import com.hannah.education.userservice.user.domain.QUser
import com.hannah.education.userservice.user.domain.QUser.user
import com.hannah.education.userservice.user.domain.User
import com.querydsl.core.QueryFactory
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class UserCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory
): UserCustomRepository {

    override fun findByAccount(account: String): User? {
        return queryFactory
            .selectFrom(user)
            .where(eqAccount(account))
            .fetchOne()
    }

    private fun eqAccount(account: String): BooleanExpression? {
        return user.account.eq(account)
    }

}