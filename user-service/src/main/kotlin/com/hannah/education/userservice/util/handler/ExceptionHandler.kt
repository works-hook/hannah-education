package com.hannah.education.userservice.util.handler

import com.hannah.education.userservice.util.ApiResponse.Error
import com.hannah.education.userservice.util.error.BusinessException
import org.springframework.http.HttpStatus
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler() {

    @ExceptionHandler(BusinessException::class)
    fun handleMemberException(e:BusinessException): Error<HttpStatus> {
        return Error(e.errorCode.status, e.message)
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    fun httpRequestMethodNotSupportedException(e: HttpRequestMethodNotSupportedException): Error<String?> {
        return Error(e.message, "잘못된 URI 요청입니다.")
    }
}