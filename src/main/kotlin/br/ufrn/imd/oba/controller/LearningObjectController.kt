package br.ufrn.imd.oba.controller

import br.ufrn.imd.oba.extension.learningObjectFindAllByParamertsResponse
import br.ufrn.imd.oba.extension.toLeaningObjectFindByIdResponse
import br.ufrn.imd.oba.request.LearningObjectSearchRequest
import br.ufrn.imd.oba.response.LearningObjectFindAllByParamertsResponse
import br.ufrn.imd.oba.response.LearningObjectFindByIdResponse
import br.ufrn.imd.oba.service.LeaningObjectService
import javax.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(
    "/v1/learning_object",
    produces = [MediaType.APPLICATION_JSON_VALUE],
    consumes = [MediaType.APPLICATION_JSON_VALUE]
)
@Validated
class LearningObjectController(
    private val learningObjectService: LeaningObjectService
) {

    @GetMapping
    fun findAllByParameters(
        @PageableDefault(page = 0, size = 10, sort = ["name"]) pageable: Pageable,
        @RequestBody @Valid request: LearningObjectSearchRequest
    ): Page<LearningObjectFindAllByParamertsResponse> {
        return learningObjectService.findAllByParameters(pageable, request)
            .map {
                it.learningObjectFindAllByParamertsResponse()
            }
    }

    @GetMapping("/{learningObjectId}")
    fun findById(
        @PathVariable("learningObjectId") learningObjectId: Long
    ): LearningObjectFindByIdResponse {
        return learningObjectService.findById(learningObjectId)
        .toLeaningObjectFindByIdResponse()
    }
}
