package pl.beone.promena.transformer.converter.libreoffice.example

import pl.beone.promena.transformer.contract.transformation.Transformation
import pl.beone.promena.transformer.converter.libreoffice.applicationmodel.libreOfficeConverterTransformation

fun promena(): Transformation {
    // Data: example.txt

    return libreOfficeConverterTransformation()
}