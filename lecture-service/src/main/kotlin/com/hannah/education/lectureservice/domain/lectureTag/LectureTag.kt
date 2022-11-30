package com.hannah.education.lectureservice.domain.lectureTag

import com.hannah.education.lectureservice.domain.lecture.Lecture
import com.hannah.education.lectureservice.domain.tag.Tag
import com.hannah.education.lectureservice.util.domain.BaseEntity
import javax.persistence.*

@Entity
class LectureTag(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    val lecture: Lecture,

    @ManyToOne(fetch = FetchType.LAZY)
    val tag: Tag,
):BaseEntity()