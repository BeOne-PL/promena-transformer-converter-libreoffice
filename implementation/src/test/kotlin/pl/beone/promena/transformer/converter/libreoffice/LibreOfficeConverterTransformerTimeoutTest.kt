package pl.beone.promena.transformer.converter.libreoffice

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import pl.beone.lib.junit.jupiter.external.DockerExtension
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_CSV
import pl.beone.promena.transformer.converter.libreoffice.model.Resource.MediaType.Path.UTF_8.Plain
import pl.beone.promena.transformer.internal.model.parameters.addTimeout
import pl.beone.promena.transformer.internal.model.parameters.emptyParameters
import java.time.Duration
import java.util.concurrent.TimeoutException

@ExtendWith(DockerExtension::class)
class LibreOfficeConverterTransformerTimeoutTest {

    @Test
    fun transform_shouldInterruptExecutionManyTimesAndThenShouldTransformCorrectly() {
        val libreOfficeConverterTransformer = createLibreOfficeConverterTransformer()

        repeat(5) {
            try {
                test(
                    Plain.CSV,
                    TEXT_CSV,
                    libreOfficeConverterTransformer = libreOfficeConverterTransformer,
                    parameters = emptyParameters() addTimeout Duration.ofMillis(100)
                )
            } catch (e: TimeoutException) {
            }
        }

        test(Plain.CSV, TEXT_CSV, libreOfficeConverterTransformer = libreOfficeConverterTransformer)
    }
}