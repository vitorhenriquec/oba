package br.ufrn.imd.oba.service

import br.ufrn.imd.oba.extension.toLearningObjectSearchResponse
import br.ufrn.imd.oba.repository.LearningObjectRepository
import br.ufrn.imd.oba.request.LearningObjectSearchRequest
import br.ufrn.imd.oba.response.LearningObjectSearchResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class LearningObjectService(
    private val learningObjectRepository: LearningObjectRepository,
    private val curriculumService: CurriculumService
) {

    fun search(
        pageable: Pageable,
        learningObjectSearchRequest: LearningObjectSearchRequest
    ): Page<LearningObjectSearchResponse> {
        val curriculumName = learningObjectSearchRequest.curriculumShortName

        return if (!curriculumName.isNullOrBlank()) {
            curriculumService.findByShortName(curriculumName).let {

               when(curriculumName){
                   "PCN" -> learningObjectRepository.findAllActiveByNameAndViewTypeAndEducationLevelIdAndContentThemeIdAndSkillId(
                       name= learningObjectSearchRequest.name,
                       viewType = learningObjectSearchRequest.viewType,
                       educationLevelId = learningObjectSearchRequest.educationLevelId,
                       contentThemeId = learningObjectSearchRequest.contentThemeId,
                       skillId = learningObjectSearchRequest.skillId,
                       pageable
                   )
                   else ->
                       learningObjectRepository.findAllActiveByNameAndViewTypeAndEducationLevelIdAndContentThemeIdAndDescriptorId(
                           name= learningObjectSearchRequest.name,
                           viewType = learningObjectSearchRequest.viewType,
                           educationLevelId = learningObjectSearchRequest.educationLevelId,
                           contentThemeId = learningObjectSearchRequest.contentThemeId,
                           descriptorId = learningObjectSearchRequest.descriptorId,
                           pageable
                       )
               }
           }
        } else {
            learningObjectRepository.findAllActiveByNameAndViewTypeAndEducationLevelIdAndContentThemeIdAndDescriptorId(
                name= learningObjectSearchRequest.name,
                viewType = learningObjectSearchRequest.viewType,
                educationLevelId = learningObjectSearchRequest.educationLevelId,
                contentThemeId = learningObjectSearchRequest.contentThemeId,
                descriptorId = learningObjectSearchRequest.descriptorId,
                pageable
            )
        }.map {
            it.toLearningObjectSearchResponse()
        }
    }
}
