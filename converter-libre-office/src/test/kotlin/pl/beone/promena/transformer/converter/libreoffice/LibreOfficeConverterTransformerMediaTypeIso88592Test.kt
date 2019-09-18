package pl.beone.promena.transformer.converter.libreoffice

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import pl.beone.lib.junit5.extension.docker.external.DockerExtension
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaType
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_HTML
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_PLAIN
import pl.beone.promena.transformer.converter.libreoffice.model.Resource
import pl.beone.promena.transformer.converter.libreoffice.util.getResourceAsBytes
import java.nio.charset.Charset

@ExtendWith(DockerExtension::class)
class LibreOfficeConverterTransformerMediaTypeIso88592Test {

    @Test
    fun transform_textPlain() {
        memoryTest(
            getResourceAsBytes(Resource.Path.ISO_8859_2.Plain.TXT),
            MediaType.of(TEXT_PLAIN.mimeType, Charset.forName("ISO-8859-2"))
        )
    }

    // Contains also charset=iso-8859-2 in meta tag. LO handles this case correctly
    @Test
    fun transform_textHtml() {
        memoryTest(
            getResourceAsBytes(Resource.Path.ISO_8859_2.Plain.COMPLEX_HTML),
            MediaType.of(TEXT_HTML.mimeType, Charset.forName("ISO-8859-2"))
        )
    }
}