package pl.beone.promena.transformer.converter.libreoffice.environment

internal object OfficeEnvironment {

    val home by lazy { getEnvironmentVariable("OFFICE_HOME") }

    val startingPort by lazy { getEnvironmentVariable("OFFICE_STARTING_PORT").toInt() }

    private fun getEnvironmentVariable(key: String): String =
        System.getenv(key) ?: throw IllegalArgumentException("There is no <$key> environment variable")
}