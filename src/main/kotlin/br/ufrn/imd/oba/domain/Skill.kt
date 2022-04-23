package br.ufrn.imd.oba.domain;

import javax.persistence.Column
import javax.persistence.Entity
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
@Table(name="skill")
data class Skill (

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skill_gen")
	@SequenceGenerator(name="skill_gen", sequenceName = "sq_skill_id", allocationSize = 1)
	val id: Long = 0L,

	@Column(columnDefinition="text", name = "description")
	val description: String,

	@Column(columnDefinition="text", name = "acquirements")
	val acquirements: String,

	@Column(name = "code")
	val code: String,

	@ManyToOne
	@JoinColumn(name="content_theme_id")
	val contentTheme: ContentTheme,

	@OneToOne
	val educationYear: EducationYear,

	@ManyToMany(mappedBy="skills")
	val learningObjects: List<LearningObject>
)
