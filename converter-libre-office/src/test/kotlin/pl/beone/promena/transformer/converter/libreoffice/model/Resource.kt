package pl.beone.promena.transformer.converter.libreoffice.model

object Resource {

    object Path {

        object UTF_8 {
            object Plain {
                const val CSV = "/document/UTF-8/plain/test.csv"
                const val HTM = "/document/UTF-8/plain/test.htm"
                const val HTML = "/document/UTF-8/plain/test.html"
                const val RTF = "/document/UTF-8/plain/test.rtf"
                const val TXT = "/document/UTF-8/plain/test.txt"
                const val XML = "/document/UTF-8/plain/test.xml"
                const val XML_WITH_TAGS = "/document/UTF-8/plain/test_html_with_tags.html"
            }

            object Presentation {
                const val ODP = "/document/UTF-8/presentation/test.odp"
                const val PPT = "/document/UTF-8/presentation/test.ppt"
                const val PPTX = "/document/UTF-8/presentation/test.pptx"
            }

            object Spreadsheet {
                const val ODS = "/document/UTF-8/spreadsheet/test.ods"
                const val XLS = "/document/UTF-8/spreadsheet/test.xls"
                const val XLSX = "/document/UTF-8/spreadsheet/test.xlsx"
            }

            object Text {
                const val ODT = "/document/UTF-8/text/test.odt"
                const val DOC = "/document/UTF-8/text/test.doc"
                const val DOCX = "/document/UTF-8/text/test.docx"
            }
        }

        object ISO_8859_2 {
            object Plain {
                const val TXT = "/document/ISO-8859-2/plain/test.txt"
            }
        }
    }
}