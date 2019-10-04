package pl.beone.promena.transformer.converter.libreoffice

data class LibreOfficeConverterTransformerSettings(
    val home: String = "/opt/libreoffice6.3",
    val startingPort: Int = 5000
)