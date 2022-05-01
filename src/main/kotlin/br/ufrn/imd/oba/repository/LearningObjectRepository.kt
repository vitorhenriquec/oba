package br.ufrn.imd.oba.repository

import br.ufrn.imd.oba.domain.LearningObject
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface LearningObjectRepository: JpaRepository<LearningObject, Long> {
    @Query(
        " SELECT lo FROM LearningObject lo " +
         " LEFT JOIN lo.descriptors d " +
         " WHERE lower(lo.name) like CONCAT('%',:name,'%') " +
         " AND lo.active = true" +
//         " AND (:viewType IS NULL OR lo.viewType = :viewType) " +
         " AND (:educationLevelId IS NULL OR d.educationLevel.id = :educationLevelId) " +
         " AND (:contentThemeId IS NULL OR d.contentTheme.id = :contentThemeId) " +
         " AND (:descriptorId IS NULL OR d.id = :descriptorId) ",
    )
    fun findAllActiveByNameAndViewTypeAndEducationLevelIdAndContentThemeIdAndDescriptorId(
        @Param("name") name: String,
        @Param("educationLevelId") educationLevelId: Long?,
        @Param("contentThemeId") contentThemeId: Long?,
        @Param("descriptorId") descriptorId: Long?,
        pageable: Pageable
    ): Page<LearningObject>


    @Query(
        " SELECT lo FROM LearningObject lo " +
                " LEFT JOIN lo.skills s " +
                " WHERE lower(lo.name) like CONCAT('%',:name,'%') " +
                " AND lo.active = true" +
//                " AND (:viewType IS NULL OR lo.viewType = :viewType) " +
                " AND (:educationLevelId IS NULL OR s.educationYear.educationLevel.id = :educationLevelId) " +
                " AND (:contentThemeId IS NULL OR s.contentTheme.id = :contentThemeId) " +
                " AND (:skillId IS NULL OR s.id = :skillId) ",
    )
    fun findAllActiveByNameAndViewTypeAndEducationLevelIdAndContentThemeIdAndSkillId(
        @Param("name") name: String,
        @Param("educationLevelId") educationLevelId: Long?,
        @Param("contentThemeId") contentThemeId: Long?,
        @Param("skillId") skillId: Long?,
        pageable: Pageable
    ): Page<LearningObject>
}
