package br.ufrn.imd.oba.domain;

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name="tema_conteudo")
data class TemaConteudo (

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tema_conteudo_gen")
	@SequenceGenerator(name="tema_conteudo_gen", sequenceName = "sq_tema_conteudo_id", allocationSize = 1)
	val id: Long = 0L,

	@Column(name = "nome")
	val nome: String,
	
	@ManyToOne
	@JoinColumn(referencedColumnName="id", name="disciplina")
	val disciplina: Disciplina,

	@OneToMany(mappedBy = "temaConteudo", cascade = [CascadeType.ALL])
	val habilidades: Set<Habilidade>,
	
	@OneToOne
	val curriculo: Curriculo,
)
