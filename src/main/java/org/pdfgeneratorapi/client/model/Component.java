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

/**
 * Template component definition
 */
@ApiModel(description = "Template component definition")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-07-30T07:15:50.107161Z[Etc/UTC]")
public class Component {
  /**
   * Defines component class/type
   */
  @JsonAdapter(ClsEnum.Adapter.class)
  public enum ClsEnum {
    LABELCOMPONENT("labelComponent"),
    
    NUMBERCOMPONENT("numberComponent"),
    
    TEXTCOMPONENT("textComponent"),
    
    IMAGECOMPONENT("imageComponent"),
    
    DATECOMPONENT("dateComponent"),
    
    HLINECOMPONENT("hlineComponent"),
    
    VLINECOMPONENT("vlineComponent"),
    
    TABLECOMPONENT("tableComponent"),
    
    COMPOSITECOMPONENT("compositeComponent"),
    
    BARCODECOMPONENT("barcodeComponent"),
    
    QRCODECOMPONENT("qrcodeComponent"),
    
    CHARTCOMPONENT("chartComponent"),
    
    RECTANGLECOMPONENT("rectangleComponent"),
    
    HEADERCOMPONENT("headerComponent"),
    
    FOOTERCOMPONENT("footerComponent"),
    
    CHECKBOXCOMPONENT("checkboxComponent"),
    
    RADIOCOMPONENT("radioComponent");

    private String value;

    ClsEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ClsEnum fromValue(String value) {
      for (ClsEnum b : ClsEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ClsEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ClsEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ClsEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ClsEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_CLS = "cls";
  @SerializedName(SERIALIZED_NAME_CLS)
  private ClsEnum cls;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_WIDTH = "width";
  @SerializedName(SERIALIZED_NAME_WIDTH)
  private BigDecimal width;

  public static final String SERIALIZED_NAME_HEIGHT = "height";
  @SerializedName(SERIALIZED_NAME_HEIGHT)
  private BigDecimal height;

  public static final String SERIALIZED_NAME_TOP = "top";
  @SerializedName(SERIALIZED_NAME_TOP)
  private BigDecimal top;

  public static final String SERIALIZED_NAME_LEFT = "left";
  @SerializedName(SERIALIZED_NAME_LEFT)
  private BigDecimal left;

  public static final String SERIALIZED_NAME_ZINDEX = "zindex";
  @SerializedName(SERIALIZED_NAME_ZINDEX)
  private Integer zindex;

  public static final String SERIALIZED_NAME_VALUE = "value";
  @SerializedName(SERIALIZED_NAME_VALUE)
  private String value;

  public static final String SERIALIZED_NAME_DATA_INDEX = "dataIndex";
  @SerializedName(SERIALIZED_NAME_DATA_INDEX)
  private String dataIndex;


  public Component cls(ClsEnum cls) {
    
    this.cls = cls;
    return this;
  }

   /**
   * Defines component class/type
   * @return cls
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "labelComponent", value = "Defines component class/type")

  public ClsEnum getCls() {
    return cls;
  }


  public void setCls(ClsEnum cls) {
    this.cls = cls;
  }


  public Component id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Component id
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "component-12313", value = "Component id")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public Component width(BigDecimal width) {
    
    this.width = width;
    return this;
  }

   /**
   * Width in units
   * @return width
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "3.5", value = "Width in units")

  public BigDecimal getWidth() {
    return width;
  }


  public void setWidth(BigDecimal width) {
    this.width = width;
  }


  public Component height(BigDecimal height) {
    
    this.height = height;
    return this;
  }

   /**
   * Height in units
   * @return height
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "Height in units")

  public BigDecimal getHeight() {
    return height;
  }


  public void setHeight(BigDecimal height) {
    this.height = height;
  }


  public Component top(BigDecimal top) {
    
    this.top = top;
    return this;
  }

   /**
   * Position from the page top in units
   * @return top
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "4.2", value = "Position from the page top in units")

  public BigDecimal getTop() {
    return top;
  }


  public void setTop(BigDecimal top) {
    this.top = top;
  }


  public Component left(BigDecimal left) {
    
    this.left = left;
    return this;
  }

   /**
   * Position from the page left in units
   * @return left
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2.5", value = "Position from the page left in units")

  public BigDecimal getLeft() {
    return left;
  }


  public void setLeft(BigDecimal left) {
    this.left = left;
  }


  public Component zindex(Integer zindex) {
    
    this.zindex = zindex;
    return this;
  }

   /**
   * Defines the rendering order on page. Components with smaller zindex are rendered before
   * @return zindex
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "102", value = "Defines the rendering order on page. Components with smaller zindex are rendered before")

  public Integer getZindex() {
    return zindex;
  }


  public void setZindex(Integer zindex) {
    this.zindex = zindex;
  }


  public Component value(String value) {
    
    this.value = value;
    return this;
  }

   /**
   * Component value
   * @return value
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "${price}", value = "Component value")

  public String getValue() {
    return value;
  }


  public void setValue(String value) {
    this.value = value;
  }


  public Component dataIndex(String dataIndex) {
    
    this.dataIndex = dataIndex;
    return this;
  }

   /**
   * Defines data field for Table and Container components which are used to iterate over list of items
   * @return dataIndex
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "line_items", value = "Defines data field for Table and Container components which are used to iterate over list of items")

  public String getDataIndex() {
    return dataIndex;
  }


  public void setDataIndex(String dataIndex) {
    this.dataIndex = dataIndex;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Component component = (Component) o;
    return Objects.equals(this.cls, component.cls) &&
        Objects.equals(this.id, component.id) &&
        Objects.equals(this.width, component.width) &&
        Objects.equals(this.height, component.height) &&
        Objects.equals(this.top, component.top) &&
        Objects.equals(this.left, component.left) &&
        Objects.equals(this.zindex, component.zindex) &&
        Objects.equals(this.value, component.value) &&
        Objects.equals(this.dataIndex, component.dataIndex);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cls, id, width, height, top, left, zindex, value, dataIndex);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Component {\n");
    sb.append("    cls: ").append(toIndentedString(cls)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    width: ").append(toIndentedString(width)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    top: ").append(toIndentedString(top)).append("\n");
    sb.append("    left: ").append(toIndentedString(left)).append("\n");
    sb.append("    zindex: ").append(toIndentedString(zindex)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    dataIndex: ").append(toIndentedString(dataIndex)).append("\n");
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

