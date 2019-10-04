package pl.beone.promena.transformer.converter.libreoffice.configuration

import io.kotlintest.shouldBe
import org.junit.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.core.env.ConfigurableEnvironment
import org.springframework.mock.env.MockEnvironment
import pl.beone.promena.transformer.converter.libreoffice.LibreOfficeConverterTransformerDefaultParameters
import pl.beone.promena.transformer.converter.libreoffice.LibreOfficeConverterTransformerSettings
import java.time.Duration

class LibreOfficeConverterTransformerConfigurationContextTest {

    @Test
    fun `setting context`() {
        val environment = createEnvironment(
            mapOf(
                "transformer.pl.beone.promena.transformer.converter.libreoffice.settings.home" to "/opt/libreoffice6.3",
                "transformer.pl.beone.promena.transformer.converter.libreoffice.settings.startingPort" to "5000",

                "transformer.pl.beone.promena.transformer.converter.libreoffice.default.parameters.timeout" to "5m"
            )
        )

        val applicationContext = createConfigApplicationContext(environment, LibreOfficeConverterTransformerConfigurationContext::class.java)
        applicationContext.getBean(LibreOfficeConverterTransformerSettings::class.java).let {
            it.home shouldBe "/opt/libreoffice6.3"
            it.startingPort shouldBe 5000
        }
        applicationContext.getBean(LibreOfficeConverterTransformerDefaultParameters::class.java)
            .timeout shouldBe Duration.ofMinutes(5)
    }

    @Test
    fun `setting context _ empty timeout`() {
        val environment = createEnvironment(
            mapOf(
                "transformer.pl.beone.promena.transformer.converter.libreoffice.settings.home" to "/opt/libreoffice6.3",
                "transformer.pl.beone.promena.transformer.converter.libreoffice.settings.startingPort" to "5000",

                "transformer.pl.beone.promena.transformer.converter.libreoffice.default.parameters.timeout" to ""
            )
        )

        val applicationContext = createConfigApplicationContext(environment, LibreOfficeConverterTransformerConfigurationContext::class.java)
        applicationContext.getBean(LibreOfficeConverterTransformerSettings::class.java).let {
            it.home shouldBe "/opt/libreoffice6.3"
            it.startingPort shouldBe 5000
        }
        applicationContext.getBean(LibreOfficeConverterTransformerDefaultParameters::class.java)
            .timeout shouldBe null
    }

    private fun createEnvironment(properties: Map<String, String>): MockEnvironment =
        MockEnvironment()
            .apply { properties.forEach { (key, value) -> setProperty(key, value) } }

    private fun createConfigApplicationContext(environment: ConfigurableEnvironment, clazz: Class<*>): AnnotationConfigApplicationContext =
        AnnotationConfigApplicationContext().apply {
            this.environment = environment
            register(clazz)
            refresh()
        }
}