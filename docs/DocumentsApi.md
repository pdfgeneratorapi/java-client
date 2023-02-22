# DocumentsApi

All URIs are relative to *https://us1.pdfgeneratorapi.com/api/v3*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**mergeTemplate**](DocumentsApi.md#mergeTemplate) | **POST** /templates/{templateId}/output | Generate document |
| [**mergeTemplates**](DocumentsApi.md#mergeTemplates) | **POST** /templates/output | Generate document (multiple templates) |


<a name="mergeTemplate"></a>
# **mergeTemplate**
> MergeTemplate200Response mergeTemplate(templateId, body, name, format, output)

Generate document

Merges template with data and returns base64 encoded document or a public URL to a document. You can send json encoded data in request body or a public URL to your json file as the data parameter. NB! When the public URL option is used, the document is stored for 30 days and automatically deleted.

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
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v3");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    DocumentsApi apiInstance = new DocumentsApi(defaultClient);
    Integer templateId = 19375; // Integer | Template unique identifier
    Object body = null; // Object | Data used to generate the PDF. This can be JSON encoded string or a public URL to your JSON file.
    String name = "My document"; // String | Document name, returned in the meta data.
    String format = "pdf"; // String | Document format. The zip option will return a ZIP file with PDF files.
    String output = "base64"; // String | Response format. \"I\" is used to return the file inline. With the url option, the document is stored for 30 days and automatically deleted.
    try {
      MergeTemplate200Response result = apiInstance.mergeTemplate(templateId, body, name, format, output);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentsApi#mergeTemplate");
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
| **templateId** | **Integer**| Template unique identifier | |
| **body** | **Object**| Data used to generate the PDF. This can be JSON encoded string or a public URL to your JSON file. | |
| **name** | **String**| Document name, returned in the meta data. | [optional] |
| **format** | **String**| Document format. The zip option will return a ZIP file with PDF files. | [optional] [enum: pdf, html, zip, xlsx] |
| **output** | **String**| Response format. \&quot;I\&quot; is used to return the file inline. With the url option, the document is stored for 30 days and automatically deleted. | [optional] [enum: base64, url, I] |

### Return type

[**MergeTemplate200Response**](MergeTemplate200Response.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: application/json
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

<a name="mergeTemplates"></a>
# **mergeTemplates**
> MergeTemplate200Response mergeTemplates(batchDataInner, name, format, output)

Generate document (multiple templates)

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
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v3");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    DocumentsApi apiInstance = new DocumentsApi(defaultClient);
    List<BatchDataInner> batchDataInner = Arrays.asList(); // List<BatchDataInner> | Data used to specify templates and data objects which are used to merge the template
    String name = "My document"; // String | Document name, returned in the meta data.
    String format = "pdf"; // String | Document format. The zip option will return a ZIP file with PDF files.
    String output = "base64"; // String | Response format. \"I\" is used to return the file inline. With the url option, the document is stored for 30 days and automatically deleted.
    try {
      MergeTemplate200Response result = apiInstance.mergeTemplates(batchDataInner, name, format, output);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentsApi#mergeTemplates");
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
| **batchDataInner** | [**List&lt;BatchDataInner&gt;**](BatchDataInner.md)| Data used to specify templates and data objects which are used to merge the template | |
| **name** | **String**| Document name, returned in the meta data. | [optional] |
| **format** | **String**| Document format. The zip option will return a ZIP file with PDF files. | [optional] [enum: pdf, html, zip, xlsx] |
| **output** | **String**| Response format. \&quot;I\&quot; is used to return the file inline. With the url option, the document is stored for 30 days and automatically deleted. | [optional] [enum: base64, url, I] |

### Return type

[**MergeTemplate200Response**](MergeTemplate200Response.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: application/json
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

