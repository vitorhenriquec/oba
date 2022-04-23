package br.ufrn.imd.oba.domain;

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name="disciplina", schema="public")
data class Disciplina (
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disciplina_gen")
	@SequenceGenerator(name="disciplina_gen", sequenceName = "sq_disciplina_id", allocationSize = 1)
	val id: Long = 0L,

	@Column(name = "nome")
	val nome: String
)
