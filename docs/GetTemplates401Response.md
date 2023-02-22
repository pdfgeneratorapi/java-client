

# GetTemplates401Response


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**message** | [**MessageEnum**](#MessageEnum) | Error description |  [optional] |



## Enum: MessageEnum

| Name | Value |
|---- | -----|
| FAILED_REQUEST_EXPIRED | &quot;Authentication failed: request expired&quot; |
| FAILED_SIGNATURE_OR_SECRET_MISSING | &quot;Authentication failed: signature or secret missing&quot; |
| FAILED_WORKSPACE_MISSING | &quot;Authentication failed: workspace missing&quot; |
| FAILED_KEY_MISSING | &quot;Authentication failed: key missing&quot; |
| FAILED_PROPERTY_ISS_ISSUER_MISSING_IN_JWT | &quot;Authentication failed: property iss (issuer) missing in JWT&quot; |
| FAILED_PROPERTY_SUB_SUBJECT_MISSING_IN_JWT | &quot;Authentication failed: property sub (subject) missing in JWT&quot; |
| FAILED_PROPERTY_EXP_EXPIRATION_TIME_MISSING_IN_JWT | &quot;Authentication failed: property exp (expiration time) missing in JWT&quot; |
| FAILED_INVALID_ISS_ISSUER_ | &quot;Authentication failed: invalid iss (issuer)&quot; |
| FAILED_INCORRECT_SIGNATURE | &quot;Authentication failed: incorrect signature&quot; |
| FAILED | &quot;Authentication failed&quot; |



