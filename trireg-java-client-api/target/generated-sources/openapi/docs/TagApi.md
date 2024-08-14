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

> String deleteTagRegistration(tagId)



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
            String result = apiInstance.deleteTagRegistration(tagId);
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

**String**


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Tag was successfully deleted |  -  |
| **401** | JWT is missing or invalid |  -  |
| **404** | The requested tag was not found and could not be deleted |  -  |

## deleteTagRegistrationWithHttpInfo

> ApiResponse<String> deleteTagRegistration deleteTagRegistrationWithHttpInfo(tagId)



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
            ApiResponse<String> response = apiInstance.deleteTagRegistrationWithHttpInfo(tagId);
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

ApiResponse<**String**>


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Tag was successfully deleted |  -  |
| **401** | JWT is missing or invalid |  -  |
| **404** | The requested tag was not found and could not be deleted |  -  |


## getTimeRegistrationTags

> List<TagTimeRegistrationResponse> getTimeRegistrationTags(timeRegistrationId)



Gets the tags associated with the given time registration

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
            List<TagTimeRegistrationResponse> result = apiInstance.getTimeRegistrationTags(timeRegistrationId);
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

[**List&lt;TagTimeRegistrationResponse&gt;**](TagTimeRegistrationResponse.md)


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | List of tags for the requested time registration |  -  |
| **401** | JWT is missing or invalid |  -  |
| **404** | Unable to find a time registration with the specified timeRegistrationId |  -  |
| **502** | While acting as a gateway or proxy, this service received an invalid response from the upstream server. |  -  |

## getTimeRegistrationTagsWithHttpInfo

> ApiResponse<List<TagTimeRegistrationResponse>> getTimeRegistrationTags getTimeRegistrationTagsWithHttpInfo(timeRegistrationId)



Gets the tags associated with the given time registration

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
            ApiResponse<List<TagTimeRegistrationResponse>> response = apiInstance.getTimeRegistrationTagsWithHttpInfo(timeRegistrationId);
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

ApiResponse<[**List&lt;TagTimeRegistrationResponse&gt;**](TagTimeRegistrationResponse.md)>


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | List of tags for the requested time registration |  -  |
| **401** | JWT is missing or invalid |  -  |
| **404** | Unable to find a time registration with the specified timeRegistrationId |  -  |
| **502** | While acting as a gateway or proxy, this service received an invalid response from the upstream server. |  -  |


## tagTimeRegistration

> String tagTimeRegistration(tagTimeRegistrationRequest)



Tags a time registration with a specified tag and optional tag value

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
        TagTimeRegistrationRequest tagTimeRegistrationRequest = new TagTimeRegistrationRequest(); // TagTimeRegistrationRequest | A JSON object containing tag information
        try {
            String result = apiInstance.tagTimeRegistration(tagTimeRegistrationRequest);
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
| **tagTimeRegistrationRequest** | [**TagTimeRegistrationRequest**](TagTimeRegistrationRequest.md)| A JSON object containing tag information | |

### Return type

**String**


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Tag was successfully added to the time registration |  -  |
| **401** | JWT is missing or invalid |  -  |
| **400** | Tag was not added to the time registration due to an error with the request |  -  |
| **404** | No time registration was found to tag |  -  |
| **502** | While acting as a gateway or proxy, this service received an invalid response from the upstream server. |  -  |

## tagTimeRegistrationWithHttpInfo

> ApiResponse<String> tagTimeRegistration tagTimeRegistrationWithHttpInfo(tagTimeRegistrationRequest)



Tags a time registration with a specified tag and optional tag value

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
        TagTimeRegistrationRequest tagTimeRegistrationRequest = new TagTimeRegistrationRequest(); // TagTimeRegistrationRequest | A JSON object containing tag information
        try {
            ApiResponse<String> response = apiInstance.tagTimeRegistrationWithHttpInfo(tagTimeRegistrationRequest);
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
| **tagTimeRegistrationRequest** | [**TagTimeRegistrationRequest**](TagTimeRegistrationRequest.md)| A JSON object containing tag information | |

### Return type

ApiResponse<**String**>


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Tag was successfully added to the time registration |  -  |
| **401** | JWT is missing or invalid |  -  |
| **400** | Tag was not added to the time registration due to an error with the request |  -  |
| **404** | No time registration was found to tag |  -  |
| **502** | While acting as a gateway or proxy, this service received an invalid response from the upstream server. |  -  |


## updateTagRegistration

> String updateTagRegistration(updateTagRegistrationRequest)



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
        UpdateTagRegistrationRequest updateTagRegistrationRequest = new UpdateTagRegistrationRequest(); // UpdateTagRegistrationRequest | A JSON object containing the updated tag information
        try {
            String result = apiInstance.updateTagRegistration(updateTagRegistrationRequest);
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
| **updateTagRegistrationRequest** | [**UpdateTagRegistrationRequest**](UpdateTagRegistrationRequest.md)| A JSON object containing the updated tag information | |

### Return type

**String**


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Tag was successfully updated |  -  |
| **400** | The updated tag information yields an invalid tag |  -  |
| **401** | JWT is missing or invalid |  -  |
| **404** | The specified tag was not found |  -  |

## updateTagRegistrationWithHttpInfo

> ApiResponse<String> updateTagRegistration updateTagRegistrationWithHttpInfo(updateTagRegistrationRequest)



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
        UpdateTagRegistrationRequest updateTagRegistrationRequest = new UpdateTagRegistrationRequest(); // UpdateTagRegistrationRequest | A JSON object containing the updated tag information
        try {
            ApiResponse<String> response = apiInstance.updateTagRegistrationWithHttpInfo(updateTagRegistrationRequest);
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
| **updateTagRegistrationRequest** | [**UpdateTagRegistrationRequest**](UpdateTagRegistrationRequest.md)| A JSON object containing the updated tag information | |

### Return type

ApiResponse<**String**>


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Tag was successfully updated |  -  |
| **400** | The updated tag information yields an invalid tag |  -  |
| **401** | JWT is missing or invalid |  -  |
| **404** | The specified tag was not found |  -  |

