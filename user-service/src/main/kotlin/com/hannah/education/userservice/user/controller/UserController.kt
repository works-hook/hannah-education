package com.hannah.education.userservice.user.controller

import com.hannah.education.userservice.user.dto.request.UserCreateRequest
import com.hannah.education.userservice.user.dto.request.UserDuplicateRequest
import com.hannah.education.userservice.user.dto.request.UserLoginRequest
import com.hannah.education.userservice.user.dto.request.UserModifyRequest
import com.hannah.education.userservice.user.dto.response.UserCreateResponse
import com.hannah.education.userservice.user.dto.response.UserModifyResponse
import com.hannah.education.userservice.user.dto.response.UserOneResponse
import com.hannah.education.userservice.user.service.UserService
import com.hannah.education.userservice.util.ApiResponse.Success
import com.hannah.education.userservice.util.code.SuccessCode
import org.springframework.web.bind.annotation.*

@RestController
class UserController(
    private val userService: UserService
) {

    @PostMapping("/users")
    fun createUser(@RequestBody request: UserCreateRequest): Success<UserCreateResponse> {
        val result = userService.createUser(request)
        return Success(result, SuccessCode.USER_REGISTER)
    }

    @PostMapping("/users/account")
    fun accountDuplicateCheck(@RequestBody request: UserDuplicateRequest): Success<String> {
        userService.accountDuplicateCheck(request)
        return Success(SuccessCode.NOT_DUPLICATE_ACCOUNT)
    }

    @PatchMapping("/users/{id}")
    fun modifyUser(@PathVariable id: Long, @RequestBody request: UserModifyRequest): Success<UserModifyResponse> {
        val result = userService.modifyUser(id, request)
        return Success(result, SuccessCode.USER_MODIFY)
    }

    @DeleteMapping("/users/{id}")
    fun deleteUser(@PathVariable id: Long): Success<String> {
        userService.deleteUser(id)
        return Success(SuccessCode.SECESSION)
    }

    @GetMapping("/users/{id}")
    fun findOneUser(@PathVariable id: Long): Success<UserOneResponse> {
        val result = userService.findOne(id)
        return Success(result, SuccessCode.USER_LIST)
    }

    @GetMapping("/users")
    fun findAllUser(): Success<List<UserOneResponse>> {
        val result = userService.findAll()
        return Success(result, SuccessCode.USER_LIST)
    }

    @PostMapping("/users/login")
    fun loginUser(@RequestBody request: UserLoginRequest): Success<String> {
        userService.loginUser(request)
        return Success(SuccessCode.LOGIN)
    }

}