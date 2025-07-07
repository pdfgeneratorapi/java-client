

# AddWatermarkRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**fileUrl** | **String** | PDF file from remote URL to add the watermark to |  |
|**watermark** | [**WatermarkFileUrlWatermark**](WatermarkFileUrlWatermark.md) |  |  |
|**output** | [**OutputEnum**](#OutputEnum) | Returned document output |  [optional] |
|**name** | **String** | File name of the returned document |  [optional] |
|**fileBase64** | **String** | PDF file from base64 string to add the watermark to |  |



## Enum: OutputEnum

| Name | Value |
|---- | -----|
| FILE | &quot;file&quot; |
| BASE64 | &quot;base64&quot; |
| URL | &quot;url&quot; |



