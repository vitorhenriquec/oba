package br.ufrn.imd.oba.domain;

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name="use_license_type")
data class UseLicenseType (
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "use_license_type_gen")
	@SequenceGenerator(name="use_license_type_gen", sequenceName = "sq_use_license_type_id", allocationSize = 1)
	val id: Long = 0L,

	@Column(name = "name")
	val name: String = "",

	@Column(name = "version")
	val version: String = "",
)
