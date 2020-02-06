package pl.beone.promena.transformer.converter.libreoffice.applicationmodel

import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_PDF
import pl.beone.promena.transformer.converter.libreoffice.applicationmodel.LibreOfficeConverterConstants.TRANSFORMER_ID
import pl.beone.promena.transformer.internal.model.parameters.emptyParameters

class LibreOfficeConverterDslTest {

    @Test
    fun libreOfficeConverterTransformation_() {
        with(libreOfficeConverterTransformation(APPLICATION_PDF, emptyParameters())) {
            transformerId shouldBe TRANSFORMER_ID
            targetMediaType shouldBe APPLICATION_PDF
            parameters.getAll().size shouldBe 0
        }
    }
}