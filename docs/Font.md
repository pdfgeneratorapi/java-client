

# Font


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | The value of a component&#39;s &#x60;fontFamily&#x60; for this font |  |
|**name** | **String** | Font name, as the editor shows it |  |
|**parent** | **String** | The &#x60;id&#x60; of the font this one is grouped under, such as another weight of the same family |  |
|**styles** | [**List&lt;StylesEnum&gt;**](#List&lt;StylesEnum&gt;) | The styles the font has glyphs of its own for. Text in another style is drawn with the regular glyphs. |  |
|**blocks** | **Map&lt;String, Integer&gt;** | The Unicode blocks the font has at least half of the characters of, with the share it has in percent. 100 means every character of the block. |  |



## Enum: List&lt;StylesEnum&gt;

| Name | Value |
|---- | -----|
| NORMAL | &quot;normal&quot; |
| BOLD | &quot;bold&quot; |
| ITALIC | &quot;italic&quot; |
| BOLD_ITALIC | &quot;bold_italic&quot; |



