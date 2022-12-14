package com.hannah.education.lectureservice.domain.lectureLike.repository

import com.hannah.education.lectureservice.domain.lecture.Lecture
import com.hannah.education.lectureservice.domain.lecture.QLecture.lecture
import com.hannah.education.lectureservice.domain.lectureLike.LectureLike
import com.hannah.education.lectureservice.domain.lectureLike.QLectureLike.lectureLike
import com.hannah.education.lectureservice.domain.user.User
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class LectureLikeCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory
): LectureLikeCustomRepository {

    override fun findCountByLecture(findLecture: Lecture): Long? {
        return queryFactory
            .select(lectureLike.count())
            .from(lecture)
            .join(lectureLike).on(lectureLike.lecture.eq(lecture))
            .where(
                eqLecture(findLecture)
            )
            .groupBy(lecture.id)
            .fetchOne()
    }

    override fun findLectureByUser(findUser: User): List<LectureLike> {
        return queryFactory
            .selectFrom(lectureLike)
            .where(
                eqUser(findUser),
                notDelete()
            )
            .fetch()
    }

    private fun eqLecture(findLecture: Lecture): BooleanExpression {
        return lecture.eq(findLecture)
    }

    private fun eqUser(findUser: User): BooleanExpression {
        return lectureLike.user.eq(findUser)
    }

    private fun notDelete(): BooleanExpression {
        return lectureLike.deletedDate.isNull
    }

}