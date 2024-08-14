# ExportApi

All URIs are relative to *https://trireg2.tcs.trifork.dev*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**exportTimeRegistrationsForUser**](ExportApi.md#exportTimeRegistrationsForUser) | **POST** /export |  |
| [**exportTimeRegistrationsForUserWithHttpInfo**](ExportApi.md#exportTimeRegistrationsForUserWithHttpInfo) | **POST** /export |  |



## exportTimeRegistrationsForUser

> String exportTimeRegistrationsForUser(start, end)



Exports time registrations for a specific time period for the user logged in

### Example

```java
// Import classes:
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.Configuration;
import com.trifork.trireg.client.auth.*;
import com.trifork.trireg.client.models.*;
import com.trifork.trireg.client.api.ExportApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://trireg2.tcs.trifork.dev");
        

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        ExportApi apiInstance = new ExportApi(defaultClient);
        LocalDate start = LocalDate.parse("Mon Mar 11 01:00:00 CET 2024"); // LocalDate | The start date of the export time interval (inclusive)
        LocalDate end = LocalDate.parse("Sun Mar 17 01:00:00 CET 2024"); // LocalDate | The end date of the export time interval (inclusive)
        try {
            String result = apiInstance.exportTimeRegistrationsForUser(start, end);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExportApi#exportTimeRegistrationsForUser");
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
| **start** | **LocalDate**| The start date of the export time interval (inclusive) | |
| **end** | **LocalDate**| The end date of the export time interval (inclusive) | |

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
| **200** | OK |  -  |
| **401** | JWT is missing or invalid |  -  |
| **502** | While acting as a gateway or proxy, this service received an invalid response from the upstream server. |  -  |

## exportTimeRegistrationsForUserWithHttpInfo

> ApiResponse<String> exportTimeRegistrationsForUser exportTimeRegistrationsForUserWithHttpInfo(start, end)



Exports time registrations for a specific time period for the user logged in

### Example

```java
// Import classes:
import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.ApiResponse;
import com.trifork.trireg.client.Configuration;
import com.trifork.trireg.client.auth.*;
import com.trifork.trireg.client.models.*;
import com.trifork.trireg.client.api.ExportApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://trireg2.tcs.trifork.dev");
        

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        ExportApi apiInstance = new ExportApi(defaultClient);
        LocalDate start = LocalDate.parse("Mon Mar 11 01:00:00 CET 2024"); // LocalDate | The start date of the export time interval (inclusive)
        LocalDate end = LocalDate.parse("Sun Mar 17 01:00:00 CET 2024"); // LocalDate | The end date of the export time interval (inclusive)
        try {
            ApiResponse<String> response = apiInstance.exportTimeRegistrationsForUserWithHttpInfo(start, end);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling ExportApi#exportTimeRegistrationsForUser");
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
| **start** | **LocalDate**| The start date of the export time interval (inclusive) | |
| **end** | **LocalDate**| The end date of the export time interval (inclusive) | |

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
| **200** | OK |  -  |
| **401** | JWT is missing or invalid |  -  |
| **502** | While acting as a gateway or proxy, this service received an invalid response from the upstream server. |  -  |

