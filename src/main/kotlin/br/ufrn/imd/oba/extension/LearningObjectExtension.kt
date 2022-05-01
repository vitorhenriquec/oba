package br.ufrn.imd.oba.extension


import br.ufrn.imd.oba.domain.LearningObject
import br.ufrn.imd.oba.response.AccessResponse
import br.ufrn.imd.oba.response.DescriptorResponse
import br.ufrn.imd.oba.response.LearningObjectFindAllByParamertsResponse
import br.ufrn.imd.oba.response.LearningObjectFindByIdResponse
import br.ufrn.imd.oba.response.MaintainingAuthorResponse
import br.ufrn.imd.oba.response.SkillResponse
import kotlin.streams.toList

fun LearningObject.learningObjectFindAllByParamertsResponse(): LearningObjectFindAllByParamertsResponse{
    return LearningObjectFindAllByParamertsResponse(
        id = id,
        name = name,
        thumbnailPath = thumbnailPath,
        accesses = learningObjectPlataforms.map {
            AccessResponse(it.link, it.accessType.toString(), it.plataform.name)
        }
    )
}

fun LearningObject.toLeaningObjectFindByIdResponse(): LearningObjectFindByIdResponse {

    return LearningObjectFindByIdResponse(
        id = id,
        name = name,
        maintainingAuthors = maintainingAuthors.map{ maintainingAuthor ->
           MaintainingAuthorResponse(
               name= maintainingAuthor.name,
               site = maintainingAuthor.site
           )
        },
        descriptors = descriptors.map { descriptor ->
            DescriptorResponse(
                description = descriptor.description,
                code = descriptor.code,
                shortName = descriptor.educationLevel.shortName
            )
        }.toList(),
        skills = skills.map { skill ->
            SkillResponse(
                description = skill.description,
                code = skill.code,
                shortName = skill.educationYear.educationLevel.shortName
            )
        }
    )
}
