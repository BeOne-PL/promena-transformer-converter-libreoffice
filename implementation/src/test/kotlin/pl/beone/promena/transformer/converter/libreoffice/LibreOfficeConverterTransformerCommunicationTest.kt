package pl.beone.promena.transformer.converter.libreoffice

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import pl.beone.lib.junit.jupiter.external.DockerExtension
import pl.beone.promena.communication.file.model.internal.fileCommunicationParameters
import pl.beone.promena.communication.memory.model.internal.memoryCommunicationParameters
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_PDF
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_PLAIN
import pl.beone.promena.transformer.converter.libreoffice.model.Resource
import pl.beone.promena.transformer.converter.libreoffice.util.getResourceAsBytes
import pl.beone.promena.transformer.converter.libreoffice.util.getResourceAsInputStream
import pl.beone.promena.transformer.internal.model.data.file.FileData
import pl.beone.promena.transformer.internal.model.data.file.toFileData
import pl.beone.promena.transformer.internal.model.data.memory.MemoryData
import pl.beone.promena.transformer.internal.model.data.memory.toMemoryData

@ExtendWith(DockerExtension::class)
class LibreOfficeConverterTransformerCommunicationTest {

    @Test
    fun transform_memoryData() {
        test(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Plain.TXT).toMemoryData(),
            MemoryData::class,
            TEXT_PLAIN,
            APPLICATION_PDF,
            LibreOfficeConverterTransformer(
                LibreOfficeConverterTransformerSettings(),
                LibreOfficeConverterTransformerDefaultParameters(),
                memoryCommunicationParameters()
            )
        )
    }

    @Test
    fun transform_fileData() {
        val directory = createTempDir()

        test(
            getResourceAsInputStream(Resource.MediaType.Path.UTF_8.Plain.TXT).toFileData(directory),
            FileData::class,
            TEXT_PLAIN,
            APPLICATION_PDF,
            LibreOfficeConverterTransformer(
                LibreOfficeConverterTransformerSettings(),
                LibreOfficeConverterTransformerDefaultParameters(),
                fileCommunicationParameters(directory)
            )
        )
    }
}