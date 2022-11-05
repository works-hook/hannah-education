package com.hannah.education.userservice.user.repository

import com.hannah.education.userservice.user.domain.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: MongoRepository<User, String>, UserCustomRepository