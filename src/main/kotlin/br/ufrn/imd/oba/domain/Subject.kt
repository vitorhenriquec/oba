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
@Table(name="subject")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
data class Subject (
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_gen")
	@SequenceGenerator(name="subject_gen", sequenceName = "sq_subject_id", allocationSize = 1)
	val id: Long = 0L,

	@Column(name = "name")
	val name: String = ""
)
