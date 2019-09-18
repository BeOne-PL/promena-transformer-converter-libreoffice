package pl.beone.promena.transformer.converter.libreoffice

import io.kotlintest.shouldBe
import io.kotlintest.shouldNotThrow
import io.kotlintest.shouldThrow
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import pl.beone.lib.junit5.extension.docker.external.DockerExtension
import pl.beone.promena.transformer.applicationmodel.exception.transformer.TransformationNotSupportedException
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaType
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_MSWORD
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_PDF
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_CSV
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.VIDEO_WEBM
import pl.beone.promena.transformer.contract.data.singleDataDescriptor
import pl.beone.promena.transformer.internal.model.data.noData
import pl.beone.promena.transformer.internal.model.metadata.emptyMetadata
import pl.beone.promena.transformer.internal.model.parameters.emptyParameters

@ExtendWith(DockerExtension::class)
class SupporterTest {

    companion object {
        private const val exceptionMessage =
            "Supported transformations: <(application/msword, UTF-8) -> (application/pdf, UTF-8)>, <(application/vnd.ms-excel, UTF-8) -> (application/pdf, UTF-8)>, <(application/application/vnd.ms-excel.sheet.macroEnabled.12, UTF-8) -> (application/pdf, UTF-8)>, <(application/vnd.ms-excel.template.macroEnabled.12, UTF-8) -> (application/pdf, UTF-8)>, <(application/vnd.ms-powerpoint, UTF-8) -> (application/pdf, UTF-8)>, <(application/vnd.ms-powerpoint.presentation.macroEnabled.12, UTF-8) -> (application/pdf, UTF-8)>, <(application/vnd.ms-powerpoint.slideshow.macroEnabled.12, UTF-8) -> (application/pdf, UTF-8)>, <(application/vnd.ms-powerpoint.template.macroEnabled.12, UTF-8) -> (application/pdf, UTF-8)>, <(application/vnd.ms-word.document.macroEnabled.12, UTF-8) -> (application/pdf, UTF-8)>, <(application/vnd.oasis.opendocument.presentation, UTF-8) -> (application/pdf, UTF-8)>, <(application/vnd.oasis.opendocument.presentation-template, UTF-8) -> (application/pdf, UTF-8)>, <(application/vnd.oasis.opendocument.spreadsheet, UTF-8) -> (application/pdf, UTF-8)>, <(application/vnd.oasis.opendocument.spreadsheet-template, UTF-8) -> (application/pdf, UTF-8)>, <(application/vnd.oasis.opendocument.text, UTF-8) -> (application/pdf, UTF-8)>, <(application/vnd.openxmlformats-officedocument.presentationml.presentation, UTF-8) -> (application/pdf, UTF-8)>, <(application/vnd.openxmlformats-officedocument.presentationml.slideshow, UTF-8) -> (application/pdf, UTF-8)>, <(application/vnd.openxmlformats-officedocument.presentationml.template, UTF-8) -> (application/pdf, UTF-8)>, <(application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, UTF-8) -> (application/pdf, UTF-8)>, <(application/vnd.openxmlformats-officedocument.spreadsheetml.template, UTF-8) -> (application/pdf, UTF-8)>, <(application/vnd.openxmlformats-officedocument.wordprocessingml.document, UTF-8) -> (application/pdf, UTF-8)>, <(application/vnd.openxmlformats-officedocument.wordprocessingml.template, UTF-8) -> (application/pdf, UTF-8)>, <(application/pdf, UTF-8) -> (application/pdf, UTF-8)>, <(text/csv) -> (application/pdf, UTF-8)>, <(text/html) -> (application/pdf, UTF-8)>, <(text/plain) -> (application/pdf, UTF-8)>, <(text/xml) -> (application/pdf, UTF-8)>"
    }

    @Test
    fun isSupported() {
        shouldNotThrow<TransformationNotSupportedException> {
            LibreOfficeConverterTransformer(mockk()).isSupported(
                singleDataDescriptor(noData(), APPLICATION_MSWORD, emptyMetadata()),
                APPLICATION_PDF,
                emptyParameters()
            )
        }
    }

    @Test
    fun isSupported2() {
        shouldNotThrow<TransformationNotSupportedException> {
            LibreOfficeConverterTransformer(mockk()).isSupported(
                singleDataDescriptor(noData(), MediaType.of(TEXT_CSV.mimeType, Charsets.ISO_8859_1), emptyMetadata()),
                APPLICATION_PDF,
                emptyParameters()
            )
        }
    }

    @Test
    fun isSupported_mediaTypeHasNotSupportedCharset_shouldThrowTransformationNotSupportedException() {
        shouldThrow<TransformationNotSupportedException> {
            LibreOfficeConverterTransformer(mockk()).isSupported(
                singleDataDescriptor(noData(), MediaType.of(APPLICATION_MSWORD.mimeType, Charsets.ISO_8859_1), emptyMetadata()),
                APPLICATION_PDF,
                emptyParameters()
            )
        }.message shouldBe exceptionMessage
    }

    @Test
    fun isSupported_mediaTypeIsNotSupported_shouldThrowTransformationNotSupportedException() {
        shouldThrow<TransformationNotSupportedException> {
            LibreOfficeConverterTransformer(mockk()).isSupported(
                singleDataDescriptor(noData(), VIDEO_WEBM, emptyMetadata()),
                APPLICATION_PDF,
                emptyParameters()
            )
        }.message shouldBe exceptionMessage
    }

    @Test
    fun isSupported_targetMediaTypeIsNotSupported_shouldThrowTransformationNotSupportedException() {
        shouldThrow<TransformationNotSupportedException> {
            LibreOfficeConverterTransformer(mockk()).isSupported(
                singleDataDescriptor(noData(), APPLICATION_PDF, emptyMetadata()),
                VIDEO_WEBM,
                emptyParameters()
            )
        }.message shouldBe exceptionMessage
    }
}