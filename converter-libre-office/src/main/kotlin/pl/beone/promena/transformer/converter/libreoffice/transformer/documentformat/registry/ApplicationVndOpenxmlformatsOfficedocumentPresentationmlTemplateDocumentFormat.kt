package pl.beone.promena.transformer.converter.libreoffice.transformer.documentformat.registry

import org.jodconverter.document.DefaultDocumentFormatRegistry
import org.jodconverter.document.DocumentFormat
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants

internal class ApplicationVndOpenxmlformatsOfficedocumentPresentationmlTemplateDocumentFormat : AbstractDocumentFormat() {

    override fun create(): DocumentFormat =
        createDocumentFormatBasedOn(
            DefaultDocumentFormatRegistry.PPTX,
            MediaTypeConstants.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_TEMPLATE.mimeType
        )
}