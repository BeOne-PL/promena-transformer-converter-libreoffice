package pl.beone.promena.transformer.converter.libreoffice

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import pl.beone.lib.junit5.extension.docker.external.DockerExtension
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_PLAIN
import pl.beone.promena.transformer.converter.libreoffice.model.Resource
import pl.beone.promena.transformer.converter.libreoffice.util.getResourceAsBytes

@ExtendWith(DockerExtension::class)
class LibreOfficeConverterTransformerTest {

    @Test
    fun transform_fromTextPlainUTF8ToApplicationPdfUTF8() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Plain.TXT),
            TEXT_PLAIN
        )
    }
}