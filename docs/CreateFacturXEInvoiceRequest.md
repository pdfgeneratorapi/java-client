

# CreateFacturXEInvoiceRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**template** | [**CreateFacturXEInvoiceRequestTemplate**](CreateFacturXEInvoiceRequestTemplate.md) |  |  |
|**profile** | [**ProfileEnum**](#ProfileEnum) | Factur-X conformance level. |  [optional] |
|**output** | **OutputParam** |  |  [optional] |
|**name** | **String** | Generated document name (optional) |  [optional] |
|**metadata** | [**MetadataParam**](MetadataParam.md) |  |  [optional] |



## Enum: ProfileEnum

| Name | Value |
|---- | -----|
| BASIC | &quot;basic&quot; |
| BASICWL | &quot;basicwl&quot; |
| EN16931 | &quot;en16931&quot; |
| MINIMUM | &quot;minimum&quot; |
| EXTENDED | &quot;extended&quot; |
| XRECHNUNG | &quot;xrechnung&quot; |



