/*
 * PDF Generator API
 * # Introduction [PDF Generator API](https://pdfgeneratorapi.com) allows you easily generate transactional PDF documents and reduce the development and support costs by enabling your users to create and manage their document templates using a browser-based drag-and-drop document editor.  The PDF Generator API features a web API architecture, allowing you to code in the language of your choice. This API supports the JSON media type, and uses UTF-8 character encoding.  ## Base URL The base URL for all the API endpoints is `https://us1.pdfgeneratorapi.com/api/v4`  For example * `https://us1.pdfgeneratorapi.com/api/v4/templates` * `https://us1.pdfgeneratorapi.com/api/v4/workspaces` * `https://us1.pdfgeneratorapi.com/api/v4/templates/123123`  ## Editor PDF Generator API comes with a powerful drag & drop editor that allows to create any kind of document templates, from barcode labels to invoices, quotes and reports. You can find tutorials and videos from our [Support Portal](https://support.pdfgeneratorapi.com). * [Component specification](https://support.pdfgeneratorapi.com/en/category/components-1ffseaj/) * [Expression Language documentation](https://support.pdfgeneratorapi.com/en/category/expression-language-q203pa/) * [Frequently asked questions and answers](https://support.pdfgeneratorapi.com/en/category/qanda-1ov519d/)  ## Definitions  ### Organization Organization is a group of workspaces owned by your account.  ### Workspace Workspace contains templates. Each workspace has access to their own templates and organization default templates.  ### Master Workspace Master Workspace is the main/default workspace of your Organization. The Master Workspace identifier is the email you signed up with.  ### Default Template Default template is a template that is available for all workspaces by default. You can set the template access type under Page Setup. If template has \"Organization\" access then your users can use them from the \"New\" menu in the Editor.  ### Data Field Data Field is a placeholder for the specific data in your JSON data set. In this example JSON you can access the buyer name using Data Field `{paymentDetails::buyerName}`. The separator between depth levels is :: (two colons). When designing the template you don’t have to know every Data Field, our editor automatically extracts all the available fields from your data set and provides an easy way to insert them into the template. ``` {     \"documentNumber\": 1,     \"paymentDetails\": {         \"method\": \"Credit Card\",         \"buyerName\": \"John Smith\"     },     \"items\": [         {             \"id\": 1,             \"name\": \"Item one\"         }     ] } ```  ## Rate limiting Our API endpoints use IP-based rate limiting and allow you to make up to 2 requests per second and 60 requests per minute. If you make more requests, you will receive a response with HTTP code 429.  Response headers contain additional values:  | Header   | Description                    | |--------|--------------------------------| | X-RateLimit-Limit    | Maximum requests per minute                   | | X-RateLimit-Remaining    | The requests remaining in the current minute               | | Retry-After     | How many seconds you need to wait until you are allowed to make requests |  *  *  *  *  *  # Libraries and SDKs ## Postman Collection We have created a [Postman Collection](https://www.postman.com/pdfgeneratorapi/workspace/pdf-generator-api-public-workspace/overview) so you can easily test all the API endpoints without developing and code. You can download the collection [here](https://www.postman.com/pdfgeneratorapi/workspace/pdf-generator-api-public-workspace/collection/11578263-42fed446-af7e-4266-84e1-69e8c1752e93).  ## Client Libraries All our Client Libraries are auto-generated using [OpenAPI Generator](https://openapi-generator.tech/) which uses the OpenAPI v3 specification to automatically generate a client library in specific programming language.  * [PHP Client](https://github.com/pdfgeneratorapi/php-client) * [Java Client](https://github.com/pdfgeneratorapi/java-client) * [Ruby Client](https://github.com/pdfgeneratorapi/ruby-client) * [Python Client](https://github.com/pdfgeneratorapi/python-client) * [Javascript Client](https://github.com/pdfgeneratorapi/javascript-client)  We have validated the generated libraries, but let us know if you find any anomalies in the client code. *  *  *  *  *  # Authentication The PDF Generator API uses __JSON Web Tokens (JWT)__ to authenticate all API requests. These tokens offer a method to establish secure server-to-server authentication by transferring a compact JSON object with a signed payload of your account’s API Key and Secret. When authenticating to the PDF Generator API, a JWT should be generated uniquely by a __server-side application__ and included as a __Bearer Token__ in the header of each request.   <SecurityDefinitions />  ## Accessing your API Key and Secret You can find your __API Key__ and __API Secret__ from the __Account Settings__ page after you login to PDF Generator API [here](https://pdfgeneratorapi.com/login).  ## Creating a JWT JSON Web Tokens are composed of three sections: a header, a payload (containing a claim set), and a signature. The header and payload are JSON objects, which are serialized to UTF-8 bytes, then encoded using base64url encoding.  The JWT's header, payload, and signature are concatenated with periods (.). As a result, a JWT typically takes the following form: ``` {Base64url encoded header}.{Base64url encoded payload}.{Base64url encoded signature} ```  We recommend and support libraries provided on [jwt.io](https://jwt.io/). While other libraries can create JWT, these recommended libraries are the most robust.  ### Header Property `alg` defines which signing algorithm is being used. PDF Generator API users HS256. Property `typ` defines the type of token and it is always JWT. ``` {   \"alg\": \"HS256\",   \"typ\": \"JWT\" } ```  ### Payload The second part of the token is the payload, which contains the claims  or the pieces of information being passed about the user and any metadata required. It is mandatory to specify the following claims: * issuer (`iss`): Your API key * subject (`sub`): Workspace identifier * expiration time (`exp`): Timestamp (unix epoch time) until the token is valid. It is highly recommended to set the exp timestamp for a short period, i.e. a matter of seconds. This way, if a token is intercepted or shared, the token will only be valid for a short period of time.  ``` {   \"iss\": \"ad54aaff89ffdfeff178bb8a8f359b29fcb20edb56250b9f584aa2cb0162ed4a\",   \"sub\": \"demo.example@actualreports.com\",   \"exp\": 1586112639 } ```  ### Signature To create the signature part you have to take the encoded header, the encoded payload, a secret, the algorithm specified in the header, and sign that. The signature is used to verify the message wasn't changed along the way, and, in the case of tokens signed with a private key, it can also verify that the sender of the JWT is who it says it is. ``` HMACSHA256(     base64UrlEncode(header) + \".\" +     base64UrlEncode(payload),     API_SECRET) ```  ### Putting all together The output is three Base64-URL strings separated by dots. The following shows a JWT that has the previous header and payload encoded, and it is signed with a secret. ``` eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhZDU0YWFmZjg5ZmZkZmVmZjE3OGJiOGE4ZjM1OWIyOWZjYjIwZWRiNTYyNTBiOWY1ODRhYTJjYjAxNjJlZDRhIiwic3ViIjoiZGVtby5leGFtcGxlQGFjdHVhbHJlcG9ydHMuY29tIn0.SxO-H7UYYYsclS8RGWO1qf0z1cB1m73wF9FLl9RCc1Q  // Base64 encoded header: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9 // Base64 encoded payload: eyJpc3MiOiJhZDU0YWFmZjg5ZmZkZmVmZjE3OGJiOGE4ZjM1OWIyOWZjYjIwZWRiNTYyNTBiOWY1ODRhYTJjYjAxNjJlZDRhIiwic3ViIjoiZGVtby5leGFtcGxlQGFjdHVhbHJlcG9ydHMuY29tIn0 // Signature: SxO-H7UYYYsclS8RGWO1qf0z1cB1m73wF9FLl9RCc1Q ```  ## Temporary JWTs You can create a temporary token in [Account Settings](https://pdfgeneratorapi.com/account/organization) page after you login to PDF Generator API. The generated token uses your email address as the subject (`sub`) value and is valid for __15 minutes__. You can also use [jwt.io](https://jwt.io/) to generate test tokens for your API calls. These test tokens should never be used in production applications. *  *  *  *  *  # Error codes  | Code   | Description                    | |--------|--------------------------------| | 401    | Unauthorized                   | | 402    | Payment Required               | | 403    | Forbidden                      | | 404    | Not Found                      | | 422    | Unprocessable Entity           | | 429    | Too Many Requests              | | 500    | Internal Server Error          |  ## 401 Unauthorized | Description                                                             | |-------------------------------------------------------------------------| | Authentication failed: request expired                                  | | Authentication failed: workspace missing                                | | Authentication failed: key missing                                      | | Authentication failed: property 'iss' (issuer) missing in JWT           | | Authentication failed: property 'sub' (subject) missing in JWT          | | Authentication failed: property 'exp' (expiration time) missing in JWT  | | Authentication failed: incorrect signature                              |  ## 402 Payment Required | Description                                                             | |-------------------------------------------------------------------------| | Your account is suspended, please upgrade your account                  |  ## 403 Forbidden | Description                                                             | |-------------------------------------------------------------------------| | Your account has exceeded the monthly document generation limit.        | | Access not granted: You cannot delete master workspace via API          | | Access not granted: Template is not accessible by this organization     | | Your session has expired, please close and reopen the editor.           |  ## 404 Entity not found | Description                                                             | |-------------------------------------------------------------------------| | Entity not found                                                        | | Resource not found                                                      | | None of the templates is available for the workspace.                   |  ## 422 Unprocessable Entity | Description                                                             | |-------------------------------------------------------------------------| | Unable to parse JSON, please check formatting                           | | Required parameter missing                                              | | Required parameter missing: template definition not defined             | | Required parameter missing: template not defined                        |  ## 429 Too Many Requests | Description                                                             | |-------------------------------------------------------------------------| | You can make up to 2 requests per second and 60 requests per minute.   |  *  *  *  *  * 
 *
 * The version of the OpenAPI document: 4.0.8
 * Contact: support@pdfgeneratorapi.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.pdfgeneratorapi.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import org.openapitools.jackson.nullable.JsonNullable;
import org.pdfgeneratorapi.client.model.TemplateDefinitionNewLayoutMargins;
import org.pdfgeneratorapi.client.model.TemplateDefinitionNewLayoutRepeatLayout;

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

import org.pdfgeneratorapi.client.JSON;

/**
 * Defines template layout (e.g page format, margins).
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-12T17:07:32.427582+02:00[Europe/Tallinn]", comments = "Generator version: 7.11.0")
public class TemplateDefinitionNewLayout {
  /**
   * Defines template page size
   */
  @JsonAdapter(FormatEnum.Adapter.class)
  public enum FormatEnum {
    A4("A4"),
    
    LETTER("letter"),
    
    CUSTOM("custom");

    private String value;

    FormatEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static FormatEnum fromValue(String value) {
      for (FormatEnum b : FormatEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<FormatEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final FormatEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public FormatEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return FormatEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      FormatEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_FORMAT = "format";
  @SerializedName(SERIALIZED_NAME_FORMAT)
  @javax.annotation.Nullable
  private FormatEnum format = FormatEnum.A4;

  public static final String SERIALIZED_NAME_WIDTH = "width";
  @SerializedName(SERIALIZED_NAME_WIDTH)
  @javax.annotation.Nullable
  private BigDecimal width;

  public static final String SERIALIZED_NAME_HEIGHT = "height";
  @SerializedName(SERIALIZED_NAME_HEIGHT)
  @javax.annotation.Nullable
  private BigDecimal height;

  /**
   * Measure unit
   */
  @JsonAdapter(UnitEnum.Adapter.class)
  public enum UnitEnum {
    CM("cm"),
    
    IN("in");

    private String value;

    UnitEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static UnitEnum fromValue(String value) {
      for (UnitEnum b : UnitEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<UnitEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final UnitEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public UnitEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return UnitEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      UnitEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_UNIT = "unit";
  @SerializedName(SERIALIZED_NAME_UNIT)
  @javax.annotation.Nullable
  private UnitEnum unit = UnitEnum.CM;

  /**
   * Page orientation
   */
  @JsonAdapter(OrientationEnum.Adapter.class)
  public enum OrientationEnum {
    PORTRAIT("portrait"),
    
    LANDSCAPE("landscape");

    private String value;

    OrientationEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static OrientationEnum fromValue(String value) {
      for (OrientationEnum b : OrientationEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<OrientationEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final OrientationEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public OrientationEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return OrientationEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      OrientationEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_ORIENTATION = "orientation";
  @SerializedName(SERIALIZED_NAME_ORIENTATION)
  @javax.annotation.Nullable
  private OrientationEnum orientation;

  /**
   * Page rotation in degrees
   */
  @JsonAdapter(RotationEnum.Adapter.class)
  public enum RotationEnum {
    NUMBER_0(0),
    
    NUMBER_90(90),
    
    NUMBER_180(180),
    
    NUMBER_270(270);

    private Integer value;

    RotationEnum(Integer value) {
      this.value = value;
    }

    public Integer getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RotationEnum fromValue(Integer value) {
      for (RotationEnum b : RotationEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<RotationEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RotationEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RotationEnum read(final JsonReader jsonReader) throws IOException {
        Integer value =  jsonReader.nextInt();
        return RotationEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      Integer value = jsonElement.getAsInt();
      RotationEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_ROTATION = "rotation";
  @SerializedName(SERIALIZED_NAME_ROTATION)
  @javax.annotation.Nullable
  private RotationEnum rotation;

  public static final String SERIALIZED_NAME_MARGINS = "margins";
  @SerializedName(SERIALIZED_NAME_MARGINS)
  @javax.annotation.Nullable
  private TemplateDefinitionNewLayoutMargins margins;

  public static final String SERIALIZED_NAME_REPEAT_LAYOUT = "repeatLayout";
  @SerializedName(SERIALIZED_NAME_REPEAT_LAYOUT)
  @javax.annotation.Nullable
  private TemplateDefinitionNewLayoutRepeatLayout repeatLayout;

  public static final String SERIALIZED_NAME_EMPTY_LABELS = "emptyLabels";
  @SerializedName(SERIALIZED_NAME_EMPTY_LABELS)
  @javax.annotation.Nullable
  private Integer emptyLabels = 0;

  public TemplateDefinitionNewLayout() {
  }

  public TemplateDefinitionNewLayout format(@javax.annotation.Nullable FormatEnum format) {
    this.format = format;
    return this;
  }

  /**
   * Defines template page size
   * @return format
   */
  @javax.annotation.Nullable
  public FormatEnum getFormat() {
    return format;
  }

  public void setFormat(@javax.annotation.Nullable FormatEnum format) {
    this.format = format;
  }


  public TemplateDefinitionNewLayout width(@javax.annotation.Nullable BigDecimal width) {
    this.width = width;
    return this;
  }

  /**
   * Page width in units
   * @return width
   */
  @javax.annotation.Nullable
  public BigDecimal getWidth() {
    return width;
  }

  public void setWidth(@javax.annotation.Nullable BigDecimal width) {
    this.width = width;
  }


  public TemplateDefinitionNewLayout height(@javax.annotation.Nullable BigDecimal height) {
    this.height = height;
    return this;
  }

  /**
   * Page height in units
   * @return height
   */
  @javax.annotation.Nullable
  public BigDecimal getHeight() {
    return height;
  }

  public void setHeight(@javax.annotation.Nullable BigDecimal height) {
    this.height = height;
  }


  public TemplateDefinitionNewLayout unit(@javax.annotation.Nullable UnitEnum unit) {
    this.unit = unit;
    return this;
  }

  /**
   * Measure unit
   * @return unit
   */
  @javax.annotation.Nullable
  public UnitEnum getUnit() {
    return unit;
  }

  public void setUnit(@javax.annotation.Nullable UnitEnum unit) {
    this.unit = unit;
  }


  public TemplateDefinitionNewLayout orientation(@javax.annotation.Nullable OrientationEnum orientation) {
    this.orientation = orientation;
    return this;
  }

  /**
   * Page orientation
   * @return orientation
   */
  @javax.annotation.Nullable
  public OrientationEnum getOrientation() {
    return orientation;
  }

  public void setOrientation(@javax.annotation.Nullable OrientationEnum orientation) {
    this.orientation = orientation;
  }


  public TemplateDefinitionNewLayout rotation(@javax.annotation.Nullable RotationEnum rotation) {
    this.rotation = rotation;
    return this;
  }

  /**
   * Page rotation in degrees
   * @return rotation
   */
  @javax.annotation.Nullable
  public RotationEnum getRotation() {
    return rotation;
  }

  public void setRotation(@javax.annotation.Nullable RotationEnum rotation) {
    this.rotation = rotation;
  }


  public TemplateDefinitionNewLayout margins(@javax.annotation.Nullable TemplateDefinitionNewLayoutMargins margins) {
    this.margins = margins;
    return this;
  }

  /**
   * Get margins
   * @return margins
   */
  @javax.annotation.Nullable
  public TemplateDefinitionNewLayoutMargins getMargins() {
    return margins;
  }

  public void setMargins(@javax.annotation.Nullable TemplateDefinitionNewLayoutMargins margins) {
    this.margins = margins;
  }


  public TemplateDefinitionNewLayout repeatLayout(@javax.annotation.Nullable TemplateDefinitionNewLayoutRepeatLayout repeatLayout) {
    this.repeatLayout = repeatLayout;
    return this;
  }

  /**
   * Get repeatLayout
   * @return repeatLayout
   */
  @javax.annotation.Nullable
  public TemplateDefinitionNewLayoutRepeatLayout getRepeatLayout() {
    return repeatLayout;
  }

  public void setRepeatLayout(@javax.annotation.Nullable TemplateDefinitionNewLayoutRepeatLayout repeatLayout) {
    this.repeatLayout = repeatLayout;
  }


  public TemplateDefinitionNewLayout emptyLabels(@javax.annotation.Nullable Integer emptyLabels) {
    this.emptyLabels = emptyLabels;
    return this;
  }

  /**
   * Specifies how many blank lables to add to sheet label.
   * @return emptyLabels
   */
  @javax.annotation.Nullable
  public Integer getEmptyLabels() {
    return emptyLabels;
  }

  public void setEmptyLabels(@javax.annotation.Nullable Integer emptyLabels) {
    this.emptyLabels = emptyLabels;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TemplateDefinitionNewLayout templateDefinitionNewLayout = (TemplateDefinitionNewLayout) o;
    return Objects.equals(this.format, templateDefinitionNewLayout.format) &&
        Objects.equals(this.width, templateDefinitionNewLayout.width) &&
        Objects.equals(this.height, templateDefinitionNewLayout.height) &&
        Objects.equals(this.unit, templateDefinitionNewLayout.unit) &&
        Objects.equals(this.orientation, templateDefinitionNewLayout.orientation) &&
        Objects.equals(this.rotation, templateDefinitionNewLayout.rotation) &&
        Objects.equals(this.margins, templateDefinitionNewLayout.margins) &&
        Objects.equals(this.repeatLayout, templateDefinitionNewLayout.repeatLayout) &&
        Objects.equals(this.emptyLabels, templateDefinitionNewLayout.emptyLabels);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(format, width, height, unit, orientation, rotation, margins, repeatLayout, emptyLabels);
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TemplateDefinitionNewLayout {\n");
    sb.append("    format: ").append(toIndentedString(format)).append("\n");
    sb.append("    width: ").append(toIndentedString(width)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
    sb.append("    orientation: ").append(toIndentedString(orientation)).append("\n");
    sb.append("    rotation: ").append(toIndentedString(rotation)).append("\n");
    sb.append("    margins: ").append(toIndentedString(margins)).append("\n");
    sb.append("    repeatLayout: ").append(toIndentedString(repeatLayout)).append("\n");
    sb.append("    emptyLabels: ").append(toIndentedString(emptyLabels)).append("\n");
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
    openapiFields = new HashSet<String>();
    openapiFields.add("format");
    openapiFields.add("width");
    openapiFields.add("height");
    openapiFields.add("unit");
    openapiFields.add("orientation");
    openapiFields.add("rotation");
    openapiFields.add("margins");
    openapiFields.add("repeatLayout");
    openapiFields.add("emptyLabels");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to TemplateDefinitionNewLayout
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!TemplateDefinitionNewLayout.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in TemplateDefinitionNewLayout is not found in the empty JSON string", TemplateDefinitionNewLayout.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!TemplateDefinitionNewLayout.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `TemplateDefinitionNewLayout` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("format") != null && !jsonObj.get("format").isJsonNull()) && !jsonObj.get("format").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `format` to be a primitive type in the JSON string but got `%s`", jsonObj.get("format").toString()));
      }
      // validate the optional field `format`
      if (jsonObj.get("format") != null && !jsonObj.get("format").isJsonNull()) {
        FormatEnum.validateJsonElement(jsonObj.get("format"));
      }
      if ((jsonObj.get("unit") != null && !jsonObj.get("unit").isJsonNull()) && !jsonObj.get("unit").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `unit` to be a primitive type in the JSON string but got `%s`", jsonObj.get("unit").toString()));
      }
      // validate the optional field `unit`
      if (jsonObj.get("unit") != null && !jsonObj.get("unit").isJsonNull()) {
        UnitEnum.validateJsonElement(jsonObj.get("unit"));
      }
      if ((jsonObj.get("orientation") != null && !jsonObj.get("orientation").isJsonNull()) && !jsonObj.get("orientation").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `orientation` to be a primitive type in the JSON string but got `%s`", jsonObj.get("orientation").toString()));
      }
      // validate the optional field `orientation`
      if (jsonObj.get("orientation") != null && !jsonObj.get("orientation").isJsonNull()) {
        OrientationEnum.validateJsonElement(jsonObj.get("orientation"));
      }
      // validate the optional field `rotation`
      if (jsonObj.get("rotation") != null && !jsonObj.get("rotation").isJsonNull()) {
        RotationEnum.validateJsonElement(jsonObj.get("rotation"));
      }
      // validate the optional field `margins`
      if (jsonObj.get("margins") != null && !jsonObj.get("margins").isJsonNull()) {
        TemplateDefinitionNewLayoutMargins.validateJsonElement(jsonObj.get("margins"));
      }
      // validate the optional field `repeatLayout`
      if (jsonObj.get("repeatLayout") != null && !jsonObj.get("repeatLayout").isJsonNull()) {
        TemplateDefinitionNewLayoutRepeatLayout.validateJsonElement(jsonObj.get("repeatLayout"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!TemplateDefinitionNewLayout.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'TemplateDefinitionNewLayout' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<TemplateDefinitionNewLayout> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(TemplateDefinitionNewLayout.class));

       return (TypeAdapter<T>) new TypeAdapter<TemplateDefinitionNewLayout>() {
           @Override
           public void write(JsonWriter out, TemplateDefinitionNewLayout value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public TemplateDefinitionNewLayout read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of TemplateDefinitionNewLayout given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of TemplateDefinitionNewLayout
   * @throws IOException if the JSON string is invalid with respect to TemplateDefinitionNewLayout
   */
  public static TemplateDefinitionNewLayout fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, TemplateDefinitionNewLayout.class);
  }

  /**
   * Convert an instance of TemplateDefinitionNewLayout to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

