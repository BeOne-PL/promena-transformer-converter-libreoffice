package pl.beone.promena.transformer.converter.libreoffice

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import pl.beone.lib.junit.jupiter.external.DockerExtension
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_CSV
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_HTML
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_PLAIN
import pl.beone.promena.transformer.applicationmodel.mediatype.withCharset
import pl.beone.promena.transformer.converter.libreoffice.model.Resource.MediaType.Path.ISO_8859_2.Plain
import pl.beone.promena.transformer.converter.libreoffice.util.test
import java.nio.charset.Charset

@ExtendWith(DockerExtension::class)
class LibreOfficeConverterTransformerMediaTypeIso88592Test {

    companion object {
        private val charset = Charset.forName("ISO-8859-2")
    }

    @Test
    fun transform_textPlain() {
        test(Plain.TXT, TEXT_PLAIN.withCharset(charset))
    }

    @Test
    fun transform_textCsv() {
        test(Plain.CSV, TEXT_CSV.withCharset(charset))
    }

    @Test
    fun transform_LibreOfficeWriter_textPlain() {
        test(Plain.LibreOfficeWriter.TXT, TEXT_PLAIN.withCharset(charset))
    }

    // Contains charset=iso-8859-2 in meta tag. LO handles this case correctly
    @Test
    fun transform_LibreOfficeWriter_textHtml() {
        test(Plain.LibreOfficeWriter.HTML, TEXT_HTML.withCharset(charset))
    }
}