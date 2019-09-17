package pl.beone.promena.transformer.converter.libreoffice.example

import pl.beone.promena.transformer.contract.transformation.Transformation
import pl.beone.promena.transformer.converter.libreoffice.applicationmodel.libreOfficeConverterTransformation

fun transform(): Transformation {
    // HTTP: localhost:8080
    // Repeat: 1
    // Concurrency: 1
    // Data: example.txt

    return libreOfficeConverterTransformation()
}