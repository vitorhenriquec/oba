package br.ufrn.imd.oba.repository

import br.ufrn.imd.oba.domain.Descriptor
import org.springframework.data.jpa.repository.JpaRepository

interface DescriptorRepository: JpaRepository<Descriptor, Long> {
}
