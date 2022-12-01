package com.hannah.education.classservice.util.exception

import com.hannah.education.classservice.util.code.ErrorCode

class BusinessException(
    val errorCode: ErrorCode
) : RuntimeException(errorCode.message)