package pl.beone.promena.transformer.converter.libreoffice.model

object Resource {

    object Multithreading {
        object Path {
            const val DOCX = "/multithreading/test.docx"
        }
    }

    object MediaType {
        object Path {
            object UTF_8 {
                object Plain {
                    object MicrosoftWord {
                        const val CSV = "/media-type/UTF-8/plain/microsoft-word/test.csv"
                        const val HTML = "/media-type/UTF-8/plain/microsoft-word/test.html"
                        const val HTML2 = "/media-type/UTF-8/plain/microsoft-word/test2.html"
                        const val RTF = "/media-type/UTF-8/plain/microsoft-word/test.rtf"
                        const val TXT = "/media-type/UTF-8/plain/microsoft-word/test.txt"
                        const val XML = "/media-type/UTF-8/plain/microsoft-word/test.xml"
                        const val XML_2003 = "/media-type/UTF-8/plain/microsoft-word/test-2003.xml"
                    }

                    object LibreOfficeWriter {
                        const val CSV = "/media-type/UTF-8/plain/libre-office-writer/test.csv"
                        const val HTML = "/media-type/UTF-8/plain/libre-office-writer/test.html"
                        const val HTML_CALC = "/media-type/UTF-8/plain/libre-office-writer/test-calc.html"
                        const val RTF = "/media-type/UTF-8/plain/libre-office-writer/test.rtf"
                        const val TXT = "/media-type/UTF-8/plain/libre-office-writer/test.txt"
                        const val XML = "/media-type/UTF-8/plain/libre-office-writer/test.xml"
                        const val XML_2003 = "/media-type/UTF-8/plain/libre-office-writer/test-2003.xml"
                    }

                    const val CSV = "/media-type/UTF-8/plain/test.csv"
                    const val HTM = "/media-type/UTF-8/plain/test.htm"
                    const val HTML = "/media-type/UTF-8/plain/test.html"
                    const val RTF = "/media-type/UTF-8/plain/test.rtf"
                    const val TXT = "/media-type/UTF-8/plain/test.txt"
                    const val XML = "/media-type/UTF-8/plain/test.xml"
                }

                object Presentation {
                    object MicrosoftPowerPoint {
                        const val ODP = "/media-type/UTF-8/presentation/microsoft-power-point/test.odp"
                        const val POT = "/media-type/UTF-8/presentation/microsoft-power-point/test.pot"
                        const val POTM = "/media-type/UTF-8/presentation/microsoft-power-point/test.potm"
                        const val POTX = "/media-type/UTF-8/presentation/microsoft-power-point/test.potx"
                        const val PPS = "/media-type/UTF-8/presentation/microsoft-power-point/test.pps"
                        const val PPSM = "/media-type/UTF-8/presentation/microsoft-power-point/test.ppsm"
                        const val PPSX = "/media-type/UTF-8/presentation/microsoft-power-point/test.ppsx"
                        const val PPT = "/media-type/UTF-8/presentation/microsoft-power-point/test.ppt"
                        const val PPTM = "/media-type/UTF-8/presentation/microsoft-power-point/test.pptm"
                        const val PPTX = "/media-type/UTF-8/presentation/microsoft-power-point/test.pptx"
                    }

                    object LibreOfficeImpress {
                        const val ODP = "/media-type/UTF-8/presentation/libre-office-impress/test.odp"
                        const val OTP = "/media-type/UTF-8/presentation/libre-office-impress/test.otp"
                        const val POT = "/media-type/UTF-8/presentation/libre-office-impress/test.pot"
                        const val POTX = "/media-type/UTF-8/presentation/libre-office-impress/test.potx"
                        const val PPS = "/media-type/UTF-8/presentation/libre-office-impress/test.pps"
                        const val PPSX = "/media-type/UTF-8/presentation/libre-office-impress/test.ppsx"
                        const val PPT = "/media-type/UTF-8/presentation/libre-office-impress/test.ppt"
                        const val PPTM = "/media-type/UTF-8/presentation/libre-office-impress/test.pptm"
                        const val PPTX = "/media-type/UTF-8/presentation/libre-office-impress/test.pptx"
                    }

                    const val ODP = "/media-type/UTF-8/presentation/test.odp"
                    const val PPT = "/media-type/UTF-8/presentation/test.ppt"
                    const val PPTX = "/media-type/UTF-8/presentation/test.pptx"
                }

                object Spreadsheet {
                    object MicrosoftExcel {
                        const val ODS = "/media-type/UTF-8/spreadsheet/microsoft-excel/test.ods"
                        const val XLS = "/media-type/UTF-8/spreadsheet/microsoft-excel/test.xls"
                        const val XLSM = "/media-type/UTF-8/spreadsheet/microsoft-excel/test.xlsm"
                        const val XLSX = "/media-type/UTF-8/spreadsheet/microsoft-excel/test.xlsx"
                        const val XLTM = "/media-type/UTF-8/spreadsheet/microsoft-excel/test.xltm"
                        const val XLTX = "/media-type/UTF-8/spreadsheet/microsoft-excel/test.xltx"
                    }

                    object LibreOfficeCalc {
                        const val ODS = "/media-type/UTF-8/spreadsheet/libre-office-calc/test.ods"
                        const val OTS = "/media-type/UTF-8/spreadsheet/libre-office-calc/test.ots"
                        const val SLK = "/media-type/UTF-8/spreadsheet/libre-office-calc/test.slk"
                        const val XLS = "/media-type/UTF-8/spreadsheet/libre-office-calc/test.xls"
                        const val XLSM = "/media-type/UTF-8/spreadsheet/libre-office-calc/test.xlsm"
                        const val XLSX = "/media-type/UTF-8/spreadsheet/libre-office-calc/test.xlsx"
                        const val XLT = "/media-type/UTF-8/spreadsheet/libre-office-calc/test.xlt"
                        const val XLTX = "/media-type/UTF-8/spreadsheet/libre-office-calc/test.xltx"
                    }

                    const val ODS = "/media-type/UTF-8/spreadsheet/test.ods"
                    const val XLS = "/media-type/UTF-8/spreadsheet/test.xls"
                    const val XLSX = "/media-type/UTF-8/spreadsheet/test.xlsx"
                }

                object Text {
                    object MicrosoftWord {
                        const val DOC = "/media-type/UTF-8/text/microsoft-word/test.doc"
                        const val DOCX = "/media-type/UTF-8/text/microsoft-word/test.docx"
                        const val DOT = "/media-type/UTF-8/text/microsoft-word/test.dot"
                        const val ODT = "/media-type/UTF-8/text/microsoft-word/test.odt"
                    }

                    object LibreOfficeWriter {
                        const val DOC = "/media-type/UTF-8/text/libre-office-writer/test.doc"
                        const val DOCM = "/media-type/UTF-8/text/libre-office-writer/test.docm"
                        const val DOCX = "/media-type/UTF-8/text/libre-office-writer/test.docx"
                        const val DOT = "/media-type/UTF-8/text/libre-office-writer/test.dot"
                        const val DOTX = "/media-type/UTF-8/text/libre-office-writer/test.dotx"
                        const val ODT = "/media-type/UTF-8/text/libre-office-writer/test.odt"
                    }

                    const val ODT = "/media-type/UTF-8/text/test.odt"
                    const val DOC = "/media-type/UTF-8/text/test.doc"
                    const val DOCX = "/media-type/UTF-8/text/test.docx"
                    const val PDF = "/media-type/UTF-8/text/test.pdf"
                }
            }

            object ISO_8859_2 {
                object Plain {
                    object LibreOfficeWriter {
                        const val HTML = "/media-type/ISO-8859-2/plain/libre-office-writer/test.html"
                        const val TXT = "/media-type/ISO-8859-2/plain/libre-office-writer/test.txt"
                    }

                    const val TXT = "/media-type/ISO-8859-2/plain/test.txt"
                    const val CSV = "/media-type/ISO-8859-2/plain/test.csv"
                }
            }
        }
    }
}