package com.hannah.education.lectureservice.domain.tag.repository

import com.hannah.education.lectureservice.domain.tag.Tag
import org.springframework.data.jpa.repository.JpaRepository

interface TagRepository: JpaRepository<Tag, Long>, TagCustomRepository