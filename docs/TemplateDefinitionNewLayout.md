

# TemplateDefinitionNewLayout

Defines template layout (e.g page format, margins). A layout needs a format, an orientation and margins with all four sides.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**format** | [**FormatEnum**](#FormatEnum) | Defines template page size. For any other size, use custom with width and height. |  |
|**width** | **BigDecimal** | Page width in units. Left out, it is the format&#39;s width; send it with a custom format. |  [optional] |
|**height** | **BigDecimal** | Page height in units. Left out, it is the format&#39;s height; send it with a custom format. |  [optional] |
|**unit** | [**UnitEnum**](#UnitEnum) | Measure unit |  [optional] |
|**orientation** | [**OrientationEnum**](#OrientationEnum) | Page orientation |  |
|**rotation** | [**RotationEnum**](#RotationEnum) | Page rotation in degrees |  [optional] |
|**margins** | [**TemplateDefinitionNewLayoutMargins**](TemplateDefinitionNewLayoutMargins.md) |  |  |
|**repeatLayout** | [**TemplateDefinitionNewLayoutRepeatLayout**](TemplateDefinitionNewLayoutRepeatLayout.md) |  |  [optional] |
|**emptyLabels** | **Integer** | Specifies how many blank lables to add to sheet label. |  [optional] |



## Enum: FormatEnum

| Name | Value |
|---- | -----|
| A2 | &quot;A2&quot; |
| A3 | &quot;A3&quot; |
| A4 | &quot;A4&quot; |
| A5 | &quot;A5&quot; |
| LETTER | &quot;letter&quot; |
| CUSTOM | &quot;custom&quot; |
| LABEL | &quot;label&quot; |



## Enum: UnitEnum

| Name | Value |
|---- | -----|
| CM | &quot;cm&quot; |
| IN | &quot;in&quot; |



## Enum: OrientationEnum

| Name | Value |
|---- | -----|
| PORTRAIT | &quot;portrait&quot; |
| LANDSCAPE | &quot;landscape&quot; |



## Enum: RotationEnum

| Name | Value |
|---- | -----|
| NUMBER_0 | 0 |
| NUMBER_90 | 90 |
| NUMBER_180 | 180 |
| NUMBER_270 | 270 |



