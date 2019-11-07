package pl.beone.promena.transformer.converter.libreoffice.transformer

import org.jodconverter.LocalConverter
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaType
import pl.beone.promena.transformer.contract.data.DataDescriptor
import pl.beone.promena.transformer.contract.data.TransformedDataDescriptor
import pl.beone.promena.transformer.contract.data.singleTransformedDataDescriptor
import pl.beone.promena.transformer.contract.model.Parameters
import pl.beone.promena.transformer.contract.model.data.Data
import pl.beone.promena.transformer.converter.libreoffice.LibreOfficeConverterTransformerDefaultParameters
import pl.beone.promena.transformer.converter.libreoffice.manager.OfficeManagerCoordinator
import pl.beone.promena.transformer.converter.libreoffice.transformer.dataprocessor.TextPlainAndTextCsvOtherThanUtf8DataProcessor
import pl.beone.promena.transformer.converter.libreoffice.transformer.documentformat.DocumentFormatManager
import pl.beone.promena.transformer.converter.libreoffice.transformer.documentformat.registry.*
import java.io.InputStream
import java.io.OutputStream
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

internal abstract class AbstractTransformer(
    private val defaultParameters: LibreOfficeConverterTransformerDefaultParameters,
    private val officeManagerCoordinator: OfficeManagerCoordinator
) {

    companion object {
        val additionalDocumentFormats = listOf(
            ApplicationHtmlDocumentFormat,
            ApplicationRtfDocumentFormat,
            TextXmlDocumentFormat,
            ApplicationVndOpenxmlformatsOfficedocumentWordprocessingmlTemplateDocumentFormat,
            ApplicationVndOpenxmlformatsOfficedocumentSpreadsheetmlTemplateDocumentFormat,
            ApplicationVndOpenxmlformatsOfficedocumentPresentationmlTemplateDocumentFormat,
            ApplicationVndOpenxmlformatsOfficedocumentPresentationmlSlideshowDocumentFormat,
            ApplicationVndMsWordDocumentMacroenabled12DocumentFormat,
            ApplicationVndMsExcelSheetMacroEnabled12DocumentFormat,
            ApplicationVndMsExcelTemplateMacroEnabled12DocumentFormat,
            ApplicationVndMsPowerpointTemplateMacroenabled12DocumentFormat,
            ApplicationVndMsPowerpointPresentationMacroenabled12DocumentFormat,
            ApplicationVndMsPowerpointSlideshowMacroenabled12DocumentFormat,
            ApplicationAlfresccoVndMsExcelSheetMacroEnabled12DocumentFormat,
            ApplicationAlfrescoVndMsExcelTemplateMacroEnabled12DocumentFormat,
            ApplicationAlfrescoVndMsPowerpointPresentationMacroenabled12DocumentFormat,
            ApplicationAlfrescoVndMsPowerpointSlideshowMacroenabled12DocumentFormat,
            ApplicationAlfrescoVndMsPowerpointTemplateMacroenabled12DocumentFormat,
            ApplicationAlfrescoVndMsWordDocumentMacroenabled12DocumentFormat
        )

        val dataProcessors = listOf(
            TextPlainAndTextCsvOtherThanUtf8DataProcessor
        )
    }

    protected abstract fun getOutputStream(): OutputStream

    protected abstract fun createData(): Data

    fun transform(singleDataDescriptor: DataDescriptor.Single, targetMediaType: MediaType, parameters: Parameters): TransformedDataDescriptor.Single {
        DocumentFormatManager.register(additionalDocumentFormats)

        val (data, mediaType, metadata) = singleDataDescriptor

        processData(data, mediaType).getInputStream().use { inputStream ->
            getOutputStream().use { outputStream ->
                val timeout = parameters.getTimeoutOrNull() ?: defaultParameters.timeout
                if (timeout != null) {
                    Executors.newSingleThreadExecutor()
                        .submit { convert(inputStream, mediaType, outputStream, targetMediaType) }
                        // FIXME it only interrupts this thread but not the running LibreOffice process
                        .get(timeout.toMillis(), TimeUnit.MILLISECONDS)
                } else {
                    convert(inputStream, mediaType, outputStream, targetMediaType)
                }
            }
        }

        return singleTransformedDataDescriptor(createData(), metadata)
    }

    private fun convert(inputStream: InputStream, mediaType: MediaType, outputStream: OutputStream, targetMediaType: MediaType) {
        LocalConverter.make(officeManagerCoordinator.getManager())
            .convert(inputStream)
            .`as`(DocumentFormatManager.getDocumentFormat(mediaType))
            .to(outputStream, false)
            .`as`(DocumentFormatManager.getDocumentFormat(targetMediaType))
            .execute()
    }

    private fun processData(data: Data, mediaType: MediaType): Data =
        dataProcessors
            .filter { it.isSupported(data, mediaType) }
            .fold(data) { currentData, dataProcessor -> dataProcessor.process(currentData, mediaType) }
}