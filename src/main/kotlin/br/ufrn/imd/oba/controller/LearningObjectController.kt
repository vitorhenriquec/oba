package br.ufrn.imd.oba.controller

import br.ufrn.imd.oba.domain.LearningObject
import br.ufrn.imd.oba.extension.toLearningObjectSearchResponse
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
        @RequestBody(required = false) @Valid request: LearningObjectSearchRequest?
    ): Mono<Page<LearningObjectSearchResponse>> {
        return Mono.just(
            learningObjectService.search(pageable).map {
                it.toLearningObjectSearchResponse()
            }
        )
    }
}
