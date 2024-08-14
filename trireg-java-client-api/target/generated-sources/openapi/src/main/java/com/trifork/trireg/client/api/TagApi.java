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

import com.trifork.trireg.client.api.TagTimeRegistrationRequest;
import com.trifork.trireg.client.api.TagTimeRegistrationResponse;
import com.trifork.trireg.client.api.UpdateTagRegistrationRequest;

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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-13T16:52:04.325230800+02:00[Europe/Copenhagen]", comments = "Generator version: 7.4.0")
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
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String deleteTagRegistration(Long tagId) throws ApiException {
    ApiResponse<String> localVarResponse = deleteTagRegistrationWithHttpInfo(tagId);
    return localVarResponse.getData();
  }

  /**
   * 
   * Deletes a tag that was added to a time registration
   * @param tagId The ID of the tag to delete (required)
   * @return ApiResponse&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<String> deleteTagRegistrationWithHttpInfo(Long tagId) throws ApiException {
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
        // for plain text response
        if (localVarResponse.headers().map().containsKey("Content-Type") &&
                "text/plain".equalsIgnoreCase(localVarResponse.headers().map().get("Content-Type").get(0).split(";")[0].trim())) {
          java.util.Scanner s = new java.util.Scanner(localVarResponse.body()).useDelimiter("\\A");
          String responseBodyText = s.hasNext() ? s.next() : "";
          return new ApiResponse<String>(
                  localVarResponse.statusCode(),
                  localVarResponse.headers().map(),
                  responseBodyText
          );
        } else {
            throw new RuntimeException("Error! The response Content-Type is supposed to be `text/plain` but it's not: " + localVarResponse);
        }
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

    localVarRequestBuilder.header("Accept", "text/plain");

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
   * Gets the tags associated with the given time registration
   * @param timeRegistrationId The ID of the time registration to get tags for (required)
   * @return List&lt;TagTimeRegistrationResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public List<TagTimeRegistrationResponse> getTimeRegistrationTags(Long timeRegistrationId) throws ApiException {
    ApiResponse<List<TagTimeRegistrationResponse>> localVarResponse = getTimeRegistrationTagsWithHttpInfo(timeRegistrationId);
    return localVarResponse.getData();
  }

  /**
   * 
   * Gets the tags associated with the given time registration
   * @param timeRegistrationId The ID of the time registration to get tags for (required)
   * @return ApiResponse&lt;List&lt;TagTimeRegistrationResponse&gt;&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<List<TagTimeRegistrationResponse>> getTimeRegistrationTagsWithHttpInfo(Long timeRegistrationId) throws ApiException {
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
        return new ApiResponse<List<TagTimeRegistrationResponse>>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<List<TagTimeRegistrationResponse>>() {}) // closes the InputStream
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
   * Tags a time registration with a specified tag and optional tag value
   * @param tagTimeRegistrationRequest A JSON object containing tag information (required)
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String tagTimeRegistration(TagTimeRegistrationRequest tagTimeRegistrationRequest) throws ApiException {
    ApiResponse<String> localVarResponse = tagTimeRegistrationWithHttpInfo(tagTimeRegistrationRequest);
    return localVarResponse.getData();
  }

  /**
   * 
   * Tags a time registration with a specified tag and optional tag value
   * @param tagTimeRegistrationRequest A JSON object containing tag information (required)
   * @return ApiResponse&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<String> tagTimeRegistrationWithHttpInfo(TagTimeRegistrationRequest tagTimeRegistrationRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = tagTimeRegistrationRequestBuilder(tagTimeRegistrationRequest);
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
        // for plain text response
        if (localVarResponse.headers().map().containsKey("Content-Type") &&
                "text/plain".equalsIgnoreCase(localVarResponse.headers().map().get("Content-Type").get(0).split(";")[0].trim())) {
          java.util.Scanner s = new java.util.Scanner(localVarResponse.body()).useDelimiter("\\A");
          String responseBodyText = s.hasNext() ? s.next() : "";
          return new ApiResponse<String>(
                  localVarResponse.statusCode(),
                  localVarResponse.headers().map(),
                  responseBodyText
          );
        } else {
            throw new RuntimeException("Error! The response Content-Type is supposed to be `text/plain` but it's not: " + localVarResponse);
        }
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

  private HttpRequest.Builder tagTimeRegistrationRequestBuilder(TagTimeRegistrationRequest tagTimeRegistrationRequest) throws ApiException {
    // verify the required parameter 'tagTimeRegistrationRequest' is set
    if (tagTimeRegistrationRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'tagTimeRegistrationRequest' when calling tagTimeRegistration");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/tag";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "text/plain");

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
   * @param updateTagRegistrationRequest A JSON object containing the updated tag information (required)
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String updateTagRegistration(UpdateTagRegistrationRequest updateTagRegistrationRequest) throws ApiException {
    ApiResponse<String> localVarResponse = updateTagRegistrationWithHttpInfo(updateTagRegistrationRequest);
    return localVarResponse.getData();
  }

  /**
   * 
   * Updates a tag that was added to a time registration
   * @param updateTagRegistrationRequest A JSON object containing the updated tag information (required)
   * @return ApiResponse&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<String> updateTagRegistrationWithHttpInfo(UpdateTagRegistrationRequest updateTagRegistrationRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = updateTagRegistrationRequestBuilder(updateTagRegistrationRequest);
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
        // for plain text response
        if (localVarResponse.headers().map().containsKey("Content-Type") &&
                "text/plain".equalsIgnoreCase(localVarResponse.headers().map().get("Content-Type").get(0).split(";")[0].trim())) {
          java.util.Scanner s = new java.util.Scanner(localVarResponse.body()).useDelimiter("\\A");
          String responseBodyText = s.hasNext() ? s.next() : "";
          return new ApiResponse<String>(
                  localVarResponse.statusCode(),
                  localVarResponse.headers().map(),
                  responseBodyText
          );
        } else {
            throw new RuntimeException("Error! The response Content-Type is supposed to be `text/plain` but it's not: " + localVarResponse);
        }
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

  private HttpRequest.Builder updateTagRegistrationRequestBuilder(UpdateTagRegistrationRequest updateTagRegistrationRequest) throws ApiException {
    // verify the required parameter 'updateTagRegistrationRequest' is set
    if (updateTagRegistrationRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'updateTagRegistrationRequest' when calling updateTagRegistration");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/tag";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "text/plain");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(updateTagRegistrationRequest);
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
