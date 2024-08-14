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
 * ImportTimeRegistrationResponseInner
 */

@JsonTypeName("ImportTimeRegistrationResponse_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-13T16:52:07.953210+02:00[Europe/Copenhagen]", comments = "Generator version: 7.4.0")
public class ImportTimeRegistrationResponseInner {

  private Long timeRegistrationId;

  private String status;

  private String message;

  public ImportTimeRegistrationResponseInner() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ImportTimeRegistrationResponseInner(Long timeRegistrationId, String status) {
    this.timeRegistrationId = timeRegistrationId;
    this.status = status;
  }

  public ImportTimeRegistrationResponseInner timeRegistrationId(Long timeRegistrationId) {
    this.timeRegistrationId = timeRegistrationId;
    return this;
  }

  /**
   * Get timeRegistrationId
   * @return timeRegistrationId
  */
  @NotNull 
  @Schema(name = "timeRegistrationId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("timeRegistrationId")
  public Long getTimeRegistrationId() {
    return timeRegistrationId;
  }

  public void setTimeRegistrationId(Long timeRegistrationId) {
    this.timeRegistrationId = timeRegistrationId;
  }

  public ImportTimeRegistrationResponseInner status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Describes the status of importing the time registration (SUCCESS, PENDING, FAILED)
   * @return status
  */
  @NotNull 
  @Schema(name = "status", description = "Describes the status of importing the time registration (SUCCESS, PENDING, FAILED)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ImportTimeRegistrationResponseInner message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Provides a description of the import status
   * @return message
  */
  
  @Schema(name = "message", description = "Provides a description of the import status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

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
}

