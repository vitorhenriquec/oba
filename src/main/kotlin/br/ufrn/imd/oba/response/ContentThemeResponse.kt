package br.ufrn.imd.oba.response

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class ContentThemeResponse(
    val id: Long,

    val name: String,

    val curriculum: CurriculumResponse
)

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class CurriculumResponse(
    val id: Long,

    val shortName: String
)
