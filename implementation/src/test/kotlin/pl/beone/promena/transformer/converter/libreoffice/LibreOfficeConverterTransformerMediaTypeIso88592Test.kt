package pl.beone.promena.transformer.converter.libreoffice

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import pl.beone.lib.junit.jupiter.external.DockerExtension
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaType
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_CSV
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_HTML
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_PLAIN
import pl.beone.promena.transformer.converter.libreoffice.model.Resource
import pl.beone.promena.transformer.converter.libreoffice.util.getResourceAsBytes
import java.nio.charset.Charset

@ExtendWith(DockerExtension::class)
class LibreOfficeConverterTransformerMediaTypeIso88592Test {

    companion object {
        private val charset = Charset.forName("ISO-8859-2")
    }

    @Test
    fun transform_textPlain() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.ISO_8859_2.Plain.TXT),
            MediaType.of(TEXT_PLAIN.mimeType, charset)
        )
    }

    @Test
    fun transform_textCsv() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.ISO_8859_2.Plain.CSV),
            MediaType.of(TEXT_CSV.mimeType, charset)
        )
    }

    @Test
    fun transform_LibreOfficeWriter_textPlain() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.ISO_8859_2.Plain.LibreOfficeWriter.TXT),
            MediaType.of(TEXT_PLAIN.mimeType, charset)
        )
    }

    // Contains charset=iso-8859-2 in meta tag. LO handles this case correctly
    @Test
    fun transform_LibreOfficeWriter_textHtml() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.ISO_8859_2.Plain.LibreOfficeWriter.HTML),
            MediaType.of(TEXT_HTML.mimeType, charset)
        )
    }
}