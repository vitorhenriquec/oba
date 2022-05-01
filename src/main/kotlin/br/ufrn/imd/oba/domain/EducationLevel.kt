package br.ufrn.imd.oba.domain;

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.SequenceGenerator
import javax.persistence.Table
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode

@Entity
@Table(name="education_level")
data class EducationLevel(
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "education_level_gen")
	@SequenceGenerator(name="education_level_gen", sequenceName = "sq_education_level_id", allocationSize = 1)
	val id: Long = 0L,

	@Column(name = "name")
	val name: String = "",

	@Column(name = "short_name")
	val shortName: String = "",
)
