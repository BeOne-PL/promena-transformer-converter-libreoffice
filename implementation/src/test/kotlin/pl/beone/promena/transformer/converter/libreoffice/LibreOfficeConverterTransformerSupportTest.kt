package pl.beone.promena.transformer.converter.libreoffice

import io.mockk.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import pl.beone.lib.junit.jupiter.external.DockerExtension
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaType
import pl.beone.promena.transformer.contract.data.DataDescriptor
import pl.beone.promena.transformer.contract.model.Parameters
import pl.beone.promena.transformer.converter.libreoffice.applicationmodel.LibreOfficeConverterSupport

@ExtendWith(DockerExtension::class)
class LibreOfficeConverterTransformerSupportTest {

    @Test
    fun isSupported() {
        val dataDescriptor = mockk<DataDescriptor>()
        val targetMediaType = mockk<MediaType>()
        val parameters = mockk<Parameters>()

        mockkStatic(LibreOfficeConverterSupport::class)
        every { LibreOfficeConverterSupport.isSupported(dataDescriptor, targetMediaType, parameters) } just Runs

        LibreOfficeConverterTransformer(LibreOfficeConverterTransformerSettings(), LibreOfficeConverterTransformerDefaultParameters(), mockk())
            .isSupported(dataDescriptor, targetMediaType, parameters)

        verify(exactly = 1) { LibreOfficeConverterSupport.isSupported(dataDescriptor, targetMediaType, parameters) }
    }
}