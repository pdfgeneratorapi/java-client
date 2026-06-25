# pdf-generator-api

PDF Generator API
- API version: 4.0.26
  - Build date: 2026-06-25T14:29:26.098108138Z[Etc/UTC]
  - Generator version: 7.14.0

# Introduction
[PDF Generator API](https://pdfgeneratorapi.com) allows you easily generate transactional PDF documents and reduce the development and support costs by enabling your users to create and manage their document templates using a browser-based drag-and-drop document editor.

The PDF Generator API features a web API architecture, allowing you to code in the language of your choice. This API supports the JSON media type, and uses UTF-8 character encoding.

## Base URL
The base URL for all the API endpoints is `https://us1.pdfgeneratorapi.com/api/v4`

For example
* `https://us1.pdfgeneratorapi.com/api/v4/templates`
* `https://us1.pdfgeneratorapi.com/api/v4/workspaces`
* `https://us1.pdfgeneratorapi.com/api/v4/templates/123123`

## Editor
PDF Generator API comes with a powerful drag & drop editor that allows to create any kind of document templates, from barcode labels to invoices, quotes and reports. You can find tutorials and videos from our [Support Portal](https://support.pdfgeneratorapi.com).
* [Component specification](https://support.pdfgeneratorapi.com/en/category/components-1ffseaj/)
* [Expression Language documentation](https://support.pdfgeneratorapi.com/en/category/expression-language-q203pa/)
* [Frequently asked questions and answers](https://support.pdfgeneratorapi.com/en/category/qanda-1ov519d/)

## Definitions

### Organization
Organization is a group of workspaces owned by your account.

### Workspace
Workspace contains templates. Each workspace has access to their own templates and organization default templates.

### Master Workspace
Master Workspace is the main/default workspace of your Organization. The Master Workspace identifier is the email you signed up with.

### Default Template
Default template is a template that is available for all workspaces by default. You can set the template access type under Page Setup. If template has "Organization" access then your users can use them from the "New" menu in the Editor.

### Data Field
Data Field is a placeholder for the specific data in your JSON data set. In this example JSON you can access the buyer name using Data Field `{paymentDetails::buyerName}`. The separator between depth levels is :: (two colons). When designing the template you don’t have to know every Data Field, our editor automatically extracts all the available fields from your data set and provides an easy way to insert them into the template.
```
{
    "documentNumber": 1,
    "paymentDetails": {
        "method": "Credit Card",
        "buyerName": "John Smith"
    },
    "items": [
        {
            "id": 1,
            "name": "Item one"
        }
    ]
}
```

## Rate limiting
Our API endpoints use IP-based rate limiting and allow you to make up to 2 requests per second and 60 requests per minute. If you make more requests, you will receive a response with HTTP code 429.

Response headers contain additional values:

| Header   | Description                    |
|--------|--------------------------------|
| X-RateLimit-Limit    | Maximum requests per minute                   |
| X-RateLimit-Remaining    | The requests remaining in the current minute               |
| Retry-After     | How many seconds you need to wait until you are allowed to make requests |

*  *  *  *  *

# Libraries and SDKs
## Postman Collection
We have created a [Postman Collection](https://www.postman.com/pdfgeneratorapi/workspace/pdf-generator-api-public-workspace/overview) so you can easily test all the API endpoints without developing and code.


## Client Libraries
All our Client Libraries are auto-generated using [OpenAPI Generator](https://openapi-generator.tech/) which uses the OpenAPI v3 specification to automatically generate a client library in specific programming language.

* [PHP Client](https://github.com/pdfgeneratorapi/php-client)
* [Java Client](https://github.com/pdfgeneratorapi/java-client)
* [Ruby Client](https://github.com/pdfgeneratorapi/ruby-client)
* [Python Client](https://github.com/pdfgeneratorapi/python-client)
* [Javascript Client](https://github.com/pdfgeneratorapi/javascript-client)

We have validated the generated libraries, but let us know if you find any anomalies in the client code.

## Model Context Protocol (MCP) Server
Integrate document generation directly into your AI agents and LLM applications using our official Model Context Protocol (MCP) Server.

The MCP server provides a standardized interface that allows AI assistants (like Claude Desktop and other MCP-compatible clients) to securely interact with the PDF Generator API. With it, your AI applications can automatically fetch workspaces, retrieve templates, merge data, and generate PDF documents on the fly.

[Get PDF Generator API MCP Server](https://github.com/pdfgeneratorapi/mcp-server)
*  *  *  *  *


# Authentication
The PDF Generator API uses __JSON Web Tokens (JWT)__ to authenticate all API requests. These tokens offer a method to establish secure server-to-server authentication by transferring a compact JSON object with a signed payload of your account’s API Key and Secret.
When authenticating to the PDF Generator API, a JWT should be generated uniquely by a __server-side application__ and included as a __Bearer Token__ in the header of each request.


<SecurityDefinitions />

## Accessing your API Key and Secret
You can find your __API Key__ and __API Secret__ from the __Account Settings__ page after you login to PDF Generator API [here](https://pdfgeneratorapi.com/login).

## Creating a JWT
JSON Web Tokens are composed of three sections: a header, a payload (containing a claim set), and a signature. The header and payload are JSON objects, which are serialized to UTF-8 bytes, then encoded using base64url encoding.

The JWT's header, payload, and signature are concatenated with periods (.). As a result, a JWT typically takes the following form:
```
{Base64url encoded header}.{Base64url encoded payload}.{Base64url encoded signature}
```

We recommend and support libraries provided on [jwt.io](https://jwt.io/). While other libraries can create JWT, these recommended libraries are the most robust.

### Header
Property `alg` defines which signing algorithm is being used. PDF Generator API users HS256.
Property `typ` defines the type of token and it is always JWT.
```
{
  "alg": "HS256",
  "typ": "JWT"
}
```

### Payload
The second part of the token is the payload, which contains the claims  or the pieces of information being passed about the user and any metadata required.
It is mandatory to specify the following claims:
* issuer (`iss`): Your API key
* subject (`sub`): Workspace identifier
* expiration time (`exp`): Timestamp (unix epoch time) until the token is valid. It is highly recommended to set the exp timestamp for a short period, i.e. a matter of seconds. This way, if a token is intercepted or shared, the token will only be valid for a short period of time.

```
{
  "iss": "ad54aaff89ffdfeff178bb8a8f359b29fcb20edb56250b9f584aa2cb0162ed4a",
  "sub": "demo.example@actualreports.com",
  "exp": 1586112639
}
```

### Payload for Partners
Our partners can send their unique identifier (provided by us) in JWT's partner_id claim. If the `partner_id` value is specified in the JWT, the organization making the request is automatically connected to the partner account.
* Partner ID (`partner_id`): Unique identifier provide by PDF Generator API team

```
{
  "iss": "ad54aaff89ffdfeff178bb8a8f359b29fcb20edb56250b9f584aa2cb0162ed4a",
  "sub": "demo.example@actualreports.com",
  "partner_id": "my-partner-identifier",
  "exp": 1586112639
}
```

### Signature
To create the signature part you have to take the encoded header, the encoded payload, a secret, the algorithm specified in the header, and sign that. The signature is used to verify the message wasn't changed along the way, and, in the case of tokens signed with a private key, it can also verify that the sender of the JWT is who it says it is.
```
HMACSHA256(
    base64UrlEncode(header) + "." +
    base64UrlEncode(payload),
    API_SECRET)
```

### Putting all together
The output is three Base64-URL strings separated by dots. The following shows a JWT that has the previous header and payload encoded, and it is signed with a secret.
```
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhZDU0YWFmZjg5ZmZkZmVmZjE3OGJiOGE4ZjM1OWIyOWZjYjIwZWRiNTYyNTBiOWY1ODRhYTJjYjAxNjJlZDRhIiwic3ViIjoiZGVtby5leGFtcGxlQGFjdHVhbHJlcG9ydHMuY29tIn0.SxO-H7UYYYsclS8RGWO1qf0z1cB1m73wF9FLl9RCc1Q

// Base64 encoded header: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9
// Base64 encoded payload: eyJpc3MiOiJhZDU0YWFmZjg5ZmZkZmVmZjE3OGJiOGE4ZjM1OWIyOWZjYjIwZWRiNTYyNTBiOWY1ODRhYTJjYjAxNjJlZDRhIiwic3ViIjoiZGVtby5leGFtcGxlQGFjdHVhbHJlcG9ydHMuY29tIn0
// Signature: SxO-H7UYYYsclS8RGWO1qf0z1cB1m73wF9FLl9RCc1Q
```

## Temporary JWTs
You can create a temporary token in [Account Settings](https://pdfgeneratorapi.com/account/organization) page after you login to PDF Generator API. The generated token uses your email address as the subject (`sub`) value and is valid for __15 minutes__.
You can also use [jwt.io](https://jwt.io/) to generate test tokens for your API calls. These test tokens should never be used in production applications.
*  *  *  *  *

# Error codes

| Code   | Description                    |
|--------|--------------------------------|
| 401    | Unauthorized                   |
| 402    | Payment Required               |
| 403    | Forbidden                      |
| 404    | Not Found                      |
| 422    | Unprocessable Entity           |
| 429    | Too Many Requests              |
| 500    | Internal Server Error          |

## 401 Unauthorized
| Description                                                             |
|-------------------------------------------------------------------------|
| Authentication failed: request expired                                  |
| Authentication failed: workspace missing                                |
| Authentication failed: key missing                                      |
| Authentication failed: property 'iss' (issuer) missing in JWT           |
| Authentication failed: property 'sub' (subject) missing in JWT          |
| Authentication failed: property 'exp' (expiration time) missing in JWT  |
| Authentication failed: incorrect signature                              |

## 402 Payment Required
| Description                                                             |
|-------------------------------------------------------------------------|
| Your account is suspended, please upgrade your account                  |

## 403 Forbidden
| Description                                                             |
|-------------------------------------------------------------------------|
| Your account has exceeded the monthly document generation limit.        |
| Access not granted: You cannot delete master workspace via API          |
| Access not granted: Template is not accessible by this organization     |
| Your session has expired, please close and reopen the editor.           |

## 404 Entity not found
| Description                                                             |
|-------------------------------------------------------------------------|
| Entity not found                                                        |
| Resource not found                                                      |
| None of the templates is available for the workspace.                   |

## 422 Unprocessable Entity
| Description                                                             |
|-------------------------------------------------------------------------|
| Unable to parse JSON, please check formatting                           |
| Required parameter missing                                              |
| Required parameter missing: template definition not defined             |
| Required parameter missing: template not defined                        |

## 429 Too Many Requests
| Description                                                             |
|-------------------------------------------------------------------------|
| You can make up to 2 requests per second and 60 requests per minute.   |

*  *  *  *  *


  For more information, please visit [https://support.pdfgeneratorapi.com](https://support.pdfgeneratorapi.com)

*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*


## Requirements

Building the API client library requires:
1. Java 1.8+
2. Maven (3.8.3+)/Gradle (7.2+)

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.pdfgeneratorapi</groupId>
  <artifactId>pdf-generator-api</artifactId>
  <version>8.0.26</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
  repositories {
    mavenCentral()     // Needed if the 'pdf-generator-api' jar has been published to maven central.
    mavenLocal()       // Needed if the 'pdf-generator-api' jar has been published to the local maven repo.
  }

  dependencies {
     implementation "com.pdfgeneratorapi:pdf-generator-api:8.0.26"
  }
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/pdf-generator-api-8.0.26.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

// Import classes:
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.auth.*;
import com.pdfgeneratorapi.client.model.*;
import com.pdfgeneratorapi.client.api.AssetsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v4");
    
    // Configure HTTP bearer authorization: JSONWebTokenAuth
    HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
    JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

    AssetsApi apiInstance = new AssetsApi(defaultClient);
    GenerateQRCodeRequest generateQRCodeRequest = new GenerateQRCodeRequest(); // GenerateQRCodeRequest | QR Code configuration
    try {
      GenerateQRCode201Response result = apiInstance.generateQRCode(generateQRCodeRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AssetsApi#generateQRCode");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://us1.pdfgeneratorapi.com/api/v4*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AssetsApi* | [**generateQRCode**](docs/AssetsApi.md#generateQRCode) | **POST** /assets/qrcode | Generate QR Code
*ConversionApi* | [**convertHTML2PDF**](docs/ConversionApi.md#convertHTML2PDF) | **POST** /conversion/html2pdf | HTML to PDF
*ConversionApi* | [**convertPDF2Image**](docs/ConversionApi.md#convertPDF2Image) | **POST** /conversion/pdf2image | PDF to Image
*ConversionApi* | [**convertURL2PDF**](docs/ConversionApi.md#convertURL2PDF) | **POST** /conversion/url2pdf | URL to PDF
*DocumentsApi* | [**deleteDocument**](docs/DocumentsApi.md#deleteDocument) | **DELETE** /documents/{publicId}/actions | Delete document
*DocumentsApi* | [**generateDocument**](docs/DocumentsApi.md#generateDocument) | **POST** /documents/generate | Generate document
*DocumentsApi* | [**generateDocumentAsynchronous**](docs/DocumentsApi.md#generateDocumentAsynchronous) | **POST** /documents/generate/async | Generate document (async)
*DocumentsApi* | [**generateDocumentBatch**](docs/DocumentsApi.md#generateDocumentBatch) | **POST** /documents/generate/batch | Generate document (batch)
*DocumentsApi* | [**generateDocumentBatchAsynchronous**](docs/DocumentsApi.md#generateDocumentBatchAsynchronous) | **POST** /documents/generate/batch/async | Generate document (batch + async)
*DocumentsApi* | [**getAsyncJobStatus**](docs/DocumentsApi.md#getAsyncJobStatus) | **GET** /documents/async/{jobId} | Get job status
*DocumentsApi* | [**getDocument**](docs/DocumentsApi.md#getDocument) | **GET** /documents/{publicId} | Get document
*DocumentsApi* | [**getDocumentActions**](docs/DocumentsApi.md#getDocumentActions) | **GET** /documents/{publicId}/actions | Get document actions
*DocumentsApi* | [**getDocumentVersions**](docs/DocumentsApi.md#getDocumentVersions) | **GET** /documents/{publicId}/versions | Get document versions
*DocumentsApi* | [**getDocuments**](docs/DocumentsApi.md#getDocuments) | **GET** /documents | Get documents
*DocumentsApi* | [**storeDocument**](docs/DocumentsApi.md#storeDocument) | **POST** /documents | Store document
*EInvoicesApi* | [**createEInvoice**](docs/EInvoicesApi.md#createEInvoice) | **POST** /einvoice | Create eInvoice
*EInvoicesApi* | [**createFacturXEInvoice**](docs/EInvoicesApi.md#createFacturXEInvoice) | **POST** /einvoice/facturx | Create Factur-X eInvoice
*EInvoicesApi* | [**createXRechnungEInvoice**](docs/EInvoicesApi.md#createXRechnungEInvoice) | **POST** /einvoice/xrechnung | Create XRechnung eInvoice
*EInvoicesApi* | [**getEInvoiceSchema**](docs/EInvoicesApi.md#getEInvoiceSchema) | **GET** /einvoice/schema | Get schema
*FormsApi* | [**createForm**](docs/FormsApi.md#createForm) | **POST** /forms | Create form
*FormsApi* | [**deleteForm**](docs/FormsApi.md#deleteForm) | **DELETE** /forms/{formId} | Delete form
*FormsApi* | [**getForm**](docs/FormsApi.md#getForm) | **GET** /forms/{formId} | Get form
*FormsApi* | [**getForms**](docs/FormsApi.md#getForms) | **GET** /forms | Get forms
*FormsApi* | [**importForm**](docs/FormsApi.md#importForm) | **POST** /forms/import | Import Form
*FormsApi* | [**openFormBuilder**](docs/FormsApi.md#openFormBuilder) | **POST** /forms/open | Open new form builder
*FormsApi* | [**openFormBuilderForExistingForm**](docs/FormsApi.md#openFormBuilderForExistingForm) | **POST** /forms/{formId}/open | Open existing form builder
*FormsApi* | [**shareForm**](docs/FormsApi.md#shareForm) | **POST** /forms/{formId}/share | Share form
*FormsApi* | [**updateForm**](docs/FormsApi.md#updateForm) | **PUT** /forms/{formId} | Update form
*MiscApi* | [**getStatus**](docs/MiscApi.md#getStatus) | **GET** /status | Get Service Status
*ServicesApi* | [**addWatermark**](docs/ServicesApi.md#addWatermark) | **POST** /pdfservices/watermark | Add watermark
*ServicesApi* | [**decryptDocument**](docs/ServicesApi.md#decryptDocument) | **POST** /pdfservices/decrypt | Decrypt document
*ServicesApi* | [**encryptDocument**](docs/ServicesApi.md#encryptDocument) | **POST** /pdfservices/encrypt | Encrypt document
*ServicesApi* | [**extractFormFields**](docs/ServicesApi.md#extractFormFields) | **POST** /pdfservices/form/fields | Extract form fields
*ServicesApi* | [**fillFormFields**](docs/ServicesApi.md#fillFormFields) | **POST** /pdfservices/form/fill | Fill form fields
*ServicesApi* | [**makeAccessible**](docs/ServicesApi.md#makeAccessible) | **POST** /pdfservices/make-accessible | Make accessible
*ServicesApi* | [**optimizeDocument**](docs/ServicesApi.md#optimizeDocument) | **POST** /pdfservices/optimize | Optimize document
*TemplateLibraryApi* | [**getTemplateLibrary**](docs/TemplateLibraryApi.md#getTemplateLibrary) | **GET** /templates/library | Get template library
*TemplateLibraryApi* | [**getTemplateLibraryItem**](docs/TemplateLibraryApi.md#getTemplateLibraryItem) | **GET** /templates/library/{publicId} | Open template from the library
*TemplateVersionsApi* | [**deleteTemplateVersion**](docs/TemplateVersionsApi.md#deleteTemplateVersion) | **DELETE** /templates/{templateId}/versions/{templateVersion} | Delete template version
*TemplateVersionsApi* | [**getTemplateVersion**](docs/TemplateVersionsApi.md#getTemplateVersion) | **GET** /templates/{templateId}/versions/{templateVersion} | Get template version
*TemplateVersionsApi* | [**listTemplateVersions**](docs/TemplateVersionsApi.md#listTemplateVersions) | **GET** /templates/{templateId}/versions | List template versions
*TemplateVersionsApi* | [**promoteTemplateVersion**](docs/TemplateVersionsApi.md#promoteTemplateVersion) | **PUT** /templates/{templateId}/versions/{templateVersion}/promote | Promote template version
*TemplatesApi* | [**copyTemplate**](docs/TemplatesApi.md#copyTemplate) | **POST** /templates/{templateId}/copy | Copy template
*TemplatesApi* | [**createTemplate**](docs/TemplatesApi.md#createTemplate) | **POST** /templates | Create template
*TemplatesApi* | [**deleteTemplate**](docs/TemplatesApi.md#deleteTemplate) | **DELETE** /templates/{templateId} | Delete template
*TemplatesApi* | [**getTemplate**](docs/TemplatesApi.md#getTemplate) | **GET** /templates/{templateId} | Get template
*TemplatesApi* | [**getTemplateData**](docs/TemplatesApi.md#getTemplateData) | **GET** /templates/{templateId}/data | Get template data fields
*TemplatesApi* | [**getTemplateSchema**](docs/TemplatesApi.md#getTemplateSchema) | **GET** /templates/schema | Get schema
*TemplatesApi* | [**getTemplates**](docs/TemplatesApi.md#getTemplates) | **GET** /templates | Get templates
*TemplatesApi* | [**importTemplate**](docs/TemplatesApi.md#importTemplate) | **POST** /templates/import | Import template
*TemplatesApi* | [**openEditor**](docs/TemplatesApi.md#openEditor) | **POST** /templates/{templateId}/editor | Open editor
*TemplatesApi* | [**updateTemplate**](docs/TemplatesApi.md#updateTemplate) | **PUT** /templates/{templateId} | Update template
*TemplatesApi* | [**validateTemplate**](docs/TemplatesApi.md#validateTemplate) | **POST** /templates/validate | Validate template
*WorkspacesApi* | [**createWorkspace**](docs/WorkspacesApi.md#createWorkspace) | **POST** /workspaces | Create workspace
*WorkspacesApi* | [**deleteWorkspace**](docs/WorkspacesApi.md#deleteWorkspace) | **DELETE** /workspaces/{workspaceIdentifier} | Delete workspace
*WorkspacesApi* | [**getWorkspace**](docs/WorkspacesApi.md#getWorkspace) | **GET** /workspaces/{workspaceIdentifier} | Get workspace
*WorkspacesApi* | [**getWorkspaces**](docs/WorkspacesApi.md#getWorkspaces) | **GET** /workspaces | Get workspaces


## Documentation for Models

 - [AccessibilityOption](docs/AccessibilityOption.md)
 - [AddWatermarkRequest](docs/AddWatermarkRequest.md)
 - [AsyncOutputParam](docs/AsyncOutputParam.md)
 - [CallbackParam](docs/CallbackParam.md)
 - [Component](docs/Component.md)
 - [ConvertHTML2PDFRequest](docs/ConvertHTML2PDFRequest.md)
 - [ConvertPDF2ImageRequest](docs/ConvertPDF2ImageRequest.md)
 - [ConvertURL2PDFRequest](docs/ConvertURL2PDFRequest.md)
 - [CopyTemplateRequest](docs/CopyTemplateRequest.md)
 - [CreateEInvoiceRequest](docs/CreateEInvoiceRequest.md)
 - [CreateFacturXEInvoiceRequest](docs/CreateFacturXEInvoiceRequest.md)
 - [CreateFacturXEInvoiceRequestTemplate](docs/CreateFacturXEInvoiceRequestTemplate.md)
 - [CreateWorkspaceRequest](docs/CreateWorkspaceRequest.md)
 - [DataBatchInner](docs/DataBatchInner.md)
 - [Document](docs/Document.md)
 - [DocumentAction](docs/DocumentAction.md)
 - [DocumentUser](docs/DocumentUser.md)
 - [DocumentVersion](docs/DocumentVersion.md)
 - [EncryptAndDecryptBase64](docs/EncryptAndDecryptBase64.md)
 - [EncryptAndDecryptUrl](docs/EncryptAndDecryptUrl.md)
 - [EncryptDocumentRequest](docs/EncryptDocumentRequest.md)
 - [ExtractFormFieldsRequest](docs/ExtractFormFieldsRequest.md)
 - [FillFormFieldsRequest](docs/FillFormFieldsRequest.md)
 - [FormActionDownload](docs/FormActionDownload.md)
 - [FormActionSend](docs/FormActionSend.md)
 - [FormActionSendSendDocument](docs/FormActionSendSendDocument.md)
 - [FormActionSendSendDocumentHeadersInner](docs/FormActionSendSendDocumentHeadersInner.md)
 - [FormActionStore](docs/FormActionStore.md)
 - [FormConfiguration](docs/FormConfiguration.md)
 - [FormConfigurationNew](docs/FormConfigurationNew.md)
 - [FormConfigurationNewActionsInner](docs/FormConfigurationNewActionsInner.md)
 - [FormFieldsBase64](docs/FormFieldsBase64.md)
 - [FormFieldsInner](docs/FormFieldsInner.md)
 - [FormFieldsUrl](docs/FormFieldsUrl.md)
 - [FormFillBase64](docs/FormFillBase64.md)
 - [FormFillUrl](docs/FormFillUrl.md)
 - [FormatParam](docs/FormatParam.md)
 - [GenerateDocumentAsynchronousRequest](docs/GenerateDocumentAsynchronousRequest.md)
 - [GenerateDocumentBatchAsynchronousRequest](docs/GenerateDocumentBatchAsynchronousRequest.md)
 - [GenerateDocumentBatchRequest](docs/GenerateDocumentBatchRequest.md)
 - [GenerateDocumentRequest](docs/GenerateDocumentRequest.md)
 - [GenerateQRCode201Response](docs/GenerateQRCode201Response.md)
 - [GenerateQRCode201ResponseMeta](docs/GenerateQRCode201ResponseMeta.md)
 - [GenerateQRCodeRequest](docs/GenerateQRCodeRequest.md)
 - [GetStatus200Response](docs/GetStatus200Response.md)
 - [GetTemplateLibrary200Response](docs/GetTemplateLibrary200Response.md)
 - [GetTemplateVersion422Response](docs/GetTemplateVersion422Response.md)
 - [ImportFormBase64](docs/ImportFormBase64.md)
 - [ImportFormRequest](docs/ImportFormRequest.md)
 - [ImportFormUrl](docs/ImportFormUrl.md)
 - [ImportTemplateBase64](docs/ImportTemplateBase64.md)
 - [ImportTemplateRequest](docs/ImportTemplateRequest.md)
 - [ImportTemplateUrl](docs/ImportTemplateUrl.md)
 - [ImportTemplateUrlTemplate](docs/ImportTemplateUrlTemplate.md)
 - [InlineObject](docs/InlineObject.md)
 - [InlineObject1](docs/InlineObject1.md)
 - [InlineObject10](docs/InlineObject10.md)
 - [InlineObject10Meta](docs/InlineObject10Meta.md)
 - [InlineObject11](docs/InlineObject11.md)
 - [InlineObject11Meta](docs/InlineObject11Meta.md)
 - [InlineObject12](docs/InlineObject12.md)
 - [InlineObject12Meta](docs/InlineObject12Meta.md)
 - [InlineObject12MetaStats](docs/InlineObject12MetaStats.md)
 - [InlineObject13](docs/InlineObject13.md)
 - [InlineObject14](docs/InlineObject14.md)
 - [InlineObject14ResponseValue](docs/InlineObject14ResponseValue.md)
 - [InlineObject14ResponseValueDefault](docs/InlineObject14ResponseValueDefault.md)
 - [InlineObject14ResponseValueValue](docs/InlineObject14ResponseValueValue.md)
 - [InlineObject15](docs/InlineObject15.md)
 - [InlineObject16](docs/InlineObject16.md)
 - [InlineObject17](docs/InlineObject17.md)
 - [InlineObject18](docs/InlineObject18.md)
 - [InlineObject19](docs/InlineObject19.md)
 - [InlineObject1Response](docs/InlineObject1Response.md)
 - [InlineObject2](docs/InlineObject2.md)
 - [InlineObject20](docs/InlineObject20.md)
 - [InlineObject20Meta](docs/InlineObject20Meta.md)
 - [InlineObject21](docs/InlineObject21.md)
 - [InlineObject22](docs/InlineObject22.md)
 - [InlineObject22Response](docs/InlineObject22Response.md)
 - [InlineObject23](docs/InlineObject23.md)
 - [InlineObject24](docs/InlineObject24.md)
 - [InlineObject25](docs/InlineObject25.md)
 - [InlineObject26](docs/InlineObject26.md)
 - [InlineObject27](docs/InlineObject27.md)
 - [InlineObject28](docs/InlineObject28.md)
 - [InlineObject29](docs/InlineObject29.md)
 - [InlineObject3](docs/InlineObject3.md)
 - [InlineObject4](docs/InlineObject4.md)
 - [InlineObject5](docs/InlineObject5.md)
 - [InlineObject6](docs/InlineObject6.md)
 - [InlineObject7](docs/InlineObject7.md)
 - [InlineObject7Response](docs/InlineObject7Response.md)
 - [InlineObject8](docs/InlineObject8.md)
 - [InlineObject9](docs/InlineObject9.md)
 - [InlineObject9Meta](docs/InlineObject9Meta.md)
 - [InlineObjectMeta](docs/InlineObjectMeta.md)
 - [KeyFieldParam](docs/KeyFieldParam.md)
 - [MakeAccessibleBase64](docs/MakeAccessibleBase64.md)
 - [MakeAccessibleRequest](docs/MakeAccessibleRequest.md)
 - [MakeAccessibleUrl](docs/MakeAccessibleUrl.md)
 - [MetadataParam](docs/MetadataParam.md)
 - [OpenEditorRequest](docs/OpenEditorRequest.md)
 - [OpenEditorRequestData](docs/OpenEditorRequestData.md)
 - [OptimizeBase64](docs/OptimizeBase64.md)
 - [OptimizeDocumentRequest](docs/OptimizeDocumentRequest.md)
 - [OptimizeUrl](docs/OptimizeUrl.md)
 - [OutputParam](docs/OutputParam.md)
 - [PaginationMeta](docs/PaginationMeta.md)
 - [PromoteTemplateVersion200Response](docs/PromoteTemplateVersion200Response.md)
 - [PublicTemplateLibraryItem](docs/PublicTemplateLibraryItem.md)
 - [StatusParam](docs/StatusParam.md)
 - [StoreDocumentRequest](docs/StoreDocumentRequest.md)
 - [Template](docs/Template.md)
 - [TemplateDefinition](docs/TemplateDefinition.md)
 - [TemplateDefinitionDataSettings](docs/TemplateDefinitionDataSettings.md)
 - [TemplateDefinitionEditor](docs/TemplateDefinitionEditor.md)
 - [TemplateDefinitionNew](docs/TemplateDefinitionNew.md)
 - [TemplateDefinitionNewDataSettings](docs/TemplateDefinitionNewDataSettings.md)
 - [TemplateDefinitionNewEditor](docs/TemplateDefinitionNewEditor.md)
 - [TemplateDefinitionNewLayout](docs/TemplateDefinitionNewLayout.md)
 - [TemplateDefinitionNewLayoutMargins](docs/TemplateDefinitionNewLayoutMargins.md)
 - [TemplateDefinitionNewLayoutRepeatLayout](docs/TemplateDefinitionNewLayoutRepeatLayout.md)
 - [TemplateDefinitionNewPagesInner](docs/TemplateDefinitionNewPagesInner.md)
 - [TemplateDefinitionNewPagesInnerMargins](docs/TemplateDefinitionNewPagesInnerMargins.md)
 - [TemplateDefinitionPagesInner](docs/TemplateDefinitionPagesInner.md)
 - [TemplateParam](docs/TemplateParam.md)
 - [TemplateParamData](docs/TemplateParamData.md)
 - [TemplateParamId](docs/TemplateParamId.md)
 - [TemplateVersion](docs/TemplateVersion.md)
 - [TemplateVersionCollection](docs/TemplateVersionCollection.md)
 - [TemplateVersionCollectionMeta](docs/TemplateVersionCollectionMeta.md)
 - [WatermarkBase64](docs/WatermarkBase64.md)
 - [WatermarkFileUrlWatermark](docs/WatermarkFileUrlWatermark.md)
 - [WatermarkImage](docs/WatermarkImage.md)
 - [WatermarkImageContentBase64](docs/WatermarkImageContentBase64.md)
 - [WatermarkImageContentUrl](docs/WatermarkImageContentUrl.md)
 - [WatermarkPosition](docs/WatermarkPosition.md)
 - [WatermarkText](docs/WatermarkText.md)
 - [Workspace](docs/Workspace.md)


<a id="documentation-for-authorization"></a>
## Documentation for Authorization


Authentication schemes defined for the API:
<a id="JSONWebTokenAuth"></a>
### JSONWebTokenAuth

- **Type**: HTTP Bearer Token authentication (JWT)


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

support@pdfgeneratorapi.com

