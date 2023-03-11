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
 * ユーザー情報
 */

@Schema(name = "LoginResponse_info", description = "ユーザー情報")
@JsonTypeName("LoginResponse_info")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class LoginResponseInfo {

  @JsonProperty("userId")
  private Long userId;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("age")
  private Integer age;

  @JsonProperty("tel")
  private String tel;

  @JsonProperty("address")
  private String address;

  @JsonProperty("email")
  private String email;

  public LoginResponseInfo userId(Long userId) {
    this.userId = userId;
    return this;
  }

  /**
   * ユーザーID
   * @return userId
  */
  @NotNull 
  @Schema(name = "userId", description = "ユーザーID", required = true)
  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public LoginResponseInfo firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * 名前
   * @return firstName
  */
  @NotNull 
  @Schema(name = "firstName", description = "名前", required = true)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public LoginResponseInfo lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * 苗字
   * @return lastName
  */
  @NotNull 
  @Schema(name = "lastName", description = "苗字", required = true)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public LoginResponseInfo age(Integer age) {
    this.age = age;
    return this;
  }

  /**
   * 年齢
   * @return age
  */
  @NotNull 
  @Schema(name = "age", description = "年齢", required = true)
  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public LoginResponseInfo tel(String tel) {
    this.tel = tel;
    return this;
  }

  /**
   * 電話番号
   * @return tel
  */
  @NotNull 
  @Schema(name = "tel", description = "電話番号", required = true)
  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public LoginResponseInfo address(String address) {
    this.address = address;
    return this;
  }

  /**
   * 住所
   * @return address
  */
  @NotNull 
  @Schema(name = "address", description = "住所", required = true)
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public LoginResponseInfo email(String email) {
    this.email = email;
    return this;
  }

  /**
   * メールアドレス
   * @return email
  */
  @NotNull 
  @Schema(name = "email", description = "メールアドレス", required = true)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoginResponseInfo loginResponseInfo = (LoginResponseInfo) o;
    return Objects.equals(this.userId, loginResponseInfo.userId) &&
        Objects.equals(this.firstName, loginResponseInfo.firstName) &&
        Objects.equals(this.lastName, loginResponseInfo.lastName) &&
        Objects.equals(this.age, loginResponseInfo.age) &&
        Objects.equals(this.tel, loginResponseInfo.tel) &&
        Objects.equals(this.address, loginResponseInfo.address) &&
        Objects.equals(this.email, loginResponseInfo.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, firstName, lastName, age, tel, address, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoginResponseInfo {\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    tel: ").append(toIndentedString(tel)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

