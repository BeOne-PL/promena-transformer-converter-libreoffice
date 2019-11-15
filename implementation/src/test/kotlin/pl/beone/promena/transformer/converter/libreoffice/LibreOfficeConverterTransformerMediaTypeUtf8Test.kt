package pl.beone.promena.transformer.converter.libreoffice

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import pl.beone.lib.junit.jupiter.external.DockerExtension
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_MSWORD
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_PDF
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_RTF
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_EXCEL
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_MS_POWERPOINT
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OASIS_OPENDOCUMENT_PRESENTATION
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OASIS_OPENDOCUMENT_SPREADSHEET
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OASIS_OPENDOCUMENT_TEXT
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_PRESENTATION
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_SHEET
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_DOCUMENT
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_XML
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_CSV
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_HTML
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_PLAIN
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_XML
import pl.beone.promena.transformer.converter.libreoffice.model.Resource.MediaType.Path.UTF_8.Plain
import pl.beone.promena.transformer.converter.libreoffice.model.Resource.MediaType.Path.UTF_8.Presentation
import pl.beone.promena.transformer.converter.libreoffice.model.Resource.MediaType.Path.UTF_8.Spreadsheet
import pl.beone.promena.transformer.converter.libreoffice.model.Resource.MediaType.Path.UTF_8.Text
import pl.beone.promena.transformer.converter.libreoffice.util.test

@ExtendWith(DockerExtension::class)
class LibreOfficeConverterTransformerMediaTypeUtf8Test {

    @Test
    fun transform_textCsv() {
        test(Plain.CSV, TEXT_CSV)
    }

    @Test
    fun transform_textHtm() {
        test(Plain.HTM, TEXT_HTML)
    }

    @Test
    fun transform_textHtml() {
        test(Plain.HTML, TEXT_HTML)
    }

    @Test
    fun transform_applicationRtf() {
        test(Plain.RTF, APPLICATION_RTF)
    }

    @Test
    fun transform_textPlain() {
        test(Plain.TXT, TEXT_PLAIN)
    }

    @Test
    fun transform_applicationXml() {
        test(Plain.XML, APPLICATION_XML)
    }

    @Test
    fun transform_textXml() {
        test(Plain.XML, TEXT_XML)
    }

    // ***

    @Test
    fun transform_applicationVndOasisOpendocumentPresentation() {
        test(Presentation.ODP, APPLICATION_VND_OASIS_OPENDOCUMENT_PRESENTATION)
    }

    @Test
    fun transform_applicationVndMsPowerpoint() {
        test(Presentation.PPT, APPLICATION_VND_MS_POWERPOINT)
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentPresentationmlPresentation() {
        test(
            Presentation.PPTX,
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_PRESENTATION
        )
    }

    // ***

    @Test
    fun transform_applicationVndOasisOpendocumentSpreadsheet() {
        test(Spreadsheet.ODS, APPLICATION_VND_OASIS_OPENDOCUMENT_SPREADSHEET)
    }

    @Test
    fun transform_applicationVndMsExcel() {
        test(Spreadsheet.XLS, APPLICATION_VND_MS_EXCEL)
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentSpreadsheetmlSheet() {
        test(
            Spreadsheet.XLSX,
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_SHEET
        )
    }

    // ***

    @Test
    fun transform_applicationVndOasisOpendocumentText() {
        test(Text.ODT, APPLICATION_VND_OASIS_OPENDOCUMENT_TEXT)
    }

    @Test
    fun transform_applicationMsword() {
        test(Text.DOC, APPLICATION_MSWORD)
    }

    @Test
    fun transform_applicationVndOpenxmlformatsOfficedocumentWordprocessingmlDocument() {
        test(
            Text.DOCX,
            APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_DOCUMENT
        )
    }

    @Test
    fun transform_applicationPdf() {
        test(Text.PDF, APPLICATION_PDF)
    }
}