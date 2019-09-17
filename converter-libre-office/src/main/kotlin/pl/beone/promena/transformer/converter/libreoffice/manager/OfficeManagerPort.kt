package pl.beone.promena.transformer.converter.libreoffice.manager

import pl.beone.promena.transformer.converter.libreoffice.environment.OfficeEnvironment
import java.util.concurrent.atomic.AtomicInteger

internal class OfficeManagerPort {

    private val port = AtomicInteger(OfficeEnvironment.startingPort)

    fun getNextPort(): Int =
        port.getAndIncrement()
}