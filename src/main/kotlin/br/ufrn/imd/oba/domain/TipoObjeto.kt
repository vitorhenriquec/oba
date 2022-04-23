package br.ufrn.imd.oba.domain;

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name="tipo_objeto")
data class TipoObjeto (
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_objeto_gen")
	@SequenceGenerator(name="tipo_objeto_gen", sequenceName = "sq_tipo_objeto_id", allocationSize = 1)
	val id: Long = 0L,

	@Column(name = "nome")
	val nome: String
)
