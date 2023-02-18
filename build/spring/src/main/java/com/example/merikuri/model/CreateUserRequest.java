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
 * CreateUserRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class CreateUserRequest {

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

  @JsonProperty("password")
  private String password;

  public CreateUserRequest firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * 名前
   * @return firstName
  */
  @NotNull @Size(min = 1, max = 15) 
  @Schema(name = "firstName", description = "名前", required = true)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public CreateUserRequest lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * 苗字
   * @return lastName
  */
  @NotNull @Size(min = 1, max = 15) 
  @Schema(name = "lastName", description = "苗字", required = true)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public CreateUserRequest age(Integer age) {
    this.age = age;
    return this;
  }

  /**
   * 年齢
   * minimum: 1
   * maximum: 200
   * @return age
  */
  @NotNull @Min(1) @Max(200) 
  @Schema(name = "age", description = "年齢", required = true)
  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public CreateUserRequest tel(String tel) {
    this.tel = tel;
    return this;
  }

  /**
   * 電話番号
   * @return tel
  */
  @NotNull @Pattern(regexp = "0\\d{1,5}\\-\\d{0,4}\\-\\d{4}") 
  @Schema(name = "tel", description = "電話番号", required = true)
  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public CreateUserRequest address(String address) {
    this.address = address;
    return this;
  }

  /**
   * 住所
   * @return address
  */
  @NotNull @Size(min = 1, max = 100) 
  @Schema(name = "address", description = "住所", required = true)
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public CreateUserRequest email(String email) {
    this.email = email;
    return this;
  }

  /**
   * メールアドレス
   * @return email
  */
  @NotNull @Size(min = 1, max = 100) @Email
  @Schema(name = "email", description = "メールアドレス", required = true)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CreateUserRequest password(String password) {
    this.password = password;
    return this;
  }

  /**
   * パスワード
   * @return password
  */
  @NotNull @Size(min = 8, max = 30) 
  @Schema(name = "password", description = "パスワード", required = true)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateUserRequest createUserRequest = (CreateUserRequest) o;
    return Objects.equals(this.firstName, createUserRequest.firstName) &&
        Objects.equals(this.lastName, createUserRequest.lastName) &&
        Objects.equals(this.age, createUserRequest.age) &&
        Objects.equals(this.tel, createUserRequest.tel) &&
        Objects.equals(this.address, createUserRequest.address) &&
        Objects.equals(this.email, createUserRequest.email) &&
        Objects.equals(this.password, createUserRequest.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, age, tel, address, email, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateUserRequest {\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    tel: ").append(toIndentedString(tel)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

