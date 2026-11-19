/*
 * PDF Generator API
 * # Introduction [PDF Generator API](https://pdfgeneratorapi.com) allows you easily generate transactional PDF documents and reduce the development and support costs by enabling your users to create and manage their document templates using a browser-based drag-and-drop document editor.  The PDF Generator API features a web API architecture, allowing you to code in the language of your choice. This API supports the JSON media type, and uses UTF-8 character encoding.  ## Base URL The base URL for all the API endpoints is `https://us1.pdfgeneratorapi.com/api/v4`  For example * `https://us1.pdfgeneratorapi.com/api/v4/templates` * `https://us1.pdfgeneratorapi.com/api/v4/workspaces` * `https://us1.pdfgeneratorapi.com/api/v4/templates/123123`  ## Editor PDF Generator API comes with a powerful drag & drop editor that allows to create any kind of document templates, from barcode labels to invoices, quotes and reports. You can find tutorials and videos from our [Support Portal](https://support.pdfgeneratorapi.com). * [Component specification](https://support.pdfgeneratorapi.com/en/category/components-1ffseaj/) * [Expression Language documentation](https://support.pdfgeneratorapi.com/en/category/expression-language-q203pa/) * [Frequently asked questions and answers](https://support.pdfgeneratorapi.com/en/category/qanda-1ov519d/)  ## Definitions  ### Organization Organization is a group of workspaces owned by your account.  ### Workspace Workspace contains templates. Each workspace has access to their own templates and organization default templates.  ### Master Workspace Master Workspace is the main/default workspace of your Organization. The Master Workspace identifier is the email you signed up with.  ### Default Template Default template is a template that is available for all workspaces by default. You can set the template access type under Page Setup. If template has \"Organization\" access then your users can use them from the \"New\" menu in the Editor.  ### Data Field Data Field is a placeholder for the specific data in your JSON data set. In this example JSON you can access the buyer name using Data Field `{paymentDetails::buyerName}`. The separator between depth levels is :: (two colons). When designing the template you don’t have to know every Data Field, our editor automatically extracts all the available fields from your data set and provides an easy way to insert them into the template. ``` {     \"documentNumber\": 1,     \"paymentDetails\": {         \"method\": \"Credit Card\",         \"buyerName\": \"John Smith\"     },     \"items\": [         {             \"id\": 1,             \"name\": \"Item one\"         }     ] } ```  ## Rate limiting Our API endpoints use IP-based rate limiting and allow you to make up to 2 requests per second and 60 requests per minute. If you make more requests, you will receive a response with HTTP code 429.  Response headers contain additional values:  | Header   | Description                    | |--------|--------------------------------| | X-RateLimit-Limit    | Maximum requests per minute                   | | X-RateLimit-Remaining    | The requests remaining in the current minute               | | Retry-After     | How many seconds you need to wait until you are allowed to make requests |  *  *  *  *  *  # Libraries and SDKs ## Postman Collection We have created a [Postman Collection](https://www.postman.com/pdfgeneratorapi/workspace/pdf-generator-api-public-workspace/overview) so you can easily test all the API endpoints without developing and code.   ## Client Libraries All our Client Libraries are auto-generated using [OpenAPI Generator](https://openapi-generator.tech/) which uses the OpenAPI v3 specification to automatically generate a client library in specific programming language.  * [PHP Client](https://github.com/pdfgeneratorapi/php-client) * [Java Client](https://github.com/pdfgeneratorapi/java-client) * [Ruby Client](https://github.com/pdfgeneratorapi/ruby-client) * [Python Client](https://github.com/pdfgeneratorapi/python-client) * [Javascript Client](https://github.com/pdfgeneratorapi/javascript-client)  We have validated the generated libraries, but let us know if you find any anomalies in the client code.  ## Model Context Protocol (MCP) Server Integrate document generation directly into your AI agents and LLM applications using our official Model Context Protocol (MCP) Server.  The MCP server provides a standardized interface that allows AI assistants (like Claude Desktop and other MCP-compatible clients) to securely interact with the PDF Generator API. With it, your AI applications can automatically fetch workspaces, retrieve templates, merge data, and generate PDF documents on the fly.  [Get PDF Generator API MCP Server](https://github.com/pdfgeneratorapi/mcp-server) *  *  *  *  *   # Authentication The PDF Generator API uses __JSON Web Tokens (JWT)__ to authenticate all API requests. These tokens offer a method to establish secure server-to-server authentication by transferring a compact JSON object with a signed payload of your account’s API Key and Secret. When authenticating to the PDF Generator API, a JWT should be generated uniquely by a __server-side application__ and included as a __Bearer Token__ in the header of each request.   <SecurityDefinitions />  ## Accessing your API Key and Secret You can find your __API Key__ and __API Secret__ from the __Account Settings__ page after you login to PDF Generator API [here](https://pdfgeneratorapi.com/login).  ## Creating a JWT JSON Web Tokens are composed of three sections: a header, a payload (containing a claim set), and a signature. The header and payload are JSON objects, which are serialized to UTF-8 bytes, then encoded using base64url encoding.  The JWT's header, payload, and signature are concatenated with periods (.). As a result, a JWT typically takes the following form: ``` {Base64url encoded header}.{Base64url encoded payload}.{Base64url encoded signature} ```  We recommend and support libraries provided on [jwt.io](https://jwt.io/). While other libraries can create JWT, these recommended libraries are the most robust.  ### Header Property `alg` defines which signing algorithm is being used. PDF Generator API users HS256. Property `typ` defines the type of token and it is always JWT. ``` {   \"alg\": \"HS256\",   \"typ\": \"JWT\" } ```  ### Payload The second part of the token is the payload, which contains the claims  or the pieces of information being passed about the user and any metadata required. It is mandatory to specify the following claims: * issuer (`iss`): Your API key * subject (`sub`): Workspace identifier * expiration time (`exp`): Timestamp (unix epoch time) until the token is valid. It is highly recommended to set the exp timestamp for a short period, i.e. a matter of seconds. This way, if a token is intercepted or shared, the token will only be valid for a short period of time.  ``` {   \"iss\": \"ad54aaff89ffdfeff178bb8a8f359b29fcb20edb56250b9f584aa2cb0162ed4a\",   \"sub\": \"demo.example@actualreports.com\",   \"exp\": 1586112639 } ```  ### Payload for Partners Our partners can send their unique identifier (provided by us) in JWT's partner_id claim. If the `partner_id` value is specified in the JWT, the organization making the request is automatically connected to the partner account. * Partner ID (`partner_id`): Unique identifier provide by PDF Generator API team  ``` {   \"iss\": \"ad54aaff89ffdfeff178bb8a8f359b29fcb20edb56250b9f584aa2cb0162ed4a\",   \"sub\": \"demo.example@actualreports.com\",   \"partner_id\": \"my-partner-identifier\",   \"exp\": 1586112639 } ```  ### Signature To create the signature part you have to take the encoded header, the encoded payload, a secret, the algorithm specified in the header, and sign that. The signature is used to verify the message wasn't changed along the way, and, in the case of tokens signed with a private key, it can also verify that the sender of the JWT is who it says it is. ``` HMACSHA256(     base64UrlEncode(header) + \".\" +     base64UrlEncode(payload),     API_SECRET) ```  ### Putting all together The output is three Base64-URL strings separated by dots. The following shows a JWT that has the previous header and payload encoded, and it is signed with a secret. ``` eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhZDU0YWFmZjg5ZmZkZmVmZjE3OGJiOGE4ZjM1OWIyOWZjYjIwZWRiNTYyNTBiOWY1ODRhYTJjYjAxNjJlZDRhIiwic3ViIjoiZGVtby5leGFtcGxlQGFjdHVhbHJlcG9ydHMuY29tIn0.SxO-H7UYYYsclS8RGWO1qf0z1cB1m73wF9FLl9RCc1Q  // Base64 encoded header: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9 // Base64 encoded payload: eyJpc3MiOiJhZDU0YWFmZjg5ZmZkZmVmZjE3OGJiOGE4ZjM1OWIyOWZjYjIwZWRiNTYyNTBiOWY1ODRhYTJjYjAxNjJlZDRhIiwic3ViIjoiZGVtby5leGFtcGxlQGFjdHVhbHJlcG9ydHMuY29tIn0 // Signature: SxO-H7UYYYsclS8RGWO1qf0z1cB1m73wF9FLl9RCc1Q ```  ## Temporary JWTs You can create a temporary token in [Account Settings](https://pdfgeneratorapi.com/account/organization) page after you login to PDF Generator API. The generated token uses your email address as the subject (`sub`) value and is valid for __15 minutes__. You can also use [jwt.io](https://jwt.io/) to generate test tokens for your API calls. These test tokens should never be used in production applications. *  *  *  *  *  # Error codes  Every error response is a JSON object with a `message` string. Request validation failures (422) also include an `errors` object keyed by the field that failed.  ```json {   \"message\": \"The identifier field is required.\",   \"errors\": {     \"identifier\": [\"The identifier field is required.\"]   } } ```  | Code   | Description                    | |--------|--------------------------------| | 400    | Bad Request                    | | 401    | Unauthorized                   | | 402    | Payment Required               | | 403    | Forbidden                      | | 404    | Not Found                      | | 405    | Method Not Allowed             | | 409    | Conflict                       | | 410    | Gone                           | | 422    | Unprocessable Entity           | | 429    | Too Many Requests              | | 500    | Internal Server Error          | | 503    | Service Unavailable            |  ## 401 Unauthorized | Description                                                                       | |-----------------------------------------------------------------------------------| | Authentication failed: JWT Token missing.                                         | | Authentication failed: Malformed JWT Token.                                       | | Authentication failed: Expired JWT Token.                                         | | Authentication failed: Invalid workspace.                                         | | Authentication failed: Invalid organization.                                      | | Authentication failed: This application no longer has access to the workspace.   | | Authentication failed: The sub field is required. (also `iss` and `exp`)          |  ## 402 Payment Required | Description                                                                       | |-----------------------------------------------------------------------------------| | Your account is suspended, please upgrade your account or contact support@pdfgeneratorapi.com. |  ## 403 Forbidden | Description                                                                       | |-----------------------------------------------------------------------------------| | You don't have permission to access this content. Please get in touch with your organization administrator to update your access permissions. | | This application was not granted permission for this request.                    | | Deleting own user is not allowed.                                                 | | Deleting organization owner is not allowed.                                       |  ## 404 Not Found | Description                                                                       | |-----------------------------------------------------------------------------------| | Entity not found.                                                                 | | Route not found.                                                                  | | Workspace doesn’t have access to read the template.                               |  ## 422 Unprocessable Entity | Description                                                                       | |-----------------------------------------------------------------------------------| | Unable to parse JSON, please check formatting.                                    | | Template id should be a numeric value.                                            | | The per page must be at least 1. (with `errors.per_page`)                         |  ## 429 Too Many Requests | Description                                                                       | |-----------------------------------------------------------------------------------| | Per-second rate limit exceeded. Please slow down your requests.                   | | Per-minute rate limit exceeded. Please try again in a minute.                     | | Global per-second rate limit exceeded. Please slow down your requests.            | | Global per-minute rate limit exceeded. Please try again in a minute.              |  *  *  *  *  * 
 *
 * The version of the OpenAPI document: 4.0.35
 * Contact: support@pdfgeneratorapi.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.pdfgeneratorapi.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pdfgeneratorapi.client.JSON;

/**
 * How a PDF viewer opens the document (optional). Applies to PDF output. Any value left out keeps its default.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-11-19T19:56:50.729379022Z[Etc/UTC]", comments = "Generator version: 7.14.0")
public class DisplayModeParam {
  /**
   * Initial zoom * &#x60;fullpage&#x60; - Fits the whole page in the window * &#x60;fullwidth&#x60; - Fits the page width to the window * &#x60;real&#x60; - Actual size (100%) * &#x60;default&#x60; - Leaves the zoom to the viewer. The PDF gets no open action, which some e-invoice validators require 
   */
  @JsonAdapter(ZoomEnum.Adapter.class)
  public enum ZoomEnum {
    FULLPAGE("fullpage"),
    
    FULLWIDTH("fullwidth"),
    
    REAL("real"),
    
    DEFAULT("default");

    private String value;

    ZoomEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ZoomEnum fromValue(String value) {
      for (ZoomEnum b : ZoomEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ZoomEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ZoomEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ZoomEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ZoomEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      ZoomEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_ZOOM = "zoom";
  @SerializedName(SERIALIZED_NAME_ZOOM)
  @javax.annotation.Nullable
  private ZoomEnum zoom = ZoomEnum.FULLWIDTH;

  /**
   * Page layout * &#x60;SinglePage&#x60; - One page at a time * &#x60;OneColumn&#x60; - Pages in one continuous column * &#x60;TwoColumnLeft&#x60; - Pages in two columns, odd-numbered pages on the left * &#x60;TwoColumnRight&#x60; - Pages in two columns, odd-numbered pages on the right 
   */
  @JsonAdapter(LayoutEnum.Adapter.class)
  public enum LayoutEnum {
    SINGLE_PAGE("SinglePage"),
    
    ONE_COLUMN("OneColumn"),
    
    TWO_COLUMN_LEFT("TwoColumnLeft"),
    
    TWO_COLUMN_RIGHT("TwoColumnRight");

    private String value;

    LayoutEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static LayoutEnum fromValue(String value) {
      for (LayoutEnum b : LayoutEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<LayoutEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final LayoutEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public LayoutEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return LayoutEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      LayoutEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_LAYOUT = "layout";
  @SerializedName(SERIALIZED_NAME_LAYOUT)
  @javax.annotation.Nullable
  private LayoutEnum layout = LayoutEnum.SINGLE_PAGE;

  /**
   * Panel shown when the document opens * &#x60;UseNone&#x60; - No panel * &#x60;UseOutlines&#x60; - Document outline (bookmarks) * &#x60;UseThumbs&#x60; - Page thumbnails * &#x60;FullScreen&#x60; - Full-screen mode, without menu bar or window controls 
   */
  @JsonAdapter(ModeEnum.Adapter.class)
  public enum ModeEnum {
    USE_NONE("UseNone"),
    
    USE_OUTLINES("UseOutlines"),
    
    USE_THUMBS("UseThumbs"),
    
    FULL_SCREEN("FullScreen");

    private String value;

    ModeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ModeEnum fromValue(String value) {
      for (ModeEnum b : ModeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ModeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ModeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ModeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ModeEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      ModeEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_MODE = "mode";
  @SerializedName(SERIALIZED_NAME_MODE)
  @javax.annotation.Nullable
  private ModeEnum mode = ModeEnum.USE_NONE;

  public DisplayModeParam() {
  }

  public DisplayModeParam zoom(@javax.annotation.Nullable ZoomEnum zoom) {
    this.zoom = zoom;
    return this;
  }

  /**
   * Initial zoom * &#x60;fullpage&#x60; - Fits the whole page in the window * &#x60;fullwidth&#x60; - Fits the page width to the window * &#x60;real&#x60; - Actual size (100%) * &#x60;default&#x60; - Leaves the zoom to the viewer. The PDF gets no open action, which some e-invoice validators require 
   * @return zoom
   */
  @javax.annotation.Nullable
  public ZoomEnum getZoom() {
    return zoom;
  }

  public void setZoom(@javax.annotation.Nullable ZoomEnum zoom) {
    this.zoom = zoom;
  }


  public DisplayModeParam layout(@javax.annotation.Nullable LayoutEnum layout) {
    this.layout = layout;
    return this;
  }

  /**
   * Page layout * &#x60;SinglePage&#x60; - One page at a time * &#x60;OneColumn&#x60; - Pages in one continuous column * &#x60;TwoColumnLeft&#x60; - Pages in two columns, odd-numbered pages on the left * &#x60;TwoColumnRight&#x60; - Pages in two columns, odd-numbered pages on the right 
   * @return layout
   */
  @javax.annotation.Nullable
  public LayoutEnum getLayout() {
    return layout;
  }

  public void setLayout(@javax.annotation.Nullable LayoutEnum layout) {
    this.layout = layout;
  }


  public DisplayModeParam mode(@javax.annotation.Nullable ModeEnum mode) {
    this.mode = mode;
    return this;
  }

  /**
   * Panel shown when the document opens * &#x60;UseNone&#x60; - No panel * &#x60;UseOutlines&#x60; - Document outline (bookmarks) * &#x60;UseThumbs&#x60; - Page thumbnails * &#x60;FullScreen&#x60; - Full-screen mode, without menu bar or window controls 
   * @return mode
   */
  @javax.annotation.Nullable
  public ModeEnum getMode() {
    return mode;
  }

  public void setMode(@javax.annotation.Nullable ModeEnum mode) {
    this.mode = mode;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DisplayModeParam displayModeParam = (DisplayModeParam) o;
    return Objects.equals(this.zoom, displayModeParam.zoom) &&
        Objects.equals(this.layout, displayModeParam.layout) &&
        Objects.equals(this.mode, displayModeParam.mode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(zoom, layout, mode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DisplayModeParam {\n");
    sb.append("    zoom: ").append(toIndentedString(zoom)).append("\n");
    sb.append("    layout: ").append(toIndentedString(layout)).append("\n");
    sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>(Arrays.asList("zoom", "layout", "mode"));

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>(0);
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to DisplayModeParam
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!DisplayModeParam.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in DisplayModeParam is not found in the empty JSON string", DisplayModeParam.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!DisplayModeParam.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `DisplayModeParam` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("zoom") != null && !jsonObj.get("zoom").isJsonNull()) && !jsonObj.get("zoom").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `zoom` to be a primitive type in the JSON string but got `%s`", jsonObj.get("zoom").toString()));
      }
      // validate the optional field `zoom`
      if (jsonObj.get("zoom") != null && !jsonObj.get("zoom").isJsonNull()) {
        ZoomEnum.validateJsonElement(jsonObj.get("zoom"));
      }
      if ((jsonObj.get("layout") != null && !jsonObj.get("layout").isJsonNull()) && !jsonObj.get("layout").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `layout` to be a primitive type in the JSON string but got `%s`", jsonObj.get("layout").toString()));
      }
      // validate the optional field `layout`
      if (jsonObj.get("layout") != null && !jsonObj.get("layout").isJsonNull()) {
        LayoutEnum.validateJsonElement(jsonObj.get("layout"));
      }
      if ((jsonObj.get("mode") != null && !jsonObj.get("mode").isJsonNull()) && !jsonObj.get("mode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `mode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("mode").toString()));
      }
      // validate the optional field `mode`
      if (jsonObj.get("mode") != null && !jsonObj.get("mode").isJsonNull()) {
        ModeEnum.validateJsonElement(jsonObj.get("mode"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!DisplayModeParam.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'DisplayModeParam' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<DisplayModeParam> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(DisplayModeParam.class));

       return (TypeAdapter<T>) new TypeAdapter<DisplayModeParam>() {
           @Override
           public void write(JsonWriter out, DisplayModeParam value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public DisplayModeParam read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of DisplayModeParam given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of DisplayModeParam
   * @throws IOException if the JSON string is invalid with respect to DisplayModeParam
   */
  public static DisplayModeParam fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, DisplayModeParam.class);
  }

  /**
   * Convert an instance of DisplayModeParam to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

