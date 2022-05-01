package br.ufrn.imd.oba.extension


import br.ufrn.imd.oba.domain.LearningObject
import br.ufrn.imd.oba.response.DescriptorResponse
import br.ufrn.imd.oba.response.LearningObjectFindAllByParamertsResponse
import br.ufrn.imd.oba.response.LearningObjectFindByIdResponse
import br.ufrn.imd.oba.response.MaintainingAuthorResponse
import br.ufrn.imd.oba.response.SkillResponse
import kotlin.streams.toList

fun LearningObject.learningObjectFindAllByParamertsResponse(): LearningObjectFindAllByParamertsResponse{
    return LearningObjectFindAllByParamertsResponse(
        id = this.id,
        name = this.name,
        thumbnailPath = this.thumbnailPath,
    )
}

fun LearningObject.toLeaningObjectFindByIdResponse(): LearningObjectFindByIdResponse {

    return LearningObjectFindByIdResponse(
        name = this.name,
        maintainingAuthors = this.maintainingAuthors.stream().map{ maintainingAuthor ->
           MaintainingAuthorResponse(
               name= maintainingAuthor.name,
               site = maintainingAuthor.site
           )
        }.toList(),
        descriptors = this.descriptors.stream().map { descriptor ->
            DescriptorResponse(
                description = descriptor.description,
                code = descriptor.code,
                shortName = descriptor.educationLevel.shortName
            )
        }.toList(),
        skills = this.skills.stream().map { skill ->
            SkillResponse(
                description = skill.description,
                code = skill.code,
                shortName = skill.educationYear.educationLevel.shortName
            )
        }.toList()
    )
}
