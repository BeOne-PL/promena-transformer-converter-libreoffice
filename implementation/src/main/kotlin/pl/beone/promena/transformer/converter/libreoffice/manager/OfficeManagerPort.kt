package pl.beone.promena.transformer.converter.libreoffice.manager

import kotlin.properties.Delegates

object OfficeManagerPort {

    private var port by Delegates.notNull<Int>()

    @Synchronized
    fun getNextPort(startingPort: Int): Int =
        initOrIncrement(startingPort)

    private fun initOrIncrement(startingPort: Int): Int =
        try {
            ++port
        } catch (e: IllegalStateException) {
            port = startingPort
            port
        }
}