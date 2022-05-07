package br.ufrn.imd.oba.service

import br.ufrn.imd.oba.domain.LearningObject
import br.ufrn.imd.oba.exception.LearningObjectNotFoundException
import br.ufrn.imd.oba.extension.learningObjectFindAllByParamertsResponse
import br.ufrn.imd.oba.extension.toLeaningObjectFindByIdResponse
import br.ufrn.imd.oba.repository.LearningObjectRepository
import br.ufrn.imd.oba.request.LearningObjectSearchRequest
import br.ufrn.imd.oba.response.LearningObjectFindAllByParamertsResponse
import br.ufrn.imd.oba.response.LearningObjectFindByIdResponse
import org.springframework.beans.factory.support.AbstractBeanFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class LeaningObjectService(
    private val learningObjectRepository: LearningObjectRepository,
    private val curriculumService: CurriculumService,
    private val beanFactory: AbstractBeanFactory
) {
    companion object {
        private const val defaultCurriculumForSeach = "BNCC"
    }

    fun findAllByParameters(
        pageable: Pageable,
        learningObjectSearchRequest: LearningObjectSearchRequest
    ): Page<LearningObject> {
        val curriculumName = learningObjectSearchRequest.curriculumShortName

        val searchForCurriculum = !curriculumName.isNullOrBlank()

        val beanNameToCall = if (searchForCurriculum) { curriculumName } else { defaultCurriculumForSeach }

        return curriculumService.findByShortName(curriculumName!!).let {
                (beanFactory.getBean("${beanNameToCall}-LearningObjectService") as AbstractCurriculumLearningObject)
                    .findByAllParamertersForCurriculum(
                        learningObjectSearchRequest,
                        pageable
                    )
        }
    }

    fun findById(learningObjectId:Long): LearningObject {
        return learningObjectRepository.findById(learningObjectId)
            .orElseThrow{ LearningObjectNotFoundException() }
    }
}
