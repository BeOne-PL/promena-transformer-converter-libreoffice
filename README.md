# Promena Transformer - `converter - LibreOffice`
This transformer provides functionality to convert a document from one format to a `application/pdf` document using LibreOffice 6.3.1.2.

Visit [Promena#Transformer](https://gitlab.office.beone.pl/promena/promena#transformer) to understand the repository structure.

## Transformation [`LibreOfficeConverterDsl`](./application-model/src/main/kotlin/pl/beone/promena/transformer/converter/libreoffice/applicationmodel/LibreOfficeConverterDsl.kt)
The [`DataDescriptor`](https://gitlab.office.beone.pl/promena/promena/blob/master/base/promena-transformer/contract/src/main/kotlin/pl/beone/promena/transformer/contract/data/DataDescriptor.kt) has to contain at least one descriptor. If more than one descriptor is passed, the transformation will be performed on each of them separately.

## Support [`LibreOfficeConverterSupport`](./application-model/src/main/kotlin/pl/beone/promena/transformer/converter/libreoffice/applicationmodel/LibreOfficeConverterSupport.kt)
### Media type [`LibreOfficeConverterSupport.MediaTypeSupport`](./application-model/src/main/kotlin/pl/beone/promena/transformer/converter/libreoffice/applicationmodel/LibreOfficeConverterSupport.kt)
* `application/msword; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/vnd.ms-excel; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/vnd.ms-excel.sheet.macroEnabled.12; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/vnd.ms-excel.template.macroEnabled.12; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/vnd.ms-powerpoint; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/vnd.ms-powerpoint.presentation.macroEnabled.12; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/vnd.ms-powerpoint.slideshow.macroEnabled.12; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/vnd.ms-powerpoint.template.macroEnabled.12; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/vnd.ms-word.document.macroEnabled.12; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/vnd.oasis.opendocument.presentation; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/vnd.oasis.opendocument.presentation-template; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/vnd.oasis.opendocument.spreadsheet; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/vnd.oasis.opendocument.spreadsheet-template; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/vnd.oasis.opendocument.text; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/vnd.openxmlformats-officedocument.presentationml.presentation; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/vnd.openxmlformats-officedocument.presentationml.slideshow; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/vnd.openxmlformats-officedocument.presentationml.template; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/vnd.openxmlformats-officedocument.spreadsheetml.sheet; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/vnd.openxmlformats-officedocument.spreadsheetml.template; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/vnd.openxmlformats-officedocument.wordprocessingml.document; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/vnd.openxmlformats-officedocument.wordprocessingml.template; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/rtf; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/pdf; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/vnd.ms-word.document.macroenabled.12; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/vnd.ms-powerpoint.template.macroenabled.12; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/vnd.ms-powerpoint.slideshow.macroenabled.12; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/vnd.ms-powerpoint.presentation.macroenabled.12; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/vnd.ms-excel.sheet.macroenabled.12; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `application/vnd.ms-excel.template.macroenabled.12; UTF-8` :arrow_right: `application/pdf; UTF-8`
* `text/csv` :arrow_right: `application/pdf; UTF-8`
* `text/html` :arrow_right: `application/pdf; UTF-8`
* `text/plain` :arrow_right: `application/pdf; UTF-8`
* `text/xml` :arrow_right: `application/pdf; UTF-8`

## Dependency
```xml
<dependency>
    <groupId>pl.beone.promena.transformer</groupId>
    <artifactId>converter-libreoffice-configuration</artifactId>
    <version>1.0.0</version>
</dependency>
```

### `promena-docker-maven-plugin`
```xml
<dependency>
    <groupId>pl.beone.promena.transformer</groupId>
    <artifactId>converter-libreoffice</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Properties
```properties
transformer.pl.beone.promena.transformer.converter.libreoffice.LibreOfficeConverterTransformer.priority=1
transformer.pl.beone.promena.transformer.converter.libreoffice.LibreOfficeConverterTransformer.actors=1

transformer.pl.beone.promena.transformer.converter.libreoffice.settings.home=/opt/libreoffice6.3
transformer.pl.beone.promena.transformer.converter.libreoffice.settings.startingPort=5000

transformer.pl.beone.promena.transformer.converter.libreoffice.default.parameters.timeout=
```