package br.ufrn.imd.oba.domain;

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name="nivelensino")
data class NivelEnsino(
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	val id: Long = 0L,

	val nome: String,

	val nomeAbreviado: String,

	@OneToMany(mappedBy = "nivelEnsino", cascade = [CascadeType.ALL])
	val anosEnsino: Set<AnoEnsino>
)
