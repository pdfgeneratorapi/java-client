

# DocumentSignature


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**fieldName** | **String** | Name of the signature field in the document. |  [optional] |
|**signerName** | **String** | The name the signer signed under. |  [optional] |
|**signer** | **String** | Subject of the certificate that sealed it — an organization, not a person. |  [optional] |
|**issuer** | **String** | Subject of the certificate authority that issued it. |  [optional] |
|**signedAt** | **String** | When a timestamp authority attested the signature (ISO-8601). This is the defensible time; the signer&#39;s own clock proves nothing.  |  [optional] |
|**claimedSignedAt** | **String** | The time the signer&#39;s own software recorded (ISO-8601). |  [optional] |
|**timestampAuthority** | **String** | The timestamp authority that attested the signature. |  [optional] |
|**intact** | **Boolean** | The bytes this signature covers are unchanged. |  [optional] |
|**valid** | **Boolean** | The signature block itself adds up. On its own this does NOT mean the document is unchanged: a tampered file reports &#x60;valid&#x60; true with &#x60;intact&#x60; false, so a verdict needs intact AND valid AND trusted.  |  [optional] |
|**trusted** | **Boolean** | The certificate chains to a trusted root. |  [optional] |
|**coverage** | [**CoverageEnum**](#CoverageEnum) | How much of the file this signature protects. |  [optional] |
|**adesIndication** | [**AdesIndicationEnum**](#AdesIndicationEnum) | The ETSI EN 319 102-1 indication, when the AdES engine could run. |  [optional] |
|**adesSubIndication** | **String** | The AdES sub-indication, naming why an indication is not PASSED. |  [optional] |



## Enum: CoverageEnum

| Name | Value |
|---- | -----|
| ENTIRE_FILE | &quot;ENTIRE_FILE&quot; |
| ENTIRE_REVISION | &quot;ENTIRE_REVISION&quot; |
| CONTIGUOUS_BLOCK_FROM_START | &quot;CONTIGUOUS_BLOCK_FROM_START&quot; |
| OTHER | &quot;OTHER&quot; |



## Enum: AdesIndicationEnum

| Name | Value |
|---- | -----|
| PASSED | &quot;PASSED&quot; |
| INDETERMINATE | &quot;INDETERMINATE&quot; |
| FAILED | &quot;FAILED&quot; |



