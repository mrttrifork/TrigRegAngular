

# ImportTimeRegistrationRequestInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**userId** | **Long** |  |  |
|**taskId** | **Long** | Associates the time registration with a task. If not specified, then the &#x60;description&#x60; field must be a non-null value  |  [optional] |
|**date** | **LocalDate** |  |  |
|**duration** | **String** | ISO 8601 formatted duration component &lt;PnDTnHnMn.nS&gt;. Each unit is optional, but at least one must be specified |  |
|**tags** | [**List&lt;TagTimeRegistrationRequest&gt;**](TagTimeRegistrationRequest.md) |  |  |
|**description** | **String** |  |  [optional] |



