package com.example.merikuri.model;

import java.net.URI;
import java.util.Objects;
import com.example.merikuri.model.BadRequestResponseInvalidParamsInner;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * BadRequestResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class BadRequestResponse {

  @JsonProperty("code")
  private String code;

  @JsonProperty("message")
  private String message = "リクエストが不正です。";

  @JsonProperty("invalid-params")
  @Valid
  private List<BadRequestResponseInvalidParamsInner> invalidParams = null;

  public BadRequestResponse code(String code) {
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

  public BadRequestResponse message(String message) {
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

  public BadRequestResponse invalidParams(List<BadRequestResponseInvalidParamsInner> invalidParams) {
    this.invalidParams = invalidParams;
    return this;
  }

  public BadRequestResponse addInvalidParamsItem(BadRequestResponseInvalidParamsInner invalidParamsItem) {
    if (this.invalidParams == null) {
      this.invalidParams = new ArrayList<>();
    }
    this.invalidParams.add(invalidParamsItem);
    return this;
  }

  /**
   * Get invalidParams
   * @return invalidParams
  */
  @Valid 
  @Schema(name = "invalid-params", required = false)
  public List<BadRequestResponseInvalidParamsInner> getInvalidParams() {
    return invalidParams;
  }

  public void setInvalidParams(List<BadRequestResponseInvalidParamsInner> invalidParams) {
    this.invalidParams = invalidParams;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BadRequestResponse badRequestResponse = (BadRequestResponse) o;
    return Objects.equals(this.code, badRequestResponse.code) &&
        Objects.equals(this.message, badRequestResponse.message) &&
        Objects.equals(this.invalidParams, badRequestResponse.invalidParams);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, invalidParams);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BadRequestResponse {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    invalidParams: ").append(toIndentedString(invalidParams)).append("\n");
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

