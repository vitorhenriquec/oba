package br.ufrn.imd.oba.domain

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name="learning_object")
data class LearningObject(
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "learning_object_gen")
	@SequenceGenerator(name="learning_object_gen", sequenceName = "sq_learning_object_id", allocationSize = 1)
	val id: Long = 0L,

	@Column(name="name")
	val name: String = "",

	@Column(name="description", columnDefinition="text")
	val description: String = "",

	@Column(name="accesses_number")
	val accessesNumber: Int = 0,

	@Column(name="link", columnDefinition="text")
	val link: String = "",

	@Column(name="thumbnail_path")
	val thumbnailPath: String = "",

	@Column(name="release_date")
	val releaseDate: LocalDateTime = LocalDateTime.now(),

	@JoinColumn(name="object_type_id")
	@ManyToOne
	val objectType: ObjectType = ObjectType(),

	@Column(name="version")
	val version: String = "",

	@Column(name="active")
	val active: Boolean = false,

	@Column(name="view_type")
	@Enumerated(EnumType.STRING)
	val viewType: ViewType = ViewType.DESKTOP_WEB,

	@ManyToMany
	@JoinTable(
		name="learning_object_idiom",
		joinColumns = [javax.persistence.JoinColumn(name = "learning_object_id", referencedColumnName = "id")],
		inverseJoinColumns=[JoinColumn(name="idiom_id", referencedColumnName="id")]
	)
	val idiom: Set<Idiom> = setOf(),

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="learning_object_maintaining_author",
		joinColumns = [javax.persistence.JoinColumn(name = "learning_object_id", referencedColumnName = "id")],
		inverseJoinColumns=[JoinColumn(name="maintaining_author_id", referencedColumnName="id")]
	)
	val maintainingAuthors: Set<MaintainingAuthor> = setOf(),

	@JoinColumn(name="plataform_id")
	@ManyToOne
	val plataform: Plataform = Plataform(),

	@JoinColumn(name="use_license_type_id")
	@ManyToOne
	val licencaDeUso: UseLicenseType = UseLicenseType(),

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="learning_object_descriptor",
		joinColumns = [JoinColumn(name="learning_object_id", referencedColumnName="id")],
	    inverseJoinColumns=[JoinColumn(name="descriptor_id", referencedColumnName="id")]
	)
	val descriptors: Set<Descriptor> = setOf(),

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="learning_object_skill",
		joinColumns = [JoinColumn(name="learning_object_id", referencedColumnName="id")],
		inverseJoinColumns=[JoinColumn(name="skill_id", referencedColumnName="id")]
	)
	val skills: Set<Skill> = setOf()
)
