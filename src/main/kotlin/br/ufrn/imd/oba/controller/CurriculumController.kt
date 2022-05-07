package br.ufrn.imd.oba.controller

import br.ufrn.imd.oba.extension.toCurriculumRespose
import br.ufrn.imd.oba.response.CurriculumResponse
import br.ufrn.imd.oba.service.CurriculumService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(
    "/v1/curriculum",
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class CurriculumController(
    private val curriculumService: CurriculumService
) {
    @GetMapping
    fun findAll(
        @PageableDefault(page = 0, size = 10, sort = ["name"]) pageable: Pageable,
    ): Page<CurriculumResponse> {
       return curriculumService.findAll(pageable).map {
           it.toCurriculumRespose()
       }
    }

}
