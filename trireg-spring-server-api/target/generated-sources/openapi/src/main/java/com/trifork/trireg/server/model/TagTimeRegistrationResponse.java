package com.trifork.trireg.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * TagTimeRegistrationResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-19T11:41:29.305516100+02:00[Europe/Copenhagen]", comments = "Generator version: 7.4.0")
public class TagTimeRegistrationResponse {

  private Long tagConfigurationId;

  private String tagValue;

  public TagTimeRegistrationResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TagTimeRegistrationResponse(Long tagConfigurationId) {
    this.tagConfigurationId = tagConfigurationId;
  }

  public TagTimeRegistrationResponse tagConfigurationId(Long tagConfigurationId) {
    this.tagConfigurationId = tagConfigurationId;
    return this;
  }

  /**
   * Get tagConfigurationId
   * @return tagConfigurationId
  */
  @NotNull 
  @Schema(name = "tagConfigurationId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("tagConfigurationId")
  public Long getTagConfigurationId() {
    return tagConfigurationId;
  }

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
  */
  
  @Schema(name = "tagValue", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tagValue")
  public String getTagValue() {
    return tagValue;
  }

  public void setTagValue(String tagValue) {
    this.tagValue = tagValue;
  }

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
}

