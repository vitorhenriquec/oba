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
import javax.persistence.Table

@Entity
@Table(name="habilidade", schema="public")
data class Habilidade (
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	val id: Long = 0L,
	
	@Column(columnDefinition="text")
	val descricao: String,
	
	@Column(columnDefinition="text")
	val conhecimentos: String,

	val codigo: String,
	
	@ManyToOne
	@JoinColumn(name="nivelensino")
	val nivelEnsino: NivelEnsino,
	
	@ManyToOne
	@JoinColumn(name="temaconteudo")
	val temaConteudo: TemaConteudo,

	@OneToOne
	val anoEnsino: AnoEnsino,

	@ManyToMany(mappedBy="descritores")
	val objetosAprendizagem: List<ObjetoAprendizagem>
)
