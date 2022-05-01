package br.ufrn.imd.oba.response

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class LearningObjectFindByIdResponse(
    val id: Long,

    val name: String,

    val maintainingAuthors: List<MaintainingAuthorResponse>,

    val descriptors: List<DescriptorResponse>,

    val skills: List<SkillResponse>
)

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class MaintainingAuthorResponse(
    val name: String,

    val site: String
)

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class DescriptorResponse(
    val description: String,

    val code: String,

    val shortName: String
)

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class SkillResponse(
    val description: String,

    val code: String,

    val shortName: String
)


