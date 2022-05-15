package br.ufrn.imd.oba.service

import br.ufrn.imd.oba.domain.Curriculum
import br.ufrn.imd.oba.exception.CurriculumNotFoundException
import br.ufrn.imd.oba.repository.CurriculumRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CurriculumService(
    private val curriculumRepository: CurriculumRepository
) {
    fun findByShortName(curriculumName: String): Curriculum {
        return curriculumRepository.findByShortName(curriculumName)
            .orElseThrow{CurriculumNotFoundException()}
    }

    fun findAll(pageable: Pageable): Page<Curriculum> {
        return curriculumRepository.findAll(pageable)
    }
}
