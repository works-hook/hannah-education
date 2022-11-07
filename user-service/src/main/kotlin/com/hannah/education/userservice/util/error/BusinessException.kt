package com.hannah.education.userservice.util.error

class BusinessException(
    val errorCode: ErrorCode
) : RuntimeException(errorCode.message)