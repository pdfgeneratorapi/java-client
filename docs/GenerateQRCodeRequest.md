

# GenerateQRCodeRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**content** | **String** | The content which is used to generate QR code |  |
|**color** | **String** | QR code in hexadecimal format |  [optional] |
|**logoBase64** | **String** | A logo as a base64 image string to add on the QR code |  [optional] |
|**logoUrl** | **String** | A logo URL to an image to add on the QR code |  [optional] |
|**output** | [**OutputEnum**](#OutputEnum) | Response format |  [optional] |



## Enum: OutputEnum

| Name | Value |
|---- | -----|
| FILE | &quot;file&quot; |
| BASE64 | &quot;base64&quot; |



