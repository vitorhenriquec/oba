package br.ufrn.imd.oba.domain;

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "curriculo")
data class Curriculo(
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curriculo_gen")
	@SequenceGenerator(name="curriculo_gen", sequenceName = "sq_curriculo_id", allocationSize = 1)
	val id: Long = 0L,

	@Column(name = "nome_abreviado")
	val nomeAbreviado: String,

	@Column(name = "nome_completo")
	val nomeCompleto: String,
)
