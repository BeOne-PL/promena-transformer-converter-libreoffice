package pl.beone.promena.transformer.converter.libreoffice.example

import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_PDF
import pl.beone.promena.transformer.contract.transformation.Transformation
import pl.beone.promena.transformer.converter.libreoffice.applicationmodel.libreOfficeConverterTransformation
import pl.beone.promena.transformer.internal.model.parameters.emptyParameters

fun promena(): Transformation {
    // Data: example.txt

    return libreOfficeConverterTransformation(APPLICATION_PDF, emptyParameters())
}