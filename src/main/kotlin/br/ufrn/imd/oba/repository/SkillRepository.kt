package br.ufrn.imd.oba.repository

import br.ufrn.imd.oba.domain.Skill
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository: JpaRepository<Skill, Long> {
}
