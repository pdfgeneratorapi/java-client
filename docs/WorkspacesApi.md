# WorkspacesApi

All URIs are relative to *https://us1.pdfgeneratorapi.com/api/v3*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**deleteWorkspace**](WorkspacesApi.md#deleteWorkspace) | **DELETE** /workspaces/{workspaceId} | Delete workspace |
| [**getWorkspace**](WorkspacesApi.md#getWorkspace) | **GET** /workspaces/{workspaceId} | Get workspace |


<a id="deleteWorkspace"></a>
# **deleteWorkspace**
> DeleteTemplate200Response deleteWorkspace(workspaceId)

Delete workspace

Deletes the workspace

### Example
```java
// Import classes:
import org.pdfgeneratorapi.client.ApiClient;
import org.pdfgeneratorapi.client.ApiException;
import org.pdfgeneratorapi.client.Configuration;
import org.pdfgeneratorapi.client.auth.*;
import org.pdfgeneratorapi.client.models.*;
import org.pdfgeneratorapi.client.api.WorkspacesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v3");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    WorkspacesApi apiInstance = new WorkspacesApi(defaultClient);
    String workspaceId = "demo.example@actualreports.com"; // String | Workspace identifier
    try {
      DeleteTemplate200Response result = apiInstance.deleteWorkspace(workspaceId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling WorkspacesApi#deleteWorkspace");
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
| **workspaceId** | **String**| Workspace identifier | |

### Return type

[**DeleteTemplate200Response**](DeleteTemplate200Response.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The request was successfully executed. |  -  |
| **401** | Unauthorized |  -  |
| **402** | Account Suspended |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Unprocessable Entity |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="getWorkspace"></a>
# **getWorkspace**
> GetWorkspace200Response getWorkspace(workspaceId)

Get workspace

Returns workspace information

### Example
```java
// Import classes:
import org.pdfgeneratorapi.client.ApiClient;
import org.pdfgeneratorapi.client.ApiException;
import org.pdfgeneratorapi.client.Configuration;
import org.pdfgeneratorapi.client.auth.*;
import org.pdfgeneratorapi.client.models.*;
import org.pdfgeneratorapi.client.api.WorkspacesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v3");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    WorkspacesApi apiInstance = new WorkspacesApi(defaultClient);
    String workspaceId = "demo.example@actualreports.com"; // String | Workspace identifier
    try {
      GetWorkspace200Response result = apiInstance.getWorkspace(workspaceId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling WorkspacesApi#getWorkspace");
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
| **workspaceId** | **String**| Workspace identifier | |

### Return type

[**GetWorkspace200Response**](GetWorkspace200Response.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Workspace information |  -  |
| **401** | Unauthorized |  -  |
| **402** | Account Suspended |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Unprocessable Entity |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

