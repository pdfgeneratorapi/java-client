

# ExtractFormFields200ResponseResponseValue


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Unique field identifier |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | Field type |  [optional] |
|**name** | **String** | Field name |  [optional] |
|**value** | [**ExtractFormFields200ResponseResponseValueValue**](ExtractFormFields200ResponseResponseValueValue.md) |  |  [optional] |
|**locked** | **Boolean** | Whether the field is locked |  [optional] |
|**pages** | **List&lt;Integer&gt;** | Pages where the field appears |  [optional] |
|**_default** | [**ExtractFormFields200ResponseResponseValueDefault**](ExtractFormFields200ResponseResponseValueDefault.md) |  |  [optional] |
|**defaults** | **List&lt;String&gt;** | Default values for multi-select fields |  [optional] |
|**values** | **List&lt;String&gt;** | Selected values for multi-select fields |  [optional] |
|**options** | **List&lt;String&gt;** | Available options for select fields |  [optional] |
|**format** | **String** | Field format (for date fields) |  [optional] |
|**maxlen** | **Integer** | Maximum field length |  [optional] |
|**multiline** | **Boolean** | Whether text field is multiline |  [optional] |
|**editable** | **Boolean** | Whether combo box is editable |  [optional] |
|**multi** | **Boolean** | Whether list box allows multiple selections |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| TEXTFIELD | &quot;textfield&quot; |
| DATEFIELD | &quot;datefield&quot; |
| CHECKBOX | &quot;checkbox&quot; |
| RADIOBUTTONGROUP | &quot;radiobuttongroup&quot; |
| COMBOBOX | &quot;combobox&quot; |
| LISTBOX | &quot;listbox&quot; |



