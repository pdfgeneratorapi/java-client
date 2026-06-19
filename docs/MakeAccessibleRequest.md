

# MakeAccessibleRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**fileUrl** | **String** | Public URL to a PDF document |  |
|**options** | **List&lt;AccessibilityOption&gt;** | Accessibility processing options |  [optional] |
|**name** | **String** | Name for the PDF file |  [optional] |
|**output** | [**OutputEnum**](#OutputEnum) | Returned document output format |  [optional] |
|**metadata** | [**MetadataParam**](MetadataParam.md) |  |  [optional] |
|**fileBase64** | **String** | PDF document in base64 encoded string format |  |



## Enum: OutputEnum

| Name | Value |
|---- | -----|
| BASE64 | &quot;base64&quot; |
| FILE | &quot;file&quot; |
| URL | &quot;url&quot; |
| VIEWER | &quot;viewer&quot; |



