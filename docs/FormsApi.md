# FormsApi

All URIs are relative to *https://us1.pdfgeneratorapi.com/api/v4*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createForm**](FormsApi.md#createForm) | **POST** /forms | Create form |
| [**deleteForm**](FormsApi.md#deleteForm) | **DELETE** /forms/{formId} | Delete form |
| [**getForm**](FormsApi.md#getForm) | **GET** /forms/{formId} | Get form |
| [**getForms**](FormsApi.md#getForms) | **GET** /forms | Get forms |
| [**importForm**](FormsApi.md#importForm) | **POST** /forms/import | Import Form |
| [**openFormBuilder**](FormsApi.md#openFormBuilder) | **POST** /forms/open | Open new form builder |
| [**openFormBuilderForExistingForm**](FormsApi.md#openFormBuilderForExistingForm) | **POST** /forms/{formId}/open | Open existing form builder |
| [**shareForm**](FormsApi.md#shareForm) | **POST** /forms/{formId}/share | Share form |
| [**updateForm**](FormsApi.md#updateForm) | **PUT** /forms/{formId} | Update form |


<a id="createForm"></a>
# **createForm**
> InlineObject19 createForm(formConfigurationNew)

Create form

Creates a new form based on the configuration sent in the request body.

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.FormsApi;

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
      InlineObject19 result = apiInstance.createForm(formConfigurationNew);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FormsApi#createForm");
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

[**InlineObject19**](InlineObject19.md)

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
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.FormsApi;

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
> InlineObject19 getForm(formId)

Get form

Returns form configuration

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.FormsApi;

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
      InlineObject19 result = apiInstance.getForm(formId);
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

[**InlineObject19**](InlineObject19.md)

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
> InlineObject6 getForms(page, perPage)

Get forms

Returns a list of forms available for the organization

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.FormsApi;

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
      InlineObject6 result = apiInstance.getForms(page, perPage);
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

[**InlineObject6**](InlineObject6.md)

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

<a id="importForm"></a>
# **importForm**
> InlineObject19 importForm(importFormRequest)

Import Form

Creates a new form based on editable PDF

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.FormsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    FormsApi apiInstance = new FormsApi(defaultClient);
    ImportFormRequest importFormRequest = new ImportFormRequest(); // ImportFormRequest | Import editable PDF via URL or base64 string as form
    try {
      InlineObject19 result = apiInstance.importForm(importFormRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FormsApi#importForm");
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
| **importFormRequest** | [**ImportFormRequest**](ImportFormRequest.md)| Import editable PDF via URL or base64 string as form | |

### Return type

[**InlineObject19**](InlineObject19.md)

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

<a id="openFormBuilder"></a>
# **openFormBuilder**
> InlineObject21 openFormBuilder()

Open new form builder

Creates a new Form Builder session and returns a URL that can be used to open the embeddable Form Builder for creating a new form.

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.FormsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    FormsApi apiInstance = new FormsApi(defaultClient);
    try {
      InlineObject21 result = apiInstance.openFormBuilder();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FormsApi#openFormBuilder");
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

[**InlineObject21**](InlineObject21.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Form Builder URL |  -  |
| **401** | Unauthorized |  -  |
| **402** | Account Suspended |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Unprocessable Entity |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="openFormBuilderForExistingForm"></a>
# **openFormBuilderForExistingForm**
> InlineObject21 openFormBuilderForExistingForm(formId)

Open existing form builder

Creates a Form Builder session for editing an existing form and returns a URL that can be used to open the embeddable Form Builder.

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.FormsApi;

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
      InlineObject21 result = apiInstance.openFormBuilderForExistingForm(formId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FormsApi#openFormBuilderForExistingForm");
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

[**InlineObject21**](InlineObject21.md)

### Authorization

[JSONWebTokenAuth](../README.md#JSONWebTokenAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Form Builder URL |  -  |
| **401** | Unauthorized |  -  |
| **402** | Account Suspended |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Unprocessable Entity |  -  |
| **429** | Too Many Requests |  -  |
| **500** | Internal Server Error |  -  |

<a id="shareForm"></a>
# **shareForm**
> InlineObject20 shareForm(formId)

Share form

Creates an unique sharing URL to collect form data

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.FormsApi;

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
      InlineObject20 result = apiInstance.shareForm(formId);
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

[**InlineObject20**](InlineObject20.md)

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
> InlineObject19 updateForm(formId, formConfigurationNew)

Update form

Updates the form configuration. The form configuration must be complete as the entire configuration is replaced and not merged.

### Example
```java
// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.models.*;
import com.pdfgeneratorapi.client.api.FormsApi;

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
      InlineObject19 result = apiInstance.updateForm(formId, formConfigurationNew);
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

[**InlineObject19**](InlineObject19.md)

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

