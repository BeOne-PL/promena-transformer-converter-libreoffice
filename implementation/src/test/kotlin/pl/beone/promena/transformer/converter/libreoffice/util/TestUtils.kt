package pl.beone.promena.transformer.converter.libreoffice.util

import io.kotlintest.matchers.collections.shouldHaveSize
import io.kotlintest.matchers.string.shouldContain
import io.kotlintest.matchers.withClue
import io.kotlintest.shouldBe
import io.mockk.mockk
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaType
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants
import pl.beone.promena.transformer.contract.communication.CommunicationParameters
import pl.beone.promena.transformer.contract.communication.CommunicationWritableDataCreator
import pl.beone.promena.transformer.contract.data.singleDataDescriptor
import pl.beone.promena.transformer.contract.model.Parameters
import pl.beone.promena.transformer.contract.model.data.Data
import pl.beone.promena.transformer.contract.model.data.WritableData
import pl.beone.promena.transformer.converter.libreoffice.LibreOfficeConverterTransformer
import pl.beone.promena.transformer.converter.libreoffice.LibreOfficeConverterTransformerDefaultParameters
import pl.beone.promena.transformer.converter.libreoffice.LibreOfficeConverterTransformerSettings
import pl.beone.promena.transformer.internal.model.data.memory.emptyMemoryWritableData
import pl.beone.promena.transformer.internal.model.data.memory.toMemoryData
import pl.beone.promena.transformer.internal.model.metadata.emptyMetadata
import pl.beone.promena.transformer.internal.model.parameters.emptyParameters

private object MemoryCommunicationWritableDataCreator : CommunicationWritableDataCreator {
    override fun create(communicationParameters: CommunicationParameters): WritableData = emptyMemoryWritableData()
}

internal fun createLibreOfficeConverterTransformer(
    settings: LibreOfficeConverterTransformerSettings = LibreOfficeConverterTransformerSettings(
        home = "/opt/libreoffice6.4",
        startingPort = 5000
    ),
    defaultParameters: LibreOfficeConverterTransformerDefaultParameters = LibreOfficeConverterTransformerDefaultParameters(),
    communicationParameters: CommunicationParameters = mockk(),
    communicationWritableDataCreator: CommunicationWritableDataCreator = MemoryCommunicationWritableDataCreator
): LibreOfficeConverterTransformer =
    LibreOfficeConverterTransformer(
        settings,
        defaultParameters,
        communicationParameters,
        communicationWritableDataCreator
    )

internal fun test(
    resourcePath: String,
    mediaType: MediaType,
    targetMediaType: MediaType = MediaTypeConstants.APPLICATION_PDF,
    transformer: LibreOfficeConverterTransformer = createLibreOfficeConverterTransformer(),
    parameters: Parameters = emptyParameters(),
    assertText: String = "Zażółć gęślą jaźń"
) {
    val data = getResourceAsBytes(resourcePath).toMemoryData()

    with(
        transformer.transform(singleDataDescriptor(data, mediaType, emptyMetadata()), targetMediaType, parameters)
    ) {
        withClue("Transformed data should contain only <1> element") { descriptors shouldHaveSize 1 }

        with(descriptors[0]) {
            this.data.readText() shouldContain assertText
            metadata shouldBe emptyMetadata()
        }
    }
}

private fun Data.readText(): String =
    PDDocument.load(getInputStream()).use { document ->
        PDFTextStripper().getText(document)
    }