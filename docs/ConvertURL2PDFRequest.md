

# ConvertURL2PDFRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**url** | **String** | Public URL |  [optional] |
|**paperSize** | [**PaperSizeEnum**](#PaperSizeEnum) | PDF page size |  [optional] |
|**orientation** | [**OrientationEnum**](#OrientationEnum) |  |  [optional] |
|**output** | [**OutputEnum**](#OutputEnum) | Output |  [optional] |
|**filename** | **String** | Document name |  [optional] |
|**waitForCss** | **String** | CSS selector of an element to wait for before the page is printed; see &#x60;wait_for_css_state&#x60; |  [optional] |
|**waitForCssState** | [**WaitForCssStateEnum**](#WaitForCssStateEnum) | How &#x60;wait_for_css&#x60; matches. &#x60;present&#x60; waits until the element exists, even if it is empty or hidden (e.g. a &#x60;&lt;div id&#x3D;\&quot;report-ready\&quot;&gt;&lt;/div&gt;&#x60; marker); &#x60;visible&#x60; waits until it is also visible with a non-empty size (e.g. a chart that appears when data has loaded). |  [optional] |
|**waitForJs** | **String** | JavaScript expression evaluated in the page every 100ms; the page is printed once it is truthy. Promises are awaited, and an expression that throws counts as not ready yet. |  [optional] |
|**waitTimeout** | **Integer** | Seconds to wait for &#x60;wait_for_css&#x60; / &#x60;wait_for_js&#x60; before applying &#x60;on_wait_timeout&#x60; |  [optional] |
|**onWaitTimeout** | [**OnWaitTimeoutEnum**](#OnWaitTimeoutEnum) | What to do when the wait signal is not met within &#x60;wait_timeout&#x60;. &#x60;error&#x60; returns a 422 response; &#x60;print&#x60; prints the page as it is. |  [optional] |



## Enum: PaperSizeEnum

| Name | Value |
|---- | -----|
| A0 | &quot;a0&quot; |
| A1 | &quot;a1&quot; |
| A2 | &quot;a2&quot; |
| A3 | &quot;a3&quot; |
| A4 | &quot;a4&quot; |
| LEGAL | &quot;legal&quot; |
| TABLOID | &quot;tabloid&quot; |
| LETTER | &quot;letter&quot; |



## Enum: OrientationEnum

| Name | Value |
|---- | -----|
| PORTRAIT | &quot;portrait&quot; |
| LANDSCAPE | &quot;landscape&quot; |



## Enum: OutputEnum

| Name | Value |
|---- | -----|
| BASE64 | &quot;base64&quot; |
| FILE | &quot;file&quot; |



## Enum: WaitForCssStateEnum

| Name | Value |
|---- | -----|
| PRESENT | &quot;present&quot; |
| VISIBLE | &quot;visible&quot; |



## Enum: OnWaitTimeoutEnum

| Name | Value |
|---- | -----|
| ERROR | &quot;error&quot; |
| PRINT | &quot;print&quot; |



