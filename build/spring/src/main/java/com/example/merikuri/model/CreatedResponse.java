package com.example.merikuri.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * CreatedResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-02-17T23:54:37.856621+09:00[Asia/Tokyo]")
public class CreatedResponse {

  @JsonProperty("code")
  private String code;

  @JsonProperty("message")
  private String message;

  public CreatedResponse code(String code) {
    this.code = code;
    return this;
  }

  /**
   * コード
   * @return code
  */
  @NotNull 
  @Schema(name = "code", description = "コード", required = true)
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public CreatedResponse message(String message) {
    this.message = message;
    return this;
  }

  /**
   * メッセージ
   * @return message
  */
  @NotNull 
  @Schema(name = "message", description = "メッセージ", required = true)
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
    CreatedResponse createdResponse = (CreatedResponse) o;
    return Objects.equals(this.code, createdResponse.code) &&
        Objects.equals(this.message, createdResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreatedResponse {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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

