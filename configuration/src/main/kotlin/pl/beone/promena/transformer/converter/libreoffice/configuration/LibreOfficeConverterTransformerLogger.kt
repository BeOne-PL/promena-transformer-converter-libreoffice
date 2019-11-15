package pl.beone.promena.transformer.converter.libreoffice.configuration

import mu.KotlinLogging
import org.springframework.context.annotation.Configuration
import pl.beone.promena.transformer.converter.libreoffice.LibreOfficeConverterTransformer
import pl.beone.promena.transformer.converter.libreoffice.LibreOfficeConverterTransformerDefaultParameters
import pl.beone.promena.transformer.converter.libreoffice.LibreOfficeConverterTransformerSettings
import javax.annotation.PostConstruct

@Configuration
class LibreOfficeConverterTransformerLogger(
    private val settings: LibreOfficeConverterTransformerSettings,
    private val defaultParameters: LibreOfficeConverterTransformerDefaultParameters
) {

    companion object {
        private val logger = KotlinLogging.logger {}
    }

    @PostConstruct
    private fun log() {
        logger.info {
            "Run <${LibreOfficeConverterTransformer::class.java.canonicalName}> with <$settings> and <$defaultParameters>"
        }
    }
}