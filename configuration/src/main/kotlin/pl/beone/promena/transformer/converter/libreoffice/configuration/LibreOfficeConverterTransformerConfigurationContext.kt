package pl.beone.promena.transformer.converter.libreoffice.configuration

import org.joda.time.format.PeriodFormatterBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import pl.beone.promena.transformer.converter.libreoffice.LibreOfficeConverterTransformerDefaultParameters
import pl.beone.promena.transformer.converter.libreoffice.LibreOfficeConverterTransformerSettings
import java.time.Duration

@Configuration
class LibreOfficeConverterTransformerConfigurationContext {

    companion object {
        private const val PROPERTY_PREFIX = "transformer.pl.beone.promena.transformer.converter.libreoffice"
    }

    @Bean
    fun libreOfficeConverterTransformerSettings(environment: Environment): LibreOfficeConverterTransformerSettings =
        LibreOfficeConverterTransformerSettings(
            environment.getRequiredProperty("$PROPERTY_PREFIX.settings.home"),
            environment.getRequiredProperty("$PROPERTY_PREFIX.settings.startingPort").toInt()
        )

    @Bean
    fun libreOfficeConverterTransformerDefaultParameters(environment: Environment): LibreOfficeConverterTransformerDefaultParameters =
        LibreOfficeConverterTransformerDefaultParameters(
            environment.getProperty("$PROPERTY_PREFIX.default.parameters.timeout").ifSet { it.toDuration() }
        )

    private fun <T> String?.ifSet(toRun: (String) -> T): T? =
        when {
            this == null || isBlank() -> null
            else -> toRun(this)
        }

    private fun String.toDuration(): Duration =
        Duration.ofMillis(
            PeriodFormatterBuilder()
                .appendDays().appendSuffix("d")
                .appendHours().appendSuffix("h")
                .appendMinutes().appendSuffix("m")
                .appendSeconds().appendSuffix("s")
                .appendMillis().appendSuffix("ms")
                .toFormatter()
                .parsePeriod(this).toStandardDuration().millis
        )
}