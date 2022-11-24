package com.hannah.education.lectureservice.domain.user.repository

import com.hannah.education.lectureservice.domain.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>, UserCustomRepository