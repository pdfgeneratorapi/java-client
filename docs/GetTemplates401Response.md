

# GetTemplates401Response


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**message** | [**MessageEnum**](#MessageEnum) | Error description |  [optional] |



## Enum: MessageEnum

| Name | Value |
|---- | -----|
| AUTHENTICATION_FAILED_REQUEST_EXPIRED | &quot;Authentication failed: request expired&quot; |
| AUTHENTICATION_FAILED_SIGNATURE_OR_SECRET_MISSING | &quot;Authentication failed: signature or secret missing&quot; |
| AUTHENTICATION_FAILED_WORKSPACE_MISSING | &quot;Authentication failed: workspace missing&quot; |
| AUTHENTICATION_FAILED_KEY_MISSING | &quot;Authentication failed: key missing&quot; |
| AUTHENTICATION_FAILED_PROPERTY_ISS_ISSUER_MISSING_IN_JWT | &quot;Authentication failed: property iss (issuer) missing in JWT&quot; |
| AUTHENTICATION_FAILED_PROPERTY_SUB_SUBJECT_MISSING_IN_JWT | &quot;Authentication failed: property sub (subject) missing in JWT&quot; |
| AUTHENTICATION_FAILED_PROPERTY_EXP_EXPIRATION_TIME_MISSING_IN_JWT | &quot;Authentication failed: property exp (expiration time) missing in JWT&quot; |
| AUTHENTICATION_FAILED_INVALID_ISS_ISSUER_ | &quot;Authentication failed: invalid iss (issuer)&quot; |
| AUTHENTICATION_FAILED_INCORRECT_SIGNATURE | &quot;Authentication failed: incorrect signature&quot; |
| AUTHENTICATION_FAILED | &quot;Authentication failed&quot; |



