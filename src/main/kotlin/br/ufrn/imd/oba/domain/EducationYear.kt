package br.ufrn.imd.oba.domain;

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name="education_year")
data class EducationYear(
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "education_year_gen")
	@SequenceGenerator(name="education_year_gen", sequenceName = "sq_education_year_id", allocationSize = 1)
	val id: Long = 0L,

	@Column(name = "name")
	val name: String,

	@ManyToOne
	@JoinColumn(referencedColumnName="id", name="education_level_id")
	val educationLevel: EducationLevel
)
