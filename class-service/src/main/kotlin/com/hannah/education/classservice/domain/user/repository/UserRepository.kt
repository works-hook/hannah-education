package com.hannah.education.classservice.domain.user.repository

import com.hannah.education.classservice.domain.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>