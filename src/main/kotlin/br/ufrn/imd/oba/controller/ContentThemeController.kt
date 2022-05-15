package br.ufrn.imd.oba.controller

import br.ufrn.imd.oba.extension.toContentThemeResponse
import br.ufrn.imd.oba.response.ContentThemeResponse
import br.ufrn.imd.oba.service.ContentThemeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(
    "/v1/content_theme",
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
@Validated
class ContentThemeController(
    private val contentThemeService: ContentThemeService
) {
    @GetMapping
    fun findAll(
        @RequestHeader("curriculum_id") curriculumId: Long,
        @PageableDefault(page = 0, size = 10, sort = ["shortName"]) pageable: Pageable,
    ): Page<ContentThemeResponse> {
        return contentThemeService.findAllByCurriculumId(
            curriculumId,
            pageable
        ).map {
            it.toContentThemeResponse()
        }
    }
}
