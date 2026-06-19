

# CreateEInvoiceRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**data** | **Object** | JSON payload that represents the Peppol BIS Billing 3.0 UBL Invoice (https://docs.peppol.eu/poacc/billing/3.0/) Use the Get schema endpoint to see the detailed payload structure. |  |
|**type** | [**TypeEnum**](#TypeEnum) | Formatting type. |  [optional] |
|**output** | [**OutputEnum**](#OutputEnum) | Response format. When the \&quot;file\&quot; option is used the API returns the file inline. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| UBL | &quot;UBL&quot; |
| CII | &quot;CII&quot; |



## Enum: OutputEnum

| Name | Value |
|---- | -----|
| BASE64 | &quot;base64&quot; |
| FILE | &quot;file&quot; |



