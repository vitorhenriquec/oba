package br.ufrn.imd.oba.service

import br.ufrn.imd.oba.domain.LearningObject
import br.ufrn.imd.oba.exception.LearningObjectNotFoundException
import br.ufrn.imd.oba.extension.learningObjectFindAllByParamertsResponse
import br.ufrn.imd.oba.extension.toLeaningObjectFindByIdResponse
import br.ufrn.imd.oba.repository.LearningObjectRepository
import br.ufrn.imd.oba.request.LearningObjectSearchRequest
import br.ufrn.imd.oba.response.LearningObjectFindAllByParamertsResponse
import br.ufrn.imd.oba.response.LearningObjectFindByIdResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.support.AbstractBeanFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

@Component
abstract class AbstractLeaningObjectService(
    private val learningObjectRepository: LearningObjectRepository
) {
    @Autowired
    private lateinit var beanFactory: AbstractBeanFactory

    @Autowired
    private lateinit var curriculumService: CurriculumService

    final fun findAllByParameters(
        pageable: Pageable,
        learningObjectSearchRequest: LearningObjectSearchRequest
    ): Page<LearningObjectFindAllByParamertsResponse> {
        val curriculumName = learningObjectSearchRequest.curriculumShortName

        return if (!curriculumName.isNullOrBlank()) {
            curriculumService.findByShortName(curriculumName).let {
               (beanFactory.getBean("${curriculumName}-LearningObjectService") as AbstractLeaningObjectService).findParamertersByCurriculum(
                   learningObjectSearchRequest,
                   pageable
               )
            }
        } else {
            (beanFactory.getBean("BNCC-LearningObjectService") as AbstractLeaningObjectService).findParamertersByCurriculum(
                learningObjectSearchRequest,
                pageable
            )
        }.map {
            it.learningObjectFindAllByParamertsResponse()
        }
    }

    abstract fun findParamertersByCurriculum(
        learningObjectSearchRequest: LearningObjectSearchRequest,
        pageable: Pageable
    ): Page<LearningObject>

    final fun findById(learningObjectId:Long): LearningObjectFindByIdResponse {
        return learningObjectRepository.findById(learningObjectId)
            .orElseThrow{ LearningObjectNotFoundException() }.toLeaningObjectFindByIdResponse()
    }
}
