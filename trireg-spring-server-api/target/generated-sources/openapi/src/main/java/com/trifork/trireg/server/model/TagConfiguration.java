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
 * TagConfiguration
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-19T11:41:29.305516100+02:00[Europe/Copenhagen]", comments = "Generator version: 7.4.0")
public class TagConfiguration {

  private Long tagConfigurationId;

  private String value;

  public TagConfiguration() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TagConfiguration(Long tagConfigurationId) {
    this.tagConfigurationId = tagConfigurationId;
  }

  public TagConfiguration tagConfigurationId(Long tagConfigurationId) {
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

  public TagConfiguration value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
  */
  
  @Schema(name = "value", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("value")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TagConfiguration tagConfiguration = (TagConfiguration) o;
    return Objects.equals(this.tagConfigurationId, tagConfiguration.tagConfigurationId) &&
        Objects.equals(this.value, tagConfiguration.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tagConfigurationId, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TagConfiguration {\n");
    sb.append("    tagConfigurationId: ").append(toIndentedString(tagConfigurationId)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

