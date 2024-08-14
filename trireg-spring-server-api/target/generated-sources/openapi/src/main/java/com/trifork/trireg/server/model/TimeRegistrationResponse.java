package com.trifork.trireg.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * TimeRegistrationResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-13T16:52:07.953210+02:00[Europe/Copenhagen]", comments = "Generator version: 7.4.0")
public class TimeRegistrationResponse {

  private Long timeRegistrationId;

  private Long registered;

  private Long userId;

  private Long taskId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate date;

  private String duration;

  private String status;

  public TimeRegistrationResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TimeRegistrationResponse(Long timeRegistrationId, Long registered, Long userId, Long taskId, LocalDate date, String duration, String status) {
    this.timeRegistrationId = timeRegistrationId;
    this.registered = registered;
    this.userId = userId;
    this.taskId = taskId;
    this.date = date;
    this.duration = duration;
    this.status = status;
  }

  public TimeRegistrationResponse timeRegistrationId(Long timeRegistrationId) {
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

  public TimeRegistrationResponse registered(Long registered) {
    this.registered = registered;
    return this;
  }

  /**
   * The registration time as Unix milliseconds timestamp
   * @return registered
  */
  @NotNull 
  @Schema(name = "registered", description = "The registration time as Unix milliseconds timestamp", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("registered")
  public Long getRegistered() {
    return registered;
  }

  public void setRegistered(Long registered) {
    this.registered = registered;
  }

  public TimeRegistrationResponse userId(Long userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  */
  @NotNull 
  @Schema(name = "userId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("userId")
  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public TimeRegistrationResponse taskId(Long taskId) {
    this.taskId = taskId;
    return this;
  }

  /**
   * Get taskId
   * @return taskId
  */
  @NotNull 
  @Schema(name = "taskId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("taskId")
  public Long getTaskId() {
    return taskId;
  }

  public void setTaskId(Long taskId) {
    this.taskId = taskId;
  }

  public TimeRegistrationResponse date(LocalDate date) {
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

  public TimeRegistrationResponse duration(String duration) {
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

  public TimeRegistrationResponse status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Describes the status of the time registration
   * @return status
  */
  @NotNull 
  @Schema(name = "status", description = "Describes the status of the time registration", requiredMode = Schema.RequiredMode.REQUIRED)
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
    TimeRegistrationResponse timeRegistrationResponse = (TimeRegistrationResponse) o;
    return Objects.equals(this.timeRegistrationId, timeRegistrationResponse.timeRegistrationId) &&
        Objects.equals(this.registered, timeRegistrationResponse.registered) &&
        Objects.equals(this.userId, timeRegistrationResponse.userId) &&
        Objects.equals(this.taskId, timeRegistrationResponse.taskId) &&
        Objects.equals(this.date, timeRegistrationResponse.date) &&
        Objects.equals(this.duration, timeRegistrationResponse.duration) &&
        Objects.equals(this.status, timeRegistrationResponse.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timeRegistrationId, registered, userId, taskId, date, duration, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimeRegistrationResponse {\n");
    sb.append("    timeRegistrationId: ").append(toIndentedString(timeRegistrationId)).append("\n");
    sb.append("    registered: ").append(toIndentedString(registered)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
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

