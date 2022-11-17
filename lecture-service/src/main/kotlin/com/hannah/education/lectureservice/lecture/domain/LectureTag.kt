package com.hannah.education.lectureservice.lecture.domain

import com.hannah.education.lectureservice.util.domain.BaseEntity
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class LectureTag(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @ManyToOne
    val lecture: Lecture,
    @ManyToOne
    val tag: Tag,
):BaseEntity()