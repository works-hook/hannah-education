package com.hannah.education.userservice.domain.user.repository

import com.hannah.education.userservice.domain.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>, UserCustomRepository
