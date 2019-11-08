package pl.beone.promena.transformer.converter.libreoffice.processor.documentformat.registry

import org.jodconverter.document.DefaultDocumentFormatRegistry
import org.jodconverter.document.DocumentFormat
import pl.beone.promena.transformer.converter.libreoffice.applicationmodel.AlfrescoMediaTypeConstants

internal object ApplicationAlfrescoVndMsPowerpointTemplateMacroenabled12DocumentFormat : AbstractDocumentFormat() {

    override fun create(): DocumentFormat =
        createDocumentFormatBasedOn(
            DefaultDocumentFormatRegistry.PPTX,
            AlfrescoMediaTypeConstants.APPLICATION_VND_MS_POWERPOINT_TEMPLATE_MACROENABLED_12.mimeType
        )
}