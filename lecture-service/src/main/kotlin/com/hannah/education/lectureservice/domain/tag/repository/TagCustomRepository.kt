package com.hannah.education.lectureservice.domain.tag.repository

import com.hannah.education.lectureservice.domain.tag.Tag

interface TagCustomRepository {

    fun findTagByIds(ids: List<Long>): List<Tag>

}
