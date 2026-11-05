# ConversionApi

All URIs are relative to *https://us1.pdfgeneratorapi.com/api/v4*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**convertHTML2PDF**](ConversionApi.md#convertHTML2PDF) | **POST** /conversion/html2pdf | HTML to PDF |
| [**convertPDF2Image**](ConversionApi.md#convertPDF2Image) | **POST** /conversion/pdf2image | PDF to Image |
| [**convertURL2PDF**](ConversionApi.md#convertURL2PDF) | **POST** /conversion/url2pdf | URL to PDF |


<a id="convertHTML2PDF"></a>
# **convertHTML2PDF**
> InlineObject8 convertHTML2PDF(convertHTML2PDFRequest)

HTML to PDF

Converts HTML content to PDF

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.ConversionApi;

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
      InlineObject8 result = apiInstance.convertHTML2PDF(convertHTML2PDFRequest);
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

<a id="convertPDF2Image"></a>
# **convertPDF2Image**
> File convertPDF2Image(convertPDF2ImageRequest)

PDF to Image

Converts PDF document to images. Provide either a base64 encoded PDF or a public URL to a PDF file.

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.ConversionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    ConversionApi apiInstance = new ConversionApi(defaultClient);
    ConvertPDF2ImageRequest convertPDF2ImageRequest = new ConvertPDF2ImageRequest(); // ConvertPDF2ImageRequest | 
    try {
      File result = apiInstance.convertPDF2Image(convertPDF2ImageRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ConversionApi#convertPDF2Image");
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
| **convertPDF2ImageRequest** | [**ConvertPDF2ImageRequest**](ConvertPDF2ImageRequest.md)|  | |

### Return type

[**File**](File.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/zip, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | PDF to image conversion result. &#x60;output&#x3D;file&#x60; returns a ZIP archive with one image per page. |  -  |
| **401** | Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  |  -  |
| **402** | Payment Required. The account is suspended. |  -  |
| **403** | Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  |  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  |
| **404** | Not Found. The resource does not exist or the workspace cannot access it. |  -  |
| **422** | Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  |  -  |
| **429** | Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. |  * Retry-After - Seconds to wait before the next request is allowed. <br>  |
| **500** | Internal Server Error |  -  |
| **503** | Service Unavailable. PDF Services is not available on this deployment. |  -  |

<a id="convertURL2PDF"></a>
# **convertURL2PDF**
> InlineObject8 convertURL2PDF(convertURL2PDFRequest)

URL to PDF

Converts public URL to PDF.  By default the page is printed once its network activity settles. Pages that keep making background requests (e.g. single-page applications) can signal when they have finished rendering with &#x60;wait_for_css&#x60; and/or &#x60;wait_for_js&#x60;; the page is then printed as soon as the signal is met. When both are given, both must be met. 

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.ConversionApi;

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
      InlineObject8 result = apiInstance.convertURL2PDF(convertURL2PDFRequest);
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
| **400** | Bad Request. The page at the URL could not be converted to PDF.  |  -  |
| **401** | Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  |  -  |
| **402** | Payment Required. The account is suspended. |  -  |
| **403** | Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  |  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  |
| **404** | Not Found. The resource does not exist or the workspace cannot access it. |  -  |
| **422** | Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  |  -  |
| **429** | Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. |  * Retry-After - Seconds to wait before the next request is allowed. <br>  |
| **500** | Internal Server Error |  -  |

