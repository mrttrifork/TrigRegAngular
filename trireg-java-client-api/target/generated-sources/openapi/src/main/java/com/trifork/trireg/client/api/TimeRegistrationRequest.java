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
import com.trifork.trireg.client.api.TagConfiguration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * TimeRegistrationRequest
 */
@JsonPropertyOrder({
  TimeRegistrationRequest.JSON_PROPERTY_TASK_ID,
  TimeRegistrationRequest.JSON_PROPERTY_DATE,
  TimeRegistrationRequest.JSON_PROPERTY_DURATION,
  TimeRegistrationRequest.JSON_PROPERTY_TAGS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-15T11:01:30.213196900+02:00[Europe/Copenhagen]", comments = "Generator version: 7.4.0")
public class TimeRegistrationRequest {
  public static final String JSON_PROPERTY_TASK_ID = "taskId";
  private Long taskId;

  public static final String JSON_PROPERTY_DATE = "date";
  private LocalDate date;

  public static final String JSON_PROPERTY_DURATION = "duration";
  private String duration;

  public static final String JSON_PROPERTY_TAGS = "tags";
  private List<TagConfiguration> tags;

  public TimeRegistrationRequest() { 
  }

  public TimeRegistrationRequest taskId(Long taskId) {
    this.taskId = taskId;
    return this;
  }

   /**
   * Get taskId
   * @return taskId
  **/
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_TASK_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getTaskId() {
    return taskId;
  }


  @JsonProperty(JSON_PROPERTY_TASK_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
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
  **/
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_DATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public LocalDate getDate() {
    return date;
  }


  @JsonProperty(JSON_PROPERTY_DATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDate(LocalDate date) {
    this.date = date;
  }


  public TimeRegistrationRequest duration(String duration) {
    this.duration = duration;
    return this;
  }

   /**
   * ISO 8601 formatted duration component &lt;PnDTnHnMn.nS&gt;. Each unit is optional, but at least one must be specified
   * @return duration
  **/
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_DURATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getDuration() {
    return duration;
  }


  @JsonProperty(JSON_PROPERTY_DURATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDuration(String duration) {
    this.duration = duration;
  }


  public TimeRegistrationRequest tags(List<TagConfiguration> tags) {
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
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TAGS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<TagConfiguration> getTags() {
    return tags;
  }


  @JsonProperty(JSON_PROPERTY_TAGS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTags(List<TagConfiguration> tags) {
    this.tags = tags;
  }


  /**
   * Return true if this TimeRegistrationRequest object is equal to o.
   */
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

    // add `date` to the URL query string
    if (getDate() != null) {
      joiner.add(String.format("%sdate%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getDate()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `duration` to the URL query string
    if (getDuration() != null) {
      joiner.add(String.format("%sduration%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getDuration()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `tags` to the URL query string
    if (getTags() != null) {
      for (int i = 0; i < getTags().size(); i++) {
        if (getTags().get(i) != null) {
          joiner.add(getTags().get(i).toUrlQueryString(String.format("%stags%s%s", prefix, suffix,
          "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    return joiner.toString();
  }
}

