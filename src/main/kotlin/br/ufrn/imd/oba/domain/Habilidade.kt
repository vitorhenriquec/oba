package br.ufrn.imd.oba.domain;

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.OneToOne
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name="habilidade", schema="public")
data class Habilidade (
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "habilidade_gen")
	@SequenceGenerator(name="habilidade_gen", sequenceName = "sq_habilidade_id", allocationSize = 1)
	val id: Long = 0L,
	
	@Column(columnDefinition="text", name = "descricao")
	val descricao: String,
	
	@Column(columnDefinition="text", name = "conhecimentos")
	val conhecimentos: String,

	@Column(name = "código")
	val codigo: String,
	
	@ManyToOne
	@JoinColumn(name="temaConteudo")
	val temaConteudo: TemaConteudo,

	@OneToOne
	val anoEnsino: AnoEnsino,
)
