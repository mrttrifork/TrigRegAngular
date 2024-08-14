package com.trifork.trireg.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.trifork.trireg.server.model.TagConfiguration;
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
 * TimeRegistrationRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-13T16:52:07.953210+02:00[Europe/Copenhagen]", comments = "Generator version: 7.4.0")
public class TimeRegistrationRequest {

  private Long taskId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate date;

  private String duration;

  @Valid
  private List<@Valid TagConfiguration> tags;

  public TimeRegistrationRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TimeRegistrationRequest(Long taskId, LocalDate date, String duration) {
    this.taskId = taskId;
    this.date = date;
    this.duration = duration;
  }

  public TimeRegistrationRequest taskId(Long taskId) {
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

  public TimeRegistrationRequest date(LocalDate date) {
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

  public TimeRegistrationRequest duration(String duration) {
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

  public TimeRegistrationRequest tags(List<@Valid TagConfiguration> tags) {
    this.tags = tags;
    return this;
  }

  public TimeRegistrationRequest addTagsItem(TagConfiguration tagsItem) {
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
  @Valid 
  @Schema(name = "tags", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tags")
  public List<@Valid TagConfiguration> getTags() {
    return tags;
  }

  public void setTags(List<@Valid TagConfiguration> tags) {
    this.tags = tags;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimeRegistrationRequest timeRegistrationRequest = (TimeRegistrationRequest) o;
    return Objects.equals(this.taskId, timeRegistrationRequest.taskId) &&
        Objects.equals(this.date, timeRegistrationRequest.date) &&
        Objects.equals(this.duration, timeRegistrationRequest.duration) &&
        Objects.equals(this.tags, timeRegistrationRequest.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taskId, date, duration, tags);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimeRegistrationRequest {\n");
    sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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

