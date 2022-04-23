package br.ufrn.imd.oba.domain;

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="tipo_licenca_uso")
data class TipoLicencaUso (
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	val id: Long = 0L,

	val nome: String,

	val versao: String,
)
