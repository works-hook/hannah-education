package com.hannah.education.classservice.util.code

enum class SuccessCode(
    val code: String,
    val message: String,
) {
    CLASS_CREATE("10001", "수업이 등록되었습니다."),
    CLASS_MODIFY("10002", "수업이 수정되었습니다."),
    CLASS_DELETE("10003", "수업이 삭제되었습니다."),

    ALL_CLASS("10010", "수업 리스트입니다."),
}