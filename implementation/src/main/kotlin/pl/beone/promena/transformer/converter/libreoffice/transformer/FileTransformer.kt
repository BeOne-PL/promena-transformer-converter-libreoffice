package pl.beone.promena.transformer.converter.libreoffice.transformer

import pl.beone.promena.transformer.contract.model.data.Data
import pl.beone.promena.transformer.converter.libreoffice.LibreOfficeConverterTransformerDefaultParameters
import pl.beone.promena.transformer.converter.libreoffice.manager.OfficeManagerCoordinator
import pl.beone.promena.transformer.internal.model.data.file.fileData
import java.io.File
import java.io.OutputStream

internal class FileTransformer(
    defaultParameters: LibreOfficeConverterTransformerDefaultParameters,
    officeManagerCoordinator: OfficeManagerCoordinator,
    directory: File
) : AbstractTransformer(defaultParameters, officeManagerCoordinator) {

    private val file = createTempFile(directory = directory)

    override fun getOutputStream(): OutputStream =
        file.outputStream()

    override fun createData(): Data =
        fileData(file)
}