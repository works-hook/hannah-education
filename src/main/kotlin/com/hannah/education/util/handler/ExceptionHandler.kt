package com.hannah.education.util.handler

import com.hannah.education.util.ApiResponse.Error
import com.hannah.education.util.error.BusinessException
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler() {

    private val logger = KotlinLogging.logger {}

    @ExceptionHandler(BusinessException::class)
    fun handleMyException(e: BusinessException): Error<HttpStatus> {
        logger.error { "Exception --> Error code: ${ e.errorCode }" }
        return Error(e.errorCode.status, e.message)
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    fun handleResolverException(e: HttpRequestMethodNotSupportedException): Error<String> {
        val error = Error("지원하지 않은 HTTP 메소드 입니다.", e.message)
        logger.error { "Exception --> Error data: ${ error.data }" }
        return error
    }
}