package pl.beone.promena.transformer.converter.libreoffice.applicationmodel

import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_PDF
import pl.beone.promena.transformer.converter.libreoffice.applicationmodel.LibreOfficeConverterConstants.TRANSFORMER_ID

class LibreOfficeConverterDslTest {

    @Test
    fun `libreOfficeConverterParameters _ default arguments`() {
        libreOfficeConverterParameters().getAll().size shouldBe 0
    }

    @Test
    fun `libreOfficeConverterTransformation _ default parameters`() {
        libreOfficeConverterTransformation(APPLICATION_PDF).let {
            it.transformerId shouldBe TRANSFORMER_ID
            it.targetMediaType shouldBe APPLICATION_PDF
            it.parameters.getAll().size shouldBe 0
        }
    }
}