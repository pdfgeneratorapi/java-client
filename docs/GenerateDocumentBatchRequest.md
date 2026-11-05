

# GenerateDocumentBatchRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**template** | [**List&lt;TemplateParam&gt;**](TemplateParam.md) |  |  |
|**format** | **FormatParam** |  |  [optional] |
|**output** | **OutputParam** |  |  [optional] |
|**name** | **String** | Generated document name (optional) |  [optional] |
|**testing** | **Boolean** | When set to true the generation is not counted as merge (monthly usage), but a large PREVIEW stamp is added. |  [optional] |
|**print** | **Boolean** | When set to true, the PDF opens the print dialog when it is opened in a viewer. |  [optional] |
|**emptyLabels** | **Integer** | Number of label positions to leave empty at the start of the first sheet. Only applies to label templates. |  [optional] |
|**attachments** | [**List&lt;AttachmentsParamInner&gt;**](AttachmentsParamInner.md) | Files embedded into the generated PDF as attachments. Only PDF and XML files are accepted. |  [optional] |
|**metadata** | [**MetadataParam**](MetadataParam.md) |  |  [optional] |



