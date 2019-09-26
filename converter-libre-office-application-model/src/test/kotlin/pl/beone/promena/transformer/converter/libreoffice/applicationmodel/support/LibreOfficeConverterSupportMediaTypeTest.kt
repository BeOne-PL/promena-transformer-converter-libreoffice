package pl.beone.promena.transformer.converter.libreoffice.applicationmodel.support

import io.kotlintest.shouldNotThrow
import org.junit.jupiter.api.Test
import pl.beone.promena.transformer.applicationmodel.exception.transformer.TransformationNotSupportedException
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_PDF
import pl.beone.promena.transformer.applicationmodel.mediatype.mediaType
import pl.beone.promena.transformer.converter.libreoffice.applicationmodel.LibreOfficeConverterSupport.MediaTypeSupport

class LibreOfficeConverterSupportMediaTypeTest {

    @Test
    fun `isSupported _ Alfresco mediaType`() {
        shouldNotThrow<TransformationNotSupportedException> {
            MediaTypeSupport.isSupported(mediaType("application/vnd.ms-word.document.macroenabled.12"), APPLICATION_PDF)
        }
    }

    @Test
    fun `isSupported _ Alfresco mediaType2`() {
        shouldNotThrow<TransformationNotSupportedException> {
            MediaTypeSupport.isSupported(mediaType("application/vnd.ms-powerpoint.template.macroenabled.12"), APPLICATION_PDF)
        }
    }

    @Test
    fun `isSupported _ Alfresco mediaType3`() {
        shouldNotThrow<TransformationNotSupportedException> {
            MediaTypeSupport.isSupported(mediaType("application/vnd.ms-powerpoint.slideshow.macroenabled.12"), APPLICATION_PDF)
        }
    }

    @Test
    fun `isSupported _ Alfresco mediaType4`() {
        shouldNotThrow<TransformationNotSupportedException> {
            MediaTypeSupport.isSupported(mediaType("application/vnd.ms-powerpoint.presentation.macroenabled.12"), APPLICATION_PDF)
        }
    }

    @Test
    fun `isSupported _ Alfresco mediaType5`() {
        shouldNotThrow<TransformationNotSupportedException> {
            MediaTypeSupport.isSupported(mediaType("application/vnd.ms-excel.sheet.macroenabled.12"), APPLICATION_PDF)
        }
    }

    @Test
    fun `isSupported _ Alfresco mediaType6`() {
        shouldNotThrow<TransformationNotSupportedException> {
            MediaTypeSupport.isSupported(mediaType("application/vnd.ms-excel.template.macroenabled.12"), APPLICATION_PDF)
        }
    }
}