# TagApi

All URIs are relative to *https://trireg2.tcs.trifork.dev*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**deleteTagRegistration**](TagApi.md#deleteTagRegistration) | **DELETE** /tag |  |
| [**deleteTagRegistrationWithHttpInfo**](TagApi.md#deleteTagRegistrationWithHttpInfo) | **DELETE** /tag |  |
| [**getTimeRegistrationTags**](TagApi.md#getTimeRegistrationTags) | **GET** /tag |  |
| [**getTimeRegistrationTagsWithHttpInfo**](TagApi.md#getTimeRegistrationTagsWithHttpInfo) | **GET** /tag |  |
| [**tagTimeRegistration**](TagApi.md#tagTimeRegistration) | **POST** /tag |  |
| [**tagTimeRegistrationWithHttpInfo**](TagApi.md#tagTimeRegistrationWithHttpInfo) | **POST** /tag |  |
| [**updateTagRegistration**](TagApi.md#updateTagRegistration) | **PUT** /tag |  |
| [**updateTagRegistrationWithHttpInfo**](TagApi.md#updateTagRegistrationWithHttpInfo) | **PUT** /tag |  |



## deleteTagRegistration

> DefaultDeleteResponse deleteTagRegistration(tagId)



Deletes a tag that was added to a time registration

### Example

```java
// Import classes:
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.Configuration;
import com.trifork.trireg.client.auth.*;
import com.trifork.trireg.client.models.*;
import com.trifork.trireg.client.api.TagApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://trireg2.tcs.trifork.dev");
        

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        TagApi apiInstance = new TagApi(defaultClient);
        Long tagId = 56L; // Long | The ID of the tag to delete
        try {
            DefaultDeleteResponse result = apiInstance.deleteTagRegistration(tagId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TagApi#deleteTagRegistration");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tagId** | **Long**| The ID of the tag to delete | |

### Return type

[**DefaultDeleteResponse**](DefaultDeleteResponse.md)


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Tag was successfully deleted |  -  |
| **401** | JWT is missing or invalid |  -  |
| **404** | The requested tag was not found and could not be deleted |  -  |

## deleteTagRegistrationWithHttpInfo

> ApiResponse<DefaultDeleteResponse> deleteTagRegistration deleteTagRegistrationWithHttpInfo(tagId)



Deletes a tag that was added to a time registration

### Example

```java
// Import classes:
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.ApiResponse;
import com.trifork.trireg.client.Configuration;
import com.trifork.trireg.client.auth.*;
import com.trifork.trireg.client.models.*;
import com.trifork.trireg.client.api.TagApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://trireg2.tcs.trifork.dev");
        

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        TagApi apiInstance = new TagApi(defaultClient);
        Long tagId = 56L; // Long | The ID of the tag to delete
        try {
            ApiResponse<DefaultDeleteResponse> response = apiInstance.deleteTagRegistrationWithHttpInfo(tagId);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling TagApi#deleteTagRegistration");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tagId** | **Long**| The ID of the tag to delete | |

### Return type

ApiResponse<[**DefaultDeleteResponse**](DefaultDeleteResponse.md)>


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Tag was successfully deleted |  -  |
| **401** | JWT is missing or invalid |  -  |
| **404** | The requested tag was not found and could not be deleted |  -  |


## getTimeRegistrationTags

> List<TimeRegistrationTag> getTimeRegistrationTags(timeRegistrationId)



Gets the tags associated with the specified time registration. This includes both the tags that have already been added, and the ones that can be added. 

### Example

```java
// Import classes:
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.Configuration;
import com.trifork.trireg.client.auth.*;
import com.trifork.trireg.client.models.*;
import com.trifork.trireg.client.api.TagApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://trireg2.tcs.trifork.dev");
        

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        TagApi apiInstance = new TagApi(defaultClient);
        Long timeRegistrationId = 56L; // Long | The ID of the time registration to get tags for
        try {
            List<TimeRegistrationTag> result = apiInstance.getTimeRegistrationTags(timeRegistrationId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TagApi#getTimeRegistrationTags");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **timeRegistrationId** | **Long**| The ID of the time registration to get tags for | |

### Return type

[**List&lt;TimeRegistrationTag&gt;**](TimeRegistrationTag.md)


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | List of tags for the requested time registration, both existing and available to add |  -  |
| **401** | JWT is missing or invalid |  -  |
| **404** | Unable to find a time registration with the specified timeRegistrationId |  -  |
| **502** | While acting as a gateway or proxy, this service received an invalid response from the upstream server. |  -  |

## getTimeRegistrationTagsWithHttpInfo

> ApiResponse<List<TimeRegistrationTag>> getTimeRegistrationTags getTimeRegistrationTagsWithHttpInfo(timeRegistrationId)



Gets the tags associated with the specified time registration. This includes both the tags that have already been added, and the ones that can be added. 

### Example

```java
// Import classes:
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.ApiResponse;
import com.trifork.trireg.client.Configuration;
import com.trifork.trireg.client.auth.*;
import com.trifork.trireg.client.models.*;
import com.trifork.trireg.client.api.TagApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://trireg2.tcs.trifork.dev");
        

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        TagApi apiInstance = new TagApi(defaultClient);
        Long timeRegistrationId = 56L; // Long | The ID of the time registration to get tags for
        try {
            ApiResponse<List<TimeRegistrationTag>> response = apiInstance.getTimeRegistrationTagsWithHttpInfo(timeRegistrationId);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling TagApi#getTimeRegistrationTags");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **timeRegistrationId** | **Long**| The ID of the time registration to get tags for | |

### Return type

ApiResponse<[**List&lt;TimeRegistrationTag&gt;**](TimeRegistrationTag.md)>


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | List of tags for the requested time registration, both existing and available to add |  -  |
| **401** | JWT is missing or invalid |  -  |
| **404** | Unable to find a time registration with the specified timeRegistrationId |  -  |
| **502** | While acting as a gateway or proxy, this service received an invalid response from the upstream server. |  -  |


## tagTimeRegistration

> DefaultCreateResponse tagTimeRegistration(timeRegistrationId, tagTimeRegistrationRequest)



Tags a time registration with a specified tag and tag value

### Example

```java
// Import classes:
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.Configuration;
import com.trifork.trireg.client.auth.*;
import com.trifork.trireg.client.models.*;
import com.trifork.trireg.client.api.TagApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://trireg2.tcs.trifork.dev");
        

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        TagApi apiInstance = new TagApi(defaultClient);
        Long timeRegistrationId = 56L; // Long | The ID of the time registration to add a tag to
        TagTimeRegistrationRequest tagTimeRegistrationRequest = new TagTimeRegistrationRequest(); // TagTimeRegistrationRequest | A JSON object containing tag information
        try {
            DefaultCreateResponse result = apiInstance.tagTimeRegistration(timeRegistrationId, tagTimeRegistrationRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TagApi#tagTimeRegistration");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **timeRegistrationId** | **Long**| The ID of the time registration to add a tag to | |
| **tagTimeRegistrationRequest** | [**TagTimeRegistrationRequest**](TagTimeRegistrationRequest.md)| A JSON object containing tag information | |

### Return type

[**DefaultCreateResponse**](DefaultCreateResponse.md)


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Tag was successfully added to the time registration. The response contains the id of the new tag |  -  |
| **401** | JWT is missing or invalid |  -  |
| **400** | Tag was not added to the time registration due to an error with the request |  -  |
| **404** | No time registration was found to tag |  -  |
| **502** | While acting as a gateway or proxy, this service received an invalid response from the upstream server. |  -  |

## tagTimeRegistrationWithHttpInfo

> ApiResponse<DefaultCreateResponse> tagTimeRegistration tagTimeRegistrationWithHttpInfo(timeRegistrationId, tagTimeRegistrationRequest)



Tags a time registration with a specified tag and tag value

### Example

```java
// Import classes:
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.ApiResponse;
import com.trifork.trireg.client.Configuration;
import com.trifork.trireg.client.auth.*;
import com.trifork.trireg.client.models.*;
import com.trifork.trireg.client.api.TagApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://trireg2.tcs.trifork.dev");
        

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        TagApi apiInstance = new TagApi(defaultClient);
        Long timeRegistrationId = 56L; // Long | The ID of the time registration to add a tag to
        TagTimeRegistrationRequest tagTimeRegistrationRequest = new TagTimeRegistrationRequest(); // TagTimeRegistrationRequest | A JSON object containing tag information
        try {
            ApiResponse<DefaultCreateResponse> response = apiInstance.tagTimeRegistrationWithHttpInfo(timeRegistrationId, tagTimeRegistrationRequest);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling TagApi#tagTimeRegistration");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **timeRegistrationId** | **Long**| The ID of the time registration to add a tag to | |
| **tagTimeRegistrationRequest** | [**TagTimeRegistrationRequest**](TagTimeRegistrationRequest.md)| A JSON object containing tag information | |

### Return type

ApiResponse<[**DefaultCreateResponse**](DefaultCreateResponse.md)>


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Tag was successfully added to the time registration. The response contains the id of the new tag |  -  |
| **401** | JWT is missing or invalid |  -  |
| **400** | Tag was not added to the time registration due to an error with the request |  -  |
| **404** | No time registration was found to tag |  -  |
| **502** | While acting as a gateway or proxy, this service received an invalid response from the upstream server. |  -  |


## updateTagRegistration

> DefaultUpdateResponse updateTagRegistration(tagRegistration)



Updates a tag that was added to a time registration

### Example

```java
// Import classes:
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.Configuration;
import com.trifork.trireg.client.auth.*;
import com.trifork.trireg.client.models.*;
import com.trifork.trireg.client.api.TagApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://trireg2.tcs.trifork.dev");
        

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        TagApi apiInstance = new TagApi(defaultClient);
        TagRegistration tagRegistration = new TagRegistration(); // TagRegistration | A JSON object containing the updated tag information
        try {
            DefaultUpdateResponse result = apiInstance.updateTagRegistration(tagRegistration);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TagApi#updateTagRegistration");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tagRegistration** | [**TagRegistration**](TagRegistration.md)| A JSON object containing the updated tag information | |

### Return type

[**DefaultUpdateResponse**](DefaultUpdateResponse.md)


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Tag was successfully updated |  -  |
| **400** | The updated tag information yields an invalid tag |  -  |
| **401** | JWT is missing or invalid |  -  |
| **404** | The specified tag was not found |  -  |

## updateTagRegistrationWithHttpInfo

> ApiResponse<DefaultUpdateResponse> updateTagRegistration updateTagRegistrationWithHttpInfo(tagRegistration)



Updates a tag that was added to a time registration

### Example

```java
// Import classes:
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.ApiResponse;
import com.trifork.trireg.client.Configuration;
import com.trifork.trireg.client.auth.*;
import com.trifork.trireg.client.models.*;
import com.trifork.trireg.client.api.TagApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://trireg2.tcs.trifork.dev");
        

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        TagApi apiInstance = new TagApi(defaultClient);
        TagRegistration tagRegistration = new TagRegistration(); // TagRegistration | A JSON object containing the updated tag information
        try {
            ApiResponse<DefaultUpdateResponse> response = apiInstance.updateTagRegistrationWithHttpInfo(tagRegistration);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling TagApi#updateTagRegistration");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tagRegistration** | [**TagRegistration**](TagRegistration.md)| A JSON object containing the updated tag information | |

### Return type

ApiResponse<[**DefaultUpdateResponse**](DefaultUpdateResponse.md)>


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Tag was successfully updated |  -  |
| **400** | The updated tag information yields an invalid tag |  -  |
| **401** | JWT is missing or invalid |  -  |
| **404** | The specified tag was not found |  -  |

