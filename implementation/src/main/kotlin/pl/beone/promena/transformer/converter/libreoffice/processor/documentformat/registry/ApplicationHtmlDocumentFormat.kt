package pl.beone.promena.transformer.converter.libreoffice.processor.documentformat.registry

import org.jodconverter.document.DefaultDocumentFormatRegistry
import org.jodconverter.document.DocumentFormat
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants

internal object ApplicationHtmlDocumentFormat : AbstractDocumentFormat() {

    override fun create(): DocumentFormat =
        createDocumentFormatBasedOn(
            DefaultDocumentFormatRegistry.TXT,
            MediaTypeConstants.APPLICATION_XML.mimeType
        )
}