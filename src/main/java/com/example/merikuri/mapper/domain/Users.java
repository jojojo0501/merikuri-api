package com.example.merikuri.mapper.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Users {
    private Long id;

    private String firstName;

    private String lastName;

    private Integer age;

    private String tel;

    private String address;

    private String email;

    private String password;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Boolean deleteFlg;
}