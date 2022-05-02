package br.ufrn.imd.oba.service

import br.ufrn.imd.oba.extension.toDescriptorResponse
import br.ufrn.imd.oba.repository.DescriptorRepository
import br.ufrn.imd.oba.response.DescriptorResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class DescriptorService(
    private val descriptorRepository: DescriptorRepository
) {

    fun findAll(pageable: Pageable): Page<DescriptorResponse> {
        return descriptorRepository.findAll(pageable).map {
            it.toDescriptorResponse()
        }
    }

}
