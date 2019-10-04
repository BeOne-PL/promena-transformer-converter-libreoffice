package pl.beone.promena.transformer.converter.libreoffice.manager

import org.jodconverter.office.LocalOfficeManager
import org.jodconverter.office.OfficeManager

internal class OfficeManagerCoordinator(
    home: String,
    port: Int
) {

    private val officeManager: OfficeManager

    init {
        officeManager = LocalOfficeManager.builder()
            .officeHome(home)
            .portNumbers(port)
            .taskExecutionTimeout(Long.MAX_VALUE)
            .taskQueueTimeout(Long.MAX_VALUE)
            .build()
        closeConverterProcessOnShutdown()

        getManager()
    }

    private fun closeConverterProcessOnShutdown() {
        Runtime.getRuntime().addShutdownHook(object : Thread() {
            override fun run() {
                if (officeManager.isRunning) {
                    officeManager.stop()
                }
            }
        })
    }

    @Synchronized
    fun getManager(): OfficeManager {
        if (!officeManager.isRunning) {
            officeManager.start()
        }

        return officeManager
    }
}