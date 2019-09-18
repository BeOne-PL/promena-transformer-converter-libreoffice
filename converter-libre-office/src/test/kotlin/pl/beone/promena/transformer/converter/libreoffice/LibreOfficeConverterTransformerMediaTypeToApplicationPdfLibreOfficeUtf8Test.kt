package pl.beone.promena.transformer.converter.libreoffice

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import pl.beone.lib.junit5.extension.docker.external.DockerExtension
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_MSWORD
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_EXCEL
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_EXCEL_SHEET_MACRO_ENABLED_12
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
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_PLAIN
import pl.beone.promena.transformer.converter.libreoffice.model.Resource
import pl.beone.promena.transformer.converter.libreoffice.util.getResourceAsBytes

@ExtendWith(DockerExtension::class)
class LibreOfficeConverterTransformerMediaTypeLibreOfficeUtf8Test {

    @Test
    fun transform_textCsv() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Plain.LibreOfficeWriter.CSV),
            TEXT_CSV
        )
    }

    @Test
    fun transform_textHtml() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Plain.LibreOfficeWriter.HTML),
            MediaTypeConstants.TEXT_HTML
        )
    }

    @Test
    fun transform_textHtml2() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Plain.LibreOfficeWriter.HTML_CALC),
            MediaTypeConstants.TEXT_HTML
        )
    }

    @Test
    fun transform_applicationRtf() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Plain.LibreOfficeWriter.RTF),
            MediaTypeConstants.APPLICATION_RTF
        )
    }

    @Test
    fun transform_textPlain() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Plain.LibreOfficeWriter.TXT),
            TEXT_PLAIN
        )
    }

    @Test
    fun transform_textXml() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Plain.LibreOfficeWriter.XML),
            MediaTypeConstants.TEXT_XML
        )
    }

    @Test
    fun transform_textXml2003() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Plain.LibreOfficeWriter.XML_2003),
            MediaTypeConstants.TEXT_XML
        )
    }

    // ***

    @Test
    fun transform_applicationVndOasisOpendocumentPresentation() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Presentation.LibreOfficeImpress.ODP),
            APPLICATION_VND_OASIS_OPENDOCUMENT_PRESENTATION
        )
    }

    @Test
    fun transform_applicationVndOasisOpendocumentPresentationTemplate() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Presentation.LibreOfficeImpress.OTP),
            APPLICATION_VND_OASIS_OPENDOCUMENT_PRESENTATION_TEMPLATE
        )
    }

    @Test
    fun transform_applicationVndMsPowerpoint2() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Presentation.LibreOfficeImpress.POT),
            APPLICATION_VND_MS_POWERPOINT
        )
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentPresentationmlTemplate() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Presentation.LibreOfficeImpress.POTX),
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_TEMPLATE
        )
    }

    @Test
    fun transform_applicationVndMsPowerpoint3() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Presentation.LibreOfficeImpress.PPS),
            APPLICATION_VND_MS_POWERPOINT
        )
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentPresentationmlSlideshow() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Presentation.LibreOfficeImpress.PPSX),
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_SLIDESHOW
        )
    }

    @Test
    fun transform_applicationVndMsPowerpoint() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Presentation.LibreOfficeImpress.PPT),
            APPLICATION_VND_MS_POWERPOINT
        )
    }

    @Test
    fun transform_applicationVndMsPowerpointPresentationMacroenabled12() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Presentation.LibreOfficeImpress.PPTM),
            APPLICATION_VND_MS_POWERPOINT_PRESENTATION_MACROENABLED_12
        )
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentPresentationmlPresentation() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Presentation.LibreOfficeImpress.PPTX),
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_PRESENTATION
        )
    }

    // ***

    @Test
    fun transform_applicationVndOasisOpendocumentSpreadsheet() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Spreadsheet.LibreOfficeCalc.ODS),
            APPLICATION_VND_OASIS_OPENDOCUMENT_SPREADSHEET
        )
    }

    @Test
    fun transform_applicationVndOasisOpendocumentSpreadsheetTemplate() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Spreadsheet.LibreOfficeCalc.OTS),
            APPLICATION_VND_OASIS_OPENDOCUMENT_SPREADSHEET_TEMPLATE
        )
    }

    @Test
    fun transform_applicationVndMsExcel3() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Spreadsheet.LibreOfficeCalc.SLK),
            APPLICATION_VND_MS_EXCEL
        )
    }

    @Test
    fun transform_applicationVndMsExcel() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Spreadsheet.LibreOfficeCalc.XLS),
            APPLICATION_VND_MS_EXCEL
        )
    }

    @Test
    fun transform_applicationVndMsExcelSheetMacroEnabled12() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Spreadsheet.LibreOfficeCalc.XLSM),
            APPLICATION_VND_MS_EXCEL_SHEET_MACRO_ENABLED_12
        )
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentSpreadsheetmlSheet() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Spreadsheet.LibreOfficeCalc.XLSX),
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_SHEET
        )
    }

    @Test
    fun transform_applicationVndMsExcel2() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Spreadsheet.LibreOfficeCalc.XLT),
            APPLICATION_VND_MS_EXCEL
        )
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentSpreadsheetmlTemplate() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Spreadsheet.LibreOfficeCalc.XLTX),
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_TEMPLATE
        )
    }

    // ***

    @Test
    fun transform_applicationVndOasisOpendocumentText() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Text.LibreOfficeWriter.ODT),
            APPLICATION_VND_OASIS_OPENDOCUMENT_TEXT
        )
    }

    @Test
    fun transform_applicationMsword() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Text.LibreOfficeWriter.DOC),
            APPLICATION_MSWORD
        )
    }

    @Test
    fun transform_applicationVndMsWordDocumentMacroenabled12() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Text.LibreOfficeWriter.DOCM),
            APPLICATION_VND_MS_WORD_DOCUMENT_MACROENABLED_12
        )
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentWordprocessingmlDocument() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Text.LibreOfficeWriter.DOCX),
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_DOCUMENT
        )
    }

    @Test
    fun transform_applicationMsword2() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Text.LibreOfficeWriter.DOT),
            APPLICATION_MSWORD
        )
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentWordprocessingmlTemplate() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Text.LibreOfficeWriter.DOTX),
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_TEMPLATE
        )
    }
}