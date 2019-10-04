package pl.beone.promena.transformer.converter.libreoffice.transformer

import pl.beone.promena.transformer.contract.model.Data
import pl.beone.promena.transformer.converter.libreoffice.manager.OfficeManagerCoordinator
import pl.beone.promena.transformer.internal.model.data.memoryData
import java.io.ByteArrayOutputStream
import java.io.OutputStream

internal class MemoryTransformer(
    officeManagerCoordinator: OfficeManagerCoordinator
) : AbstractTransformer(officeManagerCoordinator) {

    private val outputStream = ByteArrayOutputStream()

    override fun getOutputStream(): OutputStream =
        outputStream

    override fun createData(): Data =
        memoryData(outputStream.toByteArray())
}