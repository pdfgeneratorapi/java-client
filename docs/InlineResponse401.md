

# InlineResponse401


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**error** | [**ErrorEnum**](#ErrorEnum) | Error description |  [optional]
**status** | **Integer** | HTTP Error code |  [optional]



## Enum: ErrorEnum

Name | Value
---- | -----
FAILED_REQUEST_EXPIRED | &quot;Authentication failed: request expired&quot;
FAILED_SIGNATURE_OR_SECRET_MISSING | &quot;Authentication failed: signature or secret missing&quot;
FAILED_WORKSPACE_MISSING | &quot;Authentication failed: workspace missing&quot;
FAILED_KEY_MISSING | &quot;Authentication failed: key missing&quot;
FAILED_PROPERTY_ISS_ISSUER_MISSING_IN_JWT | &quot;Authentication failed: property &#39;iss&#39; (issuer) missing in JWT&quot;
FAILED_PROPERTY_SUB_SUBJECT_MISSING_IN_JWT | &quot;Authentication failed: property &#39;sub&#39; (subject) missing in JWT&quot;
FAILED_PROPERTY_EXP_EXPIRATION_TIME_MISSING_IN_JWT | &quot;Authentication failed: property &#39;exp&#39; (expiration time) missing in JWT&quot;
FAILED_INVALID_ISS_ISSUER_ | &quot;Authentication failed: invalid &#39;iss&#39; (issuer)&quot;
FAILED_INCORRECT_SIGNATURE | &quot;Authentication failed: incorrect signature&quot;
FAILED | &quot;Authentication failed&quot;



