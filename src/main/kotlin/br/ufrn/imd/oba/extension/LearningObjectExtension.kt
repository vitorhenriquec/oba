package br.ufrn.imd.oba.extension


import br.ufrn.imd.oba.domain.LearningObject
import br.ufrn.imd.oba.response.LearningObjectSearchResponse

fun LearningObject.toLearningObjectSearchResponse(): LearningObjectSearchResponse{
    return LearningObjectSearchResponse(
        name = this.name,
        thumbnailPath = this.thumbnailPath,
        link = this.link
    )
}
