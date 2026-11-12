

# TemplateDefinitionNewPagesInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**width** | **BigDecimal** | Page width in units |  [optional] |
|**height** | **BigDecimal** | Page height in units |  [optional] |
|**margins** | [**TemplateDefinitionNewPagesInnerMargins**](TemplateDefinitionNewPagesInnerMargins.md) |  |  [optional] |
|**border** | **Boolean** | Stored for older templates. It draws nothing. |  [optional] |
|**components** | **List&lt;Object&gt;** | The page&#39;s components. The fields of each depend on its cls; the template schema (Get schema endpoint) lists them. |  [optional] |
|**layout** | [**TemplateDefinitionNewPagesInnerLayout**](TemplateDefinitionNewPagesInnerLayout.md) |  |  [optional] |
|**conditionalFormats** | **List&lt;Object&gt;** |  |  [optional] |
|**backgroundImage** | **String** | The page&#39;s background image: an image URL, a data URI or a {data field} placeholder, PNG, JPEG, GIF or SVG. It is drawn over the background color and under everything else on the page, as backgroundImageFit says. A template with a background PDF does not draw it. Empty or null for none. |  [optional] |
|**backgroundColor** | **String** | The page&#39;s background color in hex color code, #RRGGBB or #RGB, or with an alpha, #RRGGBBAA, #RGBA or rgba(r, g, b, a); a translucent one is lighter, the white of the paper showing through. It fills every sheet the page runs onto, edge to edge, under everything on it, the background image included; on a sheet of labels it fills each label. A template with a background PDF is not filled. Empty or null for none. |  [optional] |
|**backgroundImageFit** | [**BackgroundImageFitEnum**](#BackgroundImageFitEnum) | How the background image covers the page, centred: &#x60;stretch&#x60;, stretched to the page, as when none is set; &#x60;contain&#x60;, fitted inside the page, keeping its proportions; &#x60;cover&#x60;, filling the page, keeping its proportions, with what overflows cut off. Null for stretch. |  [optional] |



## Enum: BackgroundImageFitEnum

| Name | Value |
|---- | -----|
| STRETCH | &quot;stretch&quot; |
| CONTAIN | &quot;contain&quot; |
| COVER | &quot;cover&quot; |



