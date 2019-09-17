package pl.beone.promena.transformer.converter.libreoffice.transformer

import org.jodconverter.LocalConverter
import org.jodconverter.document.DefaultDocumentFormatRegistry
import org.jodconverter.document.DocumentFormat
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaType
import pl.beone.promena.transformer.contract.data.DataDescriptor
import pl.beone.promena.transformer.contract.data.TransformedDataDescriptor
import pl.beone.promena.transformer.contract.data.singleTransformedDataDescriptor
import pl.beone.promena.transformer.contract.model.Data
import pl.beone.promena.transformer.contract.model.Parameters
import pl.beone.promena.transformer.converter.libreoffice.manager.OfficeManagerCoordinator
import java.io.OutputStream

internal abstract class AbstractTransformer(
    private val officeManagerCoordinator: OfficeManagerCoordinator
) {

    protected abstract fun getOutputStream(): OutputStream

    protected abstract fun createData(): Data

    fun transform(singleDataDescriptor: DataDescriptor.Single, targetMediaType: MediaType, parameters: Parameters): TransformedDataDescriptor.Single {
        val (data, mediaType, metadata) = singleDataDescriptor

        data.getInputStream().use { inputStream ->
            getOutputStream().use { outputStream ->
                LocalConverter.make(officeManagerCoordinator.getManager())
                    .convert(inputStream)
                    .`as`(determineDocumentFormat(mediaType))
                    .to(outputStream, true)
                    .`as`(determineDocumentFormat(targetMediaType))
                    .execute()
            }
        }

        return singleTransformedDataDescriptor(createData(), metadata)
    }

    private fun determineDocumentFormat(mediaType: MediaType): DocumentFormat =
        try {
            DefaultDocumentFormatRegistry.getFormatByMediaType(mediaType.mimeType)
        } catch (e: Exception) {
            throw IllegalStateException("There is no DocumentFormat in registry for <$mediaType>")
        }
}