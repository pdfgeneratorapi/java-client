# TemplateLibraryApi

All URIs are relative to *https://us1.pdfgeneratorapi.com/api/v4*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getTemplateLibrary**](TemplateLibraryApi.md#getTemplateLibrary) | **GET** /templates/library | Get template library |
| [**getTemplateLibraryItem**](TemplateLibraryApi.md#getTemplateLibraryItem) | **GET** /templates/library/{publicId} | Open template from the library |


<a id="getTemplateLibrary"></a>
# **getTemplateLibrary**
> GetTemplateLibrary200Response getTemplateLibrary(tags)

Get template library

Returns a list of publicly available templates from the template library. 

### Example
```java
// Import classes:
import org.pdfgeneratorapi.client.ApiClient;
import org.pdfgeneratorapi.client.ApiException;
import org.pdfgeneratorapi.client.Configuration;
import org.pdfgeneratorapi.client.models.*;
import org.pdfgeneratorapi.client.api.TemplateLibraryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");

    TemplateLibraryApi apiInstance = new TemplateLibraryApi(defaultClient);
    String tags = "tags_example"; // String | Filter template by tags
    try {
      GetTemplateLibrary200Response result = apiInstance.getTemplateLibrary(tags);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplateLibraryApi#getTemplateLibrary");
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
| **tags** | **String**| Filter template by tags | [optional] |

### Return type

[**GetTemplateLibrary200Response**](GetTemplateLibrary200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returns a list of public templates |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Unprocessable Entity |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="getTemplateLibraryItem"></a>
# **getTemplateLibraryItem**
> InlineObject16 getTemplateLibraryItem(publicId)

Open template from the library

Returns the template definition for a public template identified by its &#x60;public_id&#x60;. 

### Example
```java
// Import classes:
import org.pdfgeneratorapi.client.ApiClient;
import org.pdfgeneratorapi.client.ApiException;
import org.pdfgeneratorapi.client.Configuration;
import org.pdfgeneratorapi.client.models.*;
import org.pdfgeneratorapi.client.api.TemplateLibraryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");

    TemplateLibraryApi apiInstance = new TemplateLibraryApi(defaultClient);
    String publicId = "bac8381bce1982e5f6957a0f52371336"; // String | Resource public id
    try {
      InlineObject16 result = apiInstance.getTemplateLibraryItem(publicId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplateLibraryApi#getTemplateLibraryItem");
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

[**InlineObject16**](InlineObject16.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Template configuration |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Unprocessable Entity |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

