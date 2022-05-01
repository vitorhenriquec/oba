package br.ufrn.imd.oba.domain

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class LearningObjectPlataformPK(
    @Column(name="learning_object_id", nullable = false)
    val learningObjectId: Long = 0L,

    @Column(name="plataform_id", nullable = false)
    val plataformId: Long = 0L,
): Serializable
