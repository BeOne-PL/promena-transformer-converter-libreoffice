package pl.beone.promena.transformer.converter.libreoffice

import io.kotlintest.matchers.collections.shouldHaveSize
import io.kotlintest.matchers.instanceOf
import io.kotlintest.matchers.string.shouldContain
import io.kotlintest.matchers.withClue
import io.kotlintest.shouldBe
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper
import pl.beone.promena.communication.memory.model.internal.memoryCommunicationParameters
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaType
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants
import pl.beone.promena.transformer.contract.data.singleDataDescriptor
import pl.beone.promena.transformer.contract.model.Parameters
import pl.beone.promena.transformer.contract.model.data.Data
import pl.beone.promena.transformer.internal.model.data.memory.MemoryData
import pl.beone.promena.transformer.internal.model.data.memory.toMemoryData
import pl.beone.promena.transformer.internal.model.metadata.emptyMetadata
import pl.beone.promena.transformer.internal.model.parameters.emptyParameters
import kotlin.reflect.KClass

internal fun memoryTest(
    byteArray: ByteArray,
    mediaType: MediaType,
    targetMediaType: MediaType = MediaTypeConstants.APPLICATION_PDF,
    libreOfficeConverterTransformer: LibreOfficeConverterTransformer =
        LibreOfficeConverterTransformer(
            LibreOfficeConverterTransformerSettings(),
            LibreOfficeConverterTransformerDefaultParameters(),
            memoryCommunicationParameters()
        ),
    parameters: Parameters = emptyParameters(),
    assertText: String = "Zażółć gęślą jaźń"
) {
    test(
        byteArray.toMemoryData(),
        MemoryData::class,
        mediaType,
        targetMediaType,
        libreOfficeConverterTransformer,
        parameters,
        assertText
    )
}

internal fun test(
    data: Data,
    dataClass: KClass<*>,
    mediaType: MediaType,
    targetMediaType: MediaType = MediaTypeConstants.APPLICATION_PDF,
    libreOfficeConverterTransformer: LibreOfficeConverterTransformer,
    parameters: Parameters = emptyParameters(),
    assertText: String = "Zażółć gęślą jaźń"
) {
    libreOfficeConverterTransformer
        .transform(singleDataDescriptor(data, mediaType, emptyMetadata()), targetMediaType, parameters).let { transformedDataDescriptor ->
            withClue("Transformed data should contain only <1> element") { transformedDataDescriptor.descriptors shouldHaveSize 1 }

            transformedDataDescriptor.descriptors[0].let {
                withClue("Transformed data should be instance of <$dataClass>") { it.data shouldBe instanceOf(dataClass) }
                it.data.readText() shouldContain assertText
                it.metadata shouldBe emptyMetadata()
            }
        }
}

private fun Data.readText(): String =
    PDDocument.load(getInputStream()).use { document ->
        PDFTextStripper().getText(document)
    }