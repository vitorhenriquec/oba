package br.ufrn.imd.oba.service

import br.ufrn.imd.oba.extension.toSkillResponse
import br.ufrn.imd.oba.repository.SkillRepository
import br.ufrn.imd.oba.response.SkillResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class SkillService(
    private val skillRepository: SkillRepository
) {

    fun findAll(pageable: Pageable): Page<SkillResponse> {
        return skillRepository.findAll(pageable).map {
            it.toSkillResponse()
        }
    }
}
