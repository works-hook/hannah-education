package com.hannah.education.userservice.util.exception

import com.hannah.education.userservice.util.code.ErrorCode

class BusinessException(
    val errorCode: ErrorCode
) : RuntimeException(errorCode.message)