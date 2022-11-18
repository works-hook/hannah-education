package com.hannah.education.lectureservice.user.repository

import com.hannah.education.lectureservice.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>, UserCustomRepository