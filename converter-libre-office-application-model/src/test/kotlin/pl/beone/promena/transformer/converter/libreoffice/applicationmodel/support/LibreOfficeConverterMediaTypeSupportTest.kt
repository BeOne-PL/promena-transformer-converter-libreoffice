package pl.beone.promena.transformer.converter.libreoffice.applicationmodel.support

import io.kotlintest.shouldNotThrow
import io.kotlintest.shouldThrow
import org.junit.jupiter.api.Test
import pl.beone.promena.transformer.applicationmodel.exception.transformer.TransformationNotSupportedException
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_MSWORD
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_PDF
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_CSV
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.VIDEO_WEBM
import pl.beone.promena.transformer.applicationmodel.mediatype.mediaType
import pl.beone.promena.transformer.converter.libreoffice.applicationmodel.LibreOfficeConverterSupport.MediaTypeSupport.isSupported
import kotlin.text.Charsets.ISO_8859_1

class LibreOfficeConverterMediaTypeSupportTest {

    @Test
    fun isSupported() {
        shouldNotThrow<TransformationNotSupportedException> {
            isSupported(APPLICATION_MSWORD, APPLICATION_PDF)
        }
    }

    @Test
    fun isSupported2() {
        shouldNotThrow<TransformationNotSupportedException> {
            isSupported(mediaType(TEXT_CSV.mimeType, ISO_8859_1), APPLICATION_PDF)
        }
    }

    @Test
    fun isSupported_mediaTypeHasNotSupportedCharset_shouldThrowTransformationNotSupportedException() {
        shouldThrow<TransformationNotSupportedException> {
            isSupported(mediaType(APPLICATION_MSWORD.mimeType, ISO_8859_1), APPLICATION_PDF)
        }
    }

    @Test
    fun isSupported_mediaTypeIsNotSupported_shouldThrowTransformationNotSupportedException() {
        shouldThrow<TransformationNotSupportedException> {
            isSupported(VIDEO_WEBM, APPLICATION_PDF)
        }
    }
}