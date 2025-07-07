/*
 * PDF Generator API
 * # Introduction [PDF Generator API](https://pdfgeneratorapi.com) allows you easily generate transactional PDF documents and reduce the development and support costs by enabling your users to create and manage their document templates using a browser-based drag-and-drop document editor.  The PDF Generator API features a web API architecture, allowing you to code in the language of your choice. This API supports the JSON media type, and uses UTF-8 character encoding.  ## Base URL The base URL for all the API endpoints is `https://us1.pdfgeneratorapi.com/api/v4`  For example * `https://us1.pdfgeneratorapi.com/api/v4/templates` * `https://us1.pdfgeneratorapi.com/api/v4/workspaces` * `https://us1.pdfgeneratorapi.com/api/v4/templates/123123`  ## Editor PDF Generator API comes with a powerful drag & drop editor that allows to create any kind of document templates, from barcode labels to invoices, quotes and reports. You can find tutorials and videos from our [Support Portal](https://support.pdfgeneratorapi.com). * [Component specification](https://support.pdfgeneratorapi.com/en/category/components-1ffseaj/) * [Expression Language documentation](https://support.pdfgeneratorapi.com/en/category/expression-language-q203pa/) * [Frequently asked questions and answers](https://support.pdfgeneratorapi.com/en/category/qanda-1ov519d/)  ## Definitions  ### Organization Organization is a group of workspaces owned by your account.  ### Workspace Workspace contains templates. Each workspace has access to their own templates and organization default templates.  ### Master Workspace Master Workspace is the main/default workspace of your Organization. The Master Workspace identifier is the email you signed up with.  ### Default Template Default template is a template that is available for all workspaces by default. You can set the template access type under Page Setup. If template has \"Organization\" access then your users can use them from the \"New\" menu in the Editor.  ### Data Field Data Field is a placeholder for the specific data in your JSON data set. In this example JSON you can access the buyer name using Data Field `{paymentDetails::buyerName}`. The separator between depth levels is :: (two colons). When designing the template you don’t have to know every Data Field, our editor automatically extracts all the available fields from your data set and provides an easy way to insert them into the template. ``` {     \"documentNumber\": 1,     \"paymentDetails\": {         \"method\": \"Credit Card\",         \"buyerName\": \"John Smith\"     },     \"items\": [         {             \"id\": 1,             \"name\": \"Item one\"         }     ] } ```  ## Rate limiting Our API endpoints use IP-based rate limiting and allow you to make up to 2 requests per second and 60 requests per minute. If you make more requests, you will receive a response with HTTP code 429.  Response headers contain additional values:  | Header   | Description                    | |--------|--------------------------------| | X-RateLimit-Limit    | Maximum requests per minute                   | | X-RateLimit-Remaining    | The requests remaining in the current minute               | | Retry-After     | How many seconds you need to wait until you are allowed to make requests |  *  *  *  *  *  # Libraries and SDKs ## Postman Collection We have created a [Postman Collection](https://www.postman.com/pdfgeneratorapi/workspace/pdf-generator-api-public-workspace/overview) so you can easily test all the API endpoints without developing and code. You can download the collection [here](https://www.postman.com/pdfgeneratorapi/workspace/pdf-generator-api-public-workspace/collection/11578263-42fed446-af7e-4266-84e1-69e8c1752e93).  ## Client Libraries All our Client Libraries are auto-generated using [OpenAPI Generator](https://openapi-generator.tech/) which uses the OpenAPI v3 specification to automatically generate a client library in specific programming language.  * [PHP Client](https://github.com/pdfgeneratorapi/php-client) * [Java Client](https://github.com/pdfgeneratorapi/java-client) * [Ruby Client](https://github.com/pdfgeneratorapi/ruby-client) * [Python Client](https://github.com/pdfgeneratorapi/python-client) * [Javascript Client](https://github.com/pdfgeneratorapi/javascript-client)  We have validated the generated libraries, but let us know if you find any anomalies in the client code. *  *  *  *  *  # Authentication The PDF Generator API uses __JSON Web Tokens (JWT)__ to authenticate all API requests. These tokens offer a method to establish secure server-to-server authentication by transferring a compact JSON object with a signed payload of your account’s API Key and Secret. When authenticating to the PDF Generator API, a JWT should be generated uniquely by a __server-side application__ and included as a __Bearer Token__ in the header of each request.   <SecurityDefinitions />  ## Accessing your API Key and Secret You can find your __API Key__ and __API Secret__ from the __Account Settings__ page after you login to PDF Generator API [here](https://pdfgeneratorapi.com/login).  ## Creating a JWT JSON Web Tokens are composed of three sections: a header, a payload (containing a claim set), and a signature. The header and payload are JSON objects, which are serialized to UTF-8 bytes, then encoded using base64url encoding.  The JWT's header, payload, and signature are concatenated with periods (.). As a result, a JWT typically takes the following form: ``` {Base64url encoded header}.{Base64url encoded payload}.{Base64url encoded signature} ```  We recommend and support libraries provided on [jwt.io](https://jwt.io/). While other libraries can create JWT, these recommended libraries are the most robust.  ### Header Property `alg` defines which signing algorithm is being used. PDF Generator API users HS256. Property `typ` defines the type of token and it is always JWT. ``` {   \"alg\": \"HS256\",   \"typ\": \"JWT\" } ```  ### Payload The second part of the token is the payload, which contains the claims  or the pieces of information being passed about the user and any metadata required. It is mandatory to specify the following claims: * issuer (`iss`): Your API key * subject (`sub`): Workspace identifier * expiration time (`exp`): Timestamp (unix epoch time) until the token is valid. It is highly recommended to set the exp timestamp for a short period, i.e. a matter of seconds. This way, if a token is intercepted or shared, the token will only be valid for a short period of time.  ``` {   \"iss\": \"ad54aaff89ffdfeff178bb8a8f359b29fcb20edb56250b9f584aa2cb0162ed4a\",   \"sub\": \"demo.example@actualreports.com\",   \"exp\": 1586112639 } ```  ### Payload for Partners Our partners can send their unique identifier (provided by us) in JWT's partner_id claim. If the `partner_id` value is specified in the JWT, the organization making the request is automatically connected to the partner account. * Partner ID (`partner_id`): Unique identifier provide by PDF Generator API team  ``` {   \"iss\": \"ad54aaff89ffdfeff178bb8a8f359b29fcb20edb56250b9f584aa2cb0162ed4a\",   \"sub\": \"demo.example@actualreports.com\",   \"partner_id\": \"my-partner-identifier\",   \"exp\": 1586112639 } ```  ### Signature To create the signature part you have to take the encoded header, the encoded payload, a secret, the algorithm specified in the header, and sign that. The signature is used to verify the message wasn't changed along the way, and, in the case of tokens signed with a private key, it can also verify that the sender of the JWT is who it says it is. ``` HMACSHA256(     base64UrlEncode(header) + \".\" +     base64UrlEncode(payload),     API_SECRET) ```  ### Putting all together The output is three Base64-URL strings separated by dots. The following shows a JWT that has the previous header and payload encoded, and it is signed with a secret. ``` eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhZDU0YWFmZjg5ZmZkZmVmZjE3OGJiOGE4ZjM1OWIyOWZjYjIwZWRiNTYyNTBiOWY1ODRhYTJjYjAxNjJlZDRhIiwic3ViIjoiZGVtby5leGFtcGxlQGFjdHVhbHJlcG9ydHMuY29tIn0.SxO-H7UYYYsclS8RGWO1qf0z1cB1m73wF9FLl9RCc1Q  // Base64 encoded header: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9 // Base64 encoded payload: eyJpc3MiOiJhZDU0YWFmZjg5ZmZkZmVmZjE3OGJiOGE4ZjM1OWIyOWZjYjIwZWRiNTYyNTBiOWY1ODRhYTJjYjAxNjJlZDRhIiwic3ViIjoiZGVtby5leGFtcGxlQGFjdHVhbHJlcG9ydHMuY29tIn0 // Signature: SxO-H7UYYYsclS8RGWO1qf0z1cB1m73wF9FLl9RCc1Q ```  ## Temporary JWTs You can create a temporary token in [Account Settings](https://pdfgeneratorapi.com/account/organization) page after you login to PDF Generator API. The generated token uses your email address as the subject (`sub`) value and is valid for __15 minutes__. You can also use [jwt.io](https://jwt.io/) to generate test tokens for your API calls. These test tokens should never be used in production applications. *  *  *  *  *  # Error codes  | Code   | Description                    | |--------|--------------------------------| | 401    | Unauthorized                   | | 402    | Payment Required               | | 403    | Forbidden                      | | 404    | Not Found                      | | 422    | Unprocessable Entity           | | 429    | Too Many Requests              | | 500    | Internal Server Error          |  ## 401 Unauthorized | Description                                                             | |-------------------------------------------------------------------------| | Authentication failed: request expired                                  | | Authentication failed: workspace missing                                | | Authentication failed: key missing                                      | | Authentication failed: property 'iss' (issuer) missing in JWT           | | Authentication failed: property 'sub' (subject) missing in JWT          | | Authentication failed: property 'exp' (expiration time) missing in JWT  | | Authentication failed: incorrect signature                              |  ## 402 Payment Required | Description                                                             | |-------------------------------------------------------------------------| | Your account is suspended, please upgrade your account                  |  ## 403 Forbidden | Description                                                             | |-------------------------------------------------------------------------| | Your account has exceeded the monthly document generation limit.        | | Access not granted: You cannot delete master workspace via API          | | Access not granted: Template is not accessible by this organization     | | Your session has expired, please close and reopen the editor.           |  ## 404 Entity not found | Description                                                             | |-------------------------------------------------------------------------| | Entity not found                                                        | | Resource not found                                                      | | None of the templates is available for the workspace.                   |  ## 422 Unprocessable Entity | Description                                                             | |-------------------------------------------------------------------------| | Unable to parse JSON, please check formatting                           | | Required parameter missing                                              | | Required parameter missing: template definition not defined             | | Required parameter missing: template not defined                        |  ## 429 Too Many Requests | Description                                                             | |-------------------------------------------------------------------------| | You can make up to 2 requests per second and 60 requests per minute.   |  *  *  *  *  * 
 *
 * The version of the OpenAPI document: 4.0.12
 * Contact: support@pdfgeneratorapi.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.pdfgeneratorapi.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.JsonElement;
import io.gsonfire.GsonFireBuilder;
import io.gsonfire.TypeSelector;

import okio.ByteString;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.HashMap;

/*
 * A JSON utility class
 *
 * NOTE: in the future, this class may be converted to static, which may break
 *       backward-compatibility
 */
public class JSON {
    private static Gson gson;
    private static boolean isLenientOnJson = false;
    private static DateTypeAdapter dateTypeAdapter = new DateTypeAdapter();
    private static SqlDateTypeAdapter sqlDateTypeAdapter = new SqlDateTypeAdapter();
    private static OffsetDateTimeTypeAdapter offsetDateTimeTypeAdapter = new OffsetDateTimeTypeAdapter();
    private static LocalDateTypeAdapter localDateTypeAdapter = new LocalDateTypeAdapter();
    private static ByteArrayAdapter byteArrayAdapter = new ByteArrayAdapter();

    @SuppressWarnings("unchecked")
    public static GsonBuilder createGson() {
        GsonFireBuilder fireBuilder = new GsonFireBuilder()
        ;
        GsonBuilder builder = fireBuilder.createGsonBuilder();
        return builder;
    }

    private static String getDiscriminatorValue(JsonElement readElement, String discriminatorField) {
        JsonElement element = readElement.getAsJsonObject().get(discriminatorField);
        if (null == element) {
            throw new IllegalArgumentException("missing discriminator field: <" + discriminatorField + ">");
        }
        return element.getAsString();
    }

    /**
     * Returns the Java class that implements the OpenAPI schema for the specified discriminator value.
     *
     * @param classByDiscriminatorValue The map of discriminator values to Java classes.
     * @param discriminatorValue The value of the OpenAPI discriminator in the input data.
     * @return The Java class that implements the OpenAPI schema
     */
    private static Class getClassByDiscriminator(Map classByDiscriminatorValue, String discriminatorValue) {
        Class clazz = (Class) classByDiscriminatorValue.get(discriminatorValue);
        if (null == clazz) {
            throw new IllegalArgumentException("cannot determine model class of name: <" + discriminatorValue + ">");
        }
        return clazz;
    }

    static {
        GsonBuilder gsonBuilder = createGson();
        gsonBuilder.registerTypeAdapter(Date.class, dateTypeAdapter);
        gsonBuilder.registerTypeAdapter(java.sql.Date.class, sqlDateTypeAdapter);
        gsonBuilder.registerTypeAdapter(OffsetDateTime.class, offsetDateTimeTypeAdapter);
        gsonBuilder.registerTypeAdapter(LocalDate.class, localDateTypeAdapter);
        gsonBuilder.registerTypeAdapter(byte[].class, byteArrayAdapter);
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.AddWatermark201Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.AddWatermark201ResponseMeta.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.AddWatermark401Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.AddWatermark402Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.AddWatermark403Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.AddWatermark404Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.AddWatermark422Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.AddWatermark429Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.AddWatermark500Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.AddWatermarkRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.CallbackParam.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.Component.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.ConvertHTML2PDFRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.ConvertURL2PDFRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.CopyTemplateRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.CreateFrom201Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.CreateTemplate201Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.CreateWorkspace201Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.CreateWorkspaceRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.DataBatchInner.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.Document.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.EncryptAndDecryptBase64.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.EncryptAndDecryptUrl.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.EncryptDocumentRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.ExtractFormFields200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.ExtractFormFields200ResponseResponseValue.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.ExtractFormFields200ResponseResponseValueDefault.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.ExtractFormFields200ResponseResponseValueValue.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.ExtractFormFieldsRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.FillFormFieldsRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.FormActionDownload.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.FormActionStore.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.FormConfiguration.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.FormConfigurationNew.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.FormConfigurationNewActionsInner.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.FormFieldsBase64.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.FormFieldsInner.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.FormFieldsUrl.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.FormFillBase64.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.FormFillUrl.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.GenerateDocumentAsynchronous201Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.GenerateDocumentAsynchronous201ResponseResponse.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.GenerateDocumentAsynchronousRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.GenerateDocumentBatchAsynchronousRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.GenerateDocumentBatchRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.GenerateDocumentRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.GetDocument200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.GetDocument200ResponseMeta.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.GetDocuments200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.GetForms200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.GetStatus200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.GetTemplateData200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.GetTemplates200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.GetWorkspaces200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.InlineObject.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.InlineObjectResponse.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.OpenEditor200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.OpenEditorRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.OpenEditorRequestData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.OptimizeBase64.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.OptimizeDocument201Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.OptimizeDocument201ResponseMeta.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.OptimizeDocument201ResponseMetaStats.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.OptimizeDocumentRequest.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.OptimizeUrl.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.PaginationMeta.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.ShareForm201Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.ShareForm201ResponseMeta.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.Template.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.TemplateDefinition.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.TemplateDefinitionDataSettings.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.TemplateDefinitionEditor.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.TemplateDefinitionNew.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.TemplateDefinitionNewDataSettings.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.TemplateDefinitionNewEditor.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.TemplateDefinitionNewLayout.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.TemplateDefinitionNewLayoutMargins.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.TemplateDefinitionNewLayoutRepeatLayout.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.TemplateDefinitionNewPagesInner.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.TemplateDefinitionNewPagesInnerMargins.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.TemplateDefinitionPagesInner.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.TemplateParam.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.TemplateParamData.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.ValidateTemplate200Response.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.ValidateTemplate200ResponseResponse.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.WatermarkBase64.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.WatermarkFileUrlWatermark.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.WatermarkImage.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.WatermarkImageContentBase64.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.WatermarkImageContentUrl.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.WatermarkText.CustomTypeAdapterFactory());
        gsonBuilder.registerTypeAdapterFactory(new org.pdfgeneratorapi.client.model.Workspace.CustomTypeAdapterFactory());
        gson = gsonBuilder.create();
    }

    /**
     * Get Gson.
     *
     * @return Gson
     */
    public static Gson getGson() {
        return gson;
    }

    /**
     * Set Gson.
     *
     * @param gson Gson
     */
    public static void setGson(Gson gson) {
        JSON.gson = gson;
    }

    public static void setLenientOnJson(boolean lenientOnJson) {
        isLenientOnJson = lenientOnJson;
    }

    /**
     * Serialize the given Java object into JSON string.
     *
     * @param obj Object
     * @return String representation of the JSON
     */
    public static String serialize(Object obj) {
        return gson.toJson(obj);
    }

    /**
     * Deserialize the given JSON string to Java object.
     *
     * @param <T>        Type
     * @param body       The JSON string
     * @param returnType The type to deserialize into
     * @return The deserialized Java object
     */
    @SuppressWarnings("unchecked")
    public static <T> T deserialize(String body, Type returnType) {
        try {
            if (isLenientOnJson) {
                JsonReader jsonReader = new JsonReader(new StringReader(body));
                // see https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/stream/JsonReader.html#setLenient(boolean)
                jsonReader.setLenient(true);
                return gson.fromJson(jsonReader, returnType);
            } else {
                return gson.fromJson(body, returnType);
            }
        } catch (JsonParseException e) {
            // Fallback processing when failed to parse JSON form response body:
            // return the response body string directly for the String return type;
            if (returnType.equals(String.class)) {
                return (T) body;
            } else {
                throw (e);
            }
        }
    }

    /**
     * Gson TypeAdapter for Byte Array type
     */
    public static class ByteArrayAdapter extends TypeAdapter<byte[]> {

        @Override
        public void write(JsonWriter out, byte[] value) throws IOException {
            if (value == null) {
                out.nullValue();
            } else {
                out.value(ByteString.of(value).base64());
            }
        }

        @Override
        public byte[] read(JsonReader in) throws IOException {
            switch (in.peek()) {
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    String bytesAsBase64 = in.nextString();
                    ByteString byteString = ByteString.decodeBase64(bytesAsBase64);
                    return byteString.toByteArray();
            }
        }
    }

    /**
     * Gson TypeAdapter for JSR310 OffsetDateTime type
     */
    public static class OffsetDateTimeTypeAdapter extends TypeAdapter<OffsetDateTime> {

        private DateTimeFormatter formatter;

        public OffsetDateTimeTypeAdapter() {
            this(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        }

        public OffsetDateTimeTypeAdapter(DateTimeFormatter formatter) {
            this.formatter = formatter;
        }

        public void setFormat(DateTimeFormatter dateFormat) {
            this.formatter = dateFormat;
        }

        @Override
        public void write(JsonWriter out, OffsetDateTime date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                out.value(formatter.format(date));
            }
        }

        @Override
        public OffsetDateTime read(JsonReader in) throws IOException {
            switch (in.peek()) {
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    String date = in.nextString();
                    if (date.endsWith("+0000")) {
                        date = date.substring(0, date.length()-5) + "Z";
                    }
                    return OffsetDateTime.parse(date, formatter);
            }
        }
    }

    /**
     * Gson TypeAdapter for JSR310 LocalDate type
     */
    public static class LocalDateTypeAdapter extends TypeAdapter<LocalDate> {

        private DateTimeFormatter formatter;

        public LocalDateTypeAdapter() {
            this(DateTimeFormatter.ISO_LOCAL_DATE);
        }

        public LocalDateTypeAdapter(DateTimeFormatter formatter) {
            this.formatter = formatter;
        }

        public void setFormat(DateTimeFormatter dateFormat) {
            this.formatter = dateFormat;
        }

        @Override
        public void write(JsonWriter out, LocalDate date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                out.value(formatter.format(date));
            }
        }

        @Override
        public LocalDate read(JsonReader in) throws IOException {
            switch (in.peek()) {
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    String date = in.nextString();
                    return LocalDate.parse(date, formatter);
            }
        }
    }

    public static void setOffsetDateTimeFormat(DateTimeFormatter dateFormat) {
        offsetDateTimeTypeAdapter.setFormat(dateFormat);
    }

    public static void setLocalDateFormat(DateTimeFormatter dateFormat) {
        localDateTypeAdapter.setFormat(dateFormat);
    }

    /**
     * Gson TypeAdapter for java.sql.Date type
     * If the dateFormat is null, a simple "yyyy-MM-dd" format will be used
     * (more efficient than SimpleDateFormat).
     */
    public static class SqlDateTypeAdapter extends TypeAdapter<java.sql.Date> {

        private DateFormat dateFormat;

        public SqlDateTypeAdapter() {}

        public SqlDateTypeAdapter(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        public void setFormat(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        @Override
        public void write(JsonWriter out, java.sql.Date date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                String value;
                if (dateFormat != null) {
                    value = dateFormat.format(date);
                } else {
                    value = date.toString();
                }
                out.value(value);
            }
        }

        @Override
        public java.sql.Date read(JsonReader in) throws IOException {
            switch (in.peek()) {
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    String date = in.nextString();
                    try {
                        if (dateFormat != null) {
                            return new java.sql.Date(dateFormat.parse(date).getTime());
                        }
                        return new java.sql.Date(ISO8601Utils.parse(date, new ParsePosition(0)).getTime());
                    } catch (ParseException e) {
                        throw new JsonParseException(e);
                    }
            }
        }
    }

    /**
     * Gson TypeAdapter for java.util.Date type
     * If the dateFormat is null, ISO8601Utils will be used.
     */
    public static class DateTypeAdapter extends TypeAdapter<Date> {

        private DateFormat dateFormat;

        public DateTypeAdapter() {}

        public DateTypeAdapter(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        public void setFormat(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        @Override
        public void write(JsonWriter out, Date date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                String value;
                if (dateFormat != null) {
                    value = dateFormat.format(date);
                } else {
                    value = ISO8601Utils.format(date, true);
                }
                out.value(value);
            }
        }

        @Override
        public Date read(JsonReader in) throws IOException {
            try {
                switch (in.peek()) {
                    case NULL:
                        in.nextNull();
                        return null;
                    default:
                        String date = in.nextString();
                        try {
                            if (dateFormat != null) {
                                return dateFormat.parse(date);
                            }
                            return ISO8601Utils.parse(date, new ParsePosition(0));
                        } catch (ParseException e) {
                            throw new JsonParseException(e);
                        }
                }
            } catch (IllegalArgumentException e) {
                throw new JsonParseException(e);
            }
        }
    }

    public static void setDateFormat(DateFormat dateFormat) {
        dateTypeAdapter.setFormat(dateFormat);
    }

    public static void setSqlDateFormat(DateFormat dateFormat) {
        sqlDateTypeAdapter.setFormat(dateFormat);
    }
}
