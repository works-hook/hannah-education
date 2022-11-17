package com.hannah.education.lectureservice.util.exception

import com.hannah.education.lectureservice.util.code.ErrorCode

class BusinessException(
    val errorCode: ErrorCode
) : RuntimeException(errorCode.message)