package com.hannah.education.util.error

import com.hannah.education.util.error.ErrorCode

class BusinessException(
    val errorCode: ErrorCode
) : RuntimeException(errorCode.message)