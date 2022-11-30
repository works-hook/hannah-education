package com.hannah.education.lectureservice.domain.lectureLike

import com.hannah.education.lectureservice.domain.lecture.Lecture
import com.hannah.education.lectureservice.domain.user.User
import com.hannah.education.lectureservice.util.domain.BaseEntity
import javax.persistence.*

@Entity
class LectureLike(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    val lecture: Lecture,

    @OneToOne
    val user: User,
): BaseEntity()