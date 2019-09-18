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
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_SHEET
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_DOCUMENT
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_CSV
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_PLAIN
import pl.beone.promena.transformer.converter.libreoffice.model.Resource
import pl.beone.promena.transformer.converter.libreoffice.util.getResourceAsBytes

@ExtendWith(DockerExtension::class)
class LibreOfficeConverterTransformerMediaTypeUtf8Test {

    @Test
    fun transform_textCsv() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Plain.CSV),
            TEXT_CSV
        )
    }

    @Test
    fun transform_textHtm() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Plain.HTM),
            MediaTypeConstants.TEXT_HTML
        )
    }

    @Test
    fun transform_textHtml() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Plain.HTML),
            MediaTypeConstants.TEXT_HTML
        )
    }

    @Test
    fun transform_applicationRtf() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Plain.RTF),
            MediaTypeConstants.APPLICATION_RTF
        )
    }

    @Test
    fun transform_textPlain() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Plain.TXT),
            TEXT_PLAIN
        )
    }

    @Test
    fun transform_applicationXml() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Plain.XML),
            MediaTypeConstants.APPLICATION_XML
        )
    }

    @Test
    fun transform_textXml() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Plain.XML),
            MediaTypeConstants.TEXT_XML
        )
    }

    // ***

    @Test
    fun transform_applicationVndOasisOpendocumentPresentation() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Presentation.ODP),
            APPLICATION_VND_OASIS_OPENDOCUMENT_PRESENTATION
        )
    }

    @Test
    fun transform_applicationVndMsPowerpoint() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Presentation.PPT),
            APPLICATION_VND_MS_POWERPOINT
        )
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentPresentationmlPresentation() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Presentation.PPTX),
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_PRESENTATION
        )
    }

    // ***

    @Test
    fun transform_applicationVndOasisOpendocumentSpreadsheet() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Spreadsheet.ODS),
            APPLICATION_VND_OASIS_OPENDOCUMENT_SPREADSHEET
        )
    }

    @Test
    fun transform_applicationVndMsExcel() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Spreadsheet.XLS),
            APPLICATION_VND_MS_EXCEL
        )
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentSpreadsheetmlSheet() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Spreadsheet.XLSX),
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_SHEET
        )
    }

    // ***

    @Test
    fun transform_applicationVndOasisOpendocumentText() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Text.ODT),
            APPLICATION_VND_OASIS_OPENDOCUMENT_TEXT
        )
    }

    @Test
    fun transform_applicationMsword() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Text.DOC),
            APPLICATION_MSWORD
        )
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentWordprocessingmlDocument() {
        memoryTest(
            getResourceAsBytes(Resource.Path.UTF_8.Text.DOCX),
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_DOCUMENT
        )
    }
}