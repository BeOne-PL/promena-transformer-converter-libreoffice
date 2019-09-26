package pl.beone.promena.transformer.converter.libreoffice.transformer.dataprocessor

import pl.beone.promena.transformer.applicationmodel.mediatype.MediaType
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_CSV
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_PLAIN
import pl.beone.promena.transformer.contract.model.Data
import pl.beone.promena.transformer.internal.model.data.toMemoryData

internal object TextPlainAndTextCsvOtherThanUtf8DataProcessor : AbstractDataProcessor() {

    private val mimeTypes = listOf(TEXT_PLAIN.mimeType, TEXT_CSV.mimeType)

    override fun process(data: Data, mediaType: MediaType): Data =
        String(data.getBytes(), mediaType.charset).toMemoryData()

    override fun isSupported(data: Data, mediaType: MediaType): Boolean =
        (mimeTypes.contains(mediaType.mimeType) && mediaType.charset != Charsets.UTF_8)
}