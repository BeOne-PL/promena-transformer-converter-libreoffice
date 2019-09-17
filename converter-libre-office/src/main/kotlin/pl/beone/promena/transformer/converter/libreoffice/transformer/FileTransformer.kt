package pl.beone.promena.transformer.converter.libreoffice.transformer

import pl.beone.promena.transformer.contract.model.Data
import pl.beone.promena.transformer.converter.libreoffice.manager.OfficeManagerCoordinator
import pl.beone.promena.transformer.internal.model.data.fileData
import java.io.File
import java.io.OutputStream

internal class FileTransformer(
    officeManagerCoordinator: OfficeManagerCoordinator,
    directory: File
) : AbstractTransformer(officeManagerCoordinator) {

    private val file = createTempFile(directory = directory)

    override fun getOutputStream(): OutputStream =
        file.outputStream()

    override fun createData(): Data =
        fileData(file)
}