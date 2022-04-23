package br.ufrn.imd.oba.domain;

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name="ano_ensino")
data class AnoEnsino(
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ano_ensino_gen")
	@SequenceGenerator(name="ano_ensino_gen", sequenceName = "sq_ano_ensino_id", allocationSize = 1)
	val id: Long = 0L,

	@Column(name = "nome")
	val nome: String,

	@ManyToOne
	val nivelEnsino: NivelEnsino
)
