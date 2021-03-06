package br.ufrn.imd.oba.controller

import br.ufrn.imd.oba.extension.toDescriptorResponse
import br.ufrn.imd.oba.response.DescriptorResponse
import br.ufrn.imd.oba.service.DescriptorService
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
    "/v1/descriptor",
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
@Validated
class DescriptorController(
    private val descriptorService: DescriptorService
) {

    @GetMapping
    fun findAll(
        @PageableDefault(page = 0, size = 10, sort = ["code"]) pageable: Pageable,
    ): Page<DescriptorResponse> {
        return descriptorService.findAll(pageable).map {
            it.toDescriptorResponse()
        }
    }
}
