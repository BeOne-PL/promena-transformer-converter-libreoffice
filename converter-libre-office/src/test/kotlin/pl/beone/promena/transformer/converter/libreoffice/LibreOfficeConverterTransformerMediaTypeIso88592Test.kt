package pl.beone.promena.transformer.converter.libreoffice

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import pl.beone.lib.junit5.extension.docker.external.DockerExtension
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaType
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_PLAIN
import pl.beone.promena.transformer.converter.libreoffice.model.Resource
import pl.beone.promena.transformer.converter.libreoffice.util.getResourceAsBytes
import java.nio.charset.Charset

@ExtendWith(DockerExtension::class)
class LibreOfficeConverterTransformerMediaTypeIso88592Test {

    @Test
    fun transform_fromTextPlainToApplicationPdf() {
        memoryTest(
            getResourceAsBytes(Resource.Path.ISO_8859_2.Plain.TXT),
            MediaType.of(TEXT_PLAIN.mimeType, Charset.forName("ISO-8859-2"))
        )
    }

    @Test
    fun transform_fromTextXmlWithTagsToApplicationPdf() {
        memoryTest(
            getResourceAsBytes(Resource.Path.ISO_8859_2.Plain.XML_WITH_TAGS),
            MediaTypeConstants.TEXT_XML
        )
    }
}