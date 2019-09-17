package pl.beone.promena.transformer.converter.libreoffice

import pl.beone.promena.communication.file.model.contract.FileCommunicationParameters
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaType
import pl.beone.promena.transformer.contract.Transformer
import pl.beone.promena.transformer.contract.communication.CommunicationParameters
import pl.beone.promena.transformer.contract.data.DataDescriptor
import pl.beone.promena.transformer.contract.data.TransformedDataDescriptor
import pl.beone.promena.transformer.contract.data.toTransformedDataDescriptor
import pl.beone.promena.transformer.contract.model.Parameters
import pl.beone.promena.transformer.converter.libreoffice.manager.OfficeManagerCoordinator
import pl.beone.promena.transformer.converter.libreoffice.manager.OfficeManagerPort
import pl.beone.promena.transformer.converter.libreoffice.transformer.AbstractTransformer
import pl.beone.promena.transformer.converter.libreoffice.transformer.FileTransformer
import pl.beone.promena.transformer.converter.libreoffice.transformer.MemoryTransformer

class LibreOfficeConverterTransformer(
    private val internalCommunicationParameters: CommunicationParameters
) : Transformer {

    companion object {
        private val officeManagerPort by lazy { OfficeManagerPort() }

        private val supporter = Supporter()
    }

    private val officeManagerCoordinator = OfficeManagerCoordinator(officeManagerPort.getNextPort())

    override fun transform(dataDescriptor: DataDescriptor, targetMediaType: MediaType, parameters: Parameters): TransformedDataDescriptor =
        dataDescriptor.descriptors
            .map { determineTransformer().transform(it, targetMediaType, parameters) }
            .toTransformedDataDescriptor()

    private fun determineTransformer(): AbstractTransformer =
        when (internalCommunicationParameters.getId()) {
            FileCommunicationParameters.ID ->
                FileTransformer(officeManagerCoordinator, (internalCommunicationParameters as FileCommunicationParameters).getDirectory())
            else ->
                MemoryTransformer(officeManagerCoordinator)
        }

    override fun isSupported(dataDescriptor: DataDescriptor, targetMediaType: MediaType, parameters: Parameters) {
        supporter.isSupported(dataDescriptor, targetMediaType)
    }
}