package pl.beone.promena.transformer.converter.libreoffice

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
import pl.beone.promena.transformer.converter.libreoffice.util.getResourceAsBytes
import pl.beone.promena.transformer.internal.model.data.memory.emptyMemoryWritableData
import pl.beone.promena.transformer.internal.model.data.memory.toMemoryData
import pl.beone.promena.transformer.internal.model.metadata.emptyMetadata
import pl.beone.promena.transformer.internal.model.parameters.emptyParameters

private object MemoryCommunicationWritableDataCreator : CommunicationWritableDataCreator {
    override fun create(communicationParameters: CommunicationParameters): WritableData = emptyMemoryWritableData()
}

internal fun createLibreOfficeConverterTransformer(): LibreOfficeConverterTransformer =
    LibreOfficeConverterTransformer(
        LibreOfficeConverterTransformerSettings(),
        LibreOfficeConverterTransformerDefaultParameters(),
        mockk(),
        MemoryCommunicationWritableDataCreator
    )

internal fun test(
    resourcePath: String,
    mediaType: MediaType,
    targetMediaType: MediaType = MediaTypeConstants.APPLICATION_PDF,
    libreOfficeConverterTransformer: LibreOfficeConverterTransformer = createLibreOfficeConverterTransformer(),
    parameters: Parameters = emptyParameters(),
    assertText: String = "Zażółć gęślą jaźń"
) {
    val data = getResourceAsBytes(resourcePath).toMemoryData()

    libreOfficeConverterTransformer
        .transform(singleDataDescriptor(data, mediaType, emptyMetadata()), targetMediaType, parameters).let { transformedDataDescriptor ->
            withClue("Transformed data should contain only <1> element") { transformedDataDescriptor.descriptors shouldHaveSize 1 }

            transformedDataDescriptor.descriptors[0].let {
                it.data.readText() shouldContain assertText
                it.metadata shouldBe emptyMetadata()
            }
        }
}

private fun Data.readText(): String =
    PDDocument.load(getInputStream()).use { document ->
        PDFTextStripper().getText(document)
    }