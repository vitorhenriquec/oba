package br.ufrn.imd.oba.controller

import br.ufrn.imd.oba.response.DescriptorResponse
import br.ufrn.imd.oba.response.SkillResponse
import br.ufrn.imd.oba.service.DescriptorService
import br.ufrn.imd.oba.service.SkillService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(
    "/v1/skill",
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
@Validated
class SkillController(
    private val skillService: SkillService
) {

    @GetMapping
    fun findAll(
        @PageableDefault(page = 0, size = 10, sort = ["code"]) pageable: Pageable,
    ): Page<SkillResponse> {
        return skillService.findAll(pageable)
    }
}
