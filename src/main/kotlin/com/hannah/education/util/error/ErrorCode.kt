package com.hannah.education.util.error

import org.springframework.http.HttpStatus

enum class ErrorCode(
    val status: HttpStatus,
    val message: String
) {
    INTERNAL_SYSTEM_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "시스템에서 문제가 발생하였습니다."),

    NOT_EXIST_MEMBER(HttpStatus.BAD_REQUEST, "회원이 존재하지 않습니다."),

    NOT_EXIST_FEE(HttpStatus.BAD_REQUEST, "요금이 존재하지 않습니다.")
}