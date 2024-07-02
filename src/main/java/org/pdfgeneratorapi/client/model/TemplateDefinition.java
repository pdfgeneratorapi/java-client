/*
 * PDF Generator API
 * # Introduction [PDF Generator API](https://pdfgeneratorapi.com) allows you easily generate transactional PDF documents and reduce the development and support costs by enabling your users to create and manage their document templates using a browser-based drag-and-drop document editor.  The PDF Generator API features a web API architecture, allowing you to code in the language of your choice. This API supports the JSON media type, and uses UTF-8 character encoding.  ## Base URL The base URL for all the API endpoints is `https://us1.pdfgeneratorapi.com/api/v4`  For example * `https://us1.pdfgeneratorapi.com/api/v4/templates` * `https://us1.pdfgeneratorapi.com/api/v4/workspaces` * `https://us1.pdfgeneratorapi.com/api/v4/templates/123123`  ## Editor PDF Generator API comes with a powerful drag & drop editor that allows to create any kind of document templates, from barcode labels to invoices, quotes and reports. You can find tutorials and videos from our [Support Portal](https://support.pdfgeneratorapi.com). * [Component specification](https://support.pdfgeneratorapi.com/en/category/components-1ffseaj/) * [Expression Language documentation](https://support.pdfgeneratorapi.com/en/category/expression-language-q203pa/) * [Frequently asked questions and answers](https://support.pdfgeneratorapi.com/en/category/qanda-1ov519d/)  ## Definitions  ### Organization Organization is a group of workspaces owned by your account.  ### Workspace Workspace contains templates. Each workspace has access to their own templates and organization default templates.  ### Master Workspace Master Workspace is the main/default workspace of your Organization. The Master Workspace identifier is the email you signed up with.  ### Default Template Default template is a template that is available for all workspaces by default. You can set the template access type under Page Setup. If template has \"Organization\" access then your users can use them from the \"New\" menu in the Editor.  ### Data Field Data Field is a placeholder for the specific data in your JSON data set. In this example JSON you can access the buyer name using Data Field `{paymentDetails::buyerName}`. The separator between depth levels is :: (two colons). When designing the template you don’t have to know every Data Field, our editor automatically extracts all the available fields from your data set and provides an easy way to insert them into the template. ``` {     \"documentNumber\": 1,     \"paymentDetails\": {         \"method\": \"Credit Card\",         \"buyerName\": \"John Smith\"     },     \"items\": [         {             \"id\": 1,             \"name\": \"Item one\"         }     ] } ```  ## Rate limiting Our API endpoints use IP-based rate limiting and allow you to make up to 2 requests per second and 60 requests per minute. If you make more requests, you will receive a response with HTTP code 429.  Response headers contain additional values:  | Header   | Description                    | |--------|--------------------------------| | X-RateLimit-Limit    | Maximum requests per minute                   | | X-RateLimit-Remaining    | The requests remaining in the current minute               | | Retry-After     | How many seconds you need to wait until you are allowed to make requests |  *  *  *  *  *  # Libraries and SDKs ## Postman Collection We have created a [Postman Collection](https://www.postman.com/pdfgeneratorapi/workspace/pdf-generator-api-public-workspace/overview) so you can easily test all the API endpoints without developing and code. You can download the collection [here](https://www.postman.com/pdfgeneratorapi/workspace/pdf-generator-api-public-workspace/collection/11578263-42fed446-af7e-4266-84e1-69e8c1752e93).  ## Client Libraries All our Client Libraries are auto-generated using [OpenAPI Generator](https://openapi-generator.tech/) which uses the OpenAPI v3 specification to automatically generate a client library in specific programming language.  * [PHP Client](https://github.com/pdfgeneratorapi/php-client) * [Java Client](https://github.com/pdfgeneratorapi/java-client) * [Ruby Client](https://github.com/pdfgeneratorapi/ruby-client) * [Python Client](https://github.com/pdfgeneratorapi/python-client) * [Javascript Client](https://github.com/pdfgeneratorapi/javascript-client)  We have validated the generated libraries, but let us know if you find any anomalies in the client code. *  *  *  *  *  # Authentication The PDF Generator API uses __JSON Web Tokens (JWT)__ to authenticate all API requests. These tokens offer a method to establish secure server-to-server authentication by transferring a compact JSON object with a signed payload of your account’s API Key and Secret. When authenticating to the PDF Generator API, a JWT should be generated uniquely by a __server-side application__ and included as a __Bearer Token__ in the header of each request.   <SecurityDefinitions />  ## Accessing your API Key and Secret You can find your __API Key__ and __API Secret__ from the __Account Settings__ page after you login to PDF Generator API [here](https://pdfgeneratorapi.com/login).  ## Creating a JWT JSON Web Tokens are composed of three sections: a header, a payload (containing a claim set), and a signature. The header and payload are JSON objects, which are serialized to UTF-8 bytes, then encoded using base64url encoding.  The JWT's header, payload, and signature are concatenated with periods (.). As a result, a JWT typically takes the following form: ``` {Base64url encoded header}.{Base64url encoded payload}.{Base64url encoded signature} ```  We recommend and support libraries provided on [jwt.io](https://jwt.io/). While other libraries can create JWT, these recommended libraries are the most robust.  ### Header Property `alg` defines which signing algorithm is being used. PDF Generator API users HS256. Property `typ` defines the type of token and it is always JWT. ``` {   \"alg\": \"HS256\",   \"typ\": \"JWT\" } ```  ### Payload The second part of the token is the payload, which contains the claims  or the pieces of information being passed about the user and any metadata required. It is mandatory to specify the following claims: * issuer (`iss`): Your API key * subject (`sub`): Workspace identifier * expiration time (`exp`): Timestamp (unix epoch time) until the token is valid. It is highly recommended to set the exp timestamp for a short period, i.e. a matter of seconds. This way, if a token is intercepted or shared, the token will only be valid for a short period of time.  ``` {   \"iss\": \"ad54aaff89ffdfeff178bb8a8f359b29fcb20edb56250b9f584aa2cb0162ed4a\",   \"sub\": \"demo.example@actualreports.com\",   \"exp\": 1586112639 } ```  ### Signature To create the signature part you have to take the encoded header, the encoded payload, a secret, the algorithm specified in the header, and sign that. The signature is used to verify the message wasn't changed along the way, and, in the case of tokens signed with a private key, it can also verify that the sender of the JWT is who it says it is. ``` HMACSHA256(     base64UrlEncode(header) + \".\" +     base64UrlEncode(payload),     API_SECRET) ```  ### Putting all together The output is three Base64-URL strings separated by dots. The following shows a JWT that has the previous header and payload encoded, and it is signed with a secret. ``` eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhZDU0YWFmZjg5ZmZkZmVmZjE3OGJiOGE4ZjM1OWIyOWZjYjIwZWRiNTYyNTBiOWY1ODRhYTJjYjAxNjJlZDRhIiwic3ViIjoiZGVtby5leGFtcGxlQGFjdHVhbHJlcG9ydHMuY29tIn0.SxO-H7UYYYsclS8RGWO1qf0z1cB1m73wF9FLl9RCc1Q  // Base64 encoded header: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9 // Base64 encoded payload: eyJpc3MiOiJhZDU0YWFmZjg5ZmZkZmVmZjE3OGJiOGE4ZjM1OWIyOWZjYjIwZWRiNTYyNTBiOWY1ODRhYTJjYjAxNjJlZDRhIiwic3ViIjoiZGVtby5leGFtcGxlQGFjdHVhbHJlcG9ydHMuY29tIn0 // Signature: SxO-H7UYYYsclS8RGWO1qf0z1cB1m73wF9FLl9RCc1Q ```  ## Temporary JWTs You can create a temporary token in [Account Settings](https://pdfgeneratorapi.com/account/organization) page after you login to PDF Generator API. The generated token uses your email address as the subject (`sub`) value and is valid for __15 minutes__. You can also use [jwt.io](https://jwt.io/) to generate test tokens for your API calls. These test tokens should never be used in production applications. *  *  *  *  *  # Error codes  | Code   | Description                    | |--------|--------------------------------| | 401    | Unauthorized                   | | 402    | Payment Required               | | 403    | Forbidden                      | | 404    | Not Found                      | | 422    | Unprocessable Entity           | | 429    | Too Many Requests              | | 500    | Internal Server Error          |  ## 401 Unauthorized | Description                                                             | |-------------------------------------------------------------------------| | Authentication failed: request expired                                  | | Authentication failed: workspace missing                                | | Authentication failed: key missing                                      | | Authentication failed: property 'iss' (issuer) missing in JWT           | | Authentication failed: property 'sub' (subject) missing in JWT          | | Authentication failed: property 'exp' (expiration time) missing in JWT  | | Authentication failed: incorrect signature                              |  ## 402 Payment Required | Description                                                             | |-------------------------------------------------------------------------| | Your account is suspended, please upgrade your account                  |  ## 403 Forbidden | Description                                                             | |-------------------------------------------------------------------------| | Your account has exceeded the monthly document generation limit.        | | Access not granted: You cannot delete master workspace via API          | | Access not granted: Template is not accessible by this organization     | | Your session has expired, please close and reopen the editor.           |  ## 404 Entity not found | Description                                                             | |-------------------------------------------------------------------------| | Entity not found                                                        | | Resource not found                                                      | | None of the templates is available for the workspace.                   |  ## 422 Unprocessable Entity | Description                                                             | |-------------------------------------------------------------------------| | Unable to parse JSON, please check formatting                           | | Required parameter missing                                              | | Required parameter missing: template definition not defined             | | Required parameter missing: template not defined                        |  ## 429 Too Many Requests | Description                                                             | |-------------------------------------------------------------------------| | You can make up to 2 requests per second and 60 requests per minute.   |  *  *  *  *  * 
 *
 * The version of the OpenAPI document: 4.0.4
 * Contact: support@pdfgeneratorapi.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.pdfgeneratorapi.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.pdfgeneratorapi.client.model.TemplateDefinitionNewDataSettings;
import org.pdfgeneratorapi.client.model.TemplateDefinitionNewEditor;
import org.pdfgeneratorapi.client.model.TemplateDefinitionNewLayout;
import org.pdfgeneratorapi.client.model.TemplateDefinitionNewPagesInner;

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

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.pdfgeneratorapi.client.JSON;

/**
 * TemplateDefinition
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-07-02T10:54:04.148726+03:00[Europe/Tallinn]")
public class TemplateDefinition {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private Integer id;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_TAGS = "tags";
  @SerializedName(SERIALIZED_NAME_TAGS)
  private List<String> tags;

  public static final String SERIALIZED_NAME_IS_DRAFT = "isDraft";
  @SerializedName(SERIALIZED_NAME_IS_DRAFT)
  private Boolean isDraft;

  public static final String SERIALIZED_NAME_LAYOUT = "layout";
  @SerializedName(SERIALIZED_NAME_LAYOUT)
  private TemplateDefinitionNewLayout layout;

  public static final String SERIALIZED_NAME_PAGES = "pages";
  @SerializedName(SERIALIZED_NAME_PAGES)
  private List<TemplateDefinitionNewPagesInner> pages;

  public static final String SERIALIZED_NAME_DATA_SETTINGS = "dataSettings";
  @SerializedName(SERIALIZED_NAME_DATA_SETTINGS)
  private TemplateDefinitionNewDataSettings dataSettings;

  public static final String SERIALIZED_NAME_EDITOR = "editor";
  @SerializedName(SERIALIZED_NAME_EDITOR)
  private TemplateDefinitionNewEditor editor;

  public TemplateDefinition() {
  }

  public TemplateDefinition id(Integer id) {
    
    this.id = id;
    return this;
  }

   /**
   * Unique identifier
   * @return id
  **/
  @javax.annotation.Nullable

  public Integer getId() {
    return id;
  }


  public void setId(Integer id) {
    this.id = id;
  }


  public TemplateDefinition name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Template name
   * @return name
  **/
  @javax.annotation.Nullable

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public TemplateDefinition tags(List<String> tags) {
    
    this.tags = tags;
    return this;
  }

  public TemplateDefinition addTagsItem(String tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<>();
    }
    this.tags.add(tagsItem);
    return this;
  }

   /**
   * A list of tags assigned to a template
   * @return tags
  **/
  @javax.annotation.Nullable

  public List<String> getTags() {
    return tags;
  }


  public void setTags(List<String> tags) {
    this.tags = tags;
  }


  public TemplateDefinition isDraft(Boolean isDraft) {
    
    this.isDraft = isDraft;
    return this;
  }

   /**
   * Indicates if the template is a draft or published.
   * @return isDraft
  **/
  @javax.annotation.Nullable

  public Boolean getIsDraft() {
    return isDraft;
  }


  public void setIsDraft(Boolean isDraft) {
    this.isDraft = isDraft;
  }


  public TemplateDefinition layout(TemplateDefinitionNewLayout layout) {
    
    this.layout = layout;
    return this;
  }

   /**
   * Get layout
   * @return layout
  **/
  @javax.annotation.Nullable

  public TemplateDefinitionNewLayout getLayout() {
    return layout;
  }


  public void setLayout(TemplateDefinitionNewLayout layout) {
    this.layout = layout;
  }


  public TemplateDefinition pages(List<TemplateDefinitionNewPagesInner> pages) {
    
    this.pages = pages;
    return this;
  }

  public TemplateDefinition addPagesItem(TemplateDefinitionNewPagesInner pagesItem) {
    if (this.pages == null) {
      this.pages = new ArrayList<>();
    }
    this.pages.add(pagesItem);
    return this;
  }

   /**
   * Defines page or label size, margins and components on page or label
   * @return pages
  **/
  @javax.annotation.Nullable

  public List<TemplateDefinitionNewPagesInner> getPages() {
    return pages;
  }


  public void setPages(List<TemplateDefinitionNewPagesInner> pages) {
    this.pages = pages;
  }


  public TemplateDefinition dataSettings(TemplateDefinitionNewDataSettings dataSettings) {
    
    this.dataSettings = dataSettings;
    return this;
  }

   /**
   * Get dataSettings
   * @return dataSettings
  **/
  @javax.annotation.Nullable

  public TemplateDefinitionNewDataSettings getDataSettings() {
    return dataSettings;
  }


  public void setDataSettings(TemplateDefinitionNewDataSettings dataSettings) {
    this.dataSettings = dataSettings;
  }


  public TemplateDefinition editor(TemplateDefinitionNewEditor editor) {
    
    this.editor = editor;
    return this;
  }

   /**
   * Get editor
   * @return editor
  **/
  @javax.annotation.Nullable

  public TemplateDefinitionNewEditor getEditor() {
    return editor;
  }


  public void setEditor(TemplateDefinitionNewEditor editor) {
    this.editor = editor;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TemplateDefinition templateDefinition = (TemplateDefinition) o;
    return Objects.equals(this.id, templateDefinition.id) &&
        Objects.equals(this.name, templateDefinition.name) &&
        Objects.equals(this.tags, templateDefinition.tags) &&
        Objects.equals(this.isDraft, templateDefinition.isDraft) &&
        Objects.equals(this.layout, templateDefinition.layout) &&
        Objects.equals(this.pages, templateDefinition.pages) &&
        Objects.equals(this.dataSettings, templateDefinition.dataSettings) &&
        Objects.equals(this.editor, templateDefinition.editor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, tags, isDraft, layout, pages, dataSettings, editor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TemplateDefinition {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    isDraft: ").append(toIndentedString(isDraft)).append("\n");
    sb.append("    layout: ").append(toIndentedString(layout)).append("\n");
    sb.append("    pages: ").append(toIndentedString(pages)).append("\n");
    sb.append("    dataSettings: ").append(toIndentedString(dataSettings)).append("\n");
    sb.append("    editor: ").append(toIndentedString(editor)).append("\n");
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
    openapiFields.add("name");
    openapiFields.add("tags");
    openapiFields.add("isDraft");
    openapiFields.add("layout");
    openapiFields.add("pages");
    openapiFields.add("dataSettings");
    openapiFields.add("editor");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to TemplateDefinition
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!TemplateDefinition.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in TemplateDefinition is not found in the empty JSON string", TemplateDefinition.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!TemplateDefinition.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `TemplateDefinition` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("name") != null && !jsonObj.get("name").isJsonNull()) && !jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("tags") != null && !jsonObj.get("tags").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `tags` to be an array in the JSON string but got `%s`", jsonObj.get("tags").toString()));
      }
      // validate the optional field `layout`
      if (jsonObj.get("layout") != null && !jsonObj.get("layout").isJsonNull()) {
        TemplateDefinitionNewLayout.validateJsonObject(jsonObj.getAsJsonObject("layout"));
      }
      if (jsonObj.get("pages") != null && !jsonObj.get("pages").isJsonNull()) {
        JsonArray jsonArraypages = jsonObj.getAsJsonArray("pages");
        if (jsonArraypages != null) {
          // ensure the json data is an array
          if (!jsonObj.get("pages").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `pages` to be an array in the JSON string but got `%s`", jsonObj.get("pages").toString()));
          }

          // validate the optional field `pages` (array)
          for (int i = 0; i < jsonArraypages.size(); i++) {
            TemplateDefinitionNewPagesInner.validateJsonObject(jsonArraypages.get(i).getAsJsonObject());
          };
        }
      }
      // validate the optional field `dataSettings`
      if (jsonObj.get("dataSettings") != null && !jsonObj.get("dataSettings").isJsonNull()) {
        TemplateDefinitionNewDataSettings.validateJsonObject(jsonObj.getAsJsonObject("dataSettings"));
      }
      // validate the optional field `editor`
      if (jsonObj.get("editor") != null && !jsonObj.get("editor").isJsonNull()) {
        TemplateDefinitionNewEditor.validateJsonObject(jsonObj.getAsJsonObject("editor"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!TemplateDefinition.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'TemplateDefinition' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<TemplateDefinition> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(TemplateDefinition.class));

       return (TypeAdapter<T>) new TypeAdapter<TemplateDefinition>() {
           @Override
           public void write(JsonWriter out, TemplateDefinition value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public TemplateDefinition read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of TemplateDefinition given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of TemplateDefinition
  * @throws IOException if the JSON string is invalid with respect to TemplateDefinition
  */
  public static TemplateDefinition fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, TemplateDefinition.class);
  }

 /**
  * Convert an instance of TemplateDefinition to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

