package pl.beone.promena.transformer.converter.libreoffice.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import pl.beone.promena.transformer.converter.libreoffice.LibreOfficeConverterTransformerDefaultParameters
import pl.beone.promena.transformer.converter.libreoffice.LibreOfficeConverterTransformerSettings
import pl.beone.promena.transformer.converter.libreoffice.configuration.extension.getNotBlankProperty
import pl.beone.promena.transformer.converter.libreoffice.configuration.extension.getRequiredNotBlankProperty
import pl.beone.promena.transformer.converter.libreoffice.configuration.extension.toDuration

@Configuration
class LibreOfficeConverterTransformerConfigurationContext {

    companion object {
        private const val PROPERTY_PREFIX = "transformer.pl.beone.promena.transformer.converter.libreoffice"
    }

    @Bean
    fun libreOfficeConverterTransformerSettings(environment: Environment): LibreOfficeConverterTransformerSettings =
        LibreOfficeConverterTransformerSettings(
            environment.getRequiredNotBlankProperty("$PROPERTY_PREFIX.settings.home"),
            environment.getRequiredNotBlankProperty("$PROPERTY_PREFIX.settings.startingPort").toInt()
        )

    @Bean
    fun libreOfficeConverterTransformerDefaultParameters(environment: Environment): LibreOfficeConverterTransformerDefaultParameters =
        LibreOfficeConverterTransformerDefaultParameters(
            environment.getNotBlankProperty("$PROPERTY_PREFIX.default.parameters.timeout")?.toDuration()
        )
}