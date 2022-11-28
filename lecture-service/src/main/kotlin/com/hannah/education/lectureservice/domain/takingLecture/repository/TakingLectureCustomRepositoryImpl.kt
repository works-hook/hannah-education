package com.hannah.education.lectureservice.domain.takingLecture.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class TakingLectureCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory
): TakingLectureCustomRepository {
}