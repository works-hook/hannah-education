package com.hannah.education.lectureservice.lecture.domain

import com.hannah.education.lectureservice.user.domain.User
import com.hannah.education.lectureservice.util.domain.BaseEntity
import java.time.LocalDate
import javax.persistence.*

@Entity
class Lecture(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String,
    val introduce: String,
    val startDate: LocalDate,
    val endDate: LocalDate,
    @ManyToOne
    val user: User,
): BaseEntity()