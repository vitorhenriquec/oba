package br.ufrn.imd.oba.extension

import br.ufrn.imd.oba.domain.Skill
import br.ufrn.imd.oba.response.DescriptorResponse
import br.ufrn.imd.oba.response.SkillResponse

fun Skill.toSkillResponse(): SkillResponse {
    return SkillResponse(
        id = id,
        description = description,
        code = code,
        shortName = educationYear.educationLevel.shortName
    )
}
