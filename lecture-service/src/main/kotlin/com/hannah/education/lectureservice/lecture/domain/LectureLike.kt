package com.hannah.education.lectureservice.lecture.domain

import com.hannah.education.lectureservice.user.domain.User
import com.hannah.education.lectureservice.util.domain.BaseEntity
import javax.persistence.*

@Entity
class LectureLike(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne val lecture: Lecture,

    @OneToOne
    val user: User,
): BaseEntity()