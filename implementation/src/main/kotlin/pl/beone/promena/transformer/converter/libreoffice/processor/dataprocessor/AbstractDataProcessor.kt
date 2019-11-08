package pl.beone.promena.transformer.converter.libreoffice.processor.dataprocessor

import pl.beone.promena.transformer.applicationmodel.mediatype.MediaType
import pl.beone.promena.transformer.contract.model.data.Data

internal abstract class AbstractDataProcessor {

    abstract fun process(data: Data, mediaType: MediaType): Data

    abstract fun isSupported(data: Data, mediaType: MediaType): Boolean
}