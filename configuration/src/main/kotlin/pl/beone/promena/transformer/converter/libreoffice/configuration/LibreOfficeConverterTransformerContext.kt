package pl.beone.promena.transformer.converter.libreoffice.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import pl.beone.promena.transformer.contract.communication.CommunicationParameters
import pl.beone.promena.transformer.converter.libreoffice.LibreOfficeConverterTransformer
import pl.beone.promena.transformer.converter.libreoffice.LibreOfficeConverterTransformerDefaultParameters
import pl.beone.promena.transformer.converter.libreoffice.LibreOfficeConverterTransformerSettings

@Configuration
class LibreOfficeConverterTransformerContext {

    @Bean
    fun libreOfficeConverterTransformer(
        settings: LibreOfficeConverterTransformerSettings,
        defaultParameters: LibreOfficeConverterTransformerDefaultParameters,
        internalCommunicationParameters: CommunicationParameters
    ) =
        LibreOfficeConverterTransformer(
            settings,
            defaultParameters,
            internalCommunicationParameters
        )
}