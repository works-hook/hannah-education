package com.hannah.education.project.lecture

import com.hannah.education.project.util.BaseTimeEntity
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Lecture (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null,

    private var title: String?,

    private var introduceContent: String?
) : BaseTimeEntity()