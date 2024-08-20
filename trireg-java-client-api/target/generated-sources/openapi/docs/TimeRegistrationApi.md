# TimeRegistrationApi

All URIs are relative to *https://trireg2.tcs.trifork.dev*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addBulkTimeRegistrationForUser**](TimeRegistrationApi.md#addBulkTimeRegistrationForUser) | **POST** /time-registration/bulk |  |
| [**addBulkTimeRegistrationForUserWithHttpInfo**](TimeRegistrationApi.md#addBulkTimeRegistrationForUserWithHttpInfo) | **POST** /time-registration/bulk |  |
| [**addTimeRegistrationForUser**](TimeRegistrationApi.md#addTimeRegistrationForUser) | **POST** /time-registration |  |
| [**addTimeRegistrationForUserWithHttpInfo**](TimeRegistrationApi.md#addTimeRegistrationForUserWithHttpInfo) | **POST** /time-registration |  |
| [**associateTimeRegistrationWithTask**](TimeRegistrationApi.md#associateTimeRegistrationWithTask) | **POST** /time-registration/associate-task |  |
| [**associateTimeRegistrationWithTaskWithHttpInfo**](TimeRegistrationApi.md#associateTimeRegistrationWithTaskWithHttpInfo) | **POST** /time-registration/associate-task |  |
| [**deleteTimeRegistration**](TimeRegistrationApi.md#deleteTimeRegistration) | **DELETE** /time-registration |  |
| [**deleteTimeRegistrationWithHttpInfo**](TimeRegistrationApi.md#deleteTimeRegistrationWithHttpInfo) | **DELETE** /time-registration |  |
| [**getTaskTimeRegistrationsOverview**](TimeRegistrationApi.md#getTaskTimeRegistrationsOverview) | **GET** /time-registration/active-task |  |
| [**getTaskTimeRegistrationsOverviewWithHttpInfo**](TimeRegistrationApi.md#getTaskTimeRegistrationsOverviewWithHttpInfo) | **GET** /time-registration/active-task |  |
| [**getTimeRegistrationsForUser**](TimeRegistrationApi.md#getTimeRegistrationsForUser) | **GET** /time-registration |  |
| [**getTimeRegistrationsForUserWithHttpInfo**](TimeRegistrationApi.md#getTimeRegistrationsForUserWithHttpInfo) | **GET** /time-registration |  |
| [**updateTimeRegistrationForUser**](TimeRegistrationApi.md#updateTimeRegistrationForUser) | **PUT** /time-registration |  |
| [**updateTimeRegistrationForUserWithHttpInfo**](TimeRegistrationApi.md#updateTimeRegistrationForUserWithHttpInfo) | **PUT** /time-registration |  |



## addBulkTimeRegistrationForUser

> List<DefaultCreateResponse> addBulkTimeRegistrationForUser(timeRegistrationRequest)



Add several time registrations for a user

### Example

```java
// Import classes:
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.Configuration;
import com.trifork.trireg.client.auth.*;
import com.trifork.trireg.client.models.*;
import com.trifork.trireg.client.api.TimeRegistrationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://trireg2.tcs.trifork.dev");
        

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        TimeRegistrationApi apiInstance = new TimeRegistrationApi(defaultClient);
        List<TimeRegistrationRequest> timeRegistrationRequest = Arrays.asList(); // List<TimeRegistrationRequest> | A JSON object containing a list of time registration information
        try {
            List<DefaultCreateResponse> result = apiInstance.addBulkTimeRegistrationForUser(timeRegistrationRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TimeRegistrationApi#addBulkTimeRegistrationForUser");
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
| **timeRegistrationRequest** | [**List&lt;TimeRegistrationRequest&gt;**](TimeRegistrationRequest.md)| A JSON object containing a list of time registration information | |

### Return type

[**List&lt;DefaultCreateResponse&gt;**](DefaultCreateResponse.md)


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Time registrations added successfully |  -  |
| **400** | Failed creating one or more time registrations - if one time registration failed, no time registration is saved |  -  |
| **401** | JWT is missing or invalid |  -  |

## addBulkTimeRegistrationForUserWithHttpInfo

> ApiResponse<List<DefaultCreateResponse>> addBulkTimeRegistrationForUser addBulkTimeRegistrationForUserWithHttpInfo(timeRegistrationRequest)



Add several time registrations for a user

### Example

```java
// Import classes:
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.ApiResponse;
import com.trifork.trireg.client.Configuration;
import com.trifork.trireg.client.auth.*;
import com.trifork.trireg.client.models.*;
import com.trifork.trireg.client.api.TimeRegistrationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://trireg2.tcs.trifork.dev");
        

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        TimeRegistrationApi apiInstance = new TimeRegistrationApi(defaultClient);
        List<TimeRegistrationRequest> timeRegistrationRequest = Arrays.asList(); // List<TimeRegistrationRequest> | A JSON object containing a list of time registration information
        try {
            ApiResponse<List<DefaultCreateResponse>> response = apiInstance.addBulkTimeRegistrationForUserWithHttpInfo(timeRegistrationRequest);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling TimeRegistrationApi#addBulkTimeRegistrationForUser");
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
| **timeRegistrationRequest** | [**List&lt;TimeRegistrationRequest&gt;**](TimeRegistrationRequest.md)| A JSON object containing a list of time registration information | |

### Return type

ApiResponse<[**List&lt;DefaultCreateResponse&gt;**](DefaultCreateResponse.md)>


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Time registrations added successfully |  -  |
| **400** | Failed creating one or more time registrations - if one time registration failed, no time registration is saved |  -  |
| **401** | JWT is missing or invalid |  -  |


## addTimeRegistrationForUser

> DefaultCreateResponse addTimeRegistrationForUser(timeRegistrationRequest)



Adds a time registration for a user

### Example

```java
// Import classes:
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.Configuration;
import com.trifork.trireg.client.auth.*;
import com.trifork.trireg.client.models.*;
import com.trifork.trireg.client.api.TimeRegistrationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://trireg2.tcs.trifork.dev");
        

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        TimeRegistrationApi apiInstance = new TimeRegistrationApi(defaultClient);
        TimeRegistrationRequest timeRegistrationRequest = new TimeRegistrationRequest(); // TimeRegistrationRequest | A JSON object containing time registration information
        try {
            DefaultCreateResponse result = apiInstance.addTimeRegistrationForUser(timeRegistrationRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TimeRegistrationApi#addTimeRegistrationForUser");
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
| **timeRegistrationRequest** | [**TimeRegistrationRequest**](TimeRegistrationRequest.md)| A JSON object containing time registration information | |

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
| **201** | Time registration added successfully |  -  |
| **401** | JWT is missing or invalid |  -  |

## addTimeRegistrationForUserWithHttpInfo

> ApiResponse<DefaultCreateResponse> addTimeRegistrationForUser addTimeRegistrationForUserWithHttpInfo(timeRegistrationRequest)



Adds a time registration for a user

### Example

```java
// Import classes:
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.ApiResponse;
import com.trifork.trireg.client.Configuration;
import com.trifork.trireg.client.auth.*;
import com.trifork.trireg.client.models.*;
import com.trifork.trireg.client.api.TimeRegistrationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://trireg2.tcs.trifork.dev");
        

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        TimeRegistrationApi apiInstance = new TimeRegistrationApi(defaultClient);
        TimeRegistrationRequest timeRegistrationRequest = new TimeRegistrationRequest(); // TimeRegistrationRequest | A JSON object containing time registration information
        try {
            ApiResponse<DefaultCreateResponse> response = apiInstance.addTimeRegistrationForUserWithHttpInfo(timeRegistrationRequest);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling TimeRegistrationApi#addTimeRegistrationForUser");
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
| **timeRegistrationRequest** | [**TimeRegistrationRequest**](TimeRegistrationRequest.md)| A JSON object containing time registration information | |

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
| **201** | Time registration added successfully |  -  |
| **401** | JWT is missing or invalid |  -  |


## associateTimeRegistrationWithTask

> DefaultUpdateResponse associateTimeRegistrationWithTask(timeRegistrationAssociateTaskRequest)



Associates a time registration - that currently does not have any task associated - to the specified task. Also accepts tags that may be required to make a valid time registration for the specified task. 

### Example

```java
// Import classes:
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.Configuration;
import com.trifork.trireg.client.auth.*;
import com.trifork.trireg.client.models.*;
import com.trifork.trireg.client.api.TimeRegistrationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://trireg2.tcs.trifork.dev");
        

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        TimeRegistrationApi apiInstance = new TimeRegistrationApi(defaultClient);
        TimeRegistrationAssociateTaskRequest timeRegistrationAssociateTaskRequest = new TimeRegistrationAssociateTaskRequest(); // TimeRegistrationAssociateTaskRequest | 
        try {
            DefaultUpdateResponse result = apiInstance.associateTimeRegistrationWithTask(timeRegistrationAssociateTaskRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TimeRegistrationApi#associateTimeRegistrationWithTask");
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
| **timeRegistrationAssociateTaskRequest** | [**TimeRegistrationAssociateTaskRequest**](TimeRegistrationAssociateTaskRequest.md)|  | |

### Return type

[**DefaultUpdateResponse**](DefaultUpdateResponse.md)


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | associated |  -  |
| **400** | Bad associate request |  -  |
| **401** | JWT is missing or invalid |  -  |
| **404** | Time registration not found |  -  |

## associateTimeRegistrationWithTaskWithHttpInfo

> ApiResponse<DefaultUpdateResponse> associateTimeRegistrationWithTask associateTimeRegistrationWithTaskWithHttpInfo(timeRegistrationAssociateTaskRequest)



Associates a time registration - that currently does not have any task associated - to the specified task. Also accepts tags that may be required to make a valid time registration for the specified task. 

### Example

```java
// Import classes:
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.ApiResponse;
import com.trifork.trireg.client.Configuration;
import com.trifork.trireg.client.auth.*;
import com.trifork.trireg.client.models.*;
import com.trifork.trireg.client.api.TimeRegistrationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://trireg2.tcs.trifork.dev");
        

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        TimeRegistrationApi apiInstance = new TimeRegistrationApi(defaultClient);
        TimeRegistrationAssociateTaskRequest timeRegistrationAssociateTaskRequest = new TimeRegistrationAssociateTaskRequest(); // TimeRegistrationAssociateTaskRequest | 
        try {
            ApiResponse<DefaultUpdateResponse> response = apiInstance.associateTimeRegistrationWithTaskWithHttpInfo(timeRegistrationAssociateTaskRequest);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling TimeRegistrationApi#associateTimeRegistrationWithTask");
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
| **timeRegistrationAssociateTaskRequest** | [**TimeRegistrationAssociateTaskRequest**](TimeRegistrationAssociateTaskRequest.md)|  | |

### Return type

ApiResponse<[**DefaultUpdateResponse**](DefaultUpdateResponse.md)>


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | associated |  -  |
| **400** | Bad associate request |  -  |
| **401** | JWT is missing or invalid |  -  |
| **404** | Time registration not found |  -  |


## deleteTimeRegistration

> DefaultDeleteResponse deleteTimeRegistration(timeRegistrationId)



Deletes the specified time registration

### Example

```java
// Import classes:
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.Configuration;
import com.trifork.trireg.client.auth.*;
import com.trifork.trireg.client.models.*;
import com.trifork.trireg.client.api.TimeRegistrationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://trireg2.tcs.trifork.dev");
        

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        TimeRegistrationApi apiInstance = new TimeRegistrationApi(defaultClient);
        Long timeRegistrationId = 56L; // Long | The id of the time registration to delete
        try {
            DefaultDeleteResponse result = apiInstance.deleteTimeRegistration(timeRegistrationId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TimeRegistrationApi#deleteTimeRegistration");
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
| **timeRegistrationId** | **Long**| The id of the time registration to delete | |

### Return type

[**DefaultDeleteResponse**](DefaultDeleteResponse.md)


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | deleted |  -  |
| **400** | Bad delete request |  -  |
| **401** | JWT is missing or invalid |  -  |
| **404** | Time registration not found |  -  |

## deleteTimeRegistrationWithHttpInfo

> ApiResponse<DefaultDeleteResponse> deleteTimeRegistration deleteTimeRegistrationWithHttpInfo(timeRegistrationId)



Deletes the specified time registration

### Example

```java
// Import classes:
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.ApiResponse;
import com.trifork.trireg.client.Configuration;
import com.trifork.trireg.client.auth.*;
import com.trifork.trireg.client.models.*;
import com.trifork.trireg.client.api.TimeRegistrationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://trireg2.tcs.trifork.dev");
        

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        TimeRegistrationApi apiInstance = new TimeRegistrationApi(defaultClient);
        Long timeRegistrationId = 56L; // Long | The id of the time registration to delete
        try {
            ApiResponse<DefaultDeleteResponse> response = apiInstance.deleteTimeRegistrationWithHttpInfo(timeRegistrationId);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling TimeRegistrationApi#deleteTimeRegistration");
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
| **timeRegistrationId** | **Long**| The id of the time registration to delete | |

### Return type

ApiResponse<[**DefaultDeleteResponse**](DefaultDeleteResponse.md)>


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | deleted |  -  |
| **400** | Bad delete request |  -  |
| **401** | JWT is missing or invalid |  -  |
| **404** | Time registration not found |  -  |


## getTaskTimeRegistrationsOverview

> TimeRegistrationsByTaskResponse getTaskTimeRegistrationsOverview(date, period)



Returns time registrations for a user grouped by task

### Example

```java
// Import classes:
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.Configuration;
import com.trifork.trireg.client.auth.*;
import com.trifork.trireg.client.models.*;
import com.trifork.trireg.client.api.TimeRegistrationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://trireg2.tcs.trifork.dev");
        

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        TimeRegistrationApi apiInstance = new TimeRegistrationApi(defaultClient);
        LocalDate date = LocalDate.now(); // LocalDate | The date to consider when fetching active tasks and time registrations
        OverviewPeriod period = OverviewPeriod.fromValue("DAY"); // OverviewPeriod | The time period to use when deciding in which time period tasks are considered active. Defaults to 'WEEK'. 
        try {
            TimeRegistrationsByTaskResponse result = apiInstance.getTaskTimeRegistrationsOverview(date, period);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TimeRegistrationApi#getTaskTimeRegistrationsOverview");
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
| **date** | **LocalDate**| The date to consider when fetching active tasks and time registrations | |
| **period** | [**OverviewPeriod**](.md)| The time period to use when deciding in which time period tasks are considered active. Defaults to &#39;WEEK&#39;.  | [optional] [enum: DAY, WEEK, MONTH] |

### Return type

[**TimeRegistrationsByTaskResponse**](TimeRegistrationsByTaskResponse.md)


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | List of time registrations for the user grouped by task |  -  |
| **400** | Request contains an invalid time period value |  -  |
| **401** | JWT is missing or invalid |  -  |

## getTaskTimeRegistrationsOverviewWithHttpInfo

> ApiResponse<TimeRegistrationsByTaskResponse> getTaskTimeRegistrationsOverview getTaskTimeRegistrationsOverviewWithHttpInfo(date, period)



Returns time registrations for a user grouped by task

### Example

```java
// Import classes:
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.ApiResponse;
import com.trifork.trireg.client.Configuration;
import com.trifork.trireg.client.auth.*;
import com.trifork.trireg.client.models.*;
import com.trifork.trireg.client.api.TimeRegistrationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://trireg2.tcs.trifork.dev");
        

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        TimeRegistrationApi apiInstance = new TimeRegistrationApi(defaultClient);
        LocalDate date = LocalDate.now(); // LocalDate | The date to consider when fetching active tasks and time registrations
        OverviewPeriod period = OverviewPeriod.fromValue("DAY"); // OverviewPeriod | The time period to use when deciding in which time period tasks are considered active. Defaults to 'WEEK'. 
        try {
            ApiResponse<TimeRegistrationsByTaskResponse> response = apiInstance.getTaskTimeRegistrationsOverviewWithHttpInfo(date, period);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling TimeRegistrationApi#getTaskTimeRegistrationsOverview");
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
| **date** | **LocalDate**| The date to consider when fetching active tasks and time registrations | |
| **period** | [**OverviewPeriod**](.md)| The time period to use when deciding in which time period tasks are considered active. Defaults to &#39;WEEK&#39;.  | [optional] [enum: DAY, WEEK, MONTH] |

### Return type

ApiResponse<[**TimeRegistrationsByTaskResponse**](TimeRegistrationsByTaskResponse.md)>


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | List of time registrations for the user grouped by task |  -  |
| **400** | Request contains an invalid time period value |  -  |
| **401** | JWT is missing or invalid |  -  |


## getTimeRegistrationsForUser

> List<TimeRegistrationResponse> getTimeRegistrationsForUser()



Returns time registrations that belongs to a user

### Example

```java
// Import classes:
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.Configuration;
import com.trifork.trireg.client.auth.*;
import com.trifork.trireg.client.models.*;
import com.trifork.trireg.client.api.TimeRegistrationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://trireg2.tcs.trifork.dev");
        

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        TimeRegistrationApi apiInstance = new TimeRegistrationApi(defaultClient);
        try {
            List<TimeRegistrationResponse> result = apiInstance.getTimeRegistrationsForUser();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TimeRegistrationApi#getTimeRegistrationsForUser");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**List&lt;TimeRegistrationResponse&gt;**](TimeRegistrationResponse.md)


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | List of time registrations for the user |  -  |
| **401** | JWT is missing or invalid |  -  |

## getTimeRegistrationsForUserWithHttpInfo

> ApiResponse<List<TimeRegistrationResponse>> getTimeRegistrationsForUser getTimeRegistrationsForUserWithHttpInfo()



Returns time registrations that belongs to a user

### Example

```java
// Import classes:
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.ApiResponse;
import com.trifork.trireg.client.Configuration;
import com.trifork.trireg.client.auth.*;
import com.trifork.trireg.client.models.*;
import com.trifork.trireg.client.api.TimeRegistrationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://trireg2.tcs.trifork.dev");
        

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        TimeRegistrationApi apiInstance = new TimeRegistrationApi(defaultClient);
        try {
            ApiResponse<List<TimeRegistrationResponse>> response = apiInstance.getTimeRegistrationsForUserWithHttpInfo();
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling TimeRegistrationApi#getTimeRegistrationsForUser");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

ApiResponse<[**List&lt;TimeRegistrationResponse&gt;**](TimeRegistrationResponse.md)>


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | List of time registrations for the user |  -  |
| **401** | JWT is missing or invalid |  -  |


## updateTimeRegistrationForUser

> DefaultCreateResponse updateTimeRegistrationForUser(timeRegistrationId, timeRegistrationUpdateRequest)



Updates the specified time registration

### Example

```java
// Import classes:
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.Configuration;
import com.trifork.trireg.client.auth.*;
import com.trifork.trireg.client.models.*;
import com.trifork.trireg.client.api.TimeRegistrationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://trireg2.tcs.trifork.dev");
        

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        TimeRegistrationApi apiInstance = new TimeRegistrationApi(defaultClient);
        Long timeRegistrationId = 56L; // Long | The id of the time registration to update
        TimeRegistrationUpdateRequest timeRegistrationUpdateRequest = new TimeRegistrationUpdateRequest(); // TimeRegistrationUpdateRequest | 
        try {
            DefaultCreateResponse result = apiInstance.updateTimeRegistrationForUser(timeRegistrationId, timeRegistrationUpdateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TimeRegistrationApi#updateTimeRegistrationForUser");
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
| **timeRegistrationId** | **Long**| The id of the time registration to update | |
| **timeRegistrationUpdateRequest** | [**TimeRegistrationUpdateRequest**](TimeRegistrationUpdateRequest.md)|  | |

### Return type

[**DefaultCreateResponse**](DefaultCreateResponse.md)


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Updated |  -  |
| **400** | Bad update request |  -  |
| **401** | JWT is missing or invalid |  -  |
| **404** | Time registration not found |  -  |

## updateTimeRegistrationForUserWithHttpInfo

> ApiResponse<DefaultCreateResponse> updateTimeRegistrationForUser updateTimeRegistrationForUserWithHttpInfo(timeRegistrationId, timeRegistrationUpdateRequest)



Updates the specified time registration

### Example

```java
// Import classes:
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.ApiResponse;
import com.trifork.trireg.client.Configuration;
import com.trifork.trireg.client.auth.*;
import com.trifork.trireg.client.models.*;
import com.trifork.trireg.client.api.TimeRegistrationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://trireg2.tcs.trifork.dev");
        

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        TimeRegistrationApi apiInstance = new TimeRegistrationApi(defaultClient);
        Long timeRegistrationId = 56L; // Long | The id of the time registration to update
        TimeRegistrationUpdateRequest timeRegistrationUpdateRequest = new TimeRegistrationUpdateRequest(); // TimeRegistrationUpdateRequest | 
        try {
            ApiResponse<DefaultCreateResponse> response = apiInstance.updateTimeRegistrationForUserWithHttpInfo(timeRegistrationId, timeRegistrationUpdateRequest);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling TimeRegistrationApi#updateTimeRegistrationForUser");
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
| **timeRegistrationId** | **Long**| The id of the time registration to update | |
| **timeRegistrationUpdateRequest** | [**TimeRegistrationUpdateRequest**](TimeRegistrationUpdateRequest.md)|  | |

### Return type

ApiResponse<[**DefaultCreateResponse**](DefaultCreateResponse.md)>


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Updated |  -  |
| **400** | Bad update request |  -  |
| **401** | JWT is missing or invalid |  -  |
| **404** | Time registration not found |  -  |

