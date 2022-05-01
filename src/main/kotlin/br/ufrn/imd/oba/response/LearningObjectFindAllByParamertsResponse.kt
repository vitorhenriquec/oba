package br.ufrn.imd.oba.response

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class LearningObjectFindAllByParamertsResponse(
    val id: Long,

    val name: String,

    val thumbnailPath: String?,

    val accesses: List<AccessResponse>
)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class AccessResponse(
    val link: String,
    val type: String,
    val plataform: String
)
