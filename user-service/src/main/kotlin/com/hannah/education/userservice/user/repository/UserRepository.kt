package com.hannah.education.userservice.user.repository

import com.hannah.education.userservice.user.domain.QUser.user
import com.hannah.education.userservice.user.domain.User
import com.querydsl.core.types.dsl.BooleanExpression
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

interface UserDataRepository: MongoRepository<User, String> {
    fun findOne(eq: BooleanExpression?): User?
}

@Repository
class UserRepository(
    private val userDataRepository: UserDataRepository
) {

    fun findByAccount(account: String): User? {
        return userDataRepository.findOne(
            user.account.eq(account)
        )
    }

}
