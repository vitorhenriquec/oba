package br.ufrn.imd.oba.domain;

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "curriculum")
data class Curriculum(
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curriculum_gen")
	@SequenceGenerator(name="curriculum_gen", sequenceName = "sq_curriculum_id", allocationSize = 1)
	val id: Long = 0L,

	@Column(name = "short_name")
	val shortName: String,

	@Column(name = "full_name")
	val fullName: String,
)
