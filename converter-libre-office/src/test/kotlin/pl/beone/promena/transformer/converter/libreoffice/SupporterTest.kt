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
        }.message shouldBe "Transformation (application/msword, ISO-8859-1) -> (application/pdf, UTF-8) isn't supported"
    }

    @Test
    fun isSupported_mediaTypeIsNotSupported_shouldThrowTransformationNotSupportedException() {
        shouldThrow<TransformationNotSupportedException> {
            LibreOfficeConverterTransformer(mockk()).isSupported(
                singleDataDescriptor(noData(), VIDEO_WEBM, emptyMetadata()),
                APPLICATION_PDF,
                emptyParameters()
            )
        }.message shouldBe "Transformation (video/webm, UTF-8) -> (application/pdf, UTF-8) isn't supported"
    }

    @Test
    fun isSupported_targetMediaTypeIsNotSupported_shouldThrowTransformationNotSupportedException() {
        shouldThrow<TransformationNotSupportedException> {
            LibreOfficeConverterTransformer(mockk()).isSupported(
                singleDataDescriptor(noData(), APPLICATION_PDF, emptyMetadata()),
                VIDEO_WEBM,
                emptyParameters()
            )
        }.message shouldBe "Transformation (application/pdf, UTF-8) -> (video/webm, UTF-8) isn't supported"
    }
}