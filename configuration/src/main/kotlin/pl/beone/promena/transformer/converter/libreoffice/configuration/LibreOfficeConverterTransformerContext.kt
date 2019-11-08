package pl.beone.promena.transformer.converter.libreoffice.configuration

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import pl.beone.promena.transformer.contract.communication.CommunicationParameters
import pl.beone.promena.transformer.contract.communication.CommunicationWritableDataCreator
import pl.beone.promena.transformer.converter.libreoffice.LibreOfficeConverterTransformer
import pl.beone.promena.transformer.converter.libreoffice.LibreOfficeConverterTransformerDefaultParameters
import pl.beone.promena.transformer.converter.libreoffice.LibreOfficeConverterTransformerSettings

@Configuration
class LibreOfficeConverterTransformerContext {

    @Bean
    fun libreOfficeConverterTransformer(
        settings: LibreOfficeConverterTransformerSettings,
        defaultParameters: LibreOfficeConverterTransformerDefaultParameters,
        @Qualifier("internalCommunicationParameters") communicationParameters: CommunicationParameters,
        @Qualifier("internalCommunicationWritableDataCreator") communicationWritableDataCreator: CommunicationWritableDataCreator
    ) =
        LibreOfficeConverterTransformer(
            settings,
            defaultParameters,
            communicationParameters,
            communicationWritableDataCreator
        )
}