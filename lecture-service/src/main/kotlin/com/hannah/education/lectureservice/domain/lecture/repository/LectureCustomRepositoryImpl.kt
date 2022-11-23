package com.hannah.education.lectureservice.domain.lecture.repository

import com.hannah.education.lectureservice.domain.lecture.Lecture
import com.hannah.education.lectureservice.domain.lecture.QLecture.lecture
import com.hannah.education.lectureservice.domain.lectureLike.QLectureLike.lectureLike
import com.hannah.education.lectureservice.user.domain.QUser.user
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class LectureCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory
): LectureCustomRepository {

    override fun findLectureAll(id: Long): List<Lecture> {
        return queryFactory
            .selectFrom(lecture)
            .where(
                eqUserId(id),
                notDelete()
            ).fetch()
    }

    override fun findLectureId(lectureId: Long): Lecture? {
        return queryFactory
            .selectFrom(lecture)
            .where(
                eqId(lectureId),
                notDelete()
            ).fetchOne()
    }

    override fun findMostTakenLectures(): List<Lecture> {
        return listOf()
    }

    override fun findMostLikeLectures(): List<Lecture> {
        return queryFactory
            .selectFrom(lecture)
            .join(lectureLike)
            .on(lectureLike.lecture.eq(lecture))
            .where(
                notDelete(),
                likeNotDelete(),
            )
            .groupBy(lecture.id)
            .orderBy(lectureLike.count().desc())
            .fetch()
    }

    private fun eqId(id: Long): BooleanExpression {
        return lecture.id.eq(id)
    }

    private fun eqUserId(id: Long): BooleanExpression {
        return user.id.eq(id)
    }

    private fun notDelete(): BooleanExpression {
        return lecture.deletedDate.isNull
    }

    private fun likeNotDelete(): BooleanExpression {
        return lectureLike.deletedDate.isNull
    }

}