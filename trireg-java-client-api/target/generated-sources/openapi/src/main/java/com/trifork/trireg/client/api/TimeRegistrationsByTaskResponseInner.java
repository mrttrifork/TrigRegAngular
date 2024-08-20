/*
 * TriReg2 User API
 * An OpenAPI specification for time registrations to be used by a user
 *
 * The version of the OpenAPI document: 0.2.0
 * Contact: example@example.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.trifork.trireg.client.api;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.StringJoiner;
import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.trifork.trireg.client.api.TimeRegistrationsByTaskResponseInnerTimeRegistrationsInner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * TimeRegistrationsByTaskResponseInner
 */
@JsonPropertyOrder({
  TimeRegistrationsByTaskResponseInner.JSON_PROPERTY_TASK_ID,
  TimeRegistrationsByTaskResponseInner.JSON_PROPERTY_TASK_NAME,
  TimeRegistrationsByTaskResponseInner.JSON_PROPERTY_TASK_DESCRIPTION,
  TimeRegistrationsByTaskResponseInner.JSON_PROPERTY_TIME_REGISTRATIONS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-19T11:41:25.998809700+02:00[Europe/Copenhagen]", comments = "Generator version: 7.4.0")
public class TimeRegistrationsByTaskResponseInner {
  public static final String JSON_PROPERTY_TASK_ID = "taskId";
  private Long taskId;

  public static final String JSON_PROPERTY_TASK_NAME = "taskName";
  private String taskName;

  public static final String JSON_PROPERTY_TASK_DESCRIPTION = "taskDescription";
  private String taskDescription;

  public static final String JSON_PROPERTY_TIME_REGISTRATIONS = "timeRegistrations";
  private List<TimeRegistrationsByTaskResponseInnerTimeRegistrationsInner> timeRegistrations;

  public TimeRegistrationsByTaskResponseInner() { 
  }

  public TimeRegistrationsByTaskResponseInner taskId(Long taskId) {
    this.taskId = taskId;
    return this;
  }

   /**
   * Get taskId
   * @return taskId
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TASK_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getTaskId() {
    return taskId;
  }


  @JsonProperty(JSON_PROPERTY_TASK_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
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
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TASK_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTaskName() {
    return taskName;
  }


  @JsonProperty(JSON_PROPERTY_TASK_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
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
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TASK_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTaskDescription() {
    return taskDescription;
  }


  @JsonProperty(JSON_PROPERTY_TASK_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTaskDescription(String taskDescription) {
    this.taskDescription = taskDescription;
  }


  public TimeRegistrationsByTaskResponseInner timeRegistrations(List<TimeRegistrationsByTaskResponseInnerTimeRegistrationsInner> timeRegistrations) {
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
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TIME_REGISTRATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<TimeRegistrationsByTaskResponseInnerTimeRegistrationsInner> getTimeRegistrations() {
    return timeRegistrations;
  }


  @JsonProperty(JSON_PROPERTY_TIME_REGISTRATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTimeRegistrations(List<TimeRegistrationsByTaskResponseInnerTimeRegistrationsInner> timeRegistrations) {
    this.timeRegistrations = timeRegistrations;
  }


  /**
   * Return true if this TimeRegistrationsByTaskResponse_inner object is equal to o.
   */
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

  /**
   * Convert the instance into URL query string.
   *
   * @return URL query string
   */
  public String toUrlQueryString() {
    return toUrlQueryString(null);
  }

  /**
   * Convert the instance into URL query string.
   *
   * @param prefix prefix of the query string
   * @return URL query string
   */
  public String toUrlQueryString(String prefix) {
    String suffix = "";
    String containerSuffix = "";
    String containerPrefix = "";
    if (prefix == null) {
      // style=form, explode=true, e.g. /pet?name=cat&type=manx
      prefix = "";
    } else {
      // deepObject style e.g. /pet?id[name]=cat&id[type]=manx
      prefix = prefix + "[";
      suffix = "]";
      containerSuffix = "]";
      containerPrefix = "[";
    }

    StringJoiner joiner = new StringJoiner("&");

    // add `taskId` to the URL query string
    if (getTaskId() != null) {
      joiner.add(String.format("%staskId%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getTaskId()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `taskName` to the URL query string
    if (getTaskName() != null) {
      joiner.add(String.format("%staskName%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getTaskName()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `taskDescription` to the URL query string
    if (getTaskDescription() != null) {
      joiner.add(String.format("%staskDescription%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getTaskDescription()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `timeRegistrations` to the URL query string
    if (getTimeRegistrations() != null) {
      for (int i = 0; i < getTimeRegistrations().size(); i++) {
        if (getTimeRegistrations().get(i) != null) {
          joiner.add(getTimeRegistrations().get(i).toUrlQueryString(String.format("%stimeRegistrations%s%s", prefix, suffix,
          "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    return joiner.toString();
  }
}

