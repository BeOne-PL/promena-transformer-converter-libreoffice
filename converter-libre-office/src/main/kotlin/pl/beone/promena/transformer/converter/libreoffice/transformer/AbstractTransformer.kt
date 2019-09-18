package pl.beone.promena.transformer.converter.libreoffice.transformer

import org.jodconverter.LocalConverter
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaType
import pl.beone.promena.transformer.contract.data.DataDescriptor
import pl.beone.promena.transformer.contract.data.TransformedDataDescriptor
import pl.beone.promena.transformer.contract.data.singleTransformedDataDescriptor
import pl.beone.promena.transformer.contract.model.Data
import pl.beone.promena.transformer.contract.model.Parameters
import pl.beone.promena.transformer.converter.libreoffice.manager.OfficeManagerCoordinator
import pl.beone.promena.transformer.converter.libreoffice.transformer.documentformat.DocumentFormatManager
import pl.beone.promena.transformer.converter.libreoffice.transformer.documentformat.registry.*
import java.io.OutputStream

internal abstract class AbstractTransformer(
    private val officeManagerCoordinator: OfficeManagerCoordinator
) {

    companion object {
        val additionalDocumentFormats = listOf(
            ApplicationHtmlDocumentFormat(),
            ApplicationRtfDocumentFormat(),
            TextXmlDocumentFormat(),
            ApplicationVndOpenxmlformatsOfficedocumentPresentationmlTemplateDocumentFormat(),
            ApplicationVndOpenxmlformatsOfficedocumentSpreadsheetmlTemplateDocumentFormat()
        )
    }

    protected abstract fun getOutputStream(): OutputStream

    protected abstract fun createData(): Data

    fun transform(singleDataDescriptor: DataDescriptor.Single, targetMediaType: MediaType, parameters: Parameters): TransformedDataDescriptor.Single {
        DocumentFormatManager.register(additionalDocumentFormats)

        val (data, mediaType, metadata) = singleDataDescriptor

        data.getInputStream().use { inputStream ->
            getOutputStream().use { outputStream ->
                LocalConverter.make(officeManagerCoordinator.getManager())
                    .convert(inputStream)
                    .`as`(DocumentFormatManager.getDocumentFormat(mediaType))
                    .to(outputStream, false)
                    .`as`(DocumentFormatManager.getDocumentFormat(targetMediaType))
                    .execute()
            }
        }

        return singleTransformedDataDescriptor(createData(), metadata)
    }
}