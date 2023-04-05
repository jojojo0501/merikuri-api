package com.example.merikuri.generated.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * BadRequestResponseInvalidParamsInner
 */

@JsonTypeName("BadRequestResponse_invalid_params_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class BadRequestResponseInvalidParamsInner {

  @JsonProperty("name")
  private String name;

  @JsonProperty("reason")
  private String reason;

  public BadRequestResponseInvalidParamsInner name(String name) {
    this.name = name;
    return this;
  }

  /**
   * フィールド名
   * @return name
  */
  
  @Schema(name = "name", description = "フィールド名", required = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BadRequestResponseInvalidParamsInner reason(String reason) {
    this.reason = reason;
    return this;
  }

  /**
   * エラー理由
   * @return reason
  */
  
  @Schema(name = "reason", description = "エラー理由", required = false)
  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BadRequestResponseInvalidParamsInner badRequestResponseInvalidParamsInner = (BadRequestResponseInvalidParamsInner) o;
    return Objects.equals(this.name, badRequestResponseInvalidParamsInner.name) &&
        Objects.equals(this.reason, badRequestResponseInvalidParamsInner.reason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, reason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BadRequestResponseInvalidParamsInner {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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

