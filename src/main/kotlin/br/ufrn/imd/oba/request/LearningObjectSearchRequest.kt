package br.ufrn.imd.oba.request

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class LearningObjectSearchRequest (
    val texto: String?,

    val educationLevelId: Long?,

    val contentThemeId: Long?,

    val descriptorId: Long?,

    val viewTypeId: Long?,

    val curriculumId: Long?
)
