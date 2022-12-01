package com.hannah.education.classservice.util.code

enum class ErrorCode(
    val code: String,
    val message: String
) {
    NOT_URI("40000", "잘못된 URI 요청입니다."),
    NOT_BODY("40001", "잘못된 Body 요청입니다."),

    NOT_EXIST_MEMBER("40020", "존재하지 않은 사용자입니다."),

    NOT_EXIST_LECTURE("50001", "존재하지 않은 강의입니다."),
    NOT_EXIST_NOTICE("50002", "존재하지 않은 공지사항입니다."),
    NOT_EXIST_CLASS("50003", "존재하지 않은 수업입니다."),
}