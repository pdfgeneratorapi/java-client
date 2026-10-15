

# FormConfigurationImport

Optional form settings applied to the imported form. Form fields are created from the editable fields of the PDF.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**templateId** | **Integer** | Template ID which is connected to the form |  [optional] |
|**name** | **String** | Form name |  [optional] |
|**actions** | [**List&lt;FormConfigurationNewActionsInner&gt;**](FormConfigurationNewActionsInner.md) | Array of action configurations. Each action is a separate object with a single key; leave an action out to disable it. |  [optional] |
|**_configuration** | [**FormConfiguration**](FormConfiguration.md) |  |  [optional] |



