package br.ufrn.imd.oba.repository

import br.ufrn.imd.oba.domain.ContentTheme
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ContentThemeRepository : JpaRepository<ContentTheme, Long>{

    @Query(
        " SELECT distinct ct FROM ContentTheme ct " +
                " LEFT JOIN ct.curriculum ctc " +
                " WHERE (:curriculumId is NULL or ctd.id = :curriculumId) ",
    )
    fun findAllByCurriculumId(
        @Param("curriculumId") curriculumId: Long,
        pageable: Pageable
    ): Page<ContentTheme>
}
