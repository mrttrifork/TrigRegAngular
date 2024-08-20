

# TimeRegistrationResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**timeRegistrationId** | **Long** |  |  |
|**registered** | **Long** | The registration time as Unix milliseconds timestamp |  |
|**userId** | **Long** |  |  |
|**taskId** | **Long** |  |  [optional] |
|**date** | **LocalDate** |  |  |
|**duration** | **String** | ISO 8601 formatted duration component &lt;PnDTnHnMn.nS&gt;. Each unit is optional, but at least one must be specified |  |
|**status** | **TimeRegistrationStatus** |  |  |
|**tags** | [**List&lt;TimeRegistrationTag&gt;**](TimeRegistrationTag.md) |  |  |
|**description** | **String** |  |  [optional] |



