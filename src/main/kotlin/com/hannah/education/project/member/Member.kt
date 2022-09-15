package com.hannah.education.project.member

import com.hannah.education.project.util.Auth
import com.hannah.education.project.util.BaseTimeEntity
import com.hannah.education.project.util.Gender
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Enumerated
import javax.persistence.EnumType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Member (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null,

    private var name: String?,

    private var brith: LocalDate?,

    @Enumerated(EnumType.STRING)
    private var gender: Gender?,

    private var phoneNumber: String?,

    private var email: String?,

    @Enumerated(EnumType.STRING)
    private var auth: Auth?

) : BaseTimeEntity()