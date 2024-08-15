package com.trifork.trireg.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * TimeRegistrationsByTaskResponseInnerTimeRegistrationsInner
 */

@JsonTypeName("TimeRegistrationsByTaskResponse_inner_timeRegistrations_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-15T11:01:35.044401800+02:00[Europe/Copenhagen]", comments = "Generator version: 7.4.0")
public class TimeRegistrationsByTaskResponseInnerTimeRegistrationsInner {

  private Long timeRegistrationId;

  private Long registered;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate date;

  private String duration;

  private String status;

  public TimeRegistrationsByTaskResponseInnerTimeRegistrationsInner() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TimeRegistrationsByTaskResponseInnerTimeRegistrationsInner(Long timeRegistrationId, Long registered, LocalDate date, String duration, String status) {
    this.timeRegistrationId = timeRegistrationId;
    this.registered = registered;
    this.date = date;
    this.duration = duration;
    this.status = status;
  }

  public TimeRegistrationsByTaskResponseInnerTimeRegistrationsInner timeRegistrationId(Long timeRegistrationId) {
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

  public TimeRegistrationsByTaskResponseInnerTimeRegistrationsInner registered(Long registered) {
    this.registered = registered;
    return this;
  }

  /**
   * The registered time value as Unix milliseconds timestamp
   * @return registered
  */
  @NotNull 
  @Schema(name = "registered", description = "The registered time value as Unix milliseconds timestamp", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("registered")
  public Long getRegistered() {
    return registered;
  }

  public void setRegistered(Long registered) {
    this.registered = registered;
  }

  public TimeRegistrationsByTaskResponseInnerTimeRegistrationsInner date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
  */
  @NotNull @Valid 
  @Schema(name = "date", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("date")
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public TimeRegistrationsByTaskResponseInnerTimeRegistrationsInner duration(String duration) {
    this.duration = duration;
    return this;
  }

  /**
   * ISO 8601 formatted duration component <PnDTnHnMn.nS>. Each unit is optional, but at least one must be specified
   * @return duration
  */
  @NotNull 
  @Schema(name = "duration", example = "PT1H30M", description = "ISO 8601 formatted duration component <PnDTnHnMn.nS>. Each unit is optional, but at least one must be specified", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("duration")
  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public TimeRegistrationsByTaskResponseInnerTimeRegistrationsInner status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Describes the status of the time registration (PENDING, VALID, INVALID)
   * @return status
  */
  @NotNull 
  @Schema(name = "status", description = "Describes the status of the time registration (PENDING, VALID, INVALID)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimeRegistrationsByTaskResponseInnerTimeRegistrationsInner timeRegistrationsByTaskResponseInnerTimeRegistrationsInner = (TimeRegistrationsByTaskResponseInnerTimeRegistrationsInner) o;
    return Objects.equals(this.timeRegistrationId, timeRegistrationsByTaskResponseInnerTimeRegistrationsInner.timeRegistrationId) &&
        Objects.equals(this.registered, timeRegistrationsByTaskResponseInnerTimeRegistrationsInner.registered) &&
        Objects.equals(this.date, timeRegistrationsByTaskResponseInnerTimeRegistrationsInner.date) &&
        Objects.equals(this.duration, timeRegistrationsByTaskResponseInnerTimeRegistrationsInner.duration) &&
        Objects.equals(this.status, timeRegistrationsByTaskResponseInnerTimeRegistrationsInner.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timeRegistrationId, registered, date, duration, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimeRegistrationsByTaskResponseInnerTimeRegistrationsInner {\n");
    sb.append("    timeRegistrationId: ").append(toIndentedString(timeRegistrationId)).append("\n");
    sb.append("    registered: ").append(toIndentedString(registered)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

