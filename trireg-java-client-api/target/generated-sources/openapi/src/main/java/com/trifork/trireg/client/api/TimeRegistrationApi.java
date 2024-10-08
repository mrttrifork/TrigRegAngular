/*
 * TriReg2 User API
 * An OpenAPI specification for time registrations to be used by a user
 *
 * The version of the OpenAPI document: 0.2.0
 * Contact: example@example.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.trifork.trireg.client.api;

import com.trifork.trireg.client.ApiClient;
import com.trifork.trireg.client.ApiException;
import com.trifork.trireg.client.ApiResponse;
import com.trifork.trireg.client.Pair;

import com.trifork.trireg.client.api.DefaultCreateResponse;
import com.trifork.trireg.client.api.DefaultDeleteResponse;
import com.trifork.trireg.client.api.DefaultUpdateResponse;
import java.time.LocalDate;
import com.trifork.trireg.client.api.OverviewPeriod;
import com.trifork.trireg.client.api.TimeRegistrationAssociateTaskRequest;
import com.trifork.trireg.client.api.TimeRegistrationRequest;
import com.trifork.trireg.client.api.TimeRegistrationResponse;
import com.trifork.trireg.client.api.TimeRegistrationUpdateRequest;
import com.trifork.trireg.client.api.TimeRegistrationsByTaskResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.http.HttpRequest;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-21T22:43:45.700872200+02:00[Europe/Copenhagen]", comments = "Generator version: 7.4.0")
public class TimeRegistrationApi {
  private final HttpClient memberVarHttpClient;
  private final ObjectMapper memberVarObjectMapper;
  private final String memberVarBaseUri;
  private final Consumer<HttpRequest.Builder> memberVarInterceptor;
  private final Duration memberVarReadTimeout;
  private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;
  private final Consumer<HttpResponse<String>> memberVarAsyncResponseInterceptor;

  public TimeRegistrationApi() {
    this(new ApiClient());
  }

  public TimeRegistrationApi(ApiClient apiClient) {
    memberVarHttpClient = apiClient.getHttpClient();
    memberVarObjectMapper = apiClient.getObjectMapper();
    memberVarBaseUri = apiClient.getBaseUri();
    memberVarInterceptor = apiClient.getRequestInterceptor();
    memberVarReadTimeout = apiClient.getReadTimeout();
    memberVarResponseInterceptor = apiClient.getResponseInterceptor();
    memberVarAsyncResponseInterceptor = apiClient.getAsyncResponseInterceptor();
  }

  protected ApiException getApiException(String operationId, HttpResponse<InputStream> response) throws IOException {
    String body = response.body() == null ? null : new String(response.body().readAllBytes());
    String message = formatExceptionMessage(operationId, response.statusCode(), body);
    return new ApiException(response.statusCode(), message, response.headers(), body);
  }

  private String formatExceptionMessage(String operationId, int statusCode, String body) {
    if (body == null || body.isEmpty()) {
      body = "[no body]";
    }
    return operationId + " call failed with: " + statusCode + " - " + body;
  }

  /**
   * 
   * Add several time registrations for a user
   * @param timeRegistrationRequest A JSON object containing a list of time registration information (required)
   * @return List&lt;DefaultCreateResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public List<DefaultCreateResponse> addBulkTimeRegistrationForUser(List<TimeRegistrationRequest> timeRegistrationRequest) throws ApiException {
    ApiResponse<List<DefaultCreateResponse>> localVarResponse = addBulkTimeRegistrationForUserWithHttpInfo(timeRegistrationRequest);
    return localVarResponse.getData();
  }

  /**
   * 
   * Add several time registrations for a user
   * @param timeRegistrationRequest A JSON object containing a list of time registration information (required)
   * @return ApiResponse&lt;List&lt;DefaultCreateResponse&gt;&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<List<DefaultCreateResponse>> addBulkTimeRegistrationForUserWithHttpInfo(List<TimeRegistrationRequest> timeRegistrationRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = addBulkTimeRegistrationForUserRequestBuilder(timeRegistrationRequest);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("addBulkTimeRegistrationForUser", localVarResponse);
        }
        return new ApiResponse<List<DefaultCreateResponse>>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<List<DefaultCreateResponse>>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder addBulkTimeRegistrationForUserRequestBuilder(List<TimeRegistrationRequest> timeRegistrationRequest) throws ApiException {
    // verify the required parameter 'timeRegistrationRequest' is set
    if (timeRegistrationRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'timeRegistrationRequest' when calling addBulkTimeRegistrationForUser");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/time-registration/bulk";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json, text/plain");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(timeRegistrationRequest);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * 
   * Adds a time registration for a user
   * @param timeRegistrationRequest A JSON object containing time registration information (required)
   * @return DefaultCreateResponse
   * @throws ApiException if fails to make API call
   */
  public DefaultCreateResponse addTimeRegistrationForUser(TimeRegistrationRequest timeRegistrationRequest) throws ApiException {
    ApiResponse<DefaultCreateResponse> localVarResponse = addTimeRegistrationForUserWithHttpInfo(timeRegistrationRequest);
    return localVarResponse.getData();
  }

  /**
   * 
   * Adds a time registration for a user
   * @param timeRegistrationRequest A JSON object containing time registration information (required)
   * @return ApiResponse&lt;DefaultCreateResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<DefaultCreateResponse> addTimeRegistrationForUserWithHttpInfo(TimeRegistrationRequest timeRegistrationRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = addTimeRegistrationForUserRequestBuilder(timeRegistrationRequest);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("addTimeRegistrationForUser", localVarResponse);
        }
        return new ApiResponse<DefaultCreateResponse>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<DefaultCreateResponse>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder addTimeRegistrationForUserRequestBuilder(TimeRegistrationRequest timeRegistrationRequest) throws ApiException {
    // verify the required parameter 'timeRegistrationRequest' is set
    if (timeRegistrationRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'timeRegistrationRequest' when calling addTimeRegistrationForUser");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/time-registration";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(timeRegistrationRequest);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * 
   * Associates a time registration - that currently does not have any task associated - to the specified task. Also accepts tags that may be required to make a valid time registration for the specified task. 
   * @param timeRegistrationAssociateTaskRequest  (required)
   * @return DefaultUpdateResponse
   * @throws ApiException if fails to make API call
   */
  public DefaultUpdateResponse associateTimeRegistrationWithTask(TimeRegistrationAssociateTaskRequest timeRegistrationAssociateTaskRequest) throws ApiException {
    ApiResponse<DefaultUpdateResponse> localVarResponse = associateTimeRegistrationWithTaskWithHttpInfo(timeRegistrationAssociateTaskRequest);
    return localVarResponse.getData();
  }

  /**
   * 
   * Associates a time registration - that currently does not have any task associated - to the specified task. Also accepts tags that may be required to make a valid time registration for the specified task. 
   * @param timeRegistrationAssociateTaskRequest  (required)
   * @return ApiResponse&lt;DefaultUpdateResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<DefaultUpdateResponse> associateTimeRegistrationWithTaskWithHttpInfo(TimeRegistrationAssociateTaskRequest timeRegistrationAssociateTaskRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = associateTimeRegistrationWithTaskRequestBuilder(timeRegistrationAssociateTaskRequest);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("associateTimeRegistrationWithTask", localVarResponse);
        }
        return new ApiResponse<DefaultUpdateResponse>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<DefaultUpdateResponse>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder associateTimeRegistrationWithTaskRequestBuilder(TimeRegistrationAssociateTaskRequest timeRegistrationAssociateTaskRequest) throws ApiException {
    // verify the required parameter 'timeRegistrationAssociateTaskRequest' is set
    if (timeRegistrationAssociateTaskRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'timeRegistrationAssociateTaskRequest' when calling associateTimeRegistrationWithTask");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/time-registration/associate-task";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json, text/plain");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(timeRegistrationAssociateTaskRequest);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * 
   * Deletes the specified time registration
   * @param timeRegistrationId The id of the time registration to delete (required)
   * @return DefaultDeleteResponse
   * @throws ApiException if fails to make API call
   */
  public DefaultDeleteResponse deleteTimeRegistration(Long timeRegistrationId) throws ApiException {
    ApiResponse<DefaultDeleteResponse> localVarResponse = deleteTimeRegistrationWithHttpInfo(timeRegistrationId);
    return localVarResponse.getData();
  }

  /**
   * 
   * Deletes the specified time registration
   * @param timeRegistrationId The id of the time registration to delete (required)
   * @return ApiResponse&lt;DefaultDeleteResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<DefaultDeleteResponse> deleteTimeRegistrationWithHttpInfo(Long timeRegistrationId) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = deleteTimeRegistrationRequestBuilder(timeRegistrationId);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("deleteTimeRegistration", localVarResponse);
        }
        return new ApiResponse<DefaultDeleteResponse>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<DefaultDeleteResponse>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder deleteTimeRegistrationRequestBuilder(Long timeRegistrationId) throws ApiException {
    // verify the required parameter 'timeRegistrationId' is set
    if (timeRegistrationId == null) {
      throw new ApiException(400, "Missing the required parameter 'timeRegistrationId' when calling deleteTimeRegistration");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/time-registration";

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "timeRegistrationId";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("timeRegistrationId", timeRegistrationId));

    if (!localVarQueryParams.isEmpty() || localVarQueryStringJoiner.length() != 0) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      if (localVarQueryStringJoiner.length() != 0) {
        queryJoiner.add(localVarQueryStringJoiner.toString());
      }
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Accept", "application/json, text/plain");

    localVarRequestBuilder.method("DELETE", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * 
   * Returns time registrations for a user grouped by task
   * @param date The date to consider when fetching active tasks and time registrations (required)
   * @param period The time period to use when deciding in which time period tasks are considered active. Defaults to &#39;WEEK&#39;.  (optional)
   * @param extraTasks An optional collection of extra tasks to include in the response, regardless of whether they are active or not (optional)
   * @return TimeRegistrationsByTaskResponse
   * @throws ApiException if fails to make API call
   */
  public TimeRegistrationsByTaskResponse getTaskTimeRegistrationsOverview(LocalDate date, OverviewPeriod period, List<Long> extraTasks) throws ApiException {
    ApiResponse<TimeRegistrationsByTaskResponse> localVarResponse = getTaskTimeRegistrationsOverviewWithHttpInfo(date, period, extraTasks);
    return localVarResponse.getData();
  }

  /**
   * 
   * Returns time registrations for a user grouped by task
   * @param date The date to consider when fetching active tasks and time registrations (required)
   * @param period The time period to use when deciding in which time period tasks are considered active. Defaults to &#39;WEEK&#39;.  (optional)
   * @param extraTasks An optional collection of extra tasks to include in the response, regardless of whether they are active or not (optional)
   * @return ApiResponse&lt;TimeRegistrationsByTaskResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<TimeRegistrationsByTaskResponse> getTaskTimeRegistrationsOverviewWithHttpInfo(LocalDate date, OverviewPeriod period, List<Long> extraTasks) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getTaskTimeRegistrationsOverviewRequestBuilder(date, period, extraTasks);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getTaskTimeRegistrationsOverview", localVarResponse);
        }
        return new ApiResponse<TimeRegistrationsByTaskResponse>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<TimeRegistrationsByTaskResponse>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getTaskTimeRegistrationsOverviewRequestBuilder(LocalDate date, OverviewPeriod period, List<Long> extraTasks) throws ApiException {
    // verify the required parameter 'date' is set
    if (date == null) {
      throw new ApiException(400, "Missing the required parameter 'date' when calling getTaskTimeRegistrationsOverview");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/time-registration/active-task";

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "date";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("date", date));
    localVarQueryParameterBaseName = "period";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("period", period));
    localVarQueryParameterBaseName = "extraTasks";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("multi", "extraTasks", extraTasks));

    if (!localVarQueryParams.isEmpty() || localVarQueryStringJoiner.length() != 0) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      if (localVarQueryStringJoiner.length() != 0) {
        queryJoiner.add(localVarQueryStringJoiner.toString());
      }
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Accept", "application/json, text/plain");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * 
   * Returns time registrations that belongs to a user
   * @return List&lt;TimeRegistrationResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public List<TimeRegistrationResponse> getTimeRegistrationsForUser() throws ApiException {
    ApiResponse<List<TimeRegistrationResponse>> localVarResponse = getTimeRegistrationsForUserWithHttpInfo();
    return localVarResponse.getData();
  }

  /**
   * 
   * Returns time registrations that belongs to a user
   * @return ApiResponse&lt;List&lt;TimeRegistrationResponse&gt;&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<List<TimeRegistrationResponse>> getTimeRegistrationsForUserWithHttpInfo() throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getTimeRegistrationsForUserRequestBuilder();
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getTimeRegistrationsForUser", localVarResponse);
        }
        return new ApiResponse<List<TimeRegistrationResponse>>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<List<TimeRegistrationResponse>>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getTimeRegistrationsForUserRequestBuilder() throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/time-registration";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * 
   * Updates the specified time registration
   * @param timeRegistrationId The id of the time registration to update (required)
   * @param timeRegistrationUpdateRequest  (required)
   * @return DefaultCreateResponse
   * @throws ApiException if fails to make API call
   */
  public DefaultCreateResponse updateTimeRegistrationForUser(Long timeRegistrationId, TimeRegistrationUpdateRequest timeRegistrationUpdateRequest) throws ApiException {
    ApiResponse<DefaultCreateResponse> localVarResponse = updateTimeRegistrationForUserWithHttpInfo(timeRegistrationId, timeRegistrationUpdateRequest);
    return localVarResponse.getData();
  }

  /**
   * 
   * Updates the specified time registration
   * @param timeRegistrationId The id of the time registration to update (required)
   * @param timeRegistrationUpdateRequest  (required)
   * @return ApiResponse&lt;DefaultCreateResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<DefaultCreateResponse> updateTimeRegistrationForUserWithHttpInfo(Long timeRegistrationId, TimeRegistrationUpdateRequest timeRegistrationUpdateRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = updateTimeRegistrationForUserRequestBuilder(timeRegistrationId, timeRegistrationUpdateRequest);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("updateTimeRegistrationForUser", localVarResponse);
        }
        return new ApiResponse<DefaultCreateResponse>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<DefaultCreateResponse>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder updateTimeRegistrationForUserRequestBuilder(Long timeRegistrationId, TimeRegistrationUpdateRequest timeRegistrationUpdateRequest) throws ApiException {
    // verify the required parameter 'timeRegistrationId' is set
    if (timeRegistrationId == null) {
      throw new ApiException(400, "Missing the required parameter 'timeRegistrationId' when calling updateTimeRegistrationForUser");
    }
    // verify the required parameter 'timeRegistrationUpdateRequest' is set
    if (timeRegistrationUpdateRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'timeRegistrationUpdateRequest' when calling updateTimeRegistrationForUser");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/time-registration";

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "timeRegistrationId";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("timeRegistrationId", timeRegistrationId));

    if (!localVarQueryParams.isEmpty() || localVarQueryStringJoiner.length() != 0) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      if (localVarQueryStringJoiner.length() != 0) {
        queryJoiner.add(localVarQueryStringJoiner.toString());
      }
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json, text/plain");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(timeRegistrationUpdateRequest);
      localVarRequestBuilder.method("PUT", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
}
