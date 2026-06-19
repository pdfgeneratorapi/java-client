

# StoreDocumentRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**fileBase64** | **String** | Base64 encoded PDF file. Required if file_url is not provided. |  [optional] |
|**fileUrl** | **String** | Public HTTPS URL to a PDF file. Required if file_base64 is not provided. |  [optional] |
|**name** | **String** | Generated document name (optional) |  [optional] |
|**output** | [**OutputEnum**](#OutputEnum) | Response format. &#x60;url&#x60; returns a public URL to the stored document; &#x60;viewer&#x60; returns a public URL to the PDF viewer. |  [optional] |



## Enum: OutputEnum

| Name | Value |
|---- | -----|
| URL | &quot;url&quot; |
| VIEWER | &quot;viewer&quot; |



