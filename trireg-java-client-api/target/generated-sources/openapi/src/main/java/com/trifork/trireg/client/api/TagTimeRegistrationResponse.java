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
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * TagTimeRegistrationResponse
 */
@JsonPropertyOrder({
  TagTimeRegistrationResponse.JSON_PROPERTY_TAG_CONFIGURATION_ID,
  TagTimeRegistrationResponse.JSON_PROPERTY_TAG_VALUE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-19T11:41:25.998809700+02:00[Europe/Copenhagen]", comments = "Generator version: 7.4.0")
public class TagTimeRegistrationResponse {
  public static final String JSON_PROPERTY_TAG_CONFIGURATION_ID = "tagConfigurationId";
  private Long tagConfigurationId;

  public static final String JSON_PROPERTY_TAG_VALUE = "tagValue";
  private String tagValue;

  public TagTimeRegistrationResponse() { 
  }

  public TagTimeRegistrationResponse tagConfigurationId(Long tagConfigurationId) {
    this.tagConfigurationId = tagConfigurationId;
    return this;
  }

   /**
   * Get tagConfigurationId
   * @return tagConfigurationId
  **/
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_TAG_CONFIGURATION_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getTagConfigurationId() {
    return tagConfigurationId;
  }


  @JsonProperty(JSON_PROPERTY_TAG_CONFIGURATION_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTagConfigurationId(Long tagConfigurationId) {
    this.tagConfigurationId = tagConfigurationId;
  }


  public TagTimeRegistrationResponse tagValue(String tagValue) {
    this.tagValue = tagValue;
    return this;
  }

   /**
   * Get tagValue
   * @return tagValue
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TAG_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTagValue() {
    return tagValue;
  }


  @JsonProperty(JSON_PROPERTY_TAG_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTagValue(String tagValue) {
    this.tagValue = tagValue;
  }


  /**
   * Return true if this TagTimeRegistrationResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TagTimeRegistrationResponse tagTimeRegistrationResponse = (TagTimeRegistrationResponse) o;
    return Objects.equals(this.tagConfigurationId, tagTimeRegistrationResponse.tagConfigurationId) &&
        Objects.equals(this.tagValue, tagTimeRegistrationResponse.tagValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tagConfigurationId, tagValue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TagTimeRegistrationResponse {\n");
    sb.append("    tagConfigurationId: ").append(toIndentedString(tagConfigurationId)).append("\n");
    sb.append("    tagValue: ").append(toIndentedString(tagValue)).append("\n");
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

    // add `tagConfigurationId` to the URL query string
    if (getTagConfigurationId() != null) {
      joiner.add(String.format("%stagConfigurationId%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getTagConfigurationId()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `tagValue` to the URL query string
    if (getTagValue() != null) {
      joiner.add(String.format("%stagValue%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getTagValue()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    return joiner.toString();
  }
}

