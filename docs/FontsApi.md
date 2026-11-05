# FontsApi

All URIs are relative to *https://us1.pdfgeneratorapi.com/api/v4*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getFonts**](FontsApi.md#getFonts) | **GET** /fonts | Get fonts |


<a id="getFonts"></a>
# **getFonts**
> GetFonts200Response getFonts(covers)

Get fonts

Returns the fonts the workspace&#39;s templates can use, sorted by name. Use a font&#39;s &#x60;id&#x60; as a component&#39;s &#x60;fontFamily&#x60;; a font that is not in this list is drawn with Open Sans.  Each font lists the styles it has glyphs of its own for, and the Unicode blocks it has at least half of the characters of, with the share in percent. To check particular characters, pass them in &#x60;covers&#x60;. 

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.FontsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    FontsApi apiInstance = new FontsApi(defaultClient);
    String covers = "€₹✓"; // String | Text whose every character a font must have a glyph for, in its regular style, to be returned. Control characters are ignored.
    try {
      GetFonts200Response result = apiInstance.getFonts(covers);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FontsApi#getFonts");
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
| **covers** | **String**| Text whose every character a font must have a glyph for, in its regular style, to be returned. Control characters are ignored. | [optional] |

### Return type

[**GetFonts200Response**](GetFonts200Response.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The fonts the workspace&#39;s templates can use |  -  |
| **401** | Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  |  -  |
| **403** | Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  |  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  |
| **422** | Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  |  -  |
| **429** | Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. |  * Retry-After - Seconds to wait before the next request is allowed. <br>  |
| **500** | Internal Server Error |  -  |

