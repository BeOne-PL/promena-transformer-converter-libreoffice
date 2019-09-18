package pl.beone.promena.transformer.converter.libreoffice

import pl.beone.promena.transformer.applicationmodel.exception.transformer.TransformationNotSupportedException
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaType
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_MSWORD
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_PDF
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_EXCEL
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_EXCEL_SHEET_MACRO_ENABLED_12
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_EXCEL_TEMPLATE_MACRO_ENABLED_12
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_POWERPOINT
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_POWERPOINT_PRESENTATION_MACROENABLED_12
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_POWERPOINT_SLIDESHOW_MACROENABLED_12
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_POWERPOINT_TEMPLATE_MACROENABLED_12
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_WORD_DOCUMENT_MACROENABLED_12
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OASIS_OPENDOCUMENT_PRESENTATION
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OASIS_OPENDOCUMENT_PRESENTATION_TEMPLATE
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OASIS_OPENDOCUMENT_SPREADSHEET
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OASIS_OPENDOCUMENT_SPREADSHEET_TEMPLATE
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OASIS_OPENDOCUMENT_TEXT
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_PRESENTATION
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_SLIDESHOW
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_TEMPLATE
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_SHEET
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_TEMPLATE
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_DOCUMENT
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_TEMPLATE
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_CSV
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_HTML
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_PLAIN
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_XML
import pl.beone.promena.transformer.contract.data.DataDescriptor

internal class Supporter {

    companion object {
        private val supportedApplicationTransformations = listOf(
            APPLICATION_MSWORD to APPLICATION_PDF,
            APPLICATION_VND_MS_EXCEL to APPLICATION_PDF,
            APPLICATION_VND_MS_EXCEL_SHEET_MACRO_ENABLED_12 to APPLICATION_PDF,
            APPLICATION_VND_MS_EXCEL_TEMPLATE_MACRO_ENABLED_12 to APPLICATION_PDF,
            APPLICATION_VND_MS_POWERPOINT to APPLICATION_PDF,
            APPLICATION_VND_MS_POWERPOINT_PRESENTATION_MACROENABLED_12 to APPLICATION_PDF,
            APPLICATION_VND_MS_POWERPOINT_SLIDESHOW_MACROENABLED_12 to APPLICATION_PDF,
            APPLICATION_VND_MS_POWERPOINT_TEMPLATE_MACROENABLED_12 to APPLICATION_PDF,
            APPLICATION_VND_MS_WORD_DOCUMENT_MACROENABLED_12 to APPLICATION_PDF,
            APPLICATION_VND_OASIS_OPENDOCUMENT_PRESENTATION to APPLICATION_PDF,
            APPLICATION_VND_OASIS_OPENDOCUMENT_PRESENTATION_TEMPLATE to APPLICATION_PDF,
            APPLICATION_VND_OASIS_OPENDOCUMENT_SPREADSHEET to APPLICATION_PDF,
            APPLICATION_VND_OASIS_OPENDOCUMENT_SPREADSHEET_TEMPLATE to APPLICATION_PDF,
            APPLICATION_VND_OASIS_OPENDOCUMENT_TEXT to APPLICATION_PDF,
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_PRESENTATION to APPLICATION_PDF,
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_SLIDESHOW to APPLICATION_PDF,
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_TEMPLATE to APPLICATION_PDF,
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_SHEET to APPLICATION_PDF,
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_TEMPLATE to APPLICATION_PDF,
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_DOCUMENT to APPLICATION_PDF,
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_TEMPLATE to APPLICATION_PDF,
            APPLICATION_PDF to APPLICATION_PDF
        )

        private val supportedTextTransformations = listOf(
            TEXT_CSV.mimeType to APPLICATION_PDF,
            TEXT_HTML.mimeType to APPLICATION_PDF,
            TEXT_PLAIN.mimeType to APPLICATION_PDF,
            TEXT_XML.mimeType to APPLICATION_PDF
        )
    }

    fun isSupported(dataDescriptor: DataDescriptor, targetMediaType: MediaType) {
        dataDescriptor.descriptors.forEach { singleDataDescriptor ->
            if (transformationIsNotSupported(singleDataDescriptor.mediaType, targetMediaType)) {
                throw TransformationNotSupportedException("Supported transformations: ${createSupportedTransformationsString()}")
            }
        }
    }

    private fun transformationIsNotSupported(mediaType: MediaType, targetMediaType: MediaType): Boolean =
        !supportedApplicationTransformations.contains(mediaType to targetMediaType) &&
                !supportedTextTransformations.contains(mediaType.mimeType to targetMediaType)

    private fun createSupportedTransformationsString(): String =
        supportedApplicationTransformations.joinToString(", ") { (from, to) -> "<${from.createDescription()} -> ${to.createDescription()}>" } +
                ", " +
                supportedTextTransformations.joinToString(", ") { (from, to) -> "<(${from}) -> ${to.createDescription()}>" }

    private fun MediaType.createDescription(): String =
        "(${mimeType}, ${charset.name()})"
}