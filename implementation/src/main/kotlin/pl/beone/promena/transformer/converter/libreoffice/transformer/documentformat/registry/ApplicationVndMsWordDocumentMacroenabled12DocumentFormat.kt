package pl.beone.promena.transformer.converter.libreoffice.transformer.documentformat.registry

import org.jodconverter.document.DefaultDocumentFormatRegistry
import org.jodconverter.document.DocumentFormat
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants

internal object ApplicationVndMsWordDocumentMacroenabled12DocumentFormat : AbstractDocumentFormat() {

    override fun create(): DocumentFormat =
        createDocumentFormatBasedOn(
            DefaultDocumentFormatRegistry.XLSX,
            MediaTypeConstants.APPLICATION_VND_MS_WORD_DOCUMENT_MACROENABLED_12.mimeType
        )
}