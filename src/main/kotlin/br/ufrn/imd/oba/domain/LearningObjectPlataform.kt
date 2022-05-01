package br.ufrn.imd.oba.domain

import javax.persistence.Column
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.MapsId
import javax.persistence.Table


@Entity
@Table(name = "learning_object_plataform")
data class LearningObjectPlataform (
    @EmbeddedId
    val id: LearningObjectPlataformPK = LearningObjectPlataformPK(),

    @Column(name="access_type", nullable = false)
    @Enumerated(EnumType.STRING)
    val accessType: AccessType = AccessType.WEB,

    @Column(name="link", columnDefinition="text", nullable = false)
    val link: String = "",

    @ManyToOne
    @MapsId("learning_object_id")
    @JoinColumn(name="learning_object_id")
    val learningObject: LearningObject = LearningObject(),

    @ManyToOne
    @MapsId("plataform_id")
    @JoinColumn(name="plataform_id")
    val plataform: Plataform = Plataform()
)
