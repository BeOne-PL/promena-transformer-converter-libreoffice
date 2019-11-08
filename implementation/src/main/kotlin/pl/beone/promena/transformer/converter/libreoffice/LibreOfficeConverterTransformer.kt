package pl.beone.promena.transformer.converter.libreoffice

import pl.beone.promena.transformer.applicationmodel.mediatype.MediaType
import pl.beone.promena.transformer.contract.Transformer
import pl.beone.promena.transformer.contract.communication.CommunicationParameters
import pl.beone.promena.transformer.contract.communication.CommunicationWritableDataCreator
import pl.beone.promena.transformer.contract.data.DataDescriptor
import pl.beone.promena.transformer.contract.data.TransformedDataDescriptor
import pl.beone.promena.transformer.contract.data.toTransformedDataDescriptor
import pl.beone.promena.transformer.contract.model.Parameters
import pl.beone.promena.transformer.converter.libreoffice.applicationmodel.LibreOfficeConverterSupport
import pl.beone.promena.transformer.converter.libreoffice.manager.OfficeManagerCoordinator
import pl.beone.promena.transformer.converter.libreoffice.manager.OfficeManagerPort
import pl.beone.promena.transformer.converter.libreoffice.processor.Processor

class LibreOfficeConverterTransformer(
    settings: LibreOfficeConverterTransformerSettings,
    defaultParameters: LibreOfficeConverterTransformerDefaultParameters,
    private val communicationParameters: CommunicationParameters,
    private val communicationWritableDataCreator: CommunicationWritableDataCreator
) : Transformer {

    private val officeManagerCoordinator = OfficeManagerCoordinator(settings.home, OfficeManagerPort.getNextPort(settings.startingPort))
    private val processor = Processor(defaultParameters, officeManagerCoordinator)

    override fun transform(dataDescriptor: DataDescriptor, targetMediaType: MediaType, parameters: Parameters): TransformedDataDescriptor =
        dataDescriptor.descriptors
            .map { processor.process(it, targetMediaType, parameters, communicationWritableDataCreator.create(communicationParameters)) }
            .toTransformedDataDescriptor()

    override fun isSupported(dataDescriptor: DataDescriptor, targetMediaType: MediaType, parameters: Parameters) {
        LibreOfficeConverterSupport.isSupported(dataDescriptor, targetMediaType, parameters)
    }
}