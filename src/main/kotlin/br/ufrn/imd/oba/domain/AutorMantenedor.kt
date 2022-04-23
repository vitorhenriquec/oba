package br.ufrn.imd.oba.domain;

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "auto_mantenedor")
data class AutorMantenedor (
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auto_mantenedor_gen")
	@SequenceGenerator(name="auto_mantenedor_gen", sequenceName = "sq_auto_mantenedor_id", allocationSize = 1)
	val id: Long = 0L,

	@Column(name = "nome")
	val nome: String,

	@Column(name = "email")
	val email: String,

	@Column(name = "site")
	val site: String
)
