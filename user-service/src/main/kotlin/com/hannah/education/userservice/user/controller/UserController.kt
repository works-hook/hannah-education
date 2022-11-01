package com.hannah.education.userservice.user.controller

import com.hannah.education.userservice.user.domain.User
import com.hannah.education.userservice.user.dto.request.UserCreateRequest
import com.hannah.education.userservice.user.dto.response.UserCreateResponse
import com.hannah.education.userservice.user.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
class UserController(
    private val userService: UserService
) {

    @PostMapping("/users")
    fun createUser(@RequestBody request: UserCreateRequest): UserCreateResponse {
        return userService.createUser(request)
    }

    @GetMapping("/users")
    fun findAllUser(): List<UserCreateResponse> {
        return userService.findAll()
    }

}