package com.hannah.education.userservice.user.controller

import com.hannah.education.userservice.user.domain.User
import com.hannah.education.userservice.user.dto.request.UserCreateRequest
import com.hannah.education.userservice.user.dto.request.UserDuplicateRequest
import com.hannah.education.userservice.user.dto.request.UserLoginRequest
import com.hannah.education.userservice.user.dto.request.UserModifyRequest
import com.hannah.education.userservice.user.dto.response.UserCreateResponse
import com.hannah.education.userservice.user.dto.response.UserModifyResponse
import com.hannah.education.userservice.user.service.UserService
import com.hannah.education.userservice.util.ApiResponse.Ok
import com.hannah.education.userservice.util.ApiResponse.Success
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService
) {

    @PostMapping("/users")
    fun createUser(@RequestBody request: UserCreateRequest): Success<UserCreateResponse> {
        val result = userService.createUser(request)
        return Success(result, "회원 가입이 완료되었습니다.")
    }

    @PostMapping("/users/account")
    fun accountDuplicateCheck(@RequestBody request: UserDuplicateRequest): Success<User> {
        val result = userService.accountDuplicateCheck(request)
        return Success(result, "사용 가능한 아이디입니다.")
    }

    @PatchMapping("/users/{id}")
    fun modifyUser(@PathVariable id: String, @RequestBody request: UserModifyRequest): Success<UserModifyResponse> {
        val result = userService.modifyUser(id, request)
        return Success(result, "회원 수정이 완료되었습니다.")
    }

    @GetMapping("/users")
    fun findAllUser(): Success<List<UserCreateResponse>> {
        val result = userService.findAll()
        return Success(result, "회원 리스트 입니다.")
    }

    @PostMapping("/users/login")
    fun loginUser(@RequestBody request: UserLoginRequest): Ok<String> {
        userService.loginUser(request)
        return Ok("로그인이 완료되었습니다.")
    }

}