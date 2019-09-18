package pl.beone.promena.transformer.converter.libreoffice.transformer.documentformat.registry

import org.jodconverter.document.DefaultDocumentFormatRegistry
import org.jodconverter.document.DocumentFormat
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants

internal class ApplicationVndMsExcelTemplateMacroEnabled12DocumentFormat : AbstractDocumentFormat() {

    override fun create(): DocumentFormat =
        createDocumentFormatBasedOn(
            DefaultDocumentFormatRegistry.DOCX,
            MediaTypeConstants.APPLICATION_VND_MS_EXCEL_TEMPLATE_MACRO_ENABLED_12.mimeType
        )
}