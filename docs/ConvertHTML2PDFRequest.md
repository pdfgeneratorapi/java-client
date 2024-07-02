

# ConvertHTML2PDFRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**content** | **String** | HTML content |  [optional] |
|**paperSize** | [**PaperSizeEnum**](#PaperSizeEnum) | PDF page size |  [optional] |
|**orientation** | [**OrientationEnum**](#OrientationEnum) |  |  [optional] |
|**output** | [**OutputEnum**](#OutputEnum) | Output |  [optional] |
|**filename** | **String** | Document name |  [optional] |



## Enum: PaperSizeEnum

| Name | Value |
|---- | -----|
| A0 | &quot;a0&quot; |
| A1 | &quot;a1&quot; |
| A2 | &quot;a2&quot; |
| A3 | &quot;a3&quot; |
| A4 | &quot;a4&quot; |
| LEGAL | &quot;legal&quot; |
| TABLOID | &quot;tabloid&quot; |
| LETTER | &quot;letter&quot; |



## Enum: OrientationEnum

| Name | Value |
|---- | -----|
| PORTRAIT | &quot;portrait&quot; |
| LANDSCAPE | &quot;landscape&quot; |



## Enum: OutputEnum

| Name | Value |
|---- | -----|
| BASE64 | &quot;base64&quot; |
| FILE | &quot;file&quot; |



