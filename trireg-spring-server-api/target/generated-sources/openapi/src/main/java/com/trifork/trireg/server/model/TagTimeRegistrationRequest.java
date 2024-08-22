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
 * A request to set a tag value for a tag configuration for a time registration. Administrators configure the rules for tags for time registrations. This includes the format of the tag value, and whether tags are mandatory or optional. When setting a tag value for a time registration, the request must follow these rules. 
 */

@Schema(name = "TagTimeRegistrationRequest", description = "A request to set a tag value for a tag configuration for a time registration. Administrators configure the rules for tags for time registrations. This includes the format of the tag value, and whether tags are mandatory or optional. When setting a tag value for a time registration, the request must follow these rules. ")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-21T22:43:49.173986300+02:00[Europe/Copenhagen]", comments = "Generator version: 7.4.0")
public class TagTimeRegistrationRequest {

  private Long tagConfigurationId;

  private String value;

  public TagTimeRegistrationRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TagTimeRegistrationRequest(Long tagConfigurationId, String value) {
    this.tagConfigurationId = tagConfigurationId;
    this.value = value;
  }

  public TagTimeRegistrationRequest tagConfigurationId(Long tagConfigurationId) {
    this.tagConfigurationId = tagConfigurationId;
    return this;
  }

  /**
   * The id of the tag configuration to set a value for. This must be a valid tag configuration for the time  registration. 
   * @return tagConfigurationId
  */
  @NotNull 
  @Schema(name = "tagConfigurationId", description = "The id of the tag configuration to set a value for. This must be a valid tag configuration for the time  registration. ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("tagConfigurationId")
  public Long getTagConfigurationId() {
    return tagConfigurationId;
  }

  public void setTagConfigurationId(Long tagConfigurationId) {
    this.tagConfigurationId = tagConfigurationId;
  }

  public TagTimeRegistrationRequest value(String value) {
    this.value = value;
    return this;
  }

  /**
   * The value to set for the tag configuration. This is a string, but the format of the string is dependent on the tag configuration. For example, if the configuration specifies that the tag is an integer, then the string value must be a valid integer.
   * @return value
  */
  @NotNull 
  @Schema(name = "value", description = "The value to set for the tag configuration. This is a string, but the format of the string is dependent on the tag configuration. For example, if the configuration specifies that the tag is an integer, then the string value must be a valid integer.", requiredMode = Schema.RequiredMode.REQUIRED)
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
    TagTimeRegistrationRequest tagTimeRegistrationRequest = (TagTimeRegistrationRequest) o;
    return Objects.equals(this.tagConfigurationId, tagTimeRegistrationRequest.tagConfigurationId) &&
        Objects.equals(this.value, tagTimeRegistrationRequest.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tagConfigurationId, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TagTimeRegistrationRequest {\n");
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

