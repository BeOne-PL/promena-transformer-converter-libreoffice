package pl.beone.promena.transformer.converter.libreoffice.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import pl.beone.promena.transformer.contract.communication.CommunicationParameters
import pl.beone.promena.transformer.converter.libreoffice.LibreOfficeConverterTransformer

@Configuration
class LibreOfficeConverterTransformerContext {

    @Bean
    fun libreOfficeConverterTransformer(internalCommunicationParameters: CommunicationParameters) =
        LibreOfficeConverterTransformer(internalCommunicationParameters)
}