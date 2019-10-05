package pl.beone.promena.transformer.converter.libreoffice

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import pl.beone.lib.junit.jupiter.external.DockerExtension
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_MSWORD
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_RTF
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_EXCEL
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_EXCEL_SHEET_MACROENABLED_12
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_EXCEL_TEMPLATE_MACROENABLED_12
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_POWERPOINT
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_POWERPOINT_PRESENTATION_MACROENABLED_12
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_POWERPOINT_SLIDESHOW_MACROENABLED_12
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_POWERPOINT_TEMPLATE_MACROENABLED_12
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OASIS_OPENDOCUMENT_PRESENTATION
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OASIS_OPENDOCUMENT_SPREADSHEET
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OASIS_OPENDOCUMENT_TEXT
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_PRESENTATION
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_SLIDESHOW
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_TEMPLATE
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_SHEET
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_TEMPLATE
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_DOCUMENT
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_CSV
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_HTML
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_PLAIN
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_XML
import pl.beone.promena.transformer.converter.libreoffice.applicationmodel.AlfrescoMediaTypeConstants
import pl.beone.promena.transformer.converter.libreoffice.model.Resource
import pl.beone.promena.transformer.converter.libreoffice.util.getResourceAsBytes

@ExtendWith(DockerExtension::class)
class LibreOfficeConverterTransformerMediaTypeToApplicationPdfMicrosoftWordUtf8Test {

    @Test
    fun transform_textCsv() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Plain.MicrosoftWord.CSV),
            TEXT_CSV
        )
    }

    @Test
    fun transform_textHtml() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Plain.MicrosoftWord.HTML),
            TEXT_HTML
        )
    }

    @Test
    fun transform_textHtml2() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Plain.MicrosoftWord.HTML2),
            TEXT_HTML
        )
    }

    @Test
    fun transform_applicationRtf() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Plain.MicrosoftWord.RTF),
            APPLICATION_RTF
        )
    }

    @Test
    fun transform_textPlain() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Plain.MicrosoftWord.TXT),
            TEXT_PLAIN
        )
    }

    @Test
    fun transform_textXml() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Plain.MicrosoftWord.XML),
            TEXT_XML
        )
    }

    @Test
    fun transform_textXml2003() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Plain.MicrosoftWord.XML_2003),
            TEXT_XML
        )
    }

    // ***

    @Test
    fun transform_applicationVndOasisOpendocumentPresentation() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Presentation.MicrosoftPowerPoint.ODP),
            APPLICATION_VND_OASIS_OPENDOCUMENT_PRESENTATION
        )
    }

    @Test
    fun transform_applicationVndMsPowerpoint2() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Presentation.MicrosoftPowerPoint.POT),
            APPLICATION_VND_MS_POWERPOINT
        )
    }

    @Test
    fun transform_applicationVndMsPowerpointTemplateMacroenabled12() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Presentation.MicrosoftPowerPoint.POTM),
            APPLICATION_VND_MS_POWERPOINT_TEMPLATE_MACROENABLED_12
        )

        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Presentation.MicrosoftPowerPoint.POTM),
            AlfrescoMediaTypeConstants.APPLICATION_VND_MS_POWERPOINT_TEMPLATE_MACROENABLED_12
        )
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentPresentationmlTemplate() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Presentation.MicrosoftPowerPoint.POTX),
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_TEMPLATE
        )
    }

    @Test
    fun transform_applicationVndMsPowerpoint3() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Presentation.MicrosoftPowerPoint.PPS),
            APPLICATION_VND_MS_POWERPOINT
        )
    }

    @Test
    fun transform_applicationVndMsPowerpointSlideshowMacroenabled12() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Presentation.MicrosoftPowerPoint.PPSM),
            APPLICATION_VND_MS_POWERPOINT_SLIDESHOW_MACROENABLED_12
        )

        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Presentation.MicrosoftPowerPoint.PPSM),
            AlfrescoMediaTypeConstants.APPLICATION_VND_MS_POWERPOINT_SLIDESHOW_MACROENABLED_12
        )
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentPresentationmlSlideshow() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Presentation.MicrosoftPowerPoint.PPSX),
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_SLIDESHOW
        )
    }

    @Test
    fun transform_applicationVndMsPowerpoint() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Presentation.MicrosoftPowerPoint.PPT),
            APPLICATION_VND_MS_POWERPOINT
        )
    }

    @Test
    fun transform_applicationVndMsPowerpointPresentationMacroenabled12() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Presentation.MicrosoftPowerPoint.PPTM),
            APPLICATION_VND_MS_POWERPOINT_PRESENTATION_MACROENABLED_12
        )

        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Presentation.MicrosoftPowerPoint.PPTM),
            AlfrescoMediaTypeConstants.APPLICATION_VND_MS_POWERPOINT_PRESENTATION_MACROENABLED_12
        )
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentPresentationmlPresentation() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Presentation.MicrosoftPowerPoint.PPTX),
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_PRESENTATION
        )
    }

    // ***

    @Test
    fun transform_applicationVndOasisOpendocumentSpreadsheet() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Spreadsheet.MicrosoftExcel.ODS),
            APPLICATION_VND_OASIS_OPENDOCUMENT_SPREADSHEET
        )
    }

    @Test
    fun transform_applicationVndMsExcel() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Spreadsheet.MicrosoftExcel.XLS),
            APPLICATION_VND_MS_EXCEL
        )
    }

    @Test
    fun transform_applicationVndMsExcelSheetMacroEnabled12() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Spreadsheet.MicrosoftExcel.XLSM),
            APPLICATION_VND_MS_EXCEL_SHEET_MACROENABLED_12
        )

        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Spreadsheet.MicrosoftExcel.XLSM),
            AlfrescoMediaTypeConstants.APPLICATION_VND_MS_EXCEL_SHEET_MACROENABLED_12
        )
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentSpreadsheetmlSheet() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Spreadsheet.MicrosoftExcel.XLSX),
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_SHEET
        )
    }

    @Test
    fun transform_applicationVndMsExcelTemplateMacroEnabled12() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Spreadsheet.MicrosoftExcel.XLTM),
            APPLICATION_VND_MS_EXCEL_TEMPLATE_MACROENABLED_12
        )

        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Spreadsheet.MicrosoftExcel.XLTM),
            AlfrescoMediaTypeConstants.APPLICATION_VND_MS_EXCEL_TEMPLATE_MACROENABLED_12
        )
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentSpreadsheetmlTemplate() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Spreadsheet.MicrosoftExcel.XLTX),
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_TEMPLATE
        )
    }

    // ***

    @Test
    fun transform_applicationVndOasisOpendocumentText() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Text.MicrosoftWord.ODT),
            APPLICATION_VND_OASIS_OPENDOCUMENT_TEXT
        )
    }

    @Test
    fun transform_applicationMsword() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Text.MicrosoftWord.DOC),
            APPLICATION_MSWORD
        )
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentWordprocessingmlDocument() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Text.MicrosoftWord.DOCX),
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_DOCUMENT
        )
    }

    @Test
    fun transform_applicationMsword2() {
        memoryTest(
            getResourceAsBytes(Resource.MediaType.Path.UTF_8.Text.MicrosoftWord.DOT),
            APPLICATION_MSWORD
        )
    }
}