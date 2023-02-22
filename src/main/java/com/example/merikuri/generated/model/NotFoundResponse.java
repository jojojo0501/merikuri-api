package com.example.merikuri.generated.model;

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
 * 404エラーのレスポンス
 */

@Schema(name = "NotFoundResponse", description = "404エラーのレスポンス")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class NotFoundResponse {

  @JsonProperty("code")
  private String code;

  @JsonProperty("message")
  private String message;

  public NotFoundResponse code(String code) {
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

  public NotFoundResponse message(String message) {
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
    NotFoundResponse notFoundResponse = (NotFoundResponse) o;
    return Objects.equals(this.code, notFoundResponse.code) &&
        Objects.equals(this.message, notFoundResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotFoundResponse {\n");
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

