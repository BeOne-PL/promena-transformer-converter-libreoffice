package pl.beone.promena.transformer.converter.libreoffice.model

object Resource {

    object Path {

        object UTF_8 {
            object Plain {
                object MicrosoftWord {
                    const val CSV = "/document/UTF-8/plain/microsoft-word/test.csv"
                    const val HTML = "/document/UTF-8/plain/microsoft-word/test.html"
                    const val HTML2 = "/document/UTF-8/plain/microsoft-word/test2.html"
                    const val RTF = "/document/UTF-8/plain/microsoft-word/test.rtf"
                    const val TXT = "/document/UTF-8/plain/microsoft-word/test.txt"
                    const val XML = "/document/UTF-8/plain/microsoft-word/test.xml"
                    const val XML2003 = "/document/UTF-8/plain/microsoft-word/test-2003.xml"
                }

                const val CSV = "/document/UTF-8/plain/test.csv"
                const val HTM = "/document/UTF-8/plain/test.htm"
                const val HTML = "/document/UTF-8/plain/test.html"
                const val RTF = "/document/UTF-8/plain/test.rtf"
                const val TXT = "/document/UTF-8/plain/test.txt"
                const val XML = "/document/UTF-8/plain/test.xml"
            }

            object Presentation {
                object MicrosoftPowerPoint {
                    const val ODP = "/document/UTF-8/presentation/microsoft-power-point/test.odp"
                    const val POT = "/document/UTF-8/presentation/microsoft-power-point/test.pot"
                    const val POTX = "/document/UTF-8/presentation/microsoft-power-point/test.potx"
                    const val PPT = "/document/UTF-8/presentation/microsoft-power-point/test.ppt"
                    const val PPTX = "/document/UTF-8/presentation/microsoft-power-point/test.pptx"
                }

                const val ODP = "/document/UTF-8/presentation/test.odp"
                const val PPT = "/document/UTF-8/presentation/test.ppt"
                const val PPTX = "/document/UTF-8/presentation/test.pptx"
            }

            object Spreadsheet {
                object MicrosoftExcel {
                    const val ODS = "/document/UTF-8/spreadsheet/microsoft-excel/test.ods"
                    const val XLS = "/document/UTF-8/spreadsheet/microsoft-excel/test.xls"
                    const val XLSX = "/document/UTF-8/spreadsheet/microsoft-excel/test.xlsx"
                    const val XLTX = "/document/UTF-8/spreadsheet/microsoft-excel/test.xltx"
                }

                const val ODS = "/document/UTF-8/spreadsheet/test.ods"
                const val XLS = "/document/UTF-8/spreadsheet/test.xls"
                const val XLSX = "/document/UTF-8/spreadsheet/test.xlsx"
            }

            object Text {
                object MicrosoftWord {
                    const val DOC = "/document/UTF-8/text/microsoft-word/test.doc"
                    const val DOCX = "/document/UTF-8/text/microsoft-word/test.docx"
                    const val DOT = "/document/UTF-8/text/microsoft-word/test.dot"
                    const val ODT = "/document/UTF-8/text/microsoft-word/test.odt"
                }

                const val ODT = "/document/UTF-8/text/test.odt"
                const val DOC = "/document/UTF-8/text/test.doc"
                const val DOCX = "/document/UTF-8/text/test.docx"
            }
        }

        object ISO_8859_2 {
            object Plain {
                const val TXT = "/document/ISO-8859-2/plain/test.txt"
                const val COMPLEX_HTML = "/document/ISO-8859-2/plain/complex_test.html"
            }
        }
    }
}