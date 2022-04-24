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
@Table(name="descriptor")
data class Descriptor(
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "descriptor_gen")
	@SequenceGenerator(name="descriptor_gen", sequenceName = "sq_descriptor_id", allocationSize = 1)
	val id: Long = 0L,

	@Column(name = "description")
	val description: String,

	@Column(name = "code")
	val code: String,

	@ManyToOne
	@JoinColumn(name="content_theme_id")
	val contentTheme: ContentTheme = ContentTheme(),

	@ManyToMany(mappedBy="descriptors")
	val learningObjects: List<LearningObject> = listOf(),

	@ManyToOne
	@JoinColumn(name = "education_level_id")
	val educationLevel: EducationLevel = EducationLevel()
)
