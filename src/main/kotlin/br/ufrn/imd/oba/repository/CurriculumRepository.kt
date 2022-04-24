package br.ufrn.imd.oba.repository

import br.ufrn.imd.oba.domain.Curriculum
import java.util.Optional
import org.springframework.data.jpa.repository.JpaRepository

interface CurriculumRepository: JpaRepository<Curriculum, Long> {

    fun findByShortName(name: String): Optional<Curriculum>
}
