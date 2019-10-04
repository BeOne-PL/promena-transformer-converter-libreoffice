package pl.beone.promena.transformer.converter.libreoffice

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import pl.beone.lib.junit.jupiter.external.DockerExtension
import pl.beone.promena.communication.memory.model.internal.memoryCommunicationParameters
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_PDF
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_DOCUMENT
import pl.beone.promena.transformer.converter.libreoffice.model.Resource
import pl.beone.promena.transformer.converter.libreoffice.util.getResourceAsBytes
import java.util.concurrent.Executors

@ExtendWith(DockerExtension::class)
class LibreOfficeConverterTransformerMultithreadingTest {

    @Test
    fun transform_multiThreading() {
        val parallelismLevel = Runtime.getRuntime().availableProcessors()
        val iterations = parallelismLevel * 10

        val byteArray = getResourceAsBytes(Resource.Multithreading.Path.DOCX)
        val mediaType = APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_DOCUMENT
        val targetMediaType = APPLICATION_PDF

        val executors = Executors.newFixedThreadPool(parallelismLevel)
        val transformers = (0 until parallelismLevel)
            .map {
                LibreOfficeConverterTransformer(
                    LibreOfficeConverterTransformerSettings(),
                    LibreOfficeConverterTransformerDefaultParameters(),
                    memoryCommunicationParameters()
                )
            }

        (0 until iterations).map {
            executors.submit {
                memoryTest(byteArray, mediaType, targetMediaType, transformers[it % transformers.size], assertText = "Structural Elements")
            }
        }.forEach { it.get() }
    }
}