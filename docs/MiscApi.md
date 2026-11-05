# MiscApi

All URIs are relative to *https://us1.pdfgeneratorapi.com/api/v4*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getStatus**](MiscApi.md#getStatus) | **GET** /status | Get Service Status |


<a id="getStatus"></a>
# **getStatus**
> GetStatus200Response getStatus()

Get Service Status

Returns service status / health

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.MiscApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");

    MiscApi apiInstance = new MiscApi(defaultClient);
    try {
      GetStatus200Response result = apiInstance.getStatus();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MiscApi#getStatus");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetStatus200Response**](GetStatus200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returns service status |  -  |
| **500** | At least one check failed |  -  |

