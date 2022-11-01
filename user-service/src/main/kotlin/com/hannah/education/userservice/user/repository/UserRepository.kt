package com.hannah.education.userservice.user.repository

import com.hannah.education.userservice.user.domain.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository: MongoRepository<User, Long>