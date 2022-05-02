package br.ufrn.imd.oba.service

import br.ufrn.imd.oba.extension.toContentThemeResponse
import br.ufrn.imd.oba.repository.ContentThemeRepository
import br.ufrn.imd.oba.response.ContentThemeResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ContentThemeService(
    private val contentThemeRepository: ContentThemeRepository
) {
    fun findAll(pageable: Pageable): Page<ContentThemeResponse> {
        return contentThemeRepository.findAll(pageable).map {
            it.toContentThemeResponse()
        }
    }
}
