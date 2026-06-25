# TemplateVersionsApi

All URIs are relative to *https://us1.pdfgeneratorapi.com/api/v4*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**deleteTemplateVersion**](TemplateVersionsApi.md#deleteTemplateVersion) | **DELETE** /templates/{templateId}/versions/{templateVersion} | Delete template version |
| [**getTemplateVersion**](TemplateVersionsApi.md#getTemplateVersion) | **GET** /templates/{templateId}/versions/{templateVersion} | Get template version |
| [**listTemplateVersions**](TemplateVersionsApi.md#listTemplateVersions) | **GET** /templates/{templateId}/versions | List template versions |
| [**promoteTemplateVersion**](TemplateVersionsApi.md#promoteTemplateVersion) | **PUT** /templates/{templateId}/versions/{templateVersion}/promote | Promote template version |


<a id="deleteTemplateVersion"></a>
# **deleteTemplateVersion**
> deleteTemplateVersion(templateId, templateVersion)

Delete template version

Deletes the specified template version. Production versions cannot be deleted. 

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.TemplateVersionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    TemplateVersionsApi apiInstance = new TemplateVersionsApi(defaultClient);
    Integer templateId = 19375; // Integer | Template unique identifier
    Integer templateVersion = 56; // Integer | Unique ID of the template version.
    try {
      apiInstance.deleteTemplateVersion(templateId, templateVersion);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplateVersionsApi#deleteTemplateVersion");
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
| **templateVersion** | **Integer**| Unique ID of the template version. | |

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
| **204** | Template version deleted successfully |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Unprocessable Entity |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="getTemplateVersion"></a>
# **getTemplateVersion**
> InlineObject18 getTemplateVersion(templateId, templateVersion)

Get template version

Returns the template definition of the specified version. 

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.TemplateVersionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    TemplateVersionsApi apiInstance = new TemplateVersionsApi(defaultClient);
    Integer templateId = 19375; // Integer | Template unique identifier
    Integer templateVersion = 56; // Integer | Unique ID of the template version.
    try {
      InlineObject18 result = apiInstance.getTemplateVersion(templateId, templateVersion);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplateVersionsApi#getTemplateVersion");
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
| **templateVersion** | **Integer**| Unique ID of the template version. | |

### Return type

[**InlineObject18**](InlineObject18.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

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
| **422** | Cannot delete production template version |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="listTemplateVersions"></a>
# **listTemplateVersions**
> TemplateVersionCollection listTemplateVersions(templateId, perPage, page)

List template versions

Returns a paginated list of template versions for the specified template. 

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.TemplateVersionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    TemplateVersionsApi apiInstance = new TemplateVersionsApi(defaultClient);
    Integer templateId = 19375; // Integer | Template unique identifier
    Integer perPage = 56; // Integer | Number of items per page.
    Integer page = 56; // Integer | Page number to return.
    try {
      TemplateVersionCollection result = apiInstance.listTemplateVersions(templateId, perPage, page);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplateVersionsApi#listTemplateVersions");
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
| **perPage** | **Integer**| Number of items per page. | [optional] |
| **page** | **Integer**| Page number to return. | [optional] |

### Return type

[**TemplateVersionCollection**](TemplateVersionCollection.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Paginated list of template versions |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Unprocessable Entity |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="promoteTemplateVersion"></a>
# **promoteTemplateVersion**
> PromoteTemplateVersion200Response promoteTemplateVersion(templateId, templateVersion)

Promote template version

Promotes the specified template version to production. Only one version can be production at a time. 

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.TemplateVersionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    TemplateVersionsApi apiInstance = new TemplateVersionsApi(defaultClient);
    Integer templateId = 19375; // Integer | Template unique identifier
    Integer templateVersion = 56; // Integer | Unique ID of the template version.
    try {
      PromoteTemplateVersion200Response result = apiInstance.promoteTemplateVersion(templateId, templateVersion);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplateVersionsApi#promoteTemplateVersion");
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
| **templateVersion** | **Integer**| Unique ID of the template version. | |

### Return type

[**PromoteTemplateVersion200Response**](PromoteTemplateVersion200Response.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Template version promoted successfully |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Unprocessable Entity |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

