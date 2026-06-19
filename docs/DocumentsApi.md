# DocumentsApi

All URIs are relative to *https://us1.pdfgeneratorapi.com/api/v4*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**deleteDocument**](DocumentsApi.md#deleteDocument) | **DELETE** /documents/{publicId} | Delete document |
| [**generateDocument**](DocumentsApi.md#generateDocument) | **POST** /documents/generate | Generate document |
| [**generateDocumentAsynchronous**](DocumentsApi.md#generateDocumentAsynchronous) | **POST** /documents/generate/async | Generate document (async) |
| [**generateDocumentBatch**](DocumentsApi.md#generateDocumentBatch) | **POST** /documents/generate/batch | Generate document (batch) |
| [**generateDocumentBatchAsynchronous**](DocumentsApi.md#generateDocumentBatchAsynchronous) | **POST** /documents/generate/batch/async | Generate document (batch + async) |
| [**getAsyncJobStatus**](DocumentsApi.md#getAsyncJobStatus) | **GET** /documents/async/{jobId} | Get job status |
| [**getDocument**](DocumentsApi.md#getDocument) | **GET** /documents/{publicId} | Get document |
| [**getDocuments**](DocumentsApi.md#getDocuments) | **GET** /documents | Get documents |
| [**storeDocument**](DocumentsApi.md#storeDocument) | **POST** /documents | Store document |


<a id="deleteDocument"></a>
# **deleteDocument**
> deleteDocument(publicId)

Delete document

Delete document from the Document Storage

### Example
```java
// Import classes:
import org.pdfgeneratorapi.client.ApiClient;
import org.pdfgeneratorapi.client.ApiException;
import org.pdfgeneratorapi.client.Configuration;
import org.pdfgeneratorapi.client.auth.*;
import org.pdfgeneratorapi.client.models.*;
import org.pdfgeneratorapi.client.api.DocumentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    DocumentsApi apiInstance = new DocumentsApi(defaultClient);
    String publicId = "bac8381bce1982e5f6957a0f52371336"; // String | Resource public id
    try {
      apiInstance.deleteDocument(publicId);
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentsApi#deleteDocument");
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
| **publicId** | **String**| Resource public id | |

### Return type

null (empty response body)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | The resource was deleted successfully. |  -  |
| **401** | Unauthorized |  -  |
| **402** | Account Suspended |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Unprocessable Entity |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="generateDocument"></a>
# **generateDocument**
> InlineObject9 generateDocument(generateDocumentRequest)

Generate document

Merges template with data and returns base64 encoded document or a public URL to a document. NB! When the public URL option is used, the document is stored for 30 days and automatically deleted.

### Example
```java
// Import classes:
import org.pdfgeneratorapi.client.ApiClient;
import org.pdfgeneratorapi.client.ApiException;
import org.pdfgeneratorapi.client.Configuration;
import org.pdfgeneratorapi.client.auth.*;
import org.pdfgeneratorapi.client.models.*;
import org.pdfgeneratorapi.client.api.DocumentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    DocumentsApi apiInstance = new DocumentsApi(defaultClient);
    GenerateDocumentRequest generateDocumentRequest = new GenerateDocumentRequest(); // GenerateDocumentRequest | Request parameters, including template id, data and formats.
    try {
      InlineObject9 result = apiInstance.generateDocument(generateDocumentRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentsApi#generateDocument");
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
| **generateDocumentRequest** | [**GenerateDocumentRequest**](GenerateDocumentRequest.md)| Request parameters, including template id, data and formats. | |

### Return type

[**InlineObject9**](InlineObject9.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Document data |  -  |
| **401** | Unauthorized |  -  |
| **402** | Account Suspended |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Unprocessable Entity |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="generateDocumentAsynchronous"></a>
# **generateDocumentAsynchronous**
> InlineObject20 generateDocumentAsynchronous(generateDocumentAsynchronousRequest)

Generate document (async)

Merges template with data as asynchronous job and makes POST request to callback URL defined in the request. Request uses the same format as response of synchronous generation endpoint. The job id is also added to the callback request as header PDF-API-Job-Id  *Example response from callback URL:* &#x60;&#x60;&#x60; {   \&quot;response\&quot;: \&quot;https://us1.pdfgeneratorapi.com/share/12821/VBERi0xLjcKJeLjz9MKNyAwIG9i\&quot;,   \&quot;meta\&quot;: {     \&quot;name\&quot;: \&quot;a2bd25b8921f3dc7a440fd7f427f90a4.pdf\&quot;,     \&quot;display_name\&quot;: \&quot;a2bd25b8921f3dc7a440fd7f427f90a4\&quot;,     \&quot;encoding\&quot;: \&quot;binary\&quot;,     \&quot;content-type\&quot;: \&quot;application/pdf\&quot;   } } &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
import org.pdfgeneratorapi.client.ApiClient;
import org.pdfgeneratorapi.client.ApiException;
import org.pdfgeneratorapi.client.Configuration;
import org.pdfgeneratorapi.client.auth.*;
import org.pdfgeneratorapi.client.models.*;
import org.pdfgeneratorapi.client.api.DocumentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    DocumentsApi apiInstance = new DocumentsApi(defaultClient);
    GenerateDocumentAsynchronousRequest generateDocumentAsynchronousRequest = new GenerateDocumentAsynchronousRequest(); // GenerateDocumentAsynchronousRequest | Request parameters, including template id, data and formats.
    try {
      InlineObject20 result = apiInstance.generateDocumentAsynchronous(generateDocumentAsynchronousRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentsApi#generateDocumentAsynchronous");
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
| **generateDocumentAsynchronousRequest** | [**GenerateDocumentAsynchronousRequest**](GenerateDocumentAsynchronousRequest.md)| Request parameters, including template id, data and formats. | |

### Return type

[**InlineObject20**](InlineObject20.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Async job response |  -  |
| **401** | Unauthorized |  -  |
| **402** | Account Suspended |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Unprocessable Entity |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="generateDocumentBatch"></a>
# **generateDocumentBatch**
> InlineObject9 generateDocumentBatch(generateDocumentBatchRequest)

Generate document (batch)

Allows to merge multiple templates with data and returns base64 encoded document or public URL to a document. NB! When the public URL option is used, the document is stored for 30 days and automatically deleted.

### Example
```java
// Import classes:
import org.pdfgeneratorapi.client.ApiClient;
import org.pdfgeneratorapi.client.ApiException;
import org.pdfgeneratorapi.client.Configuration;
import org.pdfgeneratorapi.client.auth.*;
import org.pdfgeneratorapi.client.models.*;
import org.pdfgeneratorapi.client.api.DocumentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    DocumentsApi apiInstance = new DocumentsApi(defaultClient);
    GenerateDocumentBatchRequest generateDocumentBatchRequest = new GenerateDocumentBatchRequest(); // GenerateDocumentBatchRequest | Request parameters, including template id, data and formats.
    try {
      InlineObject9 result = apiInstance.generateDocumentBatch(generateDocumentBatchRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentsApi#generateDocumentBatch");
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
| **generateDocumentBatchRequest** | [**GenerateDocumentBatchRequest**](GenerateDocumentBatchRequest.md)| Request parameters, including template id, data and formats. | |

### Return type

[**InlineObject9**](InlineObject9.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Document data |  -  |
| **401** | Unauthorized |  -  |
| **402** | Account Suspended |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Unprocessable Entity |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="generateDocumentBatchAsynchronous"></a>
# **generateDocumentBatchAsynchronous**
> InlineObject20 generateDocumentBatchAsynchronous(generateDocumentBatchAsynchronousRequest)

Generate document (batch + async)

Merges template with data as asynchronous job and makes POST request to callback URL defined in the request. Request uses the same format as response of synchronous generation endpoint. The job id is also added to the callback request as header PDF-API-Job-Id  *Example response from callback URL:* &#x60;&#x60;&#x60; {   \&quot;response\&quot;: \&quot;https://us1.pdfgeneratorapi.com/share/12821/VBERi0xLjcKJeLjz9MKNyAwIG9i\&quot;,   \&quot;meta\&quot;: {     \&quot;name\&quot;: \&quot;a2bd25b8921f3dc7a440fd7f427f90a4.pdf\&quot;,     \&quot;display_name\&quot;: \&quot;a2bd25b8921f3dc7a440fd7f427f90a4\&quot;,     \&quot;encoding\&quot;: \&quot;binary\&quot;,     \&quot;content-type\&quot;: \&quot;application/pdf\&quot;   } } &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
import org.pdfgeneratorapi.client.ApiClient;
import org.pdfgeneratorapi.client.ApiException;
import org.pdfgeneratorapi.client.Configuration;
import org.pdfgeneratorapi.client.auth.*;
import org.pdfgeneratorapi.client.models.*;
import org.pdfgeneratorapi.client.api.DocumentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    DocumentsApi apiInstance = new DocumentsApi(defaultClient);
    GenerateDocumentBatchAsynchronousRequest generateDocumentBatchAsynchronousRequest = new GenerateDocumentBatchAsynchronousRequest(); // GenerateDocumentBatchAsynchronousRequest | Request parameters, including template id, data and formats.
    try {
      InlineObject20 result = apiInstance.generateDocumentBatchAsynchronous(generateDocumentBatchAsynchronousRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentsApi#generateDocumentBatchAsynchronous");
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
| **generateDocumentBatchAsynchronousRequest** | [**GenerateDocumentBatchAsynchronousRequest**](GenerateDocumentBatchAsynchronousRequest.md)| Request parameters, including template id, data and formats. | |

### Return type

[**InlineObject20**](InlineObject20.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Async job response |  -  |
| **401** | Unauthorized |  -  |
| **402** | Account Suspended |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Unprocessable Entity |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="getAsyncJobStatus"></a>
# **getAsyncJobStatus**
> InlineObject13 getAsyncJobStatus(jobId)

Get job status

Returns status of an async job

### Example
```java
// Import classes:
import org.pdfgeneratorapi.client.ApiClient;
import org.pdfgeneratorapi.client.ApiException;
import org.pdfgeneratorapi.client.Configuration;
import org.pdfgeneratorapi.client.auth.*;
import org.pdfgeneratorapi.client.models.*;
import org.pdfgeneratorapi.client.api.DocumentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    DocumentsApi apiInstance = new DocumentsApi(defaultClient);
    String jobId = "968b8a3a-e8ac-49cc-a670-25db545813ed"; // String | Job id
    try {
      InlineObject13 result = apiInstance.getAsyncJobStatus(jobId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentsApi#getAsyncJobStatus");
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
| **jobId** | **String**| Job id | |

### Return type

[**InlineObject13**](InlineObject13.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Async job status |  -  |
| **401** | Unauthorized |  -  |
| **402** | Account Suspended |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Unprocessable Entity |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="getDocument"></a>
# **getDocument**
> InlineObject11 getDocument(publicId)

Get document

Returns document stored in the Document Storage

### Example
```java
// Import classes:
import org.pdfgeneratorapi.client.ApiClient;
import org.pdfgeneratorapi.client.ApiException;
import org.pdfgeneratorapi.client.Configuration;
import org.pdfgeneratorapi.client.auth.*;
import org.pdfgeneratorapi.client.models.*;
import org.pdfgeneratorapi.client.api.DocumentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    DocumentsApi apiInstance = new DocumentsApi(defaultClient);
    String publicId = "bac8381bce1982e5f6957a0f52371336"; // String | Resource public id
    try {
      InlineObject11 result = apiInstance.getDocument(publicId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentsApi#getDocument");
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
| **publicId** | **String**| Resource public id | |

### Return type

[**InlineObject11**](InlineObject11.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Document data |  -  |
| **401** | Unauthorized |  -  |
| **402** | Account Suspended |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Unprocessable Entity |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="getDocuments"></a>
# **getDocuments**
> InlineObject15 getDocuments(templateId, startDate, endDate, page, perPage)

Get documents

Returns a list of generated documents created by authorized workspace and stored in PDF Generator API. If master user is specified as workspace in JWT then all documents created in the organization are returned. NB! This endpoint returns only documents generated using the output&#x3D;url option.

### Example
```java
// Import classes:
import org.pdfgeneratorapi.client.ApiClient;
import org.pdfgeneratorapi.client.ApiException;
import org.pdfgeneratorapi.client.Configuration;
import org.pdfgeneratorapi.client.auth.*;
import org.pdfgeneratorapi.client.models.*;
import org.pdfgeneratorapi.client.api.DocumentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    DocumentsApi apiInstance = new DocumentsApi(defaultClient);
    Integer templateId = 19375; // Integer | Template unique identifier
    String startDate = "2022-08-01 12:00:00"; // String | Start date. Format: Y-m-d H:i:s
    String endDate = "2022-08-05 12:00:00"; // String | End date. Format: Y-m-d H:i:s. Defaults to current timestamp
    Integer page = 1; // Integer | Pagination: page to return
    Integer perPage = 15; // Integer | Pagination: How many records to return per page
    try {
      InlineObject15 result = apiInstance.getDocuments(templateId, startDate, endDate, page, perPage);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentsApi#getDocuments");
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
| **templateId** | **Integer**| Template unique identifier | [optional] |
| **startDate** | **String**| Start date. Format: Y-m-d H:i:s | [optional] |
| **endDate** | **String**| End date. Format: Y-m-d H:i:s. Defaults to current timestamp | [optional] |
| **page** | **Integer**| Pagination: page to return | [optional] [default to 1] |
| **perPage** | **Integer**| Pagination: How many records to return per page | [optional] [default to 15] |

### Return type

[**InlineObject15**](InlineObject15.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A list of generated documents |  -  |
| **401** | Unauthorized |  -  |
| **402** | Account Suspended |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Unprocessable Entity |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="storeDocument"></a>
# **storeDocument**
> InlineObject11 storeDocument(storeDocumentRequest)

Store document

Uploads a PDF as a URL or a base64 encoded string.

### Example
```java
// Import classes:
import org.pdfgeneratorapi.client.ApiClient;
import org.pdfgeneratorapi.client.ApiException;
import org.pdfgeneratorapi.client.Configuration;
import org.pdfgeneratorapi.client.auth.*;
import org.pdfgeneratorapi.client.models.*;
import org.pdfgeneratorapi.client.api.DocumentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    DocumentsApi apiInstance = new DocumentsApi(defaultClient);
    StoreDocumentRequest storeDocumentRequest = new StoreDocumentRequest(); // StoreDocumentRequest | Document source and optional metadata. Exactly one of `file_base64` or `file_url` is required.
    try {
      InlineObject11 result = apiInstance.storeDocument(storeDocumentRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentsApi#storeDocument");
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
| **storeDocumentRequest** | [**StoreDocumentRequest**](StoreDocumentRequest.md)| Document source and optional metadata. Exactly one of &#x60;file_base64&#x60; or &#x60;file_url&#x60; is required. | |

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
| **401** | Unauthorized |  -  |
| **402** | Account Suspended |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Unprocessable Entity |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

