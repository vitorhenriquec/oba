package br.ufrn.imd.oba.controller

import br.ufrn.imd.oba.request.LearningObjectSearchRequest
import br.ufrn.imd.oba.response.LearningObjectSearchResponse
import br.ufrn.imd.oba.service.LearningObjectService
import javax.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@RestController
@RequestMapping(
    "/v1/learning_object",
    produces = [MediaType.APPLICATION_JSON_VALUE],
    consumes = [MediaType.APPLICATION_JSON_VALUE]
)
class LearningObjectController(
    private val learningObjectService: LearningObjectService
) {

    @GetMapping
    fun search(
        @PageableDefault(page = 0, size = 10, sort = ["name"]) pageable: Pageable,
        @RequestBody @Valid request: LearningObjectSearchRequest
    ): Mono<Page<LearningObjectSearchResponse>> {
        return learningObjectService.search(pageable, request).toMono()
    }
}
