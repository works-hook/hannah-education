package com.hannah.education.lectureservice.domain.lectureNotice.repositoroy

import com.hannah.education.lectureservice.domain.lecture.Lecture
import com.hannah.education.lectureservice.domain.lectureNotice.LectureNotice
import com.hannah.education.lectureservice.domain.lectureNotice.QLectureNotice.lectureNotice
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class LectureNoticeCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory
): LectureNoticeCustomRepository {

    override fun findNoticeAll(lecture: Lecture): List<LectureNotice> {
        return queryFactory
            .selectFrom(lectureNotice)
            .where(
                eqLecture(lecture),
                notDelete(),
            )
            .fetch()
    }

    override fun findNoticeById(noticeId: Long): LectureNotice? {
        return queryFactory
            .selectFrom(lectureNotice)
            .where(
                eqId(noticeId),
                notDelete()
            ).fetchOne()
    }

    fun eqId(noticeId: Long): BooleanExpression {
        return lectureNotice.id.eq(noticeId)
    }

    fun eqLecture(lecture: Lecture): BooleanExpression {
        return lectureNotice.lecture.eq(lecture)
    }

    fun notDelete(): BooleanExpression {
        return lectureNotice.deletedDate.isNull
    }

}