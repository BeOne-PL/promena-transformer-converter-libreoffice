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
import pl.beone.promena.transformer.converter.libreoffice.model.Resource.MediaType.Path.UTF_8.Plain
import pl.beone.promena.transformer.converter.libreoffice.model.Resource.MediaType.Path.UTF_8.Presentation
import pl.beone.promena.transformer.converter.libreoffice.model.Resource.MediaType.Path.UTF_8.Spreadsheet
import pl.beone.promena.transformer.converter.libreoffice.model.Resource.MediaType.Path.UTF_8.Text
import pl.beone.promena.transformer.converter.libreoffice.util.test

@ExtendWith(DockerExtension::class)
class LibreOfficeConverterTransformerMediaTypeToApplicationPdfMicrosoftWordUtf8Test {

    @Test
    fun transform_textCsv() {
        test(Plain.MicrosoftWord.CSV, TEXT_CSV)
    }

    @Test
    fun transform_textHtml() {
        test(Plain.MicrosoftWord.HTML, TEXT_HTML)
    }

    @Test
    fun transform_textHtml2() {
        test(Plain.MicrosoftWord.HTML2, TEXT_HTML)
    }

    @Test
    fun transform_applicationRtf() {
        test(Plain.MicrosoftWord.RTF, APPLICATION_RTF)
    }

    @Test
    fun transform_textPlain() {
        test(Plain.MicrosoftWord.TXT, TEXT_PLAIN)
    }

    @Test
    fun transform_textXml() {
        test(Plain.MicrosoftWord.XML, TEXT_XML)
    }

    @Test
    fun transform_textXml2003() {
        test(Plain.MicrosoftWord.XML_2003, TEXT_XML)
    }

    // ***

    @Test
    fun transform_applicationVndOasisOpendocumentPresentation() {
        test(
            Presentation.MicrosoftPowerPoint.ODP,
            APPLICATION_VND_OASIS_OPENDOCUMENT_PRESENTATION
        )
    }

    @Test
    fun transform_applicationVndMsPowerpoint2() {
        test(
            Presentation.MicrosoftPowerPoint.POT,
            APPLICATION_VND_MS_POWERPOINT
        )
    }

    @Test
    fun transform_applicationVndMsPowerpointTemplateMacroenabled12() {
        test(
            Presentation.MicrosoftPowerPoint.POTM,
            APPLICATION_VND_MS_POWERPOINT_TEMPLATE_MACROENABLED_12
        )

        test(
            Presentation.MicrosoftPowerPoint.POTM,
            AlfrescoMediaTypeConstants.APPLICATION_VND_MS_POWERPOINT_TEMPLATE_MACROENABLED_12
        )
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentPresentationmlTemplate() {
        test(
            Presentation.MicrosoftPowerPoint.POTX,
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_TEMPLATE
        )
    }

    @Test
    fun transform_applicationVndMsPowerpoint3() {
        test(
            Presentation.MicrosoftPowerPoint.PPS,
            APPLICATION_VND_MS_POWERPOINT
        )
    }

    @Test
    fun transform_applicationVndMsPowerpointSlideshowMacroenabled12() {
        test(
            Presentation.MicrosoftPowerPoint.PPSM,
            APPLICATION_VND_MS_POWERPOINT_SLIDESHOW_MACROENABLED_12
        )

        test(
            Presentation.MicrosoftPowerPoint.PPSM,
            AlfrescoMediaTypeConstants.APPLICATION_VND_MS_POWERPOINT_SLIDESHOW_MACROENABLED_12
        )
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentPresentationmlSlideshow() {
        test(
            Presentation.MicrosoftPowerPoint.PPSX,
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_SLIDESHOW
        )
    }

    @Test
    fun transform_applicationVndMsPowerpoint() {
        test(
            Presentation.MicrosoftPowerPoint.PPT,
            APPLICATION_VND_MS_POWERPOINT
        )
    }

    @Test
    fun transform_applicationVndMsPowerpointPresentationMacroenabled12() {
        test(
            Presentation.MicrosoftPowerPoint.PPTM,
            APPLICATION_VND_MS_POWERPOINT_PRESENTATION_MACROENABLED_12
        )

        test(
            Presentation.MicrosoftPowerPoint.PPTM,
            AlfrescoMediaTypeConstants.APPLICATION_VND_MS_POWERPOINT_PRESENTATION_MACROENABLED_12
        )
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentPresentationmlPresentation() {
        test(
            Presentation.MicrosoftPowerPoint.PPTX,
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_PRESENTATION
        )
    }

    // ***

    @Test
    fun transform_applicationVndOasisOpendocumentSpreadsheet() {
        test(
            Spreadsheet.MicrosoftExcel.ODS,
            APPLICATION_VND_OASIS_OPENDOCUMENT_SPREADSHEET
        )
    }

    @Test
    fun transform_applicationVndMsExcel() {
        test(Spreadsheet.MicrosoftExcel.XLS, APPLICATION_VND_MS_EXCEL)
    }

    @Test
    fun transform_applicationVndMsExcelSheetMacroEnabled12() {
        test(
            Spreadsheet.MicrosoftExcel.XLSM,
            APPLICATION_VND_MS_EXCEL_SHEET_MACROENABLED_12
        )

        test(
            Spreadsheet.MicrosoftExcel.XLSM,
            AlfrescoMediaTypeConstants.APPLICATION_VND_MS_EXCEL_SHEET_MACROENABLED_12
        )
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentSpreadsheetmlSheet() {
        test(
            Spreadsheet.MicrosoftExcel.XLSX,
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_SHEET
        )
    }

    @Test
    fun transform_applicationVndMsExcelTemplateMacroEnabled12() {
        test(
            Spreadsheet.MicrosoftExcel.XLTM,
            APPLICATION_VND_MS_EXCEL_TEMPLATE_MACROENABLED_12
        )

        test(
            Spreadsheet.MicrosoftExcel.XLTM,
            AlfrescoMediaTypeConstants.APPLICATION_VND_MS_EXCEL_TEMPLATE_MACROENABLED_12
        )
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentSpreadsheetmlTemplate() {
        test(
            Spreadsheet.MicrosoftExcel.XLTX,
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_TEMPLATE
        )
    }

    // ***

    @Test
    fun transform_applicationVndOasisOpendocumentText() {
        test(Text.MicrosoftWord.ODT, APPLICATION_VND_OASIS_OPENDOCUMENT_TEXT)
    }

    @Test
    fun transform_applicationMsword() {
        test(Text.MicrosoftWord.DOC, APPLICATION_MSWORD)
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentWordprocessingmlDocument() {
        test(
            Text.MicrosoftWord.DOCX,
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_DOCUMENT
        )
    }

    @Test
    fun transform_applicationMsword2() {
        test(Text.MicrosoftWord.DOT, APPLICATION_MSWORD)
    }
}