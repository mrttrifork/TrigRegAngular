package com.trifork.trireg.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.trifork.trireg.server.model.TimeRegistrationsByTaskResponseInnerTimeRegistrationsInner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * TimeRegistrationsByTaskResponseInner
 */

@JsonTypeName("TimeRegistrationsByTaskResponse_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-13T16:52:07.953210+02:00[Europe/Copenhagen]", comments = "Generator version: 7.4.0")
public class TimeRegistrationsByTaskResponseInner {

  private Long taskId;

  private String taskName;

  private String taskDescription;

  @Valid
  private List<@Valid TimeRegistrationsByTaskResponseInnerTimeRegistrationsInner> timeRegistrations;

  public TimeRegistrationsByTaskResponseInner taskId(Long taskId) {
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

  public TimeRegistrationsByTaskResponseInner taskName(String taskName) {
    this.taskName = taskName;
    return this;
  }

  /**
   * Get taskName
   * @return taskName
  */
  
  @Schema(name = "taskName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("taskName")
  public String getTaskName() {
    return taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  public TimeRegistrationsByTaskResponseInner taskDescription(String taskDescription) {
    this.taskDescription = taskDescription;
    return this;
  }

  /**
   * Get taskDescription
   * @return taskDescription
  */
  
  @Schema(name = "taskDescription", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("taskDescription")
  public String getTaskDescription() {
    return taskDescription;
  }

  public void setTaskDescription(String taskDescription) {
    this.taskDescription = taskDescription;
  }

  public TimeRegistrationsByTaskResponseInner timeRegistrations(List<@Valid TimeRegistrationsByTaskResponseInnerTimeRegistrationsInner> timeRegistrations) {
    this.timeRegistrations = timeRegistrations;
    return this;
  }

  public TimeRegistrationsByTaskResponseInner addTimeRegistrationsItem(TimeRegistrationsByTaskResponseInnerTimeRegistrationsInner timeRegistrationsItem) {
    if (this.timeRegistrations == null) {
      this.timeRegistrations = new ArrayList<>();
    }
    this.timeRegistrations.add(timeRegistrationsItem);
    return this;
  }

  /**
   * Get timeRegistrations
   * @return timeRegistrations
  */
  @Valid 
  @Schema(name = "timeRegistrations", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("timeRegistrations")
  public List<@Valid TimeRegistrationsByTaskResponseInnerTimeRegistrationsInner> getTimeRegistrations() {
    return timeRegistrations;
  }

  public void setTimeRegistrations(List<@Valid TimeRegistrationsByTaskResponseInnerTimeRegistrationsInner> timeRegistrations) {
    this.timeRegistrations = timeRegistrations;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimeRegistrationsByTaskResponseInner timeRegistrationsByTaskResponseInner = (TimeRegistrationsByTaskResponseInner) o;
    return Objects.equals(this.taskId, timeRegistrationsByTaskResponseInner.taskId) &&
        Objects.equals(this.taskName, timeRegistrationsByTaskResponseInner.taskName) &&
        Objects.equals(this.taskDescription, timeRegistrationsByTaskResponseInner.taskDescription) &&
        Objects.equals(this.timeRegistrations, timeRegistrationsByTaskResponseInner.timeRegistrations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taskId, taskName, taskDescription, timeRegistrations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimeRegistrationsByTaskResponseInner {\n");
    sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
    sb.append("    taskName: ").append(toIndentedString(taskName)).append("\n");
    sb.append("    taskDescription: ").append(toIndentedString(taskDescription)).append("\n");
    sb.append("    timeRegistrations: ").append(toIndentedString(timeRegistrations)).append("\n");
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

