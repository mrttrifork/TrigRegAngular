# ImportApi

All URIs are relative to *https://trireg2.tcs.trifork.dev*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**importTimeRegistrations**](ImportApi.md#importTimeRegistrations) | **POST** /import |  |
| [**importTimeRegistrationsWithHttpInfo**](ImportApi.md#importTimeRegistrationsWithHttpInfo) | **POST** /import |  |



## importTimeRegistrations

> List<ImportTimeRegistrationResponseInner> importTimeRegistrations(importTimeRegistrationRequestInner)



Imports the given time registrations into the system

### Example

```java
// Import classes:
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.Configuration;
import com.trifork.trireg.client.auth.*;
import com.trifork.trireg.client.models.*;
import com.trifork.trireg.client.api.ImportApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://trireg2.tcs.trifork.dev");
        

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        ImportApi apiInstance = new ImportApi(defaultClient);
        List<ImportTimeRegistrationRequestInner> importTimeRegistrationRequestInner = Arrays.asList(); // List<ImportTimeRegistrationRequestInner> | A JSON object containing time registration information to be imported
        try {
            List<ImportTimeRegistrationResponseInner> result = apiInstance.importTimeRegistrations(importTimeRegistrationRequestInner);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ImportApi#importTimeRegistrations");
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
| **importTimeRegistrationRequestInner** | [**List&lt;ImportTimeRegistrationRequestInner&gt;**](ImportTimeRegistrationRequestInner.md)| A JSON object containing time registration information to be imported | |

### Return type

[**List&lt;ImportTimeRegistrationResponseInner&gt;**](ImportTimeRegistrationResponseInner.md)


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | JWT is missing or invalid |  -  |
| **502** | While acting as a gateway or proxy, this service received an invalid response from the upstream server. |  -  |

## importTimeRegistrationsWithHttpInfo

> ApiResponse<List<ImportTimeRegistrationResponseInner>> importTimeRegistrations importTimeRegistrationsWithHttpInfo(importTimeRegistrationRequestInner)



Imports the given time registrations into the system

### Example

```java
// Import classes:
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.ApiResponse;
import com.trifork.trireg.client.Configuration;
import com.trifork.trireg.client.auth.*;
import com.trifork.trireg.client.models.*;
import com.trifork.trireg.client.api.ImportApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://trireg2.tcs.trifork.dev");
        

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        ImportApi apiInstance = new ImportApi(defaultClient);
        List<ImportTimeRegistrationRequestInner> importTimeRegistrationRequestInner = Arrays.asList(); // List<ImportTimeRegistrationRequestInner> | A JSON object containing time registration information to be imported
        try {
            ApiResponse<List<ImportTimeRegistrationResponseInner>> response = apiInstance.importTimeRegistrationsWithHttpInfo(importTimeRegistrationRequestInner);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling ImportApi#importTimeRegistrations");
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
| **importTimeRegistrationRequestInner** | [**List&lt;ImportTimeRegistrationRequestInner&gt;**](ImportTimeRegistrationRequestInner.md)| A JSON object containing time registration information to be imported | |

### Return type

ApiResponse<[**List&lt;ImportTimeRegistrationResponseInner&gt;**](ImportTimeRegistrationResponseInner.md)>


### Authorization

[openId](../README.md#openId), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | JWT is missing or invalid |  -  |
| **502** | While acting as a gateway or proxy, this service received an invalid response from the upstream server. |  -  |

