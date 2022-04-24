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

@Service
class LearningObjectService(
    private val learningObjectRepository: LearningObjectRepository,
    private val curriculumService: CurriculumService
) {

    fun findAllByParameters(
        pageable: Pageable,
        learningObjectSearchRequest: LearningObjectSearchRequest
    ): Page<LearningObjectFindAllByParamertsResponse> {
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
            it.learningObjectFindAllByParamertsResponse()
        }
    }

    fun findById(learningObjectId:Long): LearningObjectFindByIdResponse{
        return learningObjectRepository.findById(learningObjectId)
            .orElseThrow{LearningObjectNotFoundException()}.toLeaningObjectFindByIdResponse()
    }

}
