

# FormConfigurationNew


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**templateId** | **Integer** | Template ID which is connected to the form |  [optional] |
|**name** | **String** | Form name |  |
|**actions** | [**List&lt;FormConfigurationNewActionsInner&gt;**](FormConfigurationNewActionsInner.md) | Array of action configurations. Each action is a separate object with a single key; leave an action out to disable it. |  |
|**fields** | [**List&lt;FormField&gt;**](FormField.md) | Input fields shown on the form, in display order. Field names must be unique within the form. |  |
|**_configuration** | [**FormConfiguration**](FormConfiguration.md) |  |  [optional] |



