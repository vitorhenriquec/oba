package br.ufrn.imd.oba.service

import br.ufrn.imd.oba.domain.Descriptor
import br.ufrn.imd.oba.repository.DescriptorRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class DescriptorService(
    private val descriptorRepository: DescriptorRepository
) {

    fun findAll(pageable: Pageable): Page<Descriptor> {
        return descriptorRepository.findAll(pageable)
    }

}
