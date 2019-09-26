package pl.beone.promena.transformer.converter.libreoffice.transformer.documentformat.registry

import org.jodconverter.document.DefaultDocumentFormatRegistry
import org.jodconverter.document.DocumentFormat
import pl.beone.promena.transformer.converter.libreoffice.applicationmodel.AlfrescoMediaTypeConstants

internal object ApplicationAlfrescoVndMsPowerpointPresentationMacroenabled12DocumentFormat : AbstractDocumentFormat() {

    override fun create(): DocumentFormat =
        createDocumentFormatBasedOn(
            DefaultDocumentFormatRegistry.PPTX,
            AlfrescoMediaTypeConstants.APPLICATION_VND_MS_POWERPOINT_PRESENTATION_MACROENABLED_12.mimeType
        )
}