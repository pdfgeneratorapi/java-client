

# FormFieldSubRowsInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**options** | **String** | Comma-separated list of choices. Whitespace around each choice is trimmed and choices must be unique. |  |
|**label** | **String** | Column label displayed in the form |  |
|**name** | **String** | Data field name of the column |  |
|**type** | [**TypeEnum**](#TypeEnum) | Column type. &#x60;select&#x60; columns require &#x60;subRows&#x60; with options and a &#x60;default&#x60; value. |  |
|**required** | **Boolean** | Specifies if the column is required or not |  |
|**_default** | **String** | Value pre-filled in the column. Required for &#x60;select&#x60; columns and must be one of the options. |  [optional] |
|**subRows** | [**List&lt;FormFieldOptions&gt;**](FormFieldOptions.md) | Options for &#x60;select&#x60; columns (a single object). Not used by other column types. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| TEXT | &quot;text&quot; |
| INTEGER | &quot;integer&quot; |
| NUMBER | &quot;number&quot; |
| DATE | &quot;date&quot; |
| SELECT | &quot;select&quot; |
| IMAGE | &quot;image&quot; |
| PDF | &quot;pdf&quot; |



