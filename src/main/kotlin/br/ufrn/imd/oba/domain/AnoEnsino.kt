package br.ufrn.imd.oba.domain;

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name="ano_ensino")
data class AnoEnsino(
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	val id: Long = 0L,

	val denominacao: String,

	val denominacaoAbreviada: String,

	@ManyToOne
	val nivelEnsino: NivelEnsino
)
