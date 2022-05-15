package br.ufrn.imd.oba.service

import br.ufrn.imd.oba.domain.ContentTheme
import br.ufrn.imd.oba.repository.ContentThemeRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ContentThemeService(
    private val contentThemeRepository: ContentThemeRepository
) {
    fun findAllByCurriculumId(
        curriculumId: Long,
        pageable: Pageable
    ): Page<ContentTheme> {
        return contentThemeRepository.findAllByCurriculumId(
            curriculumId,
            pageable
        )
    }
}
