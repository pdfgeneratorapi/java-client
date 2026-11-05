# TemplatesApi

All URIs are relative to *https://us1.pdfgeneratorapi.com/api/v4*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**copyTemplate**](TemplatesApi.md#copyTemplate) | **POST** /templates/{templateId}/copy | Copy template |
| [**createTemplate**](TemplatesApi.md#createTemplate) | **POST** /templates | Create template |
| [**deleteTemplate**](TemplatesApi.md#deleteTemplate) | **DELETE** /templates/{templateId} | Delete template |
| [**getTemplate**](TemplatesApi.md#getTemplate) | **GET** /templates/{templateId} | Get template |
| [**getTemplateData**](TemplatesApi.md#getTemplateData) | **GET** /templates/{templateId}/data | Get template data fields |
| [**getTemplateSchema**](TemplatesApi.md#getTemplateSchema) | **GET** /templates/schema | Get schema |
| [**getTemplates**](TemplatesApi.md#getTemplates) | **GET** /templates | Get templates |
| [**importTemplate**](TemplatesApi.md#importTemplate) | **POST** /templates/import | Import template |
| [**openEditor**](TemplatesApi.md#openEditor) | **POST** /templates/{templateId}/editor | Open editor |
| [**updateTemplate**](TemplatesApi.md#updateTemplate) | **PUT** /templates/{templateId} | Update template |
| [**validateTemplate**](TemplatesApi.md#validateTemplate) | **POST** /templates/validate | Validate template |


<a id="copyTemplate"></a>
# **copyTemplate**
> InlineObject18 copyTemplate(templateId, copyTemplateRequest)

Copy template

Creates a copy of a template to the workspace specified in authentication parameters.

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.TemplatesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    TemplatesApi apiInstance = new TemplatesApi(defaultClient);
    Integer templateId = 19375; // Integer | Template unique identifier
    CopyTemplateRequest copyTemplateRequest = new CopyTemplateRequest(); // CopyTemplateRequest | 
    try {
      InlineObject18 result = apiInstance.copyTemplate(templateId, copyTemplateRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplatesApi#copyTemplate");
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
| **copyTemplateRequest** | [**CopyTemplateRequest**](CopyTemplateRequest.md)|  | [optional] |

### Return type

[**InlineObject18**](InlineObject18.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Template configuration |  -  |
| **401** | Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  |  -  |
| **402** | Payment Required. The account is suspended. |  -  |
| **403** | Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  |  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  |
| **404** | Not Found. The resource does not exist or the workspace cannot access it. |  -  |
| **422** | Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  |  -  |
| **429** | Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. |  * Retry-After - Seconds to wait before the next request is allowed. <br>  |
| **500** | Internal Server Error |  -  |

<a id="createTemplate"></a>
# **createTemplate**
> InlineObject18 createTemplate(templateDefinitionNew)

Create template

Creates a new template. If template configuration is not specified in the request body then an empty template is created. Template is placed to the workspace specified in authentication params. Template configuration must be sent in the request body.

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.TemplatesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    TemplatesApi apiInstance = new TemplatesApi(defaultClient);
    TemplateDefinitionNew templateDefinitionNew = new TemplateDefinitionNew(); // TemplateDefinitionNew | Template configuration
    try {
      InlineObject18 result = apiInstance.createTemplate(templateDefinitionNew);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplatesApi#createTemplate");
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
| **templateDefinitionNew** | [**TemplateDefinitionNew**](TemplateDefinitionNew.md)| Template configuration | |

### Return type

[**InlineObject18**](InlineObject18.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Template configuration |  -  |
| **401** | Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  |  -  |
| **402** | Payment Required. The account is suspended. |  -  |
| **403** | Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  |  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  |
| **404** | Not Found. The resource does not exist or the workspace cannot access it. |  -  |
| **422** | Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  |  -  |
| **429** | Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. |  * Retry-After - Seconds to wait before the next request is allowed. <br>  |
| **500** | Internal Server Error |  -  |

<a id="deleteTemplate"></a>
# **deleteTemplate**
> deleteTemplate(templateId)

Delete template

Deletes the template from workspace

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.TemplatesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    TemplatesApi apiInstance = new TemplatesApi(defaultClient);
    Integer templateId = 19375; // Integer | Template unique identifier
    try {
      apiInstance.deleteTemplate(templateId);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplatesApi#deleteTemplate");
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
| **401** | Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  |  -  |
| **402** | Payment Required. The account is suspended. |  -  |
| **403** | Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  |  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  |
| **404** | Not Found. The resource does not exist or the workspace cannot access it. |  -  |
| **422** | Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  |  -  |
| **429** | Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. |  * Retry-After - Seconds to wait before the next request is allowed. <br>  |
| **500** | Internal Server Error |  -  |

<a id="getTemplate"></a>
# **getTemplate**
> InlineObject18 getTemplate(templateId)

Get template

Returns template configuration

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.TemplatesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    TemplatesApi apiInstance = new TemplatesApi(defaultClient);
    Integer templateId = 19375; // Integer | Template unique identifier
    try {
      InlineObject18 result = apiInstance.getTemplate(templateId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplatesApi#getTemplate");
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
| **401** | Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  |  -  |
| **402** | Payment Required. The account is suspended. |  -  |
| **403** | Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  |  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  |
| **404** | Not Found. The resource does not exist or the workspace cannot access it. |  -  |
| **422** | Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  |  -  |
| **429** | Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. |  * Retry-After - Seconds to wait before the next request is allowed. <br>  |
| **500** | Internal Server Error |  -  |

<a id="getTemplateData"></a>
# **getTemplateData**
> InlineObject2 getTemplateData(templateId)

Get template data fields

Returns all data fields used in the template. Returns structured JSON data that can be used to check which data fields are used in template or autogenerate sample data. 

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.TemplatesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    TemplatesApi apiInstance = new TemplatesApi(defaultClient);
    Integer templateId = 19375; // Integer | Template unique identifier
    try {
      InlineObject2 result = apiInstance.getTemplateData(templateId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplatesApi#getTemplateData");
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

### Return type

[**InlineObject2**](InlineObject2.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Template data structure |  -  |
| **401** | Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  |  -  |
| **402** | Payment Required. The account is suspended. |  -  |
| **403** | Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  |  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  |
| **404** | Not Found. The resource does not exist or the workspace cannot access it. |  -  |
| **422** | Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  |  -  |
| **429** | Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. |  * Retry-After - Seconds to wait before the next request is allowed. <br>  |
| **500** | Internal Server Error |  -  |

<a id="getTemplateSchema"></a>
# **getTemplateSchema**
> GetTemplateSchema200Response getTemplateSchema()

Get schema

Returns Template JSON Schema which defines the structure of the Template Definition.

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.TemplatesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");

    TemplatesApi apiInstance = new TemplatesApi(defaultClient);
    try {
      GetTemplateSchema200Response result = apiInstance.getTemplateSchema();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplatesApi#getTemplateSchema");
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

[**GetTemplateSchema200Response**](GetTemplateSchema200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Template JSON Schema |  -  |
| **429** | Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. |  * Retry-After - Seconds to wait before the next request is allowed. <br>  |
| **500** | Internal Server Error |  -  |

<a id="getTemplates"></a>
# **getTemplates**
> InlineObject4 getTemplates(name, tags, access, page, perPage, orderBy, orderDirection, search)

Get templates

Returns a list of templates available for the authenticated workspace

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.TemplatesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    TemplatesApi apiInstance = new TemplatesApi(defaultClient);
    String name = "name_example"; // String | Filter template by name
    String tags = "tags_example"; // String | Filter template by tags
    String access = "private"; // String | Filter template by access type. No values returns all templates. private - returns only private templates, organization - returns only organization templates.
    Integer page = 1; // Integer | Pagination: page to return
    Integer perPage = 15; // Integer | Pagination: How many records to return per page
    String orderBy = "id"; // String | Field to sort the templates by. Ignored when `name` or `tags` is set.
    String orderDirection = "asc"; // String | Sort direction. Ignored when `name` or `tags` is set.
    String search = "Invoice"; // String | Returns templates whose ID, name, tags, creation date or modification date contains the search value. Ignored when `name` or `tags` is set.
    try {
      InlineObject4 result = apiInstance.getTemplates(name, tags, access, page, perPage, orderBy, orderDirection, search);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplatesApi#getTemplates");
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
| **name** | **String**| Filter template by name | [optional] |
| **tags** | **String**| Filter template by tags | [optional] |
| **access** | **String**| Filter template by access type. No values returns all templates. private - returns only private templates, organization - returns only organization templates. | [optional] [default to ] [enum: private, organization, ] |
| **page** | **Integer**| Pagination: page to return | [optional] [default to 1] |
| **perPage** | **Integer**| Pagination: How many records to return per page | [optional] [default to 15] |
| **orderBy** | **String**| Field to sort the templates by. Ignored when &#x60;name&#x60; or &#x60;tags&#x60; is set. | [optional] [default to updated_at] [enum: id, name, is_draft, created_at, updated_at] |
| **orderDirection** | **String**| Sort direction. Ignored when &#x60;name&#x60; or &#x60;tags&#x60; is set. | [optional] [default to desc] [enum: asc, desc] |
| **search** | **String**| Returns templates whose ID, name, tags, creation date or modification date contains the search value. Ignored when &#x60;name&#x60; or &#x60;tags&#x60; is set. | [optional] |

### Return type

[**InlineObject4**](InlineObject4.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | An array of template objects |  -  |
| **401** | Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  |  -  |
| **402** | Payment Required. The account is suspended. |  -  |
| **403** | Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  |  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  |
| **404** | Not Found. The resource does not exist or the workspace cannot access it. |  -  |
| **422** | Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  |  -  |
| **429** | Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. |  * Retry-After - Seconds to wait before the next request is allowed. <br>  |
| **500** | Internal Server Error |  -  |

<a id="importTemplate"></a>
# **importTemplate**
> InlineObject18 importTemplate(importTemplateRequest)

Import template

Creates a template from existing PDF

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.TemplatesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    TemplatesApi apiInstance = new TemplatesApi(defaultClient);
    ImportTemplateRequest importTemplateRequest = new ImportTemplateRequest(); // ImportTemplateRequest | Import a PDF via URL or base64 string as template
    try {
      InlineObject18 result = apiInstance.importTemplate(importTemplateRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplatesApi#importTemplate");
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
| **importTemplateRequest** | [**ImportTemplateRequest**](ImportTemplateRequest.md)| Import a PDF via URL or base64 string as template | |

### Return type

[**InlineObject18**](InlineObject18.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Template configuration |  -  |
| **401** | Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  |  -  |
| **402** | Payment Required. The account is suspended. |  -  |
| **403** | Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  |  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  |
| **404** | Not Found. The resource does not exist or the workspace cannot access it. |  -  |
| **422** | Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  |  -  |
| **429** | Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. |  * Retry-After - Seconds to wait before the next request is allowed. <br>  |
| **500** | Internal Server Error |  -  |

<a id="openEditor"></a>
# **openEditor**
> InlineObject3 openEditor(templateId, openEditorRequest)

Open editor

Returns an unique URL which you can use to redirect your user to the editor from your application or use the generated URL as iframe source to show the editor within your application. When using iframe, make sure that your browser allows third-party cookies. 

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.TemplatesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    TemplatesApi apiInstance = new TemplatesApi(defaultClient);
    Integer templateId = 19375; // Integer | Template unique identifier
    OpenEditorRequest openEditorRequest = new OpenEditorRequest(); // OpenEditorRequest | 
    try {
      InlineObject3 result = apiInstance.openEditor(templateId, openEditorRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplatesApi#openEditor");
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
| **openEditorRequest** | [**OpenEditorRequest**](OpenEditorRequest.md)|  | |

### Return type

[**InlineObject3**](InlineObject3.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returns an URL which you can use to redirect your user to the editor or use as iframe source |  -  |
| **401** | Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  |  -  |
| **402** | Payment Required. The account is suspended. |  -  |
| **403** | Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  |  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  |
| **404** | Not Found. The resource does not exist or the workspace cannot access it. |  -  |
| **422** | Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  |  -  |
| **429** | Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. |  * Retry-After - Seconds to wait before the next request is allowed. <br>  |
| **500** | Internal Server Error |  -  |

<a id="updateTemplate"></a>
# **updateTemplate**
> InlineObject18 updateTemplate(templateId, templateDefinitionUpdate)

Update template

Updates template configuration. Each top-level field sent (name, layout, pages and the rest) replaces the stored one, so pages must be complete, with every component. A field left out keeps its stored value, the name included.

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.TemplatesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    TemplatesApi apiInstance = new TemplatesApi(defaultClient);
    Integer templateId = 19375; // Integer | Template unique identifier
    TemplateDefinitionUpdate templateDefinitionUpdate = new TemplateDefinitionUpdate(); // TemplateDefinitionUpdate | The template configuration to change
    try {
      InlineObject18 result = apiInstance.updateTemplate(templateId, templateDefinitionUpdate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplatesApi#updateTemplate");
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
| **templateDefinitionUpdate** | [**TemplateDefinitionUpdate**](TemplateDefinitionUpdate.md)| The template configuration to change | |

### Return type

[**InlineObject18**](InlineObject18.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Template configuration |  -  |
| **401** | Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  |  -  |
| **402** | Payment Required. The account is suspended. |  -  |
| **403** | Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  |  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  |
| **404** | Not Found. The resource does not exist or the workspace cannot access it. |  -  |
| **422** | Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  |  -  |
| **429** | Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. |  * Retry-After - Seconds to wait before the next request is allowed. <br>  |
| **500** | Internal Server Error |  -  |

<a id="validateTemplate"></a>
# **validateTemplate**
> InlineObject1 validateTemplate(templateDefinitionNew)

Validate template

Validates if the provided template configuration matches the template JSON schema.

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.TemplatesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");

    TemplatesApi apiInstance = new TemplatesApi(defaultClient);
    TemplateDefinitionNew templateDefinitionNew = new TemplateDefinitionNew(); // TemplateDefinitionNew | Template configuration
    try {
      InlineObject1 result = apiInstance.validateTemplate(templateDefinitionNew);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplatesApi#validateTemplate");
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
| **templateDefinitionNew** | [**TemplateDefinitionNew**](TemplateDefinitionNew.md)| Template configuration | |

### Return type

[**InlineObject1**](InlineObject1.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Template validation response |  -  |
| **401** | Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  |  -  |
| **402** | Payment Required. The account is suspended. |  -  |
| **403** | Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  |  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  |
| **404** | Not Found. The resource does not exist or the workspace cannot access it. |  -  |
| **422** | Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  |  -  |
| **429** | Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. |  * Retry-After - Seconds to wait before the next request is allowed. <br>  |
| **500** | Internal Server Error |  -  |

