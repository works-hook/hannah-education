package com.hannah.education.userservice.util.code

import org.springframework.http.HttpStatus

enum class SuccessCode(
    val code: String,
    val message: String,
) {
    USER_REGISTER("00001", "회원 가입이 완료되었습니다."),
    NOT_DUPLICATE_ACCOUNT("00002", "사용 가능한 아이디입니다."),
    USER_MODIFY("00003", "사용 가능한 아이디입니다."),
    USER_LIST("00004", "회원 리스트입니다."),
    LOGIN("00005", "로그인이 완료되었습니다."),
    SECESSION("00006", "탈퇴가 정상적으로 처리되었습니다."),
}