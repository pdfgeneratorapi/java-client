

# GenerateViewerUrlRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**output** | [**OutputEnum**](#OutputEnum) | Response format. &#x60;url&#x60; returns a public URL to the stored document; &#x60;viewer&#x60; returns a public URL to the PDF viewer (with encrypted prefill when provided). |  [optional] |
|**prefill** | [**PrefillParam**](PrefillParam.md) |  |  [optional] |



## Enum: OutputEnum

| Name | Value |
|---- | -----|
| URL | &quot;url&quot; |
| VIEWER | &quot;viewer&quot; |



