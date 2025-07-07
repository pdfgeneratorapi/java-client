# ConversionApi

All URIs are relative to *https://us1.pdfgeneratorapi.com/api/v4*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**convertHTML2PDF**](ConversionApi.md#convertHTML2PDF) | **POST** /conversion/html2pdf | HTML to PDF |
| [**convertURL2PDF**](ConversionApi.md#convertURL2PDF) | **POST** /conversion/url2pdf | URL to PDF |


<a id="convertHTML2PDF"></a>
# **convertHTML2PDF**
> AddWatermark201Response convertHTML2PDF(convertHTML2PDFRequest)

HTML to PDF

Converts HTML content to PDF

### Example
```java
// Import classes:
import org.pdfgeneratorapi.client.ApiClient;
import org.pdfgeneratorapi.client.ApiException;
import org.pdfgeneratorapi.client.Configuration;
import org.pdfgeneratorapi.client.auth.*;
import org.pdfgeneratorapi.client.models.*;
import org.pdfgeneratorapi.client.api.ConversionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    ConversionApi apiInstance = new ConversionApi(defaultClient);
    ConvertHTML2PDFRequest convertHTML2PDFRequest = new ConvertHTML2PDFRequest(); // ConvertHTML2PDFRequest | 
    try {
      AddWatermark201Response result = apiInstance.convertHTML2PDF(convertHTML2PDFRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ConversionApi#convertHTML2PDF");
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
| **convertHTML2PDFRequest** | [**ConvertHTML2PDFRequest**](ConvertHTML2PDFRequest.md)|  | |

### Return type

[**AddWatermark201Response**](AddWatermark201Response.md)

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

<a id="convertURL2PDF"></a>
# **convertURL2PDF**
> AddWatermark201Response convertURL2PDF(convertURL2PDFRequest)

URL to PDF

Converts public URL to PDF

### Example
```java
// Import classes:
import org.pdfgeneratorapi.client.ApiClient;
import org.pdfgeneratorapi.client.ApiException;
import org.pdfgeneratorapi.client.Configuration;
import org.pdfgeneratorapi.client.auth.*;
import org.pdfgeneratorapi.client.models.*;
import org.pdfgeneratorapi.client.api.ConversionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    ConversionApi apiInstance = new ConversionApi(defaultClient);
    ConvertURL2PDFRequest convertURL2PDFRequest = new ConvertURL2PDFRequest(); // ConvertURL2PDFRequest | 
    try {
      AddWatermark201Response result = apiInstance.convertURL2PDF(convertURL2PDFRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ConversionApi#convertURL2PDF");
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
| **convertURL2PDFRequest** | [**ConvertURL2PDFRequest**](ConvertURL2PDFRequest.md)|  | |

### Return type

[**AddWatermark201Response**](AddWatermark201Response.md)

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

