package br.ufrn.imd.oba.request

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import javax.validation.constraints.NotBlank

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class LearningObjectSearchRequest (
    @field:NotBlank
    val name: String,

    val educationLevelId: Long?,

    val contentThemeId: Long?,

    val descriptorId: Long?,

    val skillId: Long?,

    val accessType: String?,

    val curriculumShortName: String?
)
