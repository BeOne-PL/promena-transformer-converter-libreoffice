package pl.beone.promena.transformer.converter.libreoffice

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import pl.beone.lib.junit5.extension.docker.external.DockerExtension
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_MSWORD
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_EXCEL
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_POWERPOINT
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OASIS_OPENDOCUMENT_PRESENTATION
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OASIS_OPENDOCUMENT_SPREADSHEET
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OASIS_OPENDOCUMENT_TEXT
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_PRESENTATION
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_TEMPLATE
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_SHEET
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_TEMPLATE
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_DOCUMENT
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_CSV
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_PLAIN
import pl.beone.promena.transformer.converter.libreoffice.model.Resource
import pl.beone.promena.transformer.converter.libreoffice.util.getResourceAsBytes

@ExtendWith(DockerExtension::class)
class LibreOfficeConverterTransformerMediaTypeMicrosoftWordUtf8Test {

    @Test
    fun transform_fromTextCsvToApplicationPdf() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Plain.MicrosoftWord.CSV),
            TEXT_CSV
        )
    }

    @Test
    fun transform_fromTextHtmlToApplicationPdf() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Plain.MicrosoftWord.HTML),
            MediaTypeConstants.TEXT_HTML
        )
    }

    @Test
    fun transform_fromTextHtmlToApplicationPdf2() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Plain.MicrosoftWord.HTML2),
            MediaTypeConstants.TEXT_HTML
        )
    }

    @Test
    fun transform_fromApplicationRtfToApplicationPdf() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Plain.MicrosoftWord.RTF),
            MediaTypeConstants.APPLICATION_RTF
        )
    }

    @Test
    fun transform_fromTextPlainToApplicationPdf() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Plain.MicrosoftWord.TXT),
            TEXT_PLAIN
        )
    }

    @Test
    fun transform_fromTextXmlToApplicationPdf() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Plain.MicrosoftWord.XML),
            MediaTypeConstants.TEXT_XML
        )
    }

    @Test
    fun transform_fromTextXml2003ToApplicationPdf() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Plain.MicrosoftWord.XML2003),
            MediaTypeConstants.TEXT_XML
        )
    }

    // ***

    @Test
    fun transform_fromApplicationVndOasisOpendocumentPresentationToApplicationPdf() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Presentation.MicrosoftPowerPoint.ODP),
            APPLICATION_VND_OASIS_OPENDOCUMENT_PRESENTATION
        )
    }

    @Test
    fun transform_fromApplicationVndMsPowerpointToApplicationPdf2() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Presentation.MicrosoftPowerPoint.POT),
            APPLICATION_VND_MS_POWERPOINT
        )
    }

    @Test
    fun transform_fromApplicationVndOpenxmlformatsOfficedocumentPresentationmlTemplateToApplicationPdf() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Presentation.MicrosoftPowerPoint.POTX),
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_TEMPLATE
        )
    }

    @Test
    fun transform_fromApplicationVndMsPowerpointToApplicationPdf() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Presentation.MicrosoftPowerPoint.PPT),
            APPLICATION_VND_MS_POWERPOINT
        )
    }

    @Test
    fun transform_fromApplicationVndOpenxmlformatsOfficedocumentPresentationmlPresentationToApplicationPdf() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Presentation.MicrosoftPowerPoint.PPTX),
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_PRESENTATION
        )
    }

    // ***

    @Test
    fun transform_fromApplicationVndOasisOpendocumentSpreadsheetToApplicationPdf() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Spreadsheet.MicrosoftExcel.ODS),
            APPLICATION_VND_OASIS_OPENDOCUMENT_SPREADSHEET
        )
    }

    @Test
    fun transform_fromApplicationVndMsExcelToApplicationPdf() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Spreadsheet.MicrosoftExcel.XLS),
            APPLICATION_VND_MS_EXCEL
        )
    }

    @Test
    fun transform_fromApplicationVndOpenxmlformatsOfficedocumentSpreadsheetmlSheetToApplicationPdf() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Spreadsheet.MicrosoftExcel.XLSX),
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_SHEET
        )
    }

    @Test
    fun transform_fromApplicationVndOpenxmlformatsOfficedocumentSpreadsheetmlTemplateToApplicationPdf() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Spreadsheet.MicrosoftExcel.XLTX),
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_TEMPLATE
        )
    }

    // ***

    @Test
    fun transform_fromApplicationVndOasisOpendocumentTextToApplicationPdf() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Text.MicrosoftWord.ODT),
            APPLICATION_VND_OASIS_OPENDOCUMENT_TEXT
        )
    }

    @Test
    fun transform_fromApplicationMswordToApplicationPdf() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Text.MicrosoftWord.DOC),
            APPLICATION_MSWORD
        )
    }

    @Test
    fun transform_fromApplicationVndOpenxmlformatsOfficedocumentWordprocessingmlDocumentToApplicationPdf() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Text.MicrosoftWord.DOCX),
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_DOCUMENT
        )
    }

    @Test
    fun transform_fromApplicationMswordToApplicationPdf2() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Text.MicrosoftWord.DOT),
            APPLICATION_MSWORD
        )
    }
}