package pl.beone.promena.transformer.converter.libreoffice.applicationmodel

import pl.beone.promena.transformer.contract.transformer.transformerId

object LibreOfficeConverterConstants {

    const val TRANSFORMER_NAME = "converter"

    const val TRANSFORMER_SUB_NAME = "LibreOffice"

    @JvmField
    val TRANSFORMER_ID = transformerId(TRANSFORMER_NAME, TRANSFORMER_SUB_NAME)
}