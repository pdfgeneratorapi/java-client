/*
 * PDF Generator API
 * # Introduction [PDF Generator API](https://pdfgeneratorapi.com) allows you easily generate transactional PDF documents and reduce the development and support costs by enabling your users to create and manage their document templates using a browser-based drag-and-drop document editor.  The PDF Generator API features a web API architecture, allowing you to code in the language of your choice. This API supports the JSON media type, and uses UTF-8 character encoding.  ## Base URL The base URL for all the API endpoints is `https://us1.pdfgeneratorapi.com/api/v4`  For example * `https://us1.pdfgeneratorapi.com/api/v4/templates` * `https://us1.pdfgeneratorapi.com/api/v4/workspaces` * `https://us1.pdfgeneratorapi.com/api/v4/templates/123123`  ## Editor PDF Generator API comes with a powerful drag & drop editor that allows to create any kind of document templates, from barcode labels to invoices, quotes and reports. You can find tutorials and videos from our [Support Portal](https://support.pdfgeneratorapi.com). * [Component specification](https://support.pdfgeneratorapi.com/en/category/components-1ffseaj/) * [Expression Language documentation](https://support.pdfgeneratorapi.com/en/category/expression-language-q203pa/) * [Frequently asked questions and answers](https://support.pdfgeneratorapi.com/en/category/qanda-1ov519d/)  ## Definitions  ### Organization Organization is a group of workspaces owned by your account.  ### Workspace Workspace contains templates. Each workspace has access to their own templates and organization default templates.  ### Master Workspace Master Workspace is the main/default workspace of your Organization. The Master Workspace identifier is the email you signed up with.  ### Default Template Default template is a template that is available for all workspaces by default. You can set the template access type under Page Setup. If template has \"Organization\" access then your users can use them from the \"New\" menu in the Editor.  ### Data Field Data Field is a placeholder for the specific data in your JSON data set. In this example JSON you can access the buyer name using Data Field `{paymentDetails::buyerName}`. The separator between depth levels is :: (two colons). When designing the template you don’t have to know every Data Field, our editor automatically extracts all the available fields from your data set and provides an easy way to insert them into the template. ``` {     \"documentNumber\": 1,     \"paymentDetails\": {         \"method\": \"Credit Card\",         \"buyerName\": \"John Smith\"     },     \"items\": [         {             \"id\": 1,             \"name\": \"Item one\"         }     ] } ```  ## Rate limiting Our API endpoints use IP-based rate limiting and allow you to make up to 2 requests per second and 60 requests per minute. If you make more requests, you will receive a response with HTTP code 429.  Response headers contain additional values:  | Header   | Description                    | |--------|--------------------------------| | X-RateLimit-Limit    | Maximum requests per minute                   | | X-RateLimit-Remaining    | The requests remaining in the current minute               | | Retry-After     | How many seconds you need to wait until you are allowed to make requests |  *  *  *  *  *  # Libraries and SDKs ## Postman Collection We have created a [Postman Collection](https://www.postman.com/pdfgeneratorapi/workspace/pdf-generator-api-public-workspace/overview) so you can easily test all the API endpoints without developing and code.   ## Client Libraries All our Client Libraries are auto-generated using [OpenAPI Generator](https://openapi-generator.tech/) which uses the OpenAPI v3 specification to automatically generate a client library in specific programming language.  * [PHP Client](https://github.com/pdfgeneratorapi/php-client) * [Java Client](https://github.com/pdfgeneratorapi/java-client) * [Ruby Client](https://github.com/pdfgeneratorapi/ruby-client) * [Python Client](https://github.com/pdfgeneratorapi/python-client) * [Javascript Client](https://github.com/pdfgeneratorapi/javascript-client)  We have validated the generated libraries, but let us know if you find any anomalies in the client code.  ## Model Context Protocol (MCP) Server Integrate document generation directly into your AI agents and LLM applications using our official Model Context Protocol (MCP) Server.  The MCP server provides a standardized interface that allows AI assistants (like Claude Desktop and other MCP-compatible clients) to securely interact with the PDF Generator API. With it, your AI applications can automatically fetch workspaces, retrieve templates, merge data, and generate PDF documents on the fly.  [Get PDF Generator API MCP Server](https://github.com/pdfgeneratorapi/mcp-server) *  *  *  *  *   # Authentication The PDF Generator API uses __JSON Web Tokens (JWT)__ to authenticate all API requests. These tokens offer a method to establish secure server-to-server authentication by transferring a compact JSON object with a signed payload of your account’s API Key and Secret. When authenticating to the PDF Generator API, a JWT should be generated uniquely by a __server-side application__ and included as a __Bearer Token__ in the header of each request.   <SecurityDefinitions />  ## Accessing your API Key and Secret You can find your __API Key__ and __API Secret__ from the __Account Settings__ page after you login to PDF Generator API [here](https://pdfgeneratorapi.com/login).  ## Creating a JWT JSON Web Tokens are composed of three sections: a header, a payload (containing a claim set), and a signature. The header and payload are JSON objects, which are serialized to UTF-8 bytes, then encoded using base64url encoding.  The JWT's header, payload, and signature are concatenated with periods (.). As a result, a JWT typically takes the following form: ``` {Base64url encoded header}.{Base64url encoded payload}.{Base64url encoded signature} ```  We recommend and support libraries provided on [jwt.io](https://jwt.io/). While other libraries can create JWT, these recommended libraries are the most robust.  ### Header Property `alg` defines which signing algorithm is being used. PDF Generator API users HS256. Property `typ` defines the type of token and it is always JWT. ``` {   \"alg\": \"HS256\",   \"typ\": \"JWT\" } ```  ### Payload The second part of the token is the payload, which contains the claims  or the pieces of information being passed about the user and any metadata required. It is mandatory to specify the following claims: * issuer (`iss`): Your API key * subject (`sub`): Workspace identifier * expiration time (`exp`): Timestamp (unix epoch time) until the token is valid. It is highly recommended to set the exp timestamp for a short period, i.e. a matter of seconds. This way, if a token is intercepted or shared, the token will only be valid for a short period of time.  ``` {   \"iss\": \"ad54aaff89ffdfeff178bb8a8f359b29fcb20edb56250b9f584aa2cb0162ed4a\",   \"sub\": \"demo.example@actualreports.com\",   \"exp\": 1586112639 } ```  ### Payload for Partners Our partners can send their unique identifier (provided by us) in JWT's partner_id claim. If the `partner_id` value is specified in the JWT, the organization making the request is automatically connected to the partner account. * Partner ID (`partner_id`): Unique identifier provide by PDF Generator API team  ``` {   \"iss\": \"ad54aaff89ffdfeff178bb8a8f359b29fcb20edb56250b9f584aa2cb0162ed4a\",   \"sub\": \"demo.example@actualreports.com\",   \"partner_id\": \"my-partner-identifier\",   \"exp\": 1586112639 } ```  ### Signature To create the signature part you have to take the encoded header, the encoded payload, a secret, the algorithm specified in the header, and sign that. The signature is used to verify the message wasn't changed along the way, and, in the case of tokens signed with a private key, it can also verify that the sender of the JWT is who it says it is. ``` HMACSHA256(     base64UrlEncode(header) + \".\" +     base64UrlEncode(payload),     API_SECRET) ```  ### Putting all together The output is three Base64-URL strings separated by dots. The following shows a JWT that has the previous header and payload encoded, and it is signed with a secret. ``` eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhZDU0YWFmZjg5ZmZkZmVmZjE3OGJiOGE4ZjM1OWIyOWZjYjIwZWRiNTYyNTBiOWY1ODRhYTJjYjAxNjJlZDRhIiwic3ViIjoiZGVtby5leGFtcGxlQGFjdHVhbHJlcG9ydHMuY29tIn0.SxO-H7UYYYsclS8RGWO1qf0z1cB1m73wF9FLl9RCc1Q  // Base64 encoded header: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9 // Base64 encoded payload: eyJpc3MiOiJhZDU0YWFmZjg5ZmZkZmVmZjE3OGJiOGE4ZjM1OWIyOWZjYjIwZWRiNTYyNTBiOWY1ODRhYTJjYjAxNjJlZDRhIiwic3ViIjoiZGVtby5leGFtcGxlQGFjdHVhbHJlcG9ydHMuY29tIn0 // Signature: SxO-H7UYYYsclS8RGWO1qf0z1cB1m73wF9FLl9RCc1Q ```  ## Temporary JWTs You can create a temporary token in [Account Settings](https://pdfgeneratorapi.com/account/organization) page after you login to PDF Generator API. The generated token uses your email address as the subject (`sub`) value and is valid for __15 minutes__. You can also use [jwt.io](https://jwt.io/) to generate test tokens for your API calls. These test tokens should never be used in production applications. *  *  *  *  *  # Error codes  Every error response is a JSON object with a `message` string. Request validation failures (422) also include an `errors` object keyed by the field that failed.  ```json {   \"message\": \"The identifier field is required.\",   \"errors\": {     \"identifier\": [\"The identifier field is required.\"]   } } ```  | Code   | Description                    | |--------|--------------------------------| | 400    | Bad Request                    | | 401    | Unauthorized                   | | 402    | Payment Required               | | 403    | Forbidden                      | | 404    | Not Found                      | | 405    | Method Not Allowed             | | 409    | Conflict                       | | 410    | Gone                           | | 422    | Unprocessable Entity           | | 429    | Too Many Requests              | | 500    | Internal Server Error          | | 503    | Service Unavailable            |  ## 401 Unauthorized | Description                                                                       | |-----------------------------------------------------------------------------------| | Authentication failed: JWT Token missing.                                         | | Authentication failed: Malformed JWT Token.                                       | | Authentication failed: Expired JWT Token.                                         | | Authentication failed: Invalid workspace.                                         | | Authentication failed: Invalid organization.                                      | | Authentication failed: This application no longer has access to the workspace.   | | Authentication failed: The sub field is required. (also `iss` and `exp`)          |  ## 402 Payment Required | Description                                                                       | |-----------------------------------------------------------------------------------| | Your account is suspended, please upgrade your account or contact support@pdfgeneratorapi.com. |  ## 403 Forbidden | Description                                                                       | |-----------------------------------------------------------------------------------| | You don't have permission to access this content. Please get in touch with your organization administrator to update your access permissions. | | This application was not granted permission for this request.                    | | Deleting own user is not allowed.                                                 | | Deleting organization owner is not allowed.                                       |  ## 404 Not Found | Description                                                                       | |-----------------------------------------------------------------------------------| | Entity not found.                                                                 | | Route not found.                                                                  | | Workspace doesn’t have access to read the template.                               |  ## 422 Unprocessable Entity | Description                                                                       | |-----------------------------------------------------------------------------------| | Unable to parse JSON, please check formatting.                                    | | Template id should be a numeric value.                                            | | The per page must be at least 1. (with `errors.per_page`)                         |  ## 429 Too Many Requests | Description                                                                       | |-----------------------------------------------------------------------------------| | Per-second rate limit exceeded. Please slow down your requests.                   | | Per-minute rate limit exceeded. Please try again in a minute.                     | | Global per-second rate limit exceeded. Please slow down your requests.            | | Global per-minute rate limit exceeded. Please try again in a minute.              |  *  *  *  *  * 
 *
 * The version of the OpenAPI document: 4.0.34
 * Contact: support@pdfgeneratorapi.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.pdfgeneratorapi.client.api;

import com.pdfgeneratorapi.client.ApiCallback;
import com.pdfgeneratorapi.client.ApiClient;
import com.pdfgeneratorapi.client.ApiException;
import com.pdfgeneratorapi.client.ApiResponse;
import com.pdfgeneratorapi.client.Configuration;
import com.pdfgeneratorapi.client.Pair;
import com.pdfgeneratorapi.client.ProgressRequestBody;
import com.pdfgeneratorapi.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.pdfgeneratorapi.client.model.CreateEInvoiceRequest;
import com.pdfgeneratorapi.client.model.CreateFacturXEInvoiceRequest;
import com.pdfgeneratorapi.client.model.CreateXRechnungEInvoiceRequest;
import com.pdfgeneratorapi.client.model.Error;
import com.pdfgeneratorapi.client.model.GetEInvoiceSchema200Response;
import com.pdfgeneratorapi.client.model.InlineObject;
import com.pdfgeneratorapi.client.model.InlineObject8;
import com.pdfgeneratorapi.client.model.ValidationError;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EInvoicesApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public EInvoicesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public EInvoicesApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public int getHostIndex() {
        return localHostIndex;
    }

    public void setHostIndex(int hostIndex) {
        this.localHostIndex = hostIndex;
    }

    public String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    public void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    /**
     * Build call for createEInvoice
     * @param createEInvoiceRequest eInvoice conversion (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> XML-based e-invoice response </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  </td><td>  -  </td></tr>
        <tr><td> 402 </td><td> Payment Required. The account is suspended. </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  </td><td>  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found. The resource does not exist or the workspace cannot access it. </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. </td><td>  * Retry-After - Seconds to wait before the next request is allowed. <br>  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createEInvoiceCall(@javax.annotation.Nonnull CreateEInvoiceRequest createEInvoiceRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = createEInvoiceRequest;

        // create path and map variables
        String localVarPath = "/einvoice";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "JSONWebTokenAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createEInvoiceValidateBeforeCall(@javax.annotation.Nonnull CreateEInvoiceRequest createEInvoiceRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'createEInvoiceRequest' is set
        if (createEInvoiceRequest == null) {
            throw new ApiException("Missing the required parameter 'createEInvoiceRequest' when calling createEInvoice(Async)");
        }

        return createEInvoiceCall(createEInvoiceRequest, _callback);

    }

    /**
     * Create eInvoice
     * This endpoint transforms a JSON payload into an XML-based e-invoice that is fully compliant with the European EN 16931 standard. The generated output can be formatted in either UBL (Universal Business Language) or CII (Cross-Industry Invoice) syntax, ensuring interoperability across B2B and B2G platforms. The JSON payload follows Peppol BIS Billing 3.0 UBL Invoice described here: https://docs.peppol.eu/poacc/billing/3.0/
     * @param createEInvoiceRequest eInvoice conversion (required)
     * @return InlineObject
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> XML-based e-invoice response </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  </td><td>  -  </td></tr>
        <tr><td> 402 </td><td> Payment Required. The account is suspended. </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  </td><td>  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found. The resource does not exist or the workspace cannot access it. </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. </td><td>  * Retry-After - Seconds to wait before the next request is allowed. <br>  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public InlineObject createEInvoice(@javax.annotation.Nonnull CreateEInvoiceRequest createEInvoiceRequest) throws ApiException {
        ApiResponse<InlineObject> localVarResp = createEInvoiceWithHttpInfo(createEInvoiceRequest);
        return localVarResp.getData();
    }

    /**
     * Create eInvoice
     * This endpoint transforms a JSON payload into an XML-based e-invoice that is fully compliant with the European EN 16931 standard. The generated output can be formatted in either UBL (Universal Business Language) or CII (Cross-Industry Invoice) syntax, ensuring interoperability across B2B and B2G platforms. The JSON payload follows Peppol BIS Billing 3.0 UBL Invoice described here: https://docs.peppol.eu/poacc/billing/3.0/
     * @param createEInvoiceRequest eInvoice conversion (required)
     * @return ApiResponse&lt;InlineObject&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> XML-based e-invoice response </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  </td><td>  -  </td></tr>
        <tr><td> 402 </td><td> Payment Required. The account is suspended. </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  </td><td>  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found. The resource does not exist or the workspace cannot access it. </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. </td><td>  * Retry-After - Seconds to wait before the next request is allowed. <br>  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<InlineObject> createEInvoiceWithHttpInfo(@javax.annotation.Nonnull CreateEInvoiceRequest createEInvoiceRequest) throws ApiException {
        okhttp3.Call localVarCall = createEInvoiceValidateBeforeCall(createEInvoiceRequest, null);
        Type localVarReturnType = new TypeToken<InlineObject>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Create eInvoice (asynchronously)
     * This endpoint transforms a JSON payload into an XML-based e-invoice that is fully compliant with the European EN 16931 standard. The generated output can be formatted in either UBL (Universal Business Language) or CII (Cross-Industry Invoice) syntax, ensuring interoperability across B2B and B2G platforms. The JSON payload follows Peppol BIS Billing 3.0 UBL Invoice described here: https://docs.peppol.eu/poacc/billing/3.0/
     * @param createEInvoiceRequest eInvoice conversion (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> XML-based e-invoice response </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  </td><td>  -  </td></tr>
        <tr><td> 402 </td><td> Payment Required. The account is suspended. </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  </td><td>  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found. The resource does not exist or the workspace cannot access it. </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. </td><td>  * Retry-After - Seconds to wait before the next request is allowed. <br>  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createEInvoiceAsync(@javax.annotation.Nonnull CreateEInvoiceRequest createEInvoiceRequest, final ApiCallback<InlineObject> _callback) throws ApiException {

        okhttp3.Call localVarCall = createEInvoiceValidateBeforeCall(createEInvoiceRequest, _callback);
        Type localVarReturnType = new TypeToken<InlineObject>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for createFacturXEInvoice
     * @param createFacturXEInvoiceRequest eInvoice conversion (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Document data </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  </td><td>  -  </td></tr>
        <tr><td> 402 </td><td> Payment Required. The account is suspended. </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  </td><td>  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found. The resource does not exist or the workspace cannot access it. </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. </td><td>  * Retry-After - Seconds to wait before the next request is allowed. <br>  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createFacturXEInvoiceCall(@javax.annotation.Nonnull CreateFacturXEInvoiceRequest createFacturXEInvoiceRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = createFacturXEInvoiceRequest;

        // create path and map variables
        String localVarPath = "/einvoice/facturx";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "JSONWebTokenAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createFacturXEInvoiceValidateBeforeCall(@javax.annotation.Nonnull CreateFacturXEInvoiceRequest createFacturXEInvoiceRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'createFacturXEInvoiceRequest' is set
        if (createFacturXEInvoiceRequest == null) {
            throw new ApiException("Missing the required parameter 'createFacturXEInvoiceRequest' when calling createFacturXEInvoice(Async)");
        }

        return createFacturXEInvoiceCall(createFacturXEInvoiceRequest, _callback);

    }

    /**
     * Create Factur-X eInvoice
     * This endpoint transforms a JSON payload a Factur-X e-invoice that is fully compliant with the European EN 16931 standard. The generated output is always a PDF document, embedding a structured CII (Cross-Industry Invoice) XML according to the Factur-X format into a human-readable invoice, ensuring interoperability across B2B and B2G platforms. The JSON payload follows Peppol BIS Billing 3.0 UBL Invoice described here: https://docs.peppol.eu/poacc/billing/3.0/ Preview mode (&#x60;testing: true&#x60;) is not available for Factur-X.
     * @param createFacturXEInvoiceRequest eInvoice conversion (required)
     * @return InlineObject8
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Document data </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  </td><td>  -  </td></tr>
        <tr><td> 402 </td><td> Payment Required. The account is suspended. </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  </td><td>  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found. The resource does not exist or the workspace cannot access it. </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. </td><td>  * Retry-After - Seconds to wait before the next request is allowed. <br>  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public InlineObject8 createFacturXEInvoice(@javax.annotation.Nonnull CreateFacturXEInvoiceRequest createFacturXEInvoiceRequest) throws ApiException {
        ApiResponse<InlineObject8> localVarResp = createFacturXEInvoiceWithHttpInfo(createFacturXEInvoiceRequest);
        return localVarResp.getData();
    }

    /**
     * Create Factur-X eInvoice
     * This endpoint transforms a JSON payload a Factur-X e-invoice that is fully compliant with the European EN 16931 standard. The generated output is always a PDF document, embedding a structured CII (Cross-Industry Invoice) XML according to the Factur-X format into a human-readable invoice, ensuring interoperability across B2B and B2G platforms. The JSON payload follows Peppol BIS Billing 3.0 UBL Invoice described here: https://docs.peppol.eu/poacc/billing/3.0/ Preview mode (&#x60;testing: true&#x60;) is not available for Factur-X.
     * @param createFacturXEInvoiceRequest eInvoice conversion (required)
     * @return ApiResponse&lt;InlineObject8&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Document data </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  </td><td>  -  </td></tr>
        <tr><td> 402 </td><td> Payment Required. The account is suspended. </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  </td><td>  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found. The resource does not exist or the workspace cannot access it. </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. </td><td>  * Retry-After - Seconds to wait before the next request is allowed. <br>  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<InlineObject8> createFacturXEInvoiceWithHttpInfo(@javax.annotation.Nonnull CreateFacturXEInvoiceRequest createFacturXEInvoiceRequest) throws ApiException {
        okhttp3.Call localVarCall = createFacturXEInvoiceValidateBeforeCall(createFacturXEInvoiceRequest, null);
        Type localVarReturnType = new TypeToken<InlineObject8>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Create Factur-X eInvoice (asynchronously)
     * This endpoint transforms a JSON payload a Factur-X e-invoice that is fully compliant with the European EN 16931 standard. The generated output is always a PDF document, embedding a structured CII (Cross-Industry Invoice) XML according to the Factur-X format into a human-readable invoice, ensuring interoperability across B2B and B2G platforms. The JSON payload follows Peppol BIS Billing 3.0 UBL Invoice described here: https://docs.peppol.eu/poacc/billing/3.0/ Preview mode (&#x60;testing: true&#x60;) is not available for Factur-X.
     * @param createFacturXEInvoiceRequest eInvoice conversion (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Document data </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  </td><td>  -  </td></tr>
        <tr><td> 402 </td><td> Payment Required. The account is suspended. </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  </td><td>  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found. The resource does not exist or the workspace cannot access it. </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. </td><td>  * Retry-After - Seconds to wait before the next request is allowed. <br>  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createFacturXEInvoiceAsync(@javax.annotation.Nonnull CreateFacturXEInvoiceRequest createFacturXEInvoiceRequest, final ApiCallback<InlineObject8> _callback) throws ApiException {

        okhttp3.Call localVarCall = createFacturXEInvoiceValidateBeforeCall(createFacturXEInvoiceRequest, _callback);
        Type localVarReturnType = new TypeToken<InlineObject8>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for createXRechnungEInvoice
     * @param createXRechnungEInvoiceRequest eInvoice conversion (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> XML-based e-invoice response </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  </td><td>  -  </td></tr>
        <tr><td> 402 </td><td> Payment Required. The account is suspended. </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  </td><td>  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found. The resource does not exist or the workspace cannot access it. </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. </td><td>  * Retry-After - Seconds to wait before the next request is allowed. <br>  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createXRechnungEInvoiceCall(@javax.annotation.Nonnull CreateXRechnungEInvoiceRequest createXRechnungEInvoiceRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = createXRechnungEInvoiceRequest;

        // create path and map variables
        String localVarPath = "/einvoice/xrechnung";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "JSONWebTokenAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createXRechnungEInvoiceValidateBeforeCall(@javax.annotation.Nonnull CreateXRechnungEInvoiceRequest createXRechnungEInvoiceRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'createXRechnungEInvoiceRequest' is set
        if (createXRechnungEInvoiceRequest == null) {
            throw new ApiException("Missing the required parameter 'createXRechnungEInvoiceRequest' when calling createXRechnungEInvoice(Async)");
        }

        return createXRechnungEInvoiceCall(createXRechnungEInvoiceRequest, _callback);

    }

    /**
     * Create XRechnung eInvoice
     * This endpoint transforms a JSON payload into an XML-based XRechnung e-invoice that is fully compliant with the European EN 16931 standard. The generated output follows the XRechnung format and can be formatted in either UBL (Universal Business Language) or CII (Cross-Industry Invoice) syntax, ensuring interoperability across B2B and B2G platforms. The JSON payload follows Peppol BIS Billing 3.0 UBL Invoice described here: https://docs.peppol.eu/poacc/billing/3.0/
     * @param createXRechnungEInvoiceRequest eInvoice conversion (required)
     * @return InlineObject
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> XML-based e-invoice response </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  </td><td>  -  </td></tr>
        <tr><td> 402 </td><td> Payment Required. The account is suspended. </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  </td><td>  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found. The resource does not exist or the workspace cannot access it. </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. </td><td>  * Retry-After - Seconds to wait before the next request is allowed. <br>  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public InlineObject createXRechnungEInvoice(@javax.annotation.Nonnull CreateXRechnungEInvoiceRequest createXRechnungEInvoiceRequest) throws ApiException {
        ApiResponse<InlineObject> localVarResp = createXRechnungEInvoiceWithHttpInfo(createXRechnungEInvoiceRequest);
        return localVarResp.getData();
    }

    /**
     * Create XRechnung eInvoice
     * This endpoint transforms a JSON payload into an XML-based XRechnung e-invoice that is fully compliant with the European EN 16931 standard. The generated output follows the XRechnung format and can be formatted in either UBL (Universal Business Language) or CII (Cross-Industry Invoice) syntax, ensuring interoperability across B2B and B2G platforms. The JSON payload follows Peppol BIS Billing 3.0 UBL Invoice described here: https://docs.peppol.eu/poacc/billing/3.0/
     * @param createXRechnungEInvoiceRequest eInvoice conversion (required)
     * @return ApiResponse&lt;InlineObject&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> XML-based e-invoice response </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  </td><td>  -  </td></tr>
        <tr><td> 402 </td><td> Payment Required. The account is suspended. </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  </td><td>  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found. The resource does not exist or the workspace cannot access it. </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. </td><td>  * Retry-After - Seconds to wait before the next request is allowed. <br>  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<InlineObject> createXRechnungEInvoiceWithHttpInfo(@javax.annotation.Nonnull CreateXRechnungEInvoiceRequest createXRechnungEInvoiceRequest) throws ApiException {
        okhttp3.Call localVarCall = createXRechnungEInvoiceValidateBeforeCall(createXRechnungEInvoiceRequest, null);
        Type localVarReturnType = new TypeToken<InlineObject>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Create XRechnung eInvoice (asynchronously)
     * This endpoint transforms a JSON payload into an XML-based XRechnung e-invoice that is fully compliant with the European EN 16931 standard. The generated output follows the XRechnung format and can be formatted in either UBL (Universal Business Language) or CII (Cross-Industry Invoice) syntax, ensuring interoperability across B2B and B2G platforms. The JSON payload follows Peppol BIS Billing 3.0 UBL Invoice described here: https://docs.peppol.eu/poacc/billing/3.0/
     * @param createXRechnungEInvoiceRequest eInvoice conversion (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> XML-based e-invoice response </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized. The message starts with &#x60;Authentication failed:&#x60; followed by the reason: * &#x60;JWT Token missing.&#x60; * &#x60;Malformed JWT Token.&#x60; * &#x60;Expired JWT Token.&#x60; * &#x60;Invalid workspace.&#x60; * &#x60;Invalid organization.&#x60; * &#x60;This application no longer has access to the workspace.&#x60; * a missing &#x60;iss&#x60;, &#x60;sub&#x60; or &#x60;exp&#x60; claim, e.g. &#x60;The sub field is required.&#x60;  </td><td>  -  </td></tr>
        <tr><td> 402 </td><td> Payment Required. The account is suspended. </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden. The workspace is not allowed to perform the request, for example a regular workspace calling an endpoint reserved for the master workspace. Requests made with an OAuth application credential that lacks the scope for the endpoint also get a &#x60;WWW-Authenticate&#x60; header.  </td><td>  * WWW-Authenticate - Sent only when an OAuth application credential lacks the required scope. <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found. The resource does not exist or the workspace cannot access it. </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity. Request validation failures, including an invalid &#x60;page&#x60; or &#x60;per_page&#x60;, return an &#x60;errors&#x60; object keyed by field. Other 422 errors, such as a malformed JSON body or a failed conversion, return only &#x60;message&#x60;.  </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. </td><td>  * Retry-After - Seconds to wait before the next request is allowed. <br>  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createXRechnungEInvoiceAsync(@javax.annotation.Nonnull CreateXRechnungEInvoiceRequest createXRechnungEInvoiceRequest, final ApiCallback<InlineObject> _callback) throws ApiException {

        okhttp3.Call localVarCall = createXRechnungEInvoiceValidateBeforeCall(createXRechnungEInvoiceRequest, _callback);
        Type localVarReturnType = new TypeToken<InlineObject>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getEInvoiceSchema
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> e-invoice JSON Schema </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. </td><td>  * Retry-After - Seconds to wait before the next request is allowed. <br>  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getEInvoiceSchemaCall(final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/einvoice/schema";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getEInvoiceSchemaValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        return getEInvoiceSchemaCall(_callback);

    }

    /**
     * Get schema
     * Returns e-invoice JSON schema which defines the structure of the e-invoice.
     * @return GetEInvoiceSchema200Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> e-invoice JSON Schema </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. </td><td>  * Retry-After - Seconds to wait before the next request is allowed. <br>  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public GetEInvoiceSchema200Response getEInvoiceSchema() throws ApiException {
        ApiResponse<GetEInvoiceSchema200Response> localVarResp = getEInvoiceSchemaWithHttpInfo();
        return localVarResp.getData();
    }

    /**
     * Get schema
     * Returns e-invoice JSON schema which defines the structure of the e-invoice.
     * @return ApiResponse&lt;GetEInvoiceSchema200Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> e-invoice JSON Schema </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. </td><td>  * Retry-After - Seconds to wait before the next request is allowed. <br>  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<GetEInvoiceSchema200Response> getEInvoiceSchemaWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = getEInvoiceSchemaValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<GetEInvoiceSchema200Response>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get schema (asynchronously)
     * Returns e-invoice JSON schema which defines the structure of the e-invoice.
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table border="1">
       <caption>Response Details</caption>
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> e-invoice JSON Schema </td><td>  -  </td></tr>
        <tr><td> 429 </td><td> Too Many Requests. Wait for the number of seconds in the &#x60;Retry-After&#x60; header before retrying. </td><td>  * Retry-After - Seconds to wait before the next request is allowed. <br>  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getEInvoiceSchemaAsync(final ApiCallback<GetEInvoiceSchema200Response> _callback) throws ApiException {

        okhttp3.Call localVarCall = getEInvoiceSchemaValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<GetEInvoiceSchema200Response>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
