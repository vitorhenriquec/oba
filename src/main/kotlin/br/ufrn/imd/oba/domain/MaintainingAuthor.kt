package br.ufrn.imd.oba.domain;

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "maintaining_author")
data class MaintainingAuthor (
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "maintaining_author_gen")
	@SequenceGenerator(name="maintaining_author_gen", sequenceName = "sq_maintaining_author_id", allocationSize = 1)
	val id: Long = 0L,

	@Column(name = "name")
	val name: String = "",

	@Column(name = "email")
	val email: String = "",

	@Column(name = "site")
	val site: String = ""
)
