package br.ufrn.imd.oba.domain;

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name="nivel_ensino")
data class NivelEnsino(
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nivel_ensino_gen")
	@SequenceGenerator(name="nivel_ensino_gen", sequenceName = "sq_nivel_ensino_id", allocationSize = 1)
	val id: Long = 0L,

	@Column(name = "nome")
	val nome: String,

	@Column(name = "nome_abreviado")
	val nomeAbreviado: String,

	@OneToMany(mappedBy = "nivelEnsino", cascade = [CascadeType.ALL])
	val anosEnsino: Set<AnoEnsino>
)
