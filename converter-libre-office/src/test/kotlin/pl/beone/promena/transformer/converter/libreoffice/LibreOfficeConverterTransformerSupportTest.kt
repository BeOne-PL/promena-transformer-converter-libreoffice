package pl.beone.promena.transformer.converter.libreoffice

import io.mockk.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import pl.beone.lib.junit5.extension.docker.external.DockerExtension
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaType
import pl.beone.promena.transformer.contract.data.DataDescriptor
import pl.beone.promena.transformer.contract.model.Parameters
import pl.beone.promena.transformer.converter.libreoffice.applicationmodel.LibreOfficeConverterSupport

@ExtendWith(DockerExtension::class)
class LibreOfficeConverterTransformerSupportTest {

    @BeforeEach
    fun setUp() {
        mockkObject(LibreOfficeConverterSupport)
    }

    @Test
    fun isSupported() {
        val dataDescriptor = mockk<DataDescriptor>()
        val targetMediaType = mockk<MediaType>()
        val parameters = mockk<Parameters>()

        every { LibreOfficeConverterSupport.isSupported(dataDescriptor, targetMediaType, parameters) } just Runs

        LibreOfficeConverterTransformer(mockk())
            .isSupported(dataDescriptor, targetMediaType, parameters)

        verify(exactly = 1) { LibreOfficeConverterSupport.isSupported(dataDescriptor, targetMediaType, parameters) }
    }

    @AfterEach
    fun tearDown() {
        unmockkObject(LibreOfficeConverterSupport)
    }
}