package com.trifork.trireg.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.trifork.trireg.server.model.TimeRegistrationStatus;
import com.trifork.trireg.server.model.TimeRegistrationTag;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-20T10:30:37.943553100+02:00[Europe/Copenhagen]", comments = "Generator version: 7.4.0")
public class TimeRegistrationResponse {

  private Long timeRegistrationId;

  private Long registered;

  private Long userId;

  private Long taskId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate date;

  private String duration;

  private TimeRegistrationStatus status;

  @Valid
  private List<@Valid TimeRegistrationTag> tags = new ArrayList<>();

  private String description;

  public TimeRegistrationResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TimeRegistrationResponse(Long timeRegistrationId, Long registered, Long userId, LocalDate date, String duration, TimeRegistrationStatus status, List<@Valid TimeRegistrationTag> tags) {
    this.timeRegistrationId = timeRegistrationId;
    this.registered = registered;
    this.userId = userId;
    this.date = date;
    this.duration = duration;
    this.status = status;
    this.tags = tags;
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
  
  @Schema(name = "taskId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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

  public TimeRegistrationResponse status(TimeRegistrationStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @NotNull @Valid 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public TimeRegistrationStatus getStatus() {
    return status;
  }

  public void setStatus(TimeRegistrationStatus status) {
    this.status = status;
  }

  public TimeRegistrationResponse tags(List<@Valid TimeRegistrationTag> tags) {
    this.tags = tags;
    return this;
  }

  public TimeRegistrationResponse addTagsItem(TimeRegistrationTag tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<>();
    }
    this.tags.add(tagsItem);
    return this;
  }

  /**
   * Get tags
   * @return tags
  */
  @NotNull @Valid 
  @Schema(name = "tags", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("tags")
  public List<@Valid TimeRegistrationTag> getTags() {
    return tags;
  }

  public void setTags(List<@Valid TimeRegistrationTag> tags) {
    this.tags = tags;
  }

  public TimeRegistrationResponse description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  
  @Schema(name = "description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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
        Objects.equals(this.status, timeRegistrationResponse.status) &&
        Objects.equals(this.tags, timeRegistrationResponse.tags) &&
        Objects.equals(this.description, timeRegistrationResponse.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timeRegistrationId, registered, userId, taskId, date, duration, status, tags, description);
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
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

