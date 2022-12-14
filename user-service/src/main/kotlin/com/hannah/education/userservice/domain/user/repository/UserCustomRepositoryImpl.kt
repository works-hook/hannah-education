package com.hannah.education.userservice.domain.user.repository

import com.hannah.education.userservice.user.domain.QUser.user
import com.hannah.education.userservice.domain.user.User
import com.hannah.education.userservice.domain.user.UserType
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class UserCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory
): UserCustomRepository {

    override fun findUserAll(): List<User> {
        return queryFactory
            .selectFrom(user)
            .where(notDelete())
            .fetch()
    }

    override fun findUserById(id: Long): User? {
        return queryFactory
            .selectFrom(user)
            .where(
                eqId(id),
                notDelete()
            )
            .fetchOne()
    }

    override fun findByAccount(account: String): User? {
        return queryFactory
            .selectFrom(user)
            .where(
                eqAccount(account),
                notDelete()
            )
            .fetchOne()
    }

    override fun findTeachers(): List<User> {
        return queryFactory
            .selectFrom(user)
            .where(
                isTeacher(),
                notDelete()
            )
            .fetch()
    }

    private fun eqId(id: Long): BooleanExpression {
        return user.id.eq(id)
    }

    private fun eqAccount(account: String): BooleanExpression {
        return user.account.eq(account)
    }

    private fun isTeacher(): BooleanExpression {
        return user.userType.eq(UserType.TEACHER)
    }

    private fun notDelete(): BooleanExpression {
        return user.deletedDate.isNull
    }
}