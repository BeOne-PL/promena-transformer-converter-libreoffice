package pl.beone.promena.transformer.converter.libreoffice.transformer.documentformatregistry

import org.jodconverter.document.DefaultDocumentFormatRegistry
import org.jodconverter.document.DocumentFormat
import org.jodconverter.document.SimpleDocumentFormatRegistry
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaType
import pl.beone.promena.transformer.converter.libreoffice.transformer.documentformatregistry.registry.AbstractDocumentFormat

internal object DocumentFormatManager {

    private val simpleDocumentFormatRegistry by lazy { DefaultDocumentFormatRegistry.getInstance() as SimpleDocumentFormatRegistry }

    private val registeredFormats = mutableSetOf<AbstractDocumentFormat>()

    @Synchronized
    fun register(documentFormats: List<AbstractDocumentFormat>) {
        documentFormats.forEach(::register)
    }

    @Synchronized
    fun register(documentFormat: AbstractDocumentFormat) {
        if (!registeredFormats.contains(documentFormat)) {
            simpleDocumentFormatRegistry.addFormat(documentFormat.create())
            registeredFormats.add(documentFormat)
        }
    }

    fun getDocumentFormat(mediaType: MediaType): DocumentFormat =
        try {
            DefaultDocumentFormatRegistry.getFormatByMediaType(mediaType.mimeType)
        } catch (e: Exception) {
            throw IllegalStateException("There is no DocumentFormat in registry for <$mediaType>")
        }
}