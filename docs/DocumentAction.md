

# DocumentAction


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**action** | [**ActionEnum**](#ActionEnum) | The action performed on the document. |  [optional] |
|**person** | [**DocumentUser**](DocumentUser.md) |  |  [optional] |
|**createdAt** | **String** | Action timestamp (Y-m-d H:i:s). |  [optional] |



## Enum: ActionEnum

| Name | Value |
|---- | -----|
| OPENED | &quot;opened&quot; |
| REVIEWED | &quot;reviewed&quot; |
| ACCEPTED | &quot;accepted&quot; |
| DECLINED | &quot;declined&quot; |
| COMMENTED | &quot;commented&quot; |
| SIGNED | &quot;signed&quot; |
| ACKNOWLEDGED | &quot;acknowledged&quot; |



