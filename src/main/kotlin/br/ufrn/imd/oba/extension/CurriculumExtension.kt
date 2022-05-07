package br.ufrn.imd.oba.extension

import br.ufrn.imd.oba.domain.Curriculum
import br.ufrn.imd.oba.response.CurriculumResponse

fun Curriculum.toCurriculumRespose(): CurriculumResponse {
    return CurriculumResponse(
        id = id,
        shortName = shortName
    )
}
