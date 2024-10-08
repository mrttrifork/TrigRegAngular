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
import com.trifork.trireg.client.api.TagRegistration;
import com.trifork.trireg.client.api.TagTimeRegistrationRequest;
import com.trifork.trireg.client.api.TimeRegistrationTag;

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
public class TagApi {
  private final HttpClient memberVarHttpClient;
  private final ObjectMapper memberVarObjectMapper;
  private final String memberVarBaseUri;
  private final Consumer<HttpRequest.Builder> memberVarInterceptor;
  private final Duration memberVarReadTimeout;
  private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;
  private final Consumer<HttpResponse<String>> memberVarAsyncResponseInterceptor;

  public TagApi() {
    this(new ApiClient());
  }

  public TagApi(ApiClient apiClient) {
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
   * Deletes a tag that was added to a time registration
   * @param tagId The ID of the tag to delete (required)
   * @return DefaultDeleteResponse
   * @throws ApiException if fails to make API call
   */
  public DefaultDeleteResponse deleteTagRegistration(Long tagId) throws ApiException {
    ApiResponse<DefaultDeleteResponse> localVarResponse = deleteTagRegistrationWithHttpInfo(tagId);
    return localVarResponse.getData();
  }

  /**
   * 
   * Deletes a tag that was added to a time registration
   * @param tagId The ID of the tag to delete (required)
   * @return ApiResponse&lt;DefaultDeleteResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<DefaultDeleteResponse> deleteTagRegistrationWithHttpInfo(Long tagId) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = deleteTagRegistrationRequestBuilder(tagId);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("deleteTagRegistration", localVarResponse);
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

  private HttpRequest.Builder deleteTagRegistrationRequestBuilder(Long tagId) throws ApiException {
    // verify the required parameter 'tagId' is set
    if (tagId == null) {
      throw new ApiException(400, "Missing the required parameter 'tagId' when calling deleteTagRegistration");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/tag";

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "tagId";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("tagId", tagId));

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

    localVarRequestBuilder.header("Accept", "application/json");

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
   * Gets the tags associated with the specified time registration. This includes both the tags that have already been added, and the ones that can be added. 
   * @param timeRegistrationId The ID of the time registration to get tags for (required)
   * @return List&lt;TimeRegistrationTag&gt;
   * @throws ApiException if fails to make API call
   */
  public List<TimeRegistrationTag> getTimeRegistrationTags(Long timeRegistrationId) throws ApiException {
    ApiResponse<List<TimeRegistrationTag>> localVarResponse = getTimeRegistrationTagsWithHttpInfo(timeRegistrationId);
    return localVarResponse.getData();
  }

  /**
   * 
   * Gets the tags associated with the specified time registration. This includes both the tags that have already been added, and the ones that can be added. 
   * @param timeRegistrationId The ID of the time registration to get tags for (required)
   * @return ApiResponse&lt;List&lt;TimeRegistrationTag&gt;&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<List<TimeRegistrationTag>> getTimeRegistrationTagsWithHttpInfo(Long timeRegistrationId) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getTimeRegistrationTagsRequestBuilder(timeRegistrationId);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getTimeRegistrationTags", localVarResponse);
        }
        return new ApiResponse<List<TimeRegistrationTag>>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<List<TimeRegistrationTag>>() {}) // closes the InputStream
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

  private HttpRequest.Builder getTimeRegistrationTagsRequestBuilder(Long timeRegistrationId) throws ApiException {
    // verify the required parameter 'timeRegistrationId' is set
    if (timeRegistrationId == null) {
      throw new ApiException(400, "Missing the required parameter 'timeRegistrationId' when calling getTimeRegistrationTags");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/tag";

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
   * Tags a time registration with a specified tag and tag value
   * @param timeRegistrationId The ID of the time registration to add a tag to (required)
   * @param tagTimeRegistrationRequest A JSON object containing tag information (required)
   * @return DefaultCreateResponse
   * @throws ApiException if fails to make API call
   */
  public DefaultCreateResponse tagTimeRegistration(Long timeRegistrationId, TagTimeRegistrationRequest tagTimeRegistrationRequest) throws ApiException {
    ApiResponse<DefaultCreateResponse> localVarResponse = tagTimeRegistrationWithHttpInfo(timeRegistrationId, tagTimeRegistrationRequest);
    return localVarResponse.getData();
  }

  /**
   * 
   * Tags a time registration with a specified tag and tag value
   * @param timeRegistrationId The ID of the time registration to add a tag to (required)
   * @param tagTimeRegistrationRequest A JSON object containing tag information (required)
   * @return ApiResponse&lt;DefaultCreateResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<DefaultCreateResponse> tagTimeRegistrationWithHttpInfo(Long timeRegistrationId, TagTimeRegistrationRequest tagTimeRegistrationRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = tagTimeRegistrationRequestBuilder(timeRegistrationId, tagTimeRegistrationRequest);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("tagTimeRegistration", localVarResponse);
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

  private HttpRequest.Builder tagTimeRegistrationRequestBuilder(Long timeRegistrationId, TagTimeRegistrationRequest tagTimeRegistrationRequest) throws ApiException {
    // verify the required parameter 'timeRegistrationId' is set
    if (timeRegistrationId == null) {
      throw new ApiException(400, "Missing the required parameter 'timeRegistrationId' when calling tagTimeRegistration");
    }
    // verify the required parameter 'tagTimeRegistrationRequest' is set
    if (tagTimeRegistrationRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'tagTimeRegistrationRequest' when calling tagTimeRegistration");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/tag";

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
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(tagTimeRegistrationRequest);
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
   * Updates a tag that was added to a time registration
   * @param tagRegistration A JSON object containing the updated tag information (required)
   * @return DefaultUpdateResponse
   * @throws ApiException if fails to make API call
   */
  public DefaultUpdateResponse updateTagRegistration(TagRegistration tagRegistration) throws ApiException {
    ApiResponse<DefaultUpdateResponse> localVarResponse = updateTagRegistrationWithHttpInfo(tagRegistration);
    return localVarResponse.getData();
  }

  /**
   * 
   * Updates a tag that was added to a time registration
   * @param tagRegistration A JSON object containing the updated tag information (required)
   * @return ApiResponse&lt;DefaultUpdateResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<DefaultUpdateResponse> updateTagRegistrationWithHttpInfo(TagRegistration tagRegistration) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = updateTagRegistrationRequestBuilder(tagRegistration);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("updateTagRegistration", localVarResponse);
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

  private HttpRequest.Builder updateTagRegistrationRequestBuilder(TagRegistration tagRegistration) throws ApiException {
    // verify the required parameter 'tagRegistration' is set
    if (tagRegistration == null) {
      throw new ApiException(400, "Missing the required parameter 'tagRegistration' when calling updateTagRegistration");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/tag";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(tagRegistration);
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
