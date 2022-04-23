package br.ufrn.imd.oba.domain;

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name="descritor", schema="public")
data class Descritor(
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	val id: Long = 0L,

	val descricao: String,

	val codigo: String,

	@ManyToOne
	@JoinColumn(name="nivelensino")
	val nivelEnsino: NivelEnsino,

	@ManyToOne
	@JoinColumn(name="temaconteudo")
	val temaConteudo: TemaConteudo,

	@ManyToMany(mappedBy="descritores")
	val objetosAprendizagem: List<ObjetoAprendizagem>
)
