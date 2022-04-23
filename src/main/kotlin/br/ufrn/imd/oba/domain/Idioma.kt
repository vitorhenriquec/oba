package br.ufrn.imd.oba.domain;

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="idioma")
data class Idioma (
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	val id: Long = 0L,

	val nome: String
)
