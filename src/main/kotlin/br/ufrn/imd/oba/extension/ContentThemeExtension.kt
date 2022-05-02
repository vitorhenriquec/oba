package br.ufrn.imd.oba.extension

import br.ufrn.imd.oba.domain.ContentTheme
import br.ufrn.imd.oba.response.CurriculumResponse
import br.ufrn.imd.oba.response.ContentThemeResponse

fun ContentTheme.toContentThemeResponse(): ContentThemeResponse {
    return ContentThemeResponse(
        id = id,
        name = name,
        curriculum = CurriculumResponse(
            id = id,
            name = name
        )
    )
}
