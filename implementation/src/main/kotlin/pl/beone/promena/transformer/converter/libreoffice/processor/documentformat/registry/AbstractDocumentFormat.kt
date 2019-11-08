package pl.beone.promena.transformer.converter.libreoffice.processor.documentformat.registry

import org.jodconverter.document.DocumentFormat

internal abstract class AbstractDocumentFormat {

    abstract fun create(): DocumentFormat

    protected fun createDocumentFormatBasedOn(documentFormat: DocumentFormat, mimeType: String): DocumentFormat =
        DocumentFormat.builder()
            .name(documentFormat.name)
            .extension(documentFormat.extension)
            .mediaType(mimeType)
            .inputFamily(documentFormat.inputFamily)
            .build()
}