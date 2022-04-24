package br.ufrn.imd.oba.domain;

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name="object_type")
data class ObjectType (
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "object_type_gen")
	@SequenceGenerator(name="object_type_gen", sequenceName = "sq_object_type_id", allocationSize = 1)
	val id: Long = 0L,

	@Column(name = "name")
	val name: String = ""
)
