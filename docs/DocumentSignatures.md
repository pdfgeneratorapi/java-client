

# DocumentSignatures


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**status** | [**StatusEnum**](#StatusEnum) | The one-line answer, reduced from every signature worst case first. &#x60;unavailable&#x60; means signature validation is not enabled on this deployment — it says nothing about the document.  |  [optional] |
|**statusLabel** | **String** | The status in words, ready to display. |  [optional] |
|**hasLongTermValidation** | **Boolean** | The document carries the certificate and revocation data needed to verify it after the signing certificates expire.  |  [optional] |
|**coversWholeDocument** | **Boolean** | The last signature covers every byte, so nothing was appended after it. |  [optional] |
|**documentTimestamps** | **Integer** | Timestamp-only signatures, counted rather than listed: they are machinery, not people, and would double every signer.  |  [optional] |
|**signatures** | [**List&lt;DocumentSignature&gt;**](DocumentSignature.md) | One entry per signature, excluding document timestamps. |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| UNAVAILABLE | &quot;unavailable&quot; |
| UNSIGNED | &quot;unsigned&quot; |
| INVALID | &quot;invalid&quot; |
| INDETERMINATE | &quot;indeterminate&quot; |
| VALID | &quot;valid&quot; |



