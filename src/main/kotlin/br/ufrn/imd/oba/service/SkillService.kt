package br.ufrn.imd.oba.service

import br.ufrn.imd.oba.domain.Skill
import br.ufrn.imd.oba.repository.SkillRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class SkillService(
    private val skillRepository: SkillRepository
) {

    fun findAll(pageable: Pageable): Page<Skill> {
        return skillRepository.findAll(pageable)
    }
}
