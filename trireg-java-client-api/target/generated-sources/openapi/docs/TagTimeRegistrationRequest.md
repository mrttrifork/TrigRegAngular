

# TagTimeRegistrationRequest

A request to set a tag value for a tag configuration for a time registration. Administrators configure the rules for tags for time registrations. This includes the format of the tag value, and whether tags are mandatory or optional. When setting a tag value for a time registration, the request must follow these rules. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**tagConfigurationId** | **Long** | The id of the tag configuration to set a value for. This must be a valid tag configuration for the time  registration.  |  |
|**value** | **String** | The value to set for the tag configuration. This is a string, but the format of the string is dependent on the tag configuration. For example, if the configuration specifies that the tag is an integer, then the string value must be a valid integer. |  |



