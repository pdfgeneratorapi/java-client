

# Component

Template component definition
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**cls** | [**ClsEnum**](#ClsEnum) | Defines component class/type |  [optional]
**id** | **String** | Component id |  [optional]
**width** | [**BigDecimal**](BigDecimal.md) | Width in units |  [optional]
**height** | [**BigDecimal**](BigDecimal.md) | Height in units |  [optional]
**top** | [**BigDecimal**](BigDecimal.md) | Position from the page top in units |  [optional]
**left** | [**BigDecimal**](BigDecimal.md) | Position from the page left in units |  [optional]
**zindex** | **Integer** | Defines the rendering order on page. Components with smaller zindex are rendered before |  [optional]
**value** | **String** | Component value |  [optional]
**dataIndex** | **String** | Defines data field for Table and Container components which are used to iterate over list of items |  [optional]



## Enum: ClsEnum

Name | Value
---- | -----
LABELCOMPONENT | &quot;labelComponent&quot;
NUMBERCOMPONENT | &quot;numberComponent&quot;
TEXTCOMPONENT | &quot;textComponent&quot;
IMAGECOMPONENT | &quot;imageComponent&quot;
DATECOMPONENT | &quot;dateComponent&quot;
HLINECOMPONENT | &quot;hlineComponent&quot;
VLINECOMPONENT | &quot;vlineComponent&quot;
TABLECOMPONENT | &quot;tableComponent&quot;
COMPOSITECOMPONENT | &quot;compositeComponent&quot;
BARCODECOMPONENT | &quot;barcodeComponent&quot;
QRCODECOMPONENT | &quot;qrcodeComponent&quot;
CHARTCOMPONENT | &quot;chartComponent&quot;
RECTANGLECOMPONENT | &quot;rectangleComponent&quot;
HEADERCOMPONENT | &quot;headerComponent&quot;
FOOTERCOMPONENT | &quot;footerComponent&quot;
CHECKBOXCOMPONENT | &quot;checkboxComponent&quot;
RADIOCOMPONENT | &quot;radioComponent&quot;



