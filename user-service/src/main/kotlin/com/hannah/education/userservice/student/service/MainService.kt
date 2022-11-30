package com.hannah.education.userservice.student.service

import com.hannah.education.userservice.domain.banner.repository.BannerRepository
import com.hannah.education.userservice.domain.user.repository.UserRepository
import com.hannah.education.userservice.student.dto.response.BannerResponse
import com.hannah.education.userservice.student.dto.response.TeacherResponse
import com.hannah.education.userservice.student.dto.response.toResponse
import com.hannah.education.userservice.student.dto.response.toTeacherResponse
import org.springframework.stereotype.Service

@Service
class MainService(
    private val bannerRepository: BannerRepository,
    private val userRepository: UserRepository,
) {

    fun findAllBanner(): List<BannerResponse> {
        return bannerRepository
            .findAll()
            .map { it.toResponse() }
    }

    fun findAllTeacher(): List<TeacherResponse> {
        return userRepository
            .findTeachers()
            .shuffled()
            .map { it.toTeacherResponse() }
            .subList(0, 5)
    }

}