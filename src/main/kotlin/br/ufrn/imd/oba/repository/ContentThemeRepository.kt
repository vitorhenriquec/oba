package br.ufrn.imd.oba.repository

import br.ufrn.imd.oba.domain.ContentTheme
import org.springframework.data.jpa.repository.JpaRepository

interface ContentThemeRepository : JpaRepository<ContentTheme, Long>{
}
