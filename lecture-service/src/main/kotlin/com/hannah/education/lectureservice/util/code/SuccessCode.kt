package com.hannah.education.lectureservice.util.code

enum class SuccessCode(
    val code: String,
    val message: String,
) {
    LECTURE_CREATE("10001", "강의가 등록되었습니다."),
    LECTURE_MODIFY("10002", "강의가 수정되었습니다."),
    LECTURE_DELETE("10003", "강의가 삭제되었습니다."),

    ALL_LECTURE("10010", "강의 리스트입니다."),
    ONE_LECTURE("10011", "강의 상세입니다."),

    ALL_TAGS("10100", "태그 리스트입니다."),
    RANDOM_TAGS("10101", "랜덤 태그 리스트입니다."),

    TAKING_LECTURE("11000", "수강 신청이 정상 처리 되었습니다."),
    TAKING_LECTURE_LIST("11001", "수강중인 강의 리스트입니다."),
    LIKE_LECTURE("11002", "강의에 좋아요를 눌렀습니다."),
    LIKE_LECTURE_LIST("11003", "좋아요한 강의 리스트입니다."),
    TAKING_LECTURE_TAG("11004", "수강한 태그 리스트입니다."),

    ALL_NOTICE("20001", "강의 공지사항입니다."),
    NOTICE_CREATE("20002", "공지사항이 등록되었습니다."),
    NOTICE_MODIFY("20003", "공지사항이 수정되었습니다."),
    NOTICE_DELETE("20004", "공지사항이 삭제되었습니다."),
}