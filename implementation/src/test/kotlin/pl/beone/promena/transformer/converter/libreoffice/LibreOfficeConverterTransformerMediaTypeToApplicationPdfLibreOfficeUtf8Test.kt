package pl.beone.promena.transformer.converter.libreoffice

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import pl.beone.lib.junit.jupiter.external.DockerExtension
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_MSWORD
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_RTF
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_EXCEL
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_EXCEL_SHEET_MACROENABLED_12
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_POWERPOINT
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_POWERPOINT_PRESENTATION_MACROENABLED_12
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
import pl.beone.promena.transformer.converter.libreoffice.applicationmodel.AlfrescoMediaTypeConstants
import pl.beone.promena.transformer.converter.libreoffice.model.Resource.MediaType.Path.UTF_8.Plain
import pl.beone.promena.transformer.converter.libreoffice.model.Resource.MediaType.Path.UTF_8.Presentation
import pl.beone.promena.transformer.converter.libreoffice.model.Resource.MediaType.Path.UTF_8.Spreadsheet
import pl.beone.promena.transformer.converter.libreoffice.model.Resource.MediaType.Path.UTF_8.Text
import pl.beone.promena.transformer.converter.libreoffice.util.test

@ExtendWith(DockerExtension::class)
class LibreOfficeConverterTransformerMediaTypeToApplicationPdfLibreOfficeUtf8Test {

    @Test
    fun transform_textCsv() {
        test(Plain.LibreOfficeWriter.CSV, TEXT_CSV)
    }

    @Test
    fun transform_textHtml() {
        test(Plain.LibreOfficeWriter.HTML, TEXT_HTML)
    }

    @Test
    fun transform_textHtml2() {
        test(Plain.LibreOfficeWriter.HTML_CALC, TEXT_HTML)
    }

    @Test
    fun transform_applicationRtf() {
        test(Plain.LibreOfficeWriter.RTF, APPLICATION_RTF)
    }

    @Test
    fun transform_textPlain() {
        test(Plain.LibreOfficeWriter.TXT, TEXT_PLAIN)
    }

    @Test
    fun transform_textXml() {
        test(Plain.LibreOfficeWriter.XML, TEXT_XML)
    }

    @Test
    fun transform_textXml2003() {
        test(Plain.LibreOfficeWriter.XML_2003, TEXT_XML)
    }

    // ***

    @Test
    fun transform_applicationVndOasisOpendocumentPresentation() {
        test(
            Presentation.LibreOfficeImpress.ODP,
            APPLICATION_VND_OASIS_OPENDOCUMENT_PRESENTATION
        )
    }

    @Test
    fun transform_applicationVndOasisOpendocumentPresentationTemplate() {
        test(
            Presentation.LibreOfficeImpress.OTP,
            APPLICATION_VND_OASIS_OPENDOCUMENT_PRESENTATION_TEMPLATE
        )
    }

    @Test
    fun transform_applicationVndMsPowerpoint2() {
        test(Presentation.LibreOfficeImpress.POT, APPLICATION_VND_MS_POWERPOINT)
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentPresentationmlTemplate() {
        test(
            Presentation.LibreOfficeImpress.POTX,
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_TEMPLATE
        )
    }

    @Test
    fun transform_applicationVndMsPowerpoint3() {
        test(Presentation.LibreOfficeImpress.PPS, APPLICATION_VND_MS_POWERPOINT)
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentPresentationmlSlideshow() {
        test(
            Presentation.LibreOfficeImpress.PPSX,
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_SLIDESHOW
        )
    }

    @Test
    fun transform_applicationVndMsPowerpoint() {
        test(Presentation.LibreOfficeImpress.PPT, APPLICATION_VND_MS_POWERPOINT)
    }

    @Test
    fun transform_applicationVndMsPowerpointPresentationMacroenabled12() {
        test(
            Presentation.LibreOfficeImpress.PPTM,
            APPLICATION_VND_MS_POWERPOINT_PRESENTATION_MACROENABLED_12
        )

        test(
            Presentation.LibreOfficeImpress.PPTM,
            AlfrescoMediaTypeConstants.APPLICATION_VND_MS_POWERPOINT_PRESENTATION_MACROENABLED_12
        )
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentPresentationmlPresentation() {
        test(
            Presentation.LibreOfficeImpress.PPTX,
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_PRESENTATION
        )
    }

    // ***

    @Test
    fun transform_applicationVndOasisOpendocumentSpreadsheet() {
        test(
            Spreadsheet.LibreOfficeCalc.ODS,
            APPLICATION_VND_OASIS_OPENDOCUMENT_SPREADSHEET
        )
    }

    @Test
    fun transform_applicationVndOasisOpendocumentSpreadsheetTemplate() {
        test(
            Spreadsheet.LibreOfficeCalc.OTS,
            APPLICATION_VND_OASIS_OPENDOCUMENT_SPREADSHEET_TEMPLATE
        )
    }

    @Test
    fun transform_applicationVndMsExcel3() {
        test(Spreadsheet.LibreOfficeCalc.SLK, APPLICATION_VND_MS_EXCEL)
    }

    @Test
    fun transform_applicationVndMsExcel() {
        test(Spreadsheet.LibreOfficeCalc.XLS, APPLICATION_VND_MS_EXCEL)
    }

    @Test
    fun transform_applicationVndMsExcelSheetMacroEnabled12() {
        test(
            Spreadsheet.LibreOfficeCalc.XLSM,
            APPLICATION_VND_MS_EXCEL_SHEET_MACROENABLED_12
        )

        test(
            Spreadsheet.LibreOfficeCalc.XLSM,
            AlfrescoMediaTypeConstants.APPLICATION_VND_MS_EXCEL_SHEET_MACROENABLED_12
        )
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentSpreadsheetmlSheet() {
        test(
            Spreadsheet.LibreOfficeCalc.XLSX,
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_SHEET
        )
    }

    @Test
    fun transform_applicationVndMsExcel2() {
        test(Spreadsheet.LibreOfficeCalc.XLT, APPLICATION_VND_MS_EXCEL)
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentSpreadsheetmlTemplate() {
        test(
            Spreadsheet.LibreOfficeCalc.XLTX,
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_TEMPLATE
        )
    }

    // ***

    @Test
    fun transform_applicationVndOasisOpendocumentText() {
        test(
            Text.LibreOfficeWriter.ODT,
            APPLICATION_VND_OASIS_OPENDOCUMENT_TEXT
        )
    }

    @Test
    fun transform_applicationMsword() {
        test(Text.LibreOfficeWriter.DOC, APPLICATION_MSWORD)
    }

    @Test
    fun transform_applicationVndMsWordDocumentMacroenabled12() {
        test(
            Text.LibreOfficeWriter.DOCM,
            APPLICATION_VND_MS_WORD_DOCUMENT_MACROENABLED_12
        )

        test(
            Text.LibreOfficeWriter.DOCM,
            AlfrescoMediaTypeConstants.APPLICATION_VND_MS_WORD_DOCUMENT_MACROENABLED_12
        )
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentWordprocessingmlDocument() {
        test(
            Text.LibreOfficeWriter.DOCX,
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_DOCUMENT
        )
    }

    @Test
    fun transform_applicationMsword2() {
        test(Text.LibreOfficeWriter.DOT, APPLICATION_MSWORD)
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentWordprocessingmlTemplate() {
        test(
            Text.LibreOfficeWriter.DOTX,
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_TEMPLATE
        )
    }
}