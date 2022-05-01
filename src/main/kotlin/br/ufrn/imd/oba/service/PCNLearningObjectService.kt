package br.ufrn.imd.oba.service

import br.ufrn.imd.oba.domain.LearningObject
import br.ufrn.imd.oba.exception.LearningObjectNotFoundException
import br.ufrn.imd.oba.extension.learningObjectFindAllByParamertsResponse
import br.ufrn.imd.oba.extension.toLeaningObjectFindByIdResponse
import br.ufrn.imd.oba.repository.LearningObjectRepository
import br.ufrn.imd.oba.request.LearningObjectSearchRequest
import br.ufrn.imd.oba.response.LearningObjectFindAllByParamertsResponse
import br.ufrn.imd.oba.response.LearningObjectFindByIdResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service("PCN-LearningObjectService")
class PCNLearningObjectService(
    private val learningObjectRepository: LearningObjectRepository
): AbstractLeaningObjectService(
    learningObjectRepository
) {
    override fun findParamertersByCurriculum(
        learningObjectSearchRequest: LearningObjectSearchRequest,
        pageable: Pageable
    ): Page<LearningObject> = learningObjectRepository.findAllActiveByNameAndViewTypeAndEducationLevelIdAndContentThemeIdAndSkillId(
            name= learningObjectSearchRequest.name,
            accessType=learningObjectSearchRequest.accessType,
            educationLevelId = learningObjectSearchRequest.educationLevelId,
            contentThemeId = learningObjectSearchRequest.contentThemeId,
            skillId = learningObjectSearchRequest.skillId,
            pageable
        )
}
