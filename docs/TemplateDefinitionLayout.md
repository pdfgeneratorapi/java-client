

# TemplateDefinitionLayout

Defines template layout (e.g page format, margins).

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**format** | [**FormatEnum**](#FormatEnum) | Defines template page size |  [optional] |
|**width** | **BigDecimal** | Page width in units |  [optional] |
|**height** | **BigDecimal** | Page height in units |  [optional] |
|**unit** | [**UnitEnum**](#UnitEnum) | Measure unit |  [optional] |
|**orientation** | [**OrientationEnum**](#OrientationEnum) | Page orientation |  [optional] |
|**rotation** | [**RotationEnum**](#RotationEnum) | Page rotation in degrees |  [optional] |
|**margins** | [**TemplateDefinitionNewLayoutMargins**](TemplateDefinitionNewLayoutMargins.md) |  |  [optional] |
|**repeatLayout** | [**TemplateDefinitionNewLayoutRepeatLayout**](TemplateDefinitionNewLayoutRepeatLayout.md) |  |  [optional] |
|**emptyLabels** | **Integer** | Defines how many pages or labels should be empty |  [optional] |



## Enum: FormatEnum

| Name | Value |
|---- | -----|
| A4 | &quot;A4&quot; |
| LETTER | &quot;letter&quot; |
| CUSTOM | &quot;custom&quot; |



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



