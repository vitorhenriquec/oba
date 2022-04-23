package br.ufrn.imd.oba.domain

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name="objeto_aprendizagem")
data class ObjetoAprendizagem(
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "objeto_aprendizagem_gen")
	@SequenceGenerator(name="objeto_aprendizagem_gen", sequenceName = "sq_objeto_aprendizagem_id", allocationSize = 1)
	val id: Long = 0L,
	
	@Column(name="nome")
	val nome: String,
	
	@Column(name="descricao", columnDefinition="text")
	val descricao: String,
	
	@Column(name="quantidade_acessos")
	val qtdAcessos: Int,
	
	@Column(name="link", columnDefinition="text")
	val link: String,
	
	@Column(name="path_arquivo")
	val pathArquivo: String,
	
	@Column(name="data_lancamento")
	val dataLancamento: LocalDateTime,
	
	@JoinColumn(name="id_tipo_objeto")
	@ManyToOne
	val tipoObjeto: TipoObjeto,

	@Column(name="versao")
	val versao: String,

	@Column(name="ativo")
	val ativo: Boolean,
	
	@Column(name="tipo_visualizacao")
	@Enumerated(EnumType.STRING)
	val tipoVisualizacao: TipoVisualizacao,
	
	@ManyToMany
	@JoinTable(name="objetoaprendizagem_idioma")
	val idioma: List<Idioma>,
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="objetoaprendizagem_autormantenedor")
	val autoresMantenedores: List<AutorMantenedor>,
	
	@JoinColumn(name="id_plataforma")
	@ManyToOne
	val plataforma: Plataforma,
	
	@JoinColumn(name="id_tipo_licenca_uso")
	@ManyToOne
	val licencaDeUso: TipoLicencaUso,

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="objetoaprendizagem_descritor",
		schema="public",
		joinColumns = [JoinColumn(name="objetoaprendizagem", referencedColumnName="id")],
	    inverseJoinColumns=[JoinColumn(name="descritor_id", referencedColumnName="id")]
	)
	val descritores: Set<Descritor>,
)
