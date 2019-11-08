package pl.beone.promena.transformer.converter.libreoffice.processor.documentformat.registry

import org.jodconverter.document.DefaultDocumentFormatRegistry
import org.jodconverter.document.DocumentFormat
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants

internal object ApplicationVndMsExcelTemplateMacroEnabled12DocumentFormat : AbstractDocumentFormat() {

    override fun create(): DocumentFormat =
        createDocumentFormatBasedOn(
            DefaultDocumentFormatRegistry.DOCX,
            MediaTypeConstants.APPLICATION_VND_MS_EXCEL_TEMPLATE_MACROENABLED_12.mimeType
        )
}