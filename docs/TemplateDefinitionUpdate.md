

# TemplateDefinitionUpdate

The template configuration to change. Each top-level field sent replaces the stored one, and a field left out, the name included, keeps its stored value. Use the Get schema endpoint to see the detailed payload structure.

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



