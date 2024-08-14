package com.trifork.trireg.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * UpdateTagRegistrationRequest
 */

@JsonTypeName("updateTagRegistration_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-13T16:52:07.953210+02:00[Europe/Copenhagen]", comments = "Generator version: 7.4.0")
public class UpdateTagRegistrationRequest {

  private Long tagId;

  private String value;

  public UpdateTagRegistrationRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UpdateTagRegistrationRequest(Long tagId, String value) {
    this.tagId = tagId;
    this.value = value;
  }

  public UpdateTagRegistrationRequest tagId(Long tagId) {
    this.tagId = tagId;
    return this;
  }

  /**
   * Get tagId
   * @return tagId
  */
  @NotNull 
  @Schema(name = "tagId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("tagId")
  public Long getTagId() {
    return tagId;
  }

  public void setTagId(Long tagId) {
    this.tagId = tagId;
  }

  public UpdateTagRegistrationRequest value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
  */
  @NotNull 
  @Schema(name = "value", requiredMode = Schema.RequiredMode.REQUIRED)
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
    UpdateTagRegistrationRequest updateTagRegistrationRequest = (UpdateTagRegistrationRequest) o;
    return Objects.equals(this.tagId, updateTagRegistrationRequest.tagId) &&
        Objects.equals(this.value, updateTagRegistrationRequest.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tagId, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateTagRegistrationRequest {\n");
    sb.append("    tagId: ").append(toIndentedString(tagId)).append("\n");
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

