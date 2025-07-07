

# WatermarkBase64


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**fileBase64** | **String** | PDF file from base64 string to add the watermark to |  |
|**watermark** | [**WatermarkFileUrlWatermark**](WatermarkFileUrlWatermark.md) |  |  |
|**output** | [**OutputEnum**](#OutputEnum) | Returned document output |  [optional] |
|**name** | **String** | File name of the returned document |  [optional] |



## Enum: OutputEnum

| Name | Value |
|---- | -----|
| FILE | &quot;file&quot; |
| BASE64 | &quot;base64&quot; |
| URL | &quot;url&quot; |



