package com.hannah.education.lectureservice.domain.lectureLike.repository

import com.hannah.education.lectureservice.domain.lecture.Lecture
import com.hannah.education.lectureservice.domain.lecture.QLecture.lecture
import com.hannah.education.lectureservice.domain.lectureLike.QLectureLike.lectureLike
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
                lecture.eq(findLecture)
            )
            .groupBy(lecture.id)
            .fetchOne()
    }

}