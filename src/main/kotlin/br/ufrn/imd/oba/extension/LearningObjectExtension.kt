package br.ufrn.imd.oba.extension


import br.ufrn.imd.oba.domain.LearningObject
import br.ufrn.imd.oba.response.AccessResponse
import br.ufrn.imd.oba.response.DescriptorResponse
import br.ufrn.imd.oba.response.LearningObjectFindAllByParamertsResponse
import br.ufrn.imd.oba.response.LearningObjectFindByIdResponse
import br.ufrn.imd.oba.response.MaintainingAuthorResponse
import br.ufrn.imd.oba.response.SkillResponse

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
               id = maintainingAuthor.id,
               name= maintainingAuthor.name,
               site = maintainingAuthor.site,
               email = maintainingAuthor.email
           )
        },
        descriptors = descriptors.map { descriptor ->
            descriptor.toDescriptorResponse()
        },
        skills = skills.map { skill ->
            skill.toSkillResponse()
        }
    )
}
