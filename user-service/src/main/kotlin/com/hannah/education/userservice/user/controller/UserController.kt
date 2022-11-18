package com.hannah.education.userservice.user.controller

import com.hannah.education.userservice.user.dto.request.UserCreateRequest
import com.hannah.education.userservice.user.dto.request.UserDuplicateRequest
import com.hannah.education.userservice.user.dto.request.UserLoginRequest
import com.hannah.education.userservice.user.dto.request.UserUpdatePasswordRequest
import com.hannah.education.userservice.user.dto.response.UserCreateResponse
import com.hannah.education.userservice.user.service.UserService
import com.hannah.education.userservice.util.ApiResponse.Success
import com.hannah.education.userservice.util.code.SuccessCode
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

    @PostMapping("")
    fun createUser(@RequestBody request: UserCreateRequest): Success<UserCreateResponse> {
        val result = userService.createUser(request)
        return Success(result, SuccessCode.USER_REGISTER)
    }

    @PostMapping("/account")
    fun accountDuplicateCheck(@RequestBody request: UserDuplicateRequest): Success<String> {
        userService.accountDuplicateCheck(request)
        return Success(SuccessCode.NOT_DUPLICATE_ACCOUNT)
    }

    @DeleteMapping("/users/{id}")
    fun deleteUser(@PathVariable id: Long): Success<String> {
        userService.deleteUser(id)
        return Success(SuccessCode.SECESSION)
    }

    @PostMapping("/login")
    fun loginUser(@RequestBody request: UserLoginRequest): Success<String> {
        userService.loginUser(request)
        return Success(SuccessCode.LOGIN)
    }

    @PostMapping("/{id}")
    fun updatePassword(@PathVariable id: Long, @RequestBody request: UserUpdatePasswordRequest) {
        userService.updatePassword(id, request)
    }

}