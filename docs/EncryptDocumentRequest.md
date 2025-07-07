

# EncryptDocumentRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**fileUrl** | **String** | Public URL to a PDF document |  |
|**ownerPassword** | **String** | An owner password to open the encrypted document |  |
|**userPassword** | **String** | An user password to open the encrypted document |  [optional] |
|**name** | **String** | Name for the PDF file |  [optional] |
|**output** | [**OutputEnum**](#OutputEnum) | Returned document output format |  [optional] |
|**fileBase64** | **String** | PDF document in base64 encoded string format |  |



## Enum: OutputEnum

| Name | Value |
|---- | -----|
| FILE | &quot;file&quot; |
| BASE64 | &quot;base64&quot; |
| URL | &quot;url&quot; |



