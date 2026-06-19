

# MakeAccessibleBase64


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**fileBase64** | **String** | PDF document in base64 encoded string format |  |
|**options** | **List&lt;AccessibilityOption&gt;** | Accessibility processing options |  [optional] |
|**name** | **String** | Name for the PDF file |  [optional] |
|**output** | [**OutputEnum**](#OutputEnum) | Returned document output format |  [optional] |
|**metadata** | [**MetadataParam**](MetadataParam.md) |  |  [optional] |



## Enum: OutputEnum

| Name | Value |
|---- | -----|
| BASE64 | &quot;base64&quot; |
| FILE | &quot;file&quot; |
| URL | &quot;url&quot; |
| VIEWER | &quot;viewer&quot; |



