package com.hannah.education.students.member.controller

import com.hannah.education.students.member.service.MemberService
import com.hannah.education.util.ApiResponse.Success
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/member")
class LoginController(
    private val memberService: MemberService
) {

    @GetMapping("/login")
    fun login(): Success<Any> {
        return Success("asdf")
    }


}