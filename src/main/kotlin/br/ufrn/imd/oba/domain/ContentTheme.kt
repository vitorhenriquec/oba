package br.ufrn.imd.oba.domain;

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
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
@Table(name="content_theme")
data class ContentTheme (

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "content_theme_gen")
	@SequenceGenerator(name="content_theme_gen", sequenceName = "sq_content_theme_id", allocationSize = 1)
	val id: Long = 0L,

	@Column(name = "name")
	val name: String = "",

	@ManyToOne
	@JoinColumn(referencedColumnName="id", name="subject_id")
	val subject: Subject = Subject(),

	@OneToMany(mappedBy = "contentTheme", cascade = [CascadeType.ALL])
	val skills: Set<Skill> = emptySet(),

	@OneToOne
	val curriculo: Curriculum = Curriculum(),
)
