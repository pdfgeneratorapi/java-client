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


package org.pdfgeneratorapi.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.pdfgeneratorapi.client.model.ExtractFormFields200ResponseResponseValueDefault;
import org.pdfgeneratorapi.client.model.ExtractFormFields200ResponseResponseValueValue;

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
 * ExtractFormFields200ResponseResponseValue
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-07T10:41:30.443864+03:00[Europe/Tallinn]", comments = "Generator version: 7.11.0")
public class ExtractFormFields200ResponseResponseValue {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  @javax.annotation.Nullable
  private String id;

  /**
   * Field type
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    TEXTFIELD("textfield"),
    
    DATEFIELD("datefield"),
    
    CHECKBOX("checkbox"),
    
    RADIOBUTTONGROUP("radiobuttongroup"),
    
    COMBOBOX("combobox"),
    
    LISTBOX("listbox");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return TypeEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      TypeEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  @javax.annotation.Nullable
  private TypeEnum type;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  @javax.annotation.Nullable
  private String name;

  public static final String SERIALIZED_NAME_VALUE = "value";
  @SerializedName(SERIALIZED_NAME_VALUE)
  @javax.annotation.Nullable
  private ExtractFormFields200ResponseResponseValueValue value;

  public static final String SERIALIZED_NAME_LOCKED = "locked";
  @SerializedName(SERIALIZED_NAME_LOCKED)
  @javax.annotation.Nullable
  private Boolean locked;

  public static final String SERIALIZED_NAME_PAGES = "pages";
  @SerializedName(SERIALIZED_NAME_PAGES)
  @javax.annotation.Nullable
  private List<Integer> pages = new ArrayList<>();

  public static final String SERIALIZED_NAME_DEFAULT = "default";
  @SerializedName(SERIALIZED_NAME_DEFAULT)
  @javax.annotation.Nullable
  private ExtractFormFields200ResponseResponseValueDefault _default;

  public static final String SERIALIZED_NAME_DEFAULTS = "defaults";
  @SerializedName(SERIALIZED_NAME_DEFAULTS)
  @javax.annotation.Nullable
  private List<String> defaults = new ArrayList<>();

  public static final String SERIALIZED_NAME_VALUES = "values";
  @SerializedName(SERIALIZED_NAME_VALUES)
  @javax.annotation.Nullable
  private List<String> values = new ArrayList<>();

  public static final String SERIALIZED_NAME_OPTIONS = "options";
  @SerializedName(SERIALIZED_NAME_OPTIONS)
  @javax.annotation.Nullable
  private List<String> options = new ArrayList<>();

  public static final String SERIALIZED_NAME_FORMAT = "format";
  @SerializedName(SERIALIZED_NAME_FORMAT)
  @javax.annotation.Nullable
  private String format;

  public static final String SERIALIZED_NAME_MAXLEN = "maxlen";
  @SerializedName(SERIALIZED_NAME_MAXLEN)
  @javax.annotation.Nullable
  private Integer maxlen;

  public static final String SERIALIZED_NAME_MULTILINE = "multiline";
  @SerializedName(SERIALIZED_NAME_MULTILINE)
  @javax.annotation.Nullable
  private Boolean multiline;

  public static final String SERIALIZED_NAME_EDITABLE = "editable";
  @SerializedName(SERIALIZED_NAME_EDITABLE)
  @javax.annotation.Nullable
  private Boolean editable;

  public static final String SERIALIZED_NAME_MULTI = "multi";
  @SerializedName(SERIALIZED_NAME_MULTI)
  @javax.annotation.Nullable
  private Boolean multi;

  public ExtractFormFields200ResponseResponseValue() {
  }

  public ExtractFormFields200ResponseResponseValue id(@javax.annotation.Nullable String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique field identifier
   * @return id
   */
  @javax.annotation.Nullable
  public String getId() {
    return id;
  }

  public void setId(@javax.annotation.Nullable String id) {
    this.id = id;
  }


  public ExtractFormFields200ResponseResponseValue type(@javax.annotation.Nullable TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Field type
   * @return type
   */
  @javax.annotation.Nullable
  public TypeEnum getType() {
    return type;
  }

  public void setType(@javax.annotation.Nullable TypeEnum type) {
    this.type = type;
  }


  public ExtractFormFields200ResponseResponseValue name(@javax.annotation.Nullable String name) {
    this.name = name;
    return this;
  }

  /**
   * Field name
   * @return name
   */
  @javax.annotation.Nullable
  public String getName() {
    return name;
  }

  public void setName(@javax.annotation.Nullable String name) {
    this.name = name;
  }


  public ExtractFormFields200ResponseResponseValue value(@javax.annotation.Nullable ExtractFormFields200ResponseResponseValueValue value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
   */
  @javax.annotation.Nullable
  public ExtractFormFields200ResponseResponseValueValue getValue() {
    return value;
  }

  public void setValue(@javax.annotation.Nullable ExtractFormFields200ResponseResponseValueValue value) {
    this.value = value;
  }


  public ExtractFormFields200ResponseResponseValue locked(@javax.annotation.Nullable Boolean locked) {
    this.locked = locked;
    return this;
  }

  /**
   * Whether the field is locked
   * @return locked
   */
  @javax.annotation.Nullable
  public Boolean getLocked() {
    return locked;
  }

  public void setLocked(@javax.annotation.Nullable Boolean locked) {
    this.locked = locked;
  }


  public ExtractFormFields200ResponseResponseValue pages(@javax.annotation.Nullable List<Integer> pages) {
    this.pages = pages;
    return this;
  }

  public ExtractFormFields200ResponseResponseValue addPagesItem(Integer pagesItem) {
    if (this.pages == null) {
      this.pages = new ArrayList<>();
    }
    this.pages.add(pagesItem);
    return this;
  }

  /**
   * Pages where the field appears
   * @return pages
   */
  @javax.annotation.Nullable
  public List<Integer> getPages() {
    return pages;
  }

  public void setPages(@javax.annotation.Nullable List<Integer> pages) {
    this.pages = pages;
  }


  public ExtractFormFields200ResponseResponseValue _default(@javax.annotation.Nullable ExtractFormFields200ResponseResponseValueDefault _default) {
    this._default = _default;
    return this;
  }

  /**
   * Get _default
   * @return _default
   */
  @javax.annotation.Nullable
  public ExtractFormFields200ResponseResponseValueDefault getDefault() {
    return _default;
  }

  public void setDefault(@javax.annotation.Nullable ExtractFormFields200ResponseResponseValueDefault _default) {
    this._default = _default;
  }


  public ExtractFormFields200ResponseResponseValue defaults(@javax.annotation.Nullable List<String> defaults) {
    this.defaults = defaults;
    return this;
  }

  public ExtractFormFields200ResponseResponseValue addDefaultsItem(String defaultsItem) {
    if (this.defaults == null) {
      this.defaults = new ArrayList<>();
    }
    this.defaults.add(defaultsItem);
    return this;
  }

  /**
   * Default values for multi-select fields
   * @return defaults
   */
  @javax.annotation.Nullable
  public List<String> getDefaults() {
    return defaults;
  }

  public void setDefaults(@javax.annotation.Nullable List<String> defaults) {
    this.defaults = defaults;
  }


  public ExtractFormFields200ResponseResponseValue values(@javax.annotation.Nullable List<String> values) {
    this.values = values;
    return this;
  }

  public ExtractFormFields200ResponseResponseValue addValuesItem(String valuesItem) {
    if (this.values == null) {
      this.values = new ArrayList<>();
    }
    this.values.add(valuesItem);
    return this;
  }

  /**
   * Selected values for multi-select fields
   * @return values
   */
  @javax.annotation.Nullable
  public List<String> getValues() {
    return values;
  }

  public void setValues(@javax.annotation.Nullable List<String> values) {
    this.values = values;
  }


  public ExtractFormFields200ResponseResponseValue options(@javax.annotation.Nullable List<String> options) {
    this.options = options;
    return this;
  }

  public ExtractFormFields200ResponseResponseValue addOptionsItem(String optionsItem) {
    if (this.options == null) {
      this.options = new ArrayList<>();
    }
    this.options.add(optionsItem);
    return this;
  }

  /**
   * Available options for select fields
   * @return options
   */
  @javax.annotation.Nullable
  public List<String> getOptions() {
    return options;
  }

  public void setOptions(@javax.annotation.Nullable List<String> options) {
    this.options = options;
  }


  public ExtractFormFields200ResponseResponseValue format(@javax.annotation.Nullable String format) {
    this.format = format;
    return this;
  }

  /**
   * Field format (for date fields)
   * @return format
   */
  @javax.annotation.Nullable
  public String getFormat() {
    return format;
  }

  public void setFormat(@javax.annotation.Nullable String format) {
    this.format = format;
  }


  public ExtractFormFields200ResponseResponseValue maxlen(@javax.annotation.Nullable Integer maxlen) {
    this.maxlen = maxlen;
    return this;
  }

  /**
   * Maximum field length
   * @return maxlen
   */
  @javax.annotation.Nullable
  public Integer getMaxlen() {
    return maxlen;
  }

  public void setMaxlen(@javax.annotation.Nullable Integer maxlen) {
    this.maxlen = maxlen;
  }


  public ExtractFormFields200ResponseResponseValue multiline(@javax.annotation.Nullable Boolean multiline) {
    this.multiline = multiline;
    return this;
  }

  /**
   * Whether text field is multiline
   * @return multiline
   */
  @javax.annotation.Nullable
  public Boolean getMultiline() {
    return multiline;
  }

  public void setMultiline(@javax.annotation.Nullable Boolean multiline) {
    this.multiline = multiline;
  }


  public ExtractFormFields200ResponseResponseValue editable(@javax.annotation.Nullable Boolean editable) {
    this.editable = editable;
    return this;
  }

  /**
   * Whether combo box is editable
   * @return editable
   */
  @javax.annotation.Nullable
  public Boolean getEditable() {
    return editable;
  }

  public void setEditable(@javax.annotation.Nullable Boolean editable) {
    this.editable = editable;
  }


  public ExtractFormFields200ResponseResponseValue multi(@javax.annotation.Nullable Boolean multi) {
    this.multi = multi;
    return this;
  }

  /**
   * Whether list box allows multiple selections
   * @return multi
   */
  @javax.annotation.Nullable
  public Boolean getMulti() {
    return multi;
  }

  public void setMulti(@javax.annotation.Nullable Boolean multi) {
    this.multi = multi;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExtractFormFields200ResponseResponseValue extractFormFields200ResponseResponseValue = (ExtractFormFields200ResponseResponseValue) o;
    return Objects.equals(this.id, extractFormFields200ResponseResponseValue.id) &&
        Objects.equals(this.type, extractFormFields200ResponseResponseValue.type) &&
        Objects.equals(this.name, extractFormFields200ResponseResponseValue.name) &&
        Objects.equals(this.value, extractFormFields200ResponseResponseValue.value) &&
        Objects.equals(this.locked, extractFormFields200ResponseResponseValue.locked) &&
        Objects.equals(this.pages, extractFormFields200ResponseResponseValue.pages) &&
        Objects.equals(this._default, extractFormFields200ResponseResponseValue._default) &&
        Objects.equals(this.defaults, extractFormFields200ResponseResponseValue.defaults) &&
        Objects.equals(this.values, extractFormFields200ResponseResponseValue.values) &&
        Objects.equals(this.options, extractFormFields200ResponseResponseValue.options) &&
        Objects.equals(this.format, extractFormFields200ResponseResponseValue.format) &&
        Objects.equals(this.maxlen, extractFormFields200ResponseResponseValue.maxlen) &&
        Objects.equals(this.multiline, extractFormFields200ResponseResponseValue.multiline) &&
        Objects.equals(this.editable, extractFormFields200ResponseResponseValue.editable) &&
        Objects.equals(this.multi, extractFormFields200ResponseResponseValue.multi);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, name, value, locked, pages, _default, defaults, values, options, format, maxlen, multiline, editable, multi);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExtractFormFields200ResponseResponseValue {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    locked: ").append(toIndentedString(locked)).append("\n");
    sb.append("    pages: ").append(toIndentedString(pages)).append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
    sb.append("    defaults: ").append(toIndentedString(defaults)).append("\n");
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
    sb.append("    format: ").append(toIndentedString(format)).append("\n");
    sb.append("    maxlen: ").append(toIndentedString(maxlen)).append("\n");
    sb.append("    multiline: ").append(toIndentedString(multiline)).append("\n");
    sb.append("    editable: ").append(toIndentedString(editable)).append("\n");
    sb.append("    multi: ").append(toIndentedString(multi)).append("\n");
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
    openapiFields.add("id");
    openapiFields.add("type");
    openapiFields.add("name");
    openapiFields.add("value");
    openapiFields.add("locked");
    openapiFields.add("pages");
    openapiFields.add("default");
    openapiFields.add("defaults");
    openapiFields.add("values");
    openapiFields.add("options");
    openapiFields.add("format");
    openapiFields.add("maxlen");
    openapiFields.add("multiline");
    openapiFields.add("editable");
    openapiFields.add("multi");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to ExtractFormFields200ResponseResponseValue
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ExtractFormFields200ResponseResponseValue.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ExtractFormFields200ResponseResponseValue is not found in the empty JSON string", ExtractFormFields200ResponseResponseValue.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ExtractFormFields200ResponseResponseValue.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ExtractFormFields200ResponseResponseValue` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("id") != null && !jsonObj.get("id").isJsonNull()) && !jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if ((jsonObj.get("type") != null && !jsonObj.get("type").isJsonNull()) && !jsonObj.get("type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("type").toString()));
      }
      // validate the optional field `type`
      if (jsonObj.get("type") != null && !jsonObj.get("type").isJsonNull()) {
        TypeEnum.validateJsonElement(jsonObj.get("type"));
      }
      if ((jsonObj.get("name") != null && !jsonObj.get("name").isJsonNull()) && !jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      // validate the optional field `value`
      if (jsonObj.get("value") != null && !jsonObj.get("value").isJsonNull()) {
        ExtractFormFields200ResponseResponseValueValue.validateJsonElement(jsonObj.get("value"));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("pages") != null && !jsonObj.get("pages").isJsonNull() && !jsonObj.get("pages").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `pages` to be an array in the JSON string but got `%s`", jsonObj.get("pages").toString()));
      }
      // validate the optional field `default`
      if (jsonObj.get("default") != null && !jsonObj.get("default").isJsonNull()) {
        ExtractFormFields200ResponseResponseValueDefault.validateJsonElement(jsonObj.get("default"));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("defaults") != null && !jsonObj.get("defaults").isJsonNull() && !jsonObj.get("defaults").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `defaults` to be an array in the JSON string but got `%s`", jsonObj.get("defaults").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("values") != null && !jsonObj.get("values").isJsonNull() && !jsonObj.get("values").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `values` to be an array in the JSON string but got `%s`", jsonObj.get("values").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("options") != null && !jsonObj.get("options").isJsonNull() && !jsonObj.get("options").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `options` to be an array in the JSON string but got `%s`", jsonObj.get("options").toString()));
      }
      if ((jsonObj.get("format") != null && !jsonObj.get("format").isJsonNull()) && !jsonObj.get("format").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `format` to be a primitive type in the JSON string but got `%s`", jsonObj.get("format").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ExtractFormFields200ResponseResponseValue.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ExtractFormFields200ResponseResponseValue' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ExtractFormFields200ResponseResponseValue> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ExtractFormFields200ResponseResponseValue.class));

       return (TypeAdapter<T>) new TypeAdapter<ExtractFormFields200ResponseResponseValue>() {
           @Override
           public void write(JsonWriter out, ExtractFormFields200ResponseResponseValue value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ExtractFormFields200ResponseResponseValue read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of ExtractFormFields200ResponseResponseValue given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of ExtractFormFields200ResponseResponseValue
   * @throws IOException if the JSON string is invalid with respect to ExtractFormFields200ResponseResponseValue
   */
  public static ExtractFormFields200ResponseResponseValue fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ExtractFormFields200ResponseResponseValue.class);
  }

  /**
   * Convert an instance of ExtractFormFields200ResponseResponseValue to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

