package pl.beone.promena.transformer.converter.libreoffice.transformer.documentformatregistry.registry

import org.jodconverter.document.DefaultDocumentFormatRegistry
import org.jodconverter.document.DocumentFormat
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants

internal class TextXmlDocumentFormat : AbstractDocumentFormat() {

    override fun create(): DocumentFormat =
        createDocumentFormatBasedOn(
            DefaultDocumentFormatRegistry.TXT,
            MediaTypeConstants.TEXT_XML.mimeType
        )
}