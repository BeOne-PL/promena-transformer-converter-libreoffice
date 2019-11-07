package pl.beone.promena.transformer.converter.libreoffice.transformer

import pl.beone.promena.transformer.contract.model.data.Data
import pl.beone.promena.transformer.converter.libreoffice.LibreOfficeConverterTransformerDefaultParameters
import pl.beone.promena.transformer.converter.libreoffice.manager.OfficeManagerCoordinator
import pl.beone.promena.transformer.internal.model.data.memory.memoryData
import java.io.ByteArrayOutputStream
import java.io.OutputStream

internal class MemoryTransformer(
    defaultParameters: LibreOfficeConverterTransformerDefaultParameters,
    officeManagerCoordinator: OfficeManagerCoordinator
) : AbstractTransformer(defaultParameters, officeManagerCoordinator) {

    private val outputStream = ByteArrayOutputStream()

    override fun getOutputStream(): OutputStream =
        outputStream

    override fun createData(): Data =
        memoryData(outputStream.toByteArray())
}