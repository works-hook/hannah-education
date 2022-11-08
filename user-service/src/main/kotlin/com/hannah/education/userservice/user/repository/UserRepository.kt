package com.hannah.education.userservice.user.repository

import com.hannah.education.userservice.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>, UserCustomRepository
