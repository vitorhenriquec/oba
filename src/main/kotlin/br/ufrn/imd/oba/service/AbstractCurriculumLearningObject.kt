package br.ufrn.imd.oba.service

import br.ufrn.imd.oba.domain.LearningObject
import br.ufrn.imd.oba.request.LearningObjectSearchRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface AbstractCurriculumLearningObject {
    fun findParamertersByCurriculum(
        learningObjectSearchRequest: LearningObjectSearchRequest,
        pageable: Pageable
    ): Page<LearningObject>
}
