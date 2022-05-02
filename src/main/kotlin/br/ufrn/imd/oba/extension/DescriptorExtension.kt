package br.ufrn.imd.oba.extension

import br.ufrn.imd.oba.domain.Descriptor
import br.ufrn.imd.oba.response.DescriptorResponse

fun Descriptor.toDescriptorResponse(): DescriptorResponse {
    return DescriptorResponse(
        id = id,
        description = description,
        code = code,
        shortName = educationLevel.shortName
    )
}
