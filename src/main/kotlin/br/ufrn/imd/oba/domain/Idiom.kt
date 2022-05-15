package br.ufrn.imd.oba.domain;

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table
import org.hibernate.annotations.Cache
import org.hibernate.annotations.CacheConcurrencyStrategy

@Entity
@Table(name="idiom")
data class Idiom (
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idiom_gen")
	@SequenceGenerator(name="idiom_gen", sequenceName = "sq_idiom_id", allocationSize = 1)
	val id: Long = 0L,

	@Column(name = "name")
	val name: String
)
