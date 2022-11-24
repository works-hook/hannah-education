package com.hannah.education.lectureservice.domain.user.repository

import com.hannah.education.lectureservice.domain.user.QUser.user
import com.hannah.education.lectureservice.domain.user.User
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class UserCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory
): UserCustomRepository {

    override fun findUserById(userId: Long): User? {
        return queryFactory.selectFrom(user)
            .where(
                eqId(userId),
                notDelete()
            ).fetchOne()
    }

    private fun eqId(id: Long): BooleanExpression {
        return user.id.eq(id)
    }

    private fun notDelete(): BooleanExpression {
        return user.deletedDate.isNull
    }

}