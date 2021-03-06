/*
 * PDF Generator API
 * # Introduction PDF Generator API allows you easily generate transactional PDF documents and reduce the development and support costs by enabling your users to create and manage their document templates using a browser-based drag-and-drop document editor.  The PDF Generator API features a web API architecture, allowing you to code in the language of your choice. This API supports the JSON media type, and uses UTF-8 character encoding.  You can find our previous API documentation page with references to Simple and Signature authentication [here](https://docs.pdfgeneratorapi.com/legacy).  ## Base URL The base URL for all the API endpoints is `https://us1.pdfgeneratorapi.com/api/v3`  For example * `https://us1.pdfgeneratorapi.com/api/v3/templates` * `https://us1.pdfgeneratorapi.com/api/v3/workspaces` * `https://us1.pdfgeneratorapi.com/api/v3/templates/123123`  ## Editor PDF Generator API comes with a powerful drag & drop editor that allows to create any kind of document templates, from barcode labels to invoices, quotes and reports. You can find tutorials and videos from our [Support Portal](https://support.pdfgeneratorapi.com). * [Component specification](https://support.pdfgeneratorapi.com/en/category/components-1ffseaj/) * [Expression Language documentation](https://support.pdfgeneratorapi.com/en/category/expression-language-q203pa/) * [Frequently asked questions and answers](https://support.pdfgeneratorapi.com/en/category/qanda-1ov519d/)  ## Definitions  ### Organization Organization is a group of workspaces owned by your account.  ### Workspace Workspace contains templates. Each workspace has access to their own templates and organization default templates.  ### Master Workspace Master Workspace is the main/default workspace of your Organization. The Master Workspace identifier is the email you signed up with.  ### Default Template Default template is a template that is available for all workspaces by default. You can set the template access type under Page Setup. If template has \"Organization\" access then your users can use them from the \"New\" menu in the Editor.  ### Data Field Data Field is a placeholder for the specific data in your JSON data set. In this example JSON you can access the buyer name using Data Field `{paymentDetails::buyerName}`. The separator between depth levels is :: (two colons). When designing the template you don’t have to know every Data Field, our editor automatically extracts all the available fields from your data set and provides an easy way to insert them into the template. ``` {     \"documentNumber\": 1,     \"paymentDetails\": {         \"method\": \"Credit Card\",         \"buyerName\": \"John Smith\"     },     \"items\": [         {             \"id\": 1,             \"name\": \"Item one\"         }     ] } ```  *  *  *  *  * # Authentication The PDF Generator API uses __JSON Web Tokens (JWT)__ to authenticate all API requests. These tokens offer a method to establish secure server-to-server authentication by transferring a compact JSON object with a signed payload of your account’s API Key and Secret. When authenticating to the PDF Generator API, a JWT should be generated uniquely by a __server-side application__ and included as a __Bearer Token__ in the header of each request.  ## Legacy Simple and Signature authentication You can find our legacy documentation for Simple and Signature authentication [here](https://docs.pdfgeneratorapi.com/legacy).  <SecurityDefinitions />  ## Accessing your API Key and Secret You can find your __API Key__ and __API Secret__ from the __Account Settings__ page after you login to PDF Generator API [here](https://pdfgeneratorapi.com/login).  ## Creating a JWT JSON Web Tokens are composed of three sections: a header, a payload (containing a claim set), and a signature. The header and payload are JSON objects, which are serialized to UTF-8 bytes, then encoded using base64url encoding.  The JWT's header, payload, and signature are concatenated with periods (.). As a result, a JWT typically takes the following form: ``` {Base64url encoded header}.{Base64url encoded payload}.{Base64url encoded signature} ```  We recommend and support libraries provided on [jwt.io](https://jwt.io/). While other libraries can create JWT, these recommended libraries are the most robust.  ### Header Property `alg` defines which signing algorithm is being used. PDF Generator API users HS256. Property `typ` defines the type of token and it is always JWT. ``` {   \"alg\": \"HS256\",   \"typ\": \"JWT\" } ```  ### Payload The second part of the token is the payload, which contains the claims  or the pieces of information being passed about the user and any metadata required. It is mandatory to specify the following claims: * issuer (`iss`): Your API key * subject (`sub`): Workspace identifier  You can also specify the token expiration time (`exp`) which is timestamp in seconds since Epoch (unix epoch time). It is highly recommended to set the exp timestamp for a short period, i.e. a matter of seconds. This way, if a token is intercepted or shared, the token will only be valid for a short period of time.  ``` {   \"iss\": \"ad54aaff89ffdfeff178bb8a8f359b29fcb20edb56250b9f584aa2cb0162ed4a\",   \"sub\": \"demo.example@actualreports.com\",   \"exp\": 1586112639 } ```  ### Signature To create the signature part you have to take the encoded header, the encoded payload, a secret, the algorithm specified in the header, and sign that. The signature is used to verify the message wasn't changed along the way, and, in the case of tokens signed with a private key, it can also verify that the sender of the JWT is who it says it is. ``` HMACSHA256(     base64UrlEncode(header) + \".\" +     base64UrlEncode(payload),     API_SECRET) ```  ### Putting all together The output is three Base64-URL strings separated by dots. The following shows a JWT that has the previous header and payload encoded, and it is signed with a secret. ``` eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhZDU0YWFmZjg5ZmZkZmVmZjE3OGJiOGE4ZjM1OWIyOWZjYjIwZWRiNTYyNTBiOWY1ODRhYTJjYjAxNjJlZDRhIiwic3ViIjoiZGVtby5leGFtcGxlQGFjdHVhbHJlcG9ydHMuY29tIn0.SxO-H7UYYYsclS8RGWO1qf0z1cB1m73wF9FLl9RCc1Q  // Base64 encoded header: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9 // Base64 encoded payload: eyJpc3MiOiJhZDU0YWFmZjg5ZmZkZmVmZjE3OGJiOGE4ZjM1OWIyOWZjYjIwZWRiNTYyNTBiOWY1ODRhYTJjYjAxNjJlZDRhIiwic3ViIjoiZGVtby5leGFtcGxlQGFjdHVhbHJlcG9ydHMuY29tIn0 // Signature: SxO-H7UYYYsclS8RGWO1qf0z1cB1m73wF9FLl9RCc1Q ```  ## Testing with JWTs You can create a temporary token in [Account Settings](https://pdfgeneratorapi.com/account/organization) page after you login to PDF Generator API. The generated token uses your email address as the subject (`sub`) value and is valid for __5 minutes__. You can also use [jwt.io](https://jwt.io/) to generate test tokens for your API calls. These test tokens should never be used in production applications. *  *  *  *  *  # Libraries and SDKs ## Postman Collection We have created a [Postman](https://www.postman.com) Collection so you can easily test all the API endpoints wihtout developing and code. You can download the collection [here](https://app.getpostman.com/run-collection/329f09618ec8a957dbc4) or just click the button below.  [![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/329f09618ec8a957dbc4)  ## Client Libraries All our Client Libraries are auto-generated using [OpenAPI Generator](https://openapi-generator.tech/) which uses the OpenAPI v3 specification to automatically generate a client library in specific programming language.  * [PHP Client](https://github.com/pdfgeneratorapi/php-client) * [Java Client](https://github.com/pdfgeneratorapi/java-client) * [Ruby Client](https://github.com/pdfgeneratorapi/ruby-client) * [Python Client](https://github.com/pdfgeneratorapi/python-client) * [Javascript Client](https://github.com/pdfgeneratorapi/javascript-client)  We have validated the generated libraries, but let us know if you find any anomalies in the client code. *  *  *  *  * 
 *
 * The version of the OpenAPI document: 3.1.1
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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.math.BigDecimal;
import org.pdfgeneratorapi.client.model.TemplateDefinitionNewLayoutMargins;
import org.pdfgeneratorapi.client.model.TemplateDefinitionNewLayoutRepeatLayout;

/**
 * Defines template layout (e.g page format, margins).
 */
@ApiModel(description = "Defines template layout (e.g page format, margins).")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-07-30T07:15:50.107161Z[Etc/UTC]")
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
  }

  public static final String SERIALIZED_NAME_FORMAT = "format";
  @SerializedName(SERIALIZED_NAME_FORMAT)
  private FormatEnum format;

  public static final String SERIALIZED_NAME_WIDTH = "width";
  @SerializedName(SERIALIZED_NAME_WIDTH)
  private BigDecimal width;

  public static final String SERIALIZED_NAME_HEIGHT = "height";
  @SerializedName(SERIALIZED_NAME_HEIGHT)
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
  }

  public static final String SERIALIZED_NAME_UNIT = "unit";
  @SerializedName(SERIALIZED_NAME_UNIT)
  private UnitEnum unit;

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
  }

  public static final String SERIALIZED_NAME_ORIENTATION = "orientation";
  @SerializedName(SERIALIZED_NAME_ORIENTATION)
  private OrientationEnum orientation;

  /**
   * Page rotation in degrees
   */
  @JsonAdapter(RoationEnum.Adapter.class)
  public enum RoationEnum {
    NUMBER_0(0),
    
    NUMBER_90(90),
    
    NUMBER_180(180),
    
    NUMBER_270(270);

    private Integer value;

    RoationEnum(Integer value) {
      this.value = value;
    }

    public Integer getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RoationEnum fromValue(Integer value) {
      for (RoationEnum b : RoationEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<RoationEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RoationEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RoationEnum read(final JsonReader jsonReader) throws IOException {
        Integer value =  jsonReader.nextInt();
        return RoationEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_ROATION = "roation";
  @SerializedName(SERIALIZED_NAME_ROATION)
  private RoationEnum roation;

  public static final String SERIALIZED_NAME_MARGINS = "margins";
  @SerializedName(SERIALIZED_NAME_MARGINS)
  private TemplateDefinitionNewLayoutMargins margins;

  public static final String SERIALIZED_NAME_REPEAT_LAYOUT = "repeatLayout";
  @SerializedName(SERIALIZED_NAME_REPEAT_LAYOUT)
  private TemplateDefinitionNewLayoutRepeatLayout repeatLayout;

  public static final String SERIALIZED_NAME_EMPTY_LABELS = "emptyLabels";
  @SerializedName(SERIALIZED_NAME_EMPTY_LABELS)
  private Integer emptyLabels;


  public TemplateDefinitionNewLayout format(FormatEnum format) {
    
    this.format = format;
    return this;
  }

   /**
   * Defines template page size
   * @return format
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "A4", value = "Defines template page size")

  public FormatEnum getFormat() {
    return format;
  }


  public void setFormat(FormatEnum format) {
    this.format = format;
  }


  public TemplateDefinitionNewLayout width(BigDecimal width) {
    
    this.width = width;
    return this;
  }

   /**
   * Page width in units
   * @return width
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "21", value = "Page width in units")

  public BigDecimal getWidth() {
    return width;
  }


  public void setWidth(BigDecimal width) {
    this.width = width;
  }


  public TemplateDefinitionNewLayout height(BigDecimal height) {
    
    this.height = height;
    return this;
  }

   /**
   * Page height in units
   * @return height
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "29.7", value = "Page height in units")

  public BigDecimal getHeight() {
    return height;
  }


  public void setHeight(BigDecimal height) {
    this.height = height;
  }


  public TemplateDefinitionNewLayout unit(UnitEnum unit) {
    
    this.unit = unit;
    return this;
  }

   /**
   * Measure unit
   * @return unit
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "cm", value = "Measure unit")

  public UnitEnum getUnit() {
    return unit;
  }


  public void setUnit(UnitEnum unit) {
    this.unit = unit;
  }


  public TemplateDefinitionNewLayout orientation(OrientationEnum orientation) {
    
    this.orientation = orientation;
    return this;
  }

   /**
   * Page orientation
   * @return orientation
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "portrait", value = "Page orientation")

  public OrientationEnum getOrientation() {
    return orientation;
  }


  public void setOrientation(OrientationEnum orientation) {
    this.orientation = orientation;
  }


  public TemplateDefinitionNewLayout roation(RoationEnum roation) {
    
    this.roation = roation;
    return this;
  }

   /**
   * Page rotation in degrees
   * @return roation
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "0", value = "Page rotation in degrees")

  public RoationEnum getRoation() {
    return roation;
  }


  public void setRoation(RoationEnum roation) {
    this.roation = roation;
  }


  public TemplateDefinitionNewLayout margins(TemplateDefinitionNewLayoutMargins margins) {
    
    this.margins = margins;
    return this;
  }

   /**
   * Get margins
   * @return margins
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public TemplateDefinitionNewLayoutMargins getMargins() {
    return margins;
  }


  public void setMargins(TemplateDefinitionNewLayoutMargins margins) {
    this.margins = margins;
  }


  public TemplateDefinitionNewLayout repeatLayout(TemplateDefinitionNewLayoutRepeatLayout repeatLayout) {
    
    this.repeatLayout = repeatLayout;
    return this;
  }

   /**
   * Get repeatLayout
   * @return repeatLayout
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public TemplateDefinitionNewLayoutRepeatLayout getRepeatLayout() {
    return repeatLayout;
  }


  public void setRepeatLayout(TemplateDefinitionNewLayoutRepeatLayout repeatLayout) {
    this.repeatLayout = repeatLayout;
  }


  public TemplateDefinitionNewLayout emptyLabels(Integer emptyLabels) {
    
    this.emptyLabels = emptyLabels;
    return this;
  }

   /**
   * Defines how many pages or labels should be empty
   * @return emptyLabels
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "0", value = "Defines how many pages or labels should be empty")

  public Integer getEmptyLabels() {
    return emptyLabels;
  }


  public void setEmptyLabels(Integer emptyLabels) {
    this.emptyLabels = emptyLabels;
  }


  @Override
  public boolean equals(java.lang.Object o) {
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
        Objects.equals(this.roation, templateDefinitionNewLayout.roation) &&
        Objects.equals(this.margins, templateDefinitionNewLayout.margins) &&
        Objects.equals(this.repeatLayout, templateDefinitionNewLayout.repeatLayout) &&
        Objects.equals(this.emptyLabels, templateDefinitionNewLayout.emptyLabels);
  }

  @Override
  public int hashCode() {
    return Objects.hash(format, width, height, unit, orientation, roation, margins, repeatLayout, emptyLabels);
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
    sb.append("    roation: ").append(toIndentedString(roation)).append("\n");
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

