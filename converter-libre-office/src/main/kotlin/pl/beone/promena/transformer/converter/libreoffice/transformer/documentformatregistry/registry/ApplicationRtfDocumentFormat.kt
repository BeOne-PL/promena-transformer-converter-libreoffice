package pl.beone.promena.transformer.converter.libreoffice.transformer.documentformatregistry.registry

import org.jodconverter.document.DefaultDocumentFormatRegistry
import org.jodconverter.document.DocumentFormat
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants

internal class ApplicationRtfDocumentFormat : AbstractDocumentFormat() {

    override fun create(): DocumentFormat =
        createDocumentFormatBasedOn(
            DefaultDocumentFormatRegistry.RTF,
            MediaTypeConstants.APPLICATION_RTF.mimeType
        )
}