package br.ufrn.imd.oba.domain;

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name="idioma")
data class Idioma (
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idioma_gen")
	@SequenceGenerator(name="idioma_gen", sequenceName = "sq_idioma_id", allocationSize = 1)
	val id: Long = 0L,

	@Column(name = "nome")
	val nome: String
)
