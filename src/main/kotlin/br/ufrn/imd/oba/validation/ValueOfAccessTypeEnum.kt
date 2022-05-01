package br.ufrn.imd.oba.validation

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [ValueOfAccessTypeEnumValidator::class])
annotation class ValueOfAccessTypeEnum(
    val message: String = "Invalid access_type",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<Payload>> = [],
    val enumClass: KClass<out Enum<*>>
)
