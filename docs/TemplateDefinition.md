

# TemplateDefinition

A template as stored. Its configuration fields are those a new template is sent with.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Template name |  [optional] |
|**tags** | **List&lt;String&gt;** | A list of tags assigned to a template |  [optional] |
|**isDraft** | **Boolean** | Indicates if the template is a draft or published. |  [optional] |
|**layout** | [**TemplateDefinitionNewLayout**](TemplateDefinitionNewLayout.md) |  |  [optional] |
|**pages** | [**List&lt;TemplateDefinitionNewPagesInner&gt;**](TemplateDefinitionNewPagesInner.md) | Defines page or label size, margins and components on page or label |  [optional] |
|**dataSettings** | [**TemplateDefinitionNewDataSettings**](TemplateDefinitionNewDataSettings.md) |  |  [optional] |
|**editor** | [**TemplateDefinitionNewEditor**](TemplateDefinitionNewEditor.md) |  |  [optional] |
|**fontSubsetting** | **Boolean** | If font-subsetting is applied to document when generated |  [optional] |
|**barcodeAsImage** | **Boolean** | Defines if barcodes are rendered as raster images instead of vector graphics. |  [optional] |
|**id** | **Integer** | Unique identifier. &#x60;null&#x60; for a template library preview, which is not a template of the workspace. |  [optional] |
|**improvedHtmlSpacing** | **Boolean** | Measures HTML text the way it is drawn. New templates have it on; one saved before it existed keeps it off, and the layout it was designed with. |  [optional] |
|**backgroundPdf** | **String** | A base64 PDF the pages are drawn on. Set when the template is imported from a PDF. |  [optional] |



