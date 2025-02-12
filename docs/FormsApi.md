# FormsApi

All URIs are relative to *https://us1.pdfgeneratorapi.com/api/v4*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createFrom**](FormsApi.md#createFrom) | **POST** /forms | Create form |
| [**deleteForm**](FormsApi.md#deleteForm) | **DELETE** /forms/{formId} | Delete form |
| [**getForm**](FormsApi.md#getForm) | **GET** /forms/{formId} | Get form |
| [**getForms**](FormsApi.md#getForms) | **GET** /forms | Get forms |
| [**shareForm**](FormsApi.md#shareForm) | **POST** /forms/{formId}/share | Share form |
| [**updateForm**](FormsApi.md#updateForm) | **PUT** /forms/{formId} | Update form |


<a id="createFrom"></a>
# **createFrom**
> CreateFrom201Response createFrom(formConfigurationNew)

Create form

Creates a new form based on the configuration sent in the request body.

### Example
```java
// Import classes:
import org.pdfgeneratorapi.client.ApiClient;
import org.pdfgeneratorapi.client.ApiException;
import org.pdfgeneratorapi.client.Configuration;
import org.pdfgeneratorapi.client.auth.*;
import org.pdfgeneratorapi.client.models.*;
import org.pdfgeneratorapi.client.api.FormsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    FormsApi apiInstance = new FormsApi(defaultClient);
    FormConfigurationNew formConfigurationNew = new FormConfigurationNew(); // FormConfigurationNew | Form configuration
    try {
      CreateFrom201Response result = apiInstance.createFrom(formConfigurationNew);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FormsApi#createFrom");
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
| **formConfigurationNew** | [**FormConfigurationNew**](FormConfigurationNew.md)| Form configuration | |

### Return type

[**CreateFrom201Response**](CreateFrom201Response.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Form configuration |  -  |
| **401** | Unauthorized |  -  |
| **402** | Account Suspended |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Unprocessable Entity |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="deleteForm"></a>
# **deleteForm**
> deleteForm(formId)

Delete form

Deletes the form with specified id

### Example
```java
// Import classes:
import org.pdfgeneratorapi.client.ApiClient;
import org.pdfgeneratorapi.client.ApiException;
import org.pdfgeneratorapi.client.Configuration;
import org.pdfgeneratorapi.client.auth.*;
import org.pdfgeneratorapi.client.models.*;
import org.pdfgeneratorapi.client.api.FormsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    FormsApi apiInstance = new FormsApi(defaultClient);
    Integer formId = 1; // Integer | Form unique identifier
    try {
      apiInstance.deleteForm(formId);
    } catch (ApiException e) {
      System.err.println("Exception when calling FormsApi#deleteForm");
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
| **formId** | **Integer**| Form unique identifier | |

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

<a id="getForm"></a>
# **getForm**
> CreateFrom201Response getForm(formId)

Get form

Returns form configuration

### Example
```java
// Import classes:
import org.pdfgeneratorapi.client.ApiClient;
import org.pdfgeneratorapi.client.ApiException;
import org.pdfgeneratorapi.client.Configuration;
import org.pdfgeneratorapi.client.auth.*;
import org.pdfgeneratorapi.client.models.*;
import org.pdfgeneratorapi.client.api.FormsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    FormsApi apiInstance = new FormsApi(defaultClient);
    Integer formId = 1; // Integer | Form unique identifier
    try {
      CreateFrom201Response result = apiInstance.getForm(formId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FormsApi#getForm");
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
| **formId** | **Integer**| Form unique identifier | |

### Return type

[**CreateFrom201Response**](CreateFrom201Response.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Form configuration |  -  |
| **401** | Unauthorized |  -  |
| **402** | Account Suspended |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Unprocessable Entity |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="getForms"></a>
# **getForms**
> GetForms200Response getForms(page, perPage)

Get forms

Returns a list of forms available for the organization

### Example
```java
// Import classes:
import org.pdfgeneratorapi.client.ApiClient;
import org.pdfgeneratorapi.client.ApiException;
import org.pdfgeneratorapi.client.Configuration;
import org.pdfgeneratorapi.client.auth.*;
import org.pdfgeneratorapi.client.models.*;
import org.pdfgeneratorapi.client.api.FormsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    FormsApi apiInstance = new FormsApi(defaultClient);
    Integer page = 1; // Integer | Pagination: page to return
    Integer perPage = 15; // Integer | Pagination: How many records to return per page
    try {
      GetForms200Response result = apiInstance.getForms(page, perPage);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FormsApi#getForms");
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
| **page** | **Integer**| Pagination: page to return | [optional] [default to 1] |
| **perPage** | **Integer**| Pagination: How many records to return per page | [optional] [default to 15] |

### Return type

[**GetForms200Response**](GetForms200Response.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | An array of form objects |  -  |
| **401** | Unauthorized |  -  |
| **402** | Account Suspended |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Unprocessable Entity |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="shareForm"></a>
# **shareForm**
> ShareForm201Response shareForm(formId)

Share form

Creates an unique sharing URL to collect form data

### Example
```java
// Import classes:
import org.pdfgeneratorapi.client.ApiClient;
import org.pdfgeneratorapi.client.ApiException;
import org.pdfgeneratorapi.client.Configuration;
import org.pdfgeneratorapi.client.auth.*;
import org.pdfgeneratorapi.client.models.*;
import org.pdfgeneratorapi.client.api.FormsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    FormsApi apiInstance = new FormsApi(defaultClient);
    Integer formId = 1; // Integer | Form unique identifier
    try {
      ShareForm201Response result = apiInstance.shareForm(formId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FormsApi#shareForm");
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
| **formId** | **Integer**| Form unique identifier | |

### Return type

[**ShareForm201Response**](ShareForm201Response.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Form sharing URL |  -  |
| **401** | Unauthorized |  -  |
| **402** | Account Suspended |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Unprocessable Entity |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="updateForm"></a>
# **updateForm**
> CreateFrom201Response updateForm(formId, formConfigurationNew)

Update form

Updates the form configuration. The form configuration must be complete as the entire configuration is replaced and not merged.

### Example
```java
// Import classes:
import org.pdfgeneratorapi.client.ApiClient;
import org.pdfgeneratorapi.client.ApiException;
import org.pdfgeneratorapi.client.Configuration;
import org.pdfgeneratorapi.client.auth.*;
import org.pdfgeneratorapi.client.models.*;
import org.pdfgeneratorapi.client.api.FormsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    FormsApi apiInstance = new FormsApi(defaultClient);
    Integer formId = 1; // Integer | Form unique identifier
    FormConfigurationNew formConfigurationNew = new FormConfigurationNew(); // FormConfigurationNew | Form configuration
    try {
      CreateFrom201Response result = apiInstance.updateForm(formId, formConfigurationNew);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FormsApi#updateForm");
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
| **formId** | **Integer**| Form unique identifier | |
| **formConfigurationNew** | [**FormConfigurationNew**](FormConfigurationNew.md)| Form configuration | |

### Return type

[**CreateFrom201Response**](CreateFrom201Response.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Form configuration |  -  |
| **401** | Unauthorized |  -  |
| **402** | Account Suspended |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Unprocessable Entity |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

