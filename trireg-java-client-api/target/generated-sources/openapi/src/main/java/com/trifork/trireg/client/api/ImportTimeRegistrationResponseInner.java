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

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.StringJoiner;
import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.trifork.trireg.client.api.ImportTimeRegistrationStatus;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ImportTimeRegistrationResponseInner
 */
@JsonPropertyOrder({
  ImportTimeRegistrationResponseInner.JSON_PROPERTY_TIME_REGISTRATION_ID,
  ImportTimeRegistrationResponseInner.JSON_PROPERTY_STATUS,
  ImportTimeRegistrationResponseInner.JSON_PROPERTY_MESSAGE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-20T10:30:34.295836300+02:00[Europe/Copenhagen]", comments = "Generator version: 7.4.0")
public class ImportTimeRegistrationResponseInner {
  public static final String JSON_PROPERTY_TIME_REGISTRATION_ID = "timeRegistrationId";
  private Long timeRegistrationId;

  public static final String JSON_PROPERTY_STATUS = "status";
  private ImportTimeRegistrationStatus status;

  public static final String JSON_PROPERTY_MESSAGE = "message";
  private String message;

  public ImportTimeRegistrationResponseInner() { 
  }

  public ImportTimeRegistrationResponseInner timeRegistrationId(Long timeRegistrationId) {
    this.timeRegistrationId = timeRegistrationId;
    return this;
  }

   /**
   * Get timeRegistrationId
   * @return timeRegistrationId
  **/
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_TIME_REGISTRATION_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getTimeRegistrationId() {
    return timeRegistrationId;
  }


  @JsonProperty(JSON_PROPERTY_TIME_REGISTRATION_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTimeRegistrationId(Long timeRegistrationId) {
    this.timeRegistrationId = timeRegistrationId;
  }


  public ImportTimeRegistrationResponseInner status(ImportTimeRegistrationStatus status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ImportTimeRegistrationStatus getStatus() {
    return status;
  }


  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStatus(ImportTimeRegistrationStatus status) {
    this.status = status;
  }


  public ImportTimeRegistrationResponseInner message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Provides a description of the import status
   * @return message
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMessage() {
    return message;
  }


  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMessage(String message) {
    this.message = message;
  }


  /**
   * Return true if this ImportTimeRegistrationResponse_inner object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImportTimeRegistrationResponseInner importTimeRegistrationResponseInner = (ImportTimeRegistrationResponseInner) o;
    return Objects.equals(this.timeRegistrationId, importTimeRegistrationResponseInner.timeRegistrationId) &&
        Objects.equals(this.status, importTimeRegistrationResponseInner.status) &&
        Objects.equals(this.message, importTimeRegistrationResponseInner.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timeRegistrationId, status, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImportTimeRegistrationResponseInner {\n");
    sb.append("    timeRegistrationId: ").append(toIndentedString(timeRegistrationId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  /**
   * Convert the instance into URL query string.
   *
   * @return URL query string
   */
  public String toUrlQueryString() {
    return toUrlQueryString(null);
  }

  /**
   * Convert the instance into URL query string.
   *
   * @param prefix prefix of the query string
   * @return URL query string
   */
  public String toUrlQueryString(String prefix) {
    String suffix = "";
    String containerSuffix = "";
    String containerPrefix = "";
    if (prefix == null) {
      // style=form, explode=true, e.g. /pet?name=cat&type=manx
      prefix = "";
    } else {
      // deepObject style e.g. /pet?id[name]=cat&id[type]=manx
      prefix = prefix + "[";
      suffix = "]";
      containerSuffix = "]";
      containerPrefix = "[";
    }

    StringJoiner joiner = new StringJoiner("&");

    // add `timeRegistrationId` to the URL query string
    if (getTimeRegistrationId() != null) {
      joiner.add(String.format("%stimeRegistrationId%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getTimeRegistrationId()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `status` to the URL query string
    if (getStatus() != null) {
      joiner.add(String.format("%sstatus%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getStatus()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `message` to the URL query string
    if (getMessage() != null) {
      joiner.add(String.format("%smessage%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getMessage()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    return joiner.toString();
  }
}

