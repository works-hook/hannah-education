package com.hannah.education.project.member.repository

import com.hannah.education.project.member.Member
import com.hannah.education.project.member.repository.student.StudentCustomRepository
import com.hannah.education.project.member.repository.teacher.TeacherCustomRepository
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long>, StudentCustomRepository, TeacherCustomRepository