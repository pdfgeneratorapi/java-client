# ServicesApi

All URIs are relative to *https://us1.pdfgeneratorapi.com/api/v4*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addWatermark**](ServicesApi.md#addWatermark) | **POST** /pdfservices/watermark | Add watermark |
| [**decryptDocument**](ServicesApi.md#decryptDocument) | **POST** /pdfservices/decrypt | Decrypt document |
| [**encryptDocument**](ServicesApi.md#encryptDocument) | **POST** /pdfservices/encrypt | Encrypt document |
| [**extractFormFields**](ServicesApi.md#extractFormFields) | **POST** /pdfservices/form/fields | Extract form fields |
| [**fillFormFields**](ServicesApi.md#fillFormFields) | **POST** /pdfservices/form/fill | Fill form fields |
| [**makeAccessible**](ServicesApi.md#makeAccessible) | **POST** /pdfservices/make-accessible | Make accessible |
| [**optimizeDocument**](ServicesApi.md#optimizeDocument) | **POST** /pdfservices/optimize | Optimize document |


<a id="addWatermark"></a>
# **addWatermark**
> InlineObject8 addWatermark(addWatermarkRequest)

Add watermark

Adds a text or an image watermark to PDF document from base64 string or a remote URL.

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.ServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    ServicesApi apiInstance = new ServicesApi(defaultClient);
    AddWatermarkRequest addWatermarkRequest = new AddWatermarkRequest(); // AddWatermarkRequest | 
    try {
      InlineObject8 result = apiInstance.addWatermark(addWatermarkRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ServicesApi#addWatermark");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **addWatermarkRequest** | [**AddWatermarkRequest**](AddWatermarkRequest.md)|  | |

### Return type

[**InlineObject8**](InlineObject8.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Document data |  -  |
| **401** | Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  |  -  |
| **402** | Payment Required. The account is suspended. |  -  |
| **403** | Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  |  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  |
| **404** | Not Found. The resource does not exist or the workspace cannot access it. |  -  |
| **422** | Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  |  -  |
| **429** | Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. |  * Retry-After - Seconds to wait before the next request is allowed. <br>  |
| **500** | Internal Server Error |  -  |
| **503** | Service Unavailable. PDF Services is not available on this deployment. |  -  |

<a id="decryptDocument"></a>
# **decryptDocument**
> InlineObject8 decryptDocument(encryptDocumentRequest)

Decrypt document

Decrypts an encrypted PDF document from base64 string or a remote URL.

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.ServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    ServicesApi apiInstance = new ServicesApi(defaultClient);
    EncryptDocumentRequest encryptDocumentRequest = new EncryptDocumentRequest(); // EncryptDocumentRequest | 
    try {
      InlineObject8 result = apiInstance.decryptDocument(encryptDocumentRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ServicesApi#decryptDocument");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **encryptDocumentRequest** | [**EncryptDocumentRequest**](EncryptDocumentRequest.md)|  | |

### Return type

[**InlineObject8**](InlineObject8.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Document data |  -  |
| **401** | Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  |  -  |
| **402** | Payment Required. The account is suspended. |  -  |
| **403** | Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  |  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  |
| **404** | Not Found. The resource does not exist or the workspace cannot access it. |  -  |
| **422** | Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  |  -  |
| **429** | Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. |  * Retry-After - Seconds to wait before the next request is allowed. <br>  |
| **500** | Internal Server Error |  -  |
| **503** | Service Unavailable. PDF Services is not available on this deployment. |  -  |

<a id="encryptDocument"></a>
# **encryptDocument**
> InlineObject8 encryptDocument(encryptDocumentRequest)

Encrypt document

Encrypts a PDF document from base64 string or a remote URL.

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.ServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    ServicesApi apiInstance = new ServicesApi(defaultClient);
    EncryptDocumentRequest encryptDocumentRequest = new EncryptDocumentRequest(); // EncryptDocumentRequest | 
    try {
      InlineObject8 result = apiInstance.encryptDocument(encryptDocumentRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ServicesApi#encryptDocument");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **encryptDocumentRequest** | [**EncryptDocumentRequest**](EncryptDocumentRequest.md)|  | |

### Return type

[**InlineObject8**](InlineObject8.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Document data |  -  |
| **401** | Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  |  -  |
| **402** | Payment Required. The account is suspended. |  -  |
| **403** | Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  |  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  |
| **404** | Not Found. The resource does not exist or the workspace cannot access it. |  -  |
| **422** | Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  |  -  |
| **429** | Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. |  * Retry-After - Seconds to wait before the next request is allowed. <br>  |
| **500** | Internal Server Error |  -  |
| **503** | Service Unavailable. PDF Services is not available on this deployment. |  -  |

<a id="extractFormFields"></a>
# **extractFormFields**
> InlineObject13 extractFormFields(extractFormFieldsRequest)

Extract form fields

Extracts form fields and their metadata from a PDF document using base64 string or a remote URL.

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.ServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    ServicesApi apiInstance = new ServicesApi(defaultClient);
    ExtractFormFieldsRequest extractFormFieldsRequest = new ExtractFormFieldsRequest(); // ExtractFormFieldsRequest | 
    try {
      InlineObject13 result = apiInstance.extractFormFields(extractFormFieldsRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ServicesApi#extractFormFields");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **extractFormFieldsRequest** | [**ExtractFormFieldsRequest**](ExtractFormFieldsRequest.md)|  | |

### Return type

[**InlineObject13**](InlineObject13.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Form fields data |  -  |
| **401** | Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  |  -  |
| **402** | Payment Required. The account is suspended. |  -  |
| **403** | Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  |  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  |
| **404** | Not Found. The resource does not exist or the workspace cannot access it. |  -  |
| **422** | Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  |  -  |
| **429** | Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. |  * Retry-After - Seconds to wait before the next request is allowed. <br>  |
| **500** | Internal Server Error |  -  |
| **503** | Service Unavailable. PDF Services is not available on this deployment. |  -  |

<a id="fillFormFields"></a>
# **fillFormFields**
> InlineObject8 fillFormFields(fillFormFieldsRequest)

Fill form fields

Fills form fields in a PDF document with provided data from base64 string or a remote URL.

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.ServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    ServicesApi apiInstance = new ServicesApi(defaultClient);
    FillFormFieldsRequest fillFormFieldsRequest = new FillFormFieldsRequest(); // FillFormFieldsRequest | 
    try {
      InlineObject8 result = apiInstance.fillFormFields(fillFormFieldsRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ServicesApi#fillFormFields");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **fillFormFieldsRequest** | [**FillFormFieldsRequest**](FillFormFieldsRequest.md)|  | |

### Return type

[**InlineObject8**](InlineObject8.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Document data |  -  |
| **401** | Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  |  -  |
| **402** | Payment Required. The account is suspended. |  -  |
| **403** | Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  |  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  |
| **404** | Not Found. The resource does not exist or the workspace cannot access it. |  -  |
| **422** | Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  |  -  |
| **429** | Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. |  * Retry-After - Seconds to wait before the next request is allowed. <br>  |
| **500** | Internal Server Error |  -  |
| **503** | Service Unavailable. PDF Services is not available on this deployment. |  -  |

<a id="makeAccessible"></a>
# **makeAccessible**
> InlineObject8 makeAccessible(makeAccessibleRequest)

Make accessible

Tags a PDF document for accessibility from base64 string or a remote URL.

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.ServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    ServicesApi apiInstance = new ServicesApi(defaultClient);
    MakeAccessibleRequest makeAccessibleRequest = new MakeAccessibleRequest(); // MakeAccessibleRequest | 
    try {
      InlineObject8 result = apiInstance.makeAccessible(makeAccessibleRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ServicesApi#makeAccessible");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **makeAccessibleRequest** | [**MakeAccessibleRequest**](MakeAccessibleRequest.md)|  | |

### Return type

[**InlineObject8**](InlineObject8.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Document data |  -  |
| **401** | Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  |  -  |
| **402** | Payment Required. The account is suspended. |  -  |
| **403** | Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  |  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  |
| **404** | Not Found. The resource does not exist or the workspace cannot access it. |  -  |
| **422** | Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  |  -  |
| **429** | Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. |  * Retry-After - Seconds to wait before the next request is allowed. <br>  |
| **500** | Internal Server Error |  -  |
| **503** | Service Unavailable. PDF Services is not available on this deployment. |  -  |

<a id="optimizeDocument"></a>
# **optimizeDocument**
> InlineObject11 optimizeDocument(optimizeDocumentRequest)

Optimize document

Optimizes the size of a PDF document from base64 string or a remote URL.

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.ServicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    ServicesApi apiInstance = new ServicesApi(defaultClient);
    OptimizeDocumentRequest optimizeDocumentRequest = new OptimizeDocumentRequest(); // OptimizeDocumentRequest | 
    try {
      InlineObject11 result = apiInstance.optimizeDocument(optimizeDocumentRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ServicesApi#optimizeDocument");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **optimizeDocumentRequest** | [**OptimizeDocumentRequest**](OptimizeDocumentRequest.md)|  | |

### Return type

[**InlineObject11**](InlineObject11.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Document data |  -  |
| **401** | Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  |  -  |
| **402** | Payment Required. The account is suspended. |  -  |
| **403** | Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  |  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  |
| **404** | Not Found. The resource does not exist or the workspace cannot access it. |  -  |
| **422** | Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  |  -  |
| **429** | Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. |  * Retry-After - Seconds to wait before the next request is allowed. <br>  |
| **500** | Internal Server Error |  -  |
| **503** | Service Unavailable. PDF Services is not available on this deployment. |  -  |

