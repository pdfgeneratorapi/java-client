

# FillFormFieldsRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**fileUrl** | **String** | Public URL to a PDF document |  |
|**data** | **Object** | Form field data to fill in the PDF |  |
|**output** | [**OutputEnum**](#OutputEnum) | Returned document output format |  [optional] |
|**name** | **String** | Name for the PDF file |  [optional] |
|**fileBase64** | **String** | PDF document in base64 encoded string format |  |



## Enum: OutputEnum

| Name | Value |
|---- | -----|
| FILE | &quot;file&quot; |
| BASE64 | &quot;base64&quot; |
| URL | &quot;url&quot; |



