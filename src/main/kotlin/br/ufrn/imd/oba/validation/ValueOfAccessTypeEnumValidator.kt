package br.ufrn.imd.oba.validation

import br.ufrn.imd.oba.domain.AccessType
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class ValueOfAccessTypeEnumValidator: ConstraintValidator<ValueOfAccessTypeEnum, String> {

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if(value == null){
            return true
        }

        return try {
            AccessType.valueOf(value)
            true
        } catch (ex: Exception) {
            false
        }
    }
}
