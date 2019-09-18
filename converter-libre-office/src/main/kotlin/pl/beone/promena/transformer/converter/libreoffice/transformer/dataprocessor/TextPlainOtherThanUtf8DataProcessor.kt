package pl.beone.promena.transformer.converter.libreoffice.transformer.dataprocessor

import pl.beone.promena.transformer.applicationmodel.mediatype.MediaType
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_PLAIN
import pl.beone.promena.transformer.contract.model.Data
import pl.beone.promena.transformer.internal.model.data.toMemoryData

internal class TextPlainOtherThanUtf8DataProcessor : AbstractDataProcessor() {

    override fun process(data: Data, mediaType: MediaType): Data =
        String(data.getBytes(), mediaType.charset).toMemoryData()

    override fun isSupported(data: Data, mediaType: MediaType): Boolean =
        mediaType.mimeType == TEXT_PLAIN.mimeType && mediaType.charset != Charsets.UTF_8
}