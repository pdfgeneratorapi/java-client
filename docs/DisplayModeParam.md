

# DisplayModeParam

How a PDF viewer opens the document (optional). Applies to PDF output. Any value left out keeps its default.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**zoom** | [**ZoomEnum**](#ZoomEnum) | Initial zoom * &#x60;fullpage&#x60; - Fits the whole page in the window * &#x60;fullwidth&#x60; - Fits the page width to the window * &#x60;real&#x60; - Actual size (100%) * &#x60;default&#x60; - Leaves the zoom to the viewer. The PDF gets no open action, which some e-invoice validators require  |  [optional] |
|**layout** | [**LayoutEnum**](#LayoutEnum) | Page layout * &#x60;SinglePage&#x60; - One page at a time * &#x60;OneColumn&#x60; - Pages in one continuous column * &#x60;TwoColumnLeft&#x60; - Pages in two columns, odd-numbered pages on the left * &#x60;TwoColumnRight&#x60; - Pages in two columns, odd-numbered pages on the right  |  [optional] |
|**mode** | [**ModeEnum**](#ModeEnum) | Panel shown when the document opens * &#x60;UseNone&#x60; - No panel * &#x60;UseOutlines&#x60; - Document outline (bookmarks) * &#x60;UseThumbs&#x60; - Page thumbnails * &#x60;FullScreen&#x60; - Full-screen mode, without menu bar or window controls  |  [optional] |



## Enum: ZoomEnum

| Name | Value |
|---- | -----|
| FULLPAGE | &quot;fullpage&quot; |
| FULLWIDTH | &quot;fullwidth&quot; |
| REAL | &quot;real&quot; |
| DEFAULT | &quot;default&quot; |



## Enum: LayoutEnum

| Name | Value |
|---- | -----|
| SINGLE_PAGE | &quot;SinglePage&quot; |
| ONE_COLUMN | &quot;OneColumn&quot; |
| TWO_COLUMN_LEFT | &quot;TwoColumnLeft&quot; |
| TWO_COLUMN_RIGHT | &quot;TwoColumnRight&quot; |



## Enum: ModeEnum

| Name | Value |
|---- | -----|
| USE_NONE | &quot;UseNone&quot; |
| USE_OUTLINES | &quot;UseOutlines&quot; |
| USE_THUMBS | &quot;UseThumbs&quot; |
| FULL_SCREEN | &quot;FullScreen&quot; |



