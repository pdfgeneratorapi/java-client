

# FormFieldsInner

Form field definition

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**label** | **String** | Field label displayed in the form |  [optional] |
|**name** | **String** | Data field name. For example \&quot;name\&quot; can be used as \&quot;{name}\&quot; in the document as placeholder. |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | Field type |  [optional] |
|**required** | **Boolean** | Specifies if the field is required or not |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| TEXT | &quot;text&quot; |
| INTEGER | &quot;integer&quot; |
| NUMBER | &quot;number&quot; |
| DATE | &quot;date&quot; |
| SIGNATURE | &quot;signature&quot; |



