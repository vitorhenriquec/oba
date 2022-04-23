package br.ufrn.imd.oba.domain;

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name="descritor", schema="public")
data class Descritor(
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "descritor_gen")
	@SequenceGenerator(name="descritor_gen", sequenceName = "sq_descritor_id", allocationSize = 1)
	val id: Long = 0L,

	@Column(name = "descricao")
	val descricao: String,

	@Column(name = "código")
	val codigo: String,

	@ManyToOne
	@JoinColumn(name="temaConteudo")
	val temaConteudo: TemaConteudo,

	@ManyToMany(mappedBy="descritores")
	val objetosAprendizagem: List<ObjetoAprendizagem>
)
