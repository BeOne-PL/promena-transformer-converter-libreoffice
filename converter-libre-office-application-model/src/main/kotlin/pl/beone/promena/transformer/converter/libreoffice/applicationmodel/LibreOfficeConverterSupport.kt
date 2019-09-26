package pl.beone.promena.transformer.converter.libreoffice.applicationmodel

import pl.beone.lib.typeconverter.applicationmodel.exception.TypeConversionException
import pl.beone.promena.transformer.applicationmodel.exception.transformer.TransformationNotSupportedException
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaType
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_MSWORD
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_PDF
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_RTF
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_EXCEL
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_EXCEL_SHEET_MACROENABLED_12
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_EXCEL_TEMPLATE_MACROENABLED_12
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
import pl.beone.promena.transformer.contract.model.Parameters

object LibreOfficeConverterSupport {

    fun isSupported(dataDescriptor: DataDescriptor, targetMediaType: MediaType, parameters: Parameters) {
        dataDescriptor.descriptors.forEach { (_, mediaType) -> MediaTypeSupport.isSupported(mediaType, targetMediaType) }
        ParametersSupport.isSupported(parameters)
    }

    object MediaTypeSupport {
        private val supportedMediaType = setOf(
            APPLICATION_MSWORD to APPLICATION_PDF,
            APPLICATION_VND_MS_EXCEL to APPLICATION_PDF,
            APPLICATION_VND_MS_EXCEL_SHEET_MACROENABLED_12 to APPLICATION_PDF,
            APPLICATION_VND_MS_EXCEL_TEMPLATE_MACROENABLED_12 to APPLICATION_PDF,
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
            APPLICATION_RTF to APPLICATION_PDF,
            APPLICATION_PDF to APPLICATION_PDF,

            AlfrescoMediaTypeConstants.APPLICATION_VND_MS_WORD_DOCUMENT_MACROENABLED_12 to APPLICATION_PDF,
            AlfrescoMediaTypeConstants.APPLICATION_VND_MS_POWERPOINT_TEMPLATE_MACROENABLED_12 to APPLICATION_PDF,
            AlfrescoMediaTypeConstants.APPLICATION_VND_MS_POWERPOINT_SLIDESHOW_MACROENABLED_12 to APPLICATION_PDF,
            AlfrescoMediaTypeConstants.APPLICATION_VND_MS_POWERPOINT_PRESENTATION_MACROENABLED_12 to APPLICATION_PDF,
            AlfrescoMediaTypeConstants.APPLICATION_VND_MS_EXCEL_SHEET_MACROENABLED_12 to APPLICATION_PDF,
            AlfrescoMediaTypeConstants.APPLICATION_VND_MS_EXCEL_TEMPLATE_MACROENABLED_12 to APPLICATION_PDF
        )

        private val supportedMimeType = setOf(
            TEXT_CSV.mimeType to APPLICATION_PDF,
            TEXT_HTML.mimeType to APPLICATION_PDF,
            TEXT_PLAIN.mimeType to APPLICATION_PDF,
            TEXT_XML.mimeType to APPLICATION_PDF
        )

        fun isSupported(mediaType: MediaType, targetMediaType: MediaType) {
            if (!supportedMediaType.contains(mediaType to targetMediaType) && !supportedMimeType.contains(mediaType.mimeType to targetMediaType)) {
                throw TransformationNotSupportedException.unsupportedMediaType(mediaType, targetMediaType)
            }
        }
    }

    object ParametersSupport {
        fun isSupported(parameters: Parameters) {
            // deliberately omitted. There are no parameters
        }

        private fun Parameters.validate(name: String, clazz: Class<*>, mandatory: Boolean) {
            try {
                get(name, clazz)
            } catch (e: NoSuchElementException) {
                if (mandatory) {
                    throw TransformationNotSupportedException.mandatoryParameter(name)
                }
            } catch (e: TypeConversionException) {
                throw TransformationNotSupportedException.unsupportedParameterType(name, clazz)
            }
        }
    }
}