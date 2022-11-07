package com.hannah.education.userservice.util.handler

import com.hannah.education.userservice.util.ApiResponse.Error
import com.hannah.education.userservice.util.error.BusinessException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler() {

    @ExceptionHandler(BusinessException::class)
    fun handleMemberException(e:BusinessException): Error<HttpStatus> {
        return Error(e.errorCode.status, e.message)
    }
}