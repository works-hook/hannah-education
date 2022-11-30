package com.hannah.education.userservice.domain.banner.repository

import com.hannah.education.userservice.domain.banner.Banner
import org.springframework.data.jpa.repository.JpaRepository

interface BannerRepository: JpaRepository<Banner, Long>