package br.ufrn.imd.oba.repository

import br.ufrn.imd.oba.domain.LearningObject
import org.springframework.data.jpa.repository.JpaRepository

interface LearningObjectRepository: JpaRepository<LearningObject, Long> {
}
