package br.ufrn.imd.oba.service

import br.ufrn.imd.oba.domain.AccessType
import br.ufrn.imd.oba.domain.LearningObject
import br.ufrn.imd.oba.repository.LearningObjectRepository
import br.ufrn.imd.oba.request.LearningObjectSearchRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service("BNCC-LearningObjectService")
class BNCCLearningObjectService(
    private val learningObjectRepository: LearningObjectRepository
): AbstractCurriculumLearningObject {
    override fun findByAllParamertersForCurriculum(
        learningObjectSearchRequest: LearningObjectSearchRequest,
        pageable: Pageable
    ): Page<LearningObject> =
        learningObjectRepository.findAllActiveByNameAndViewTypeAndEducationLevelIdAndContentThemeIdAndDescriptorId(
            name= learningObjectSearchRequest.name,
            accessType = learningObjectSearchRequest.accessType?.let { AccessType.valueOf(it)},
            educationLevelId = learningObjectSearchRequest.educationLevelId,
            contentThemeId = learningObjectSearchRequest.contentThemeId,
            descriptorId = learningObjectSearchRequest.descriptorId,
            pageable
        )



}
