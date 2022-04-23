package br.ufrn.imd.oba.domain;

import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name="tema_conteudo")
data class TemaConteudo (

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	val id: Long = 0L,
	
	val nome: String,
	
	@ManyToOne
	@JoinColumn(referencedColumnName="id", name="disciplina")
	val disciplina: Disciplina,
	
	@OneToOne
	val curriculo: Curriculo,
)
